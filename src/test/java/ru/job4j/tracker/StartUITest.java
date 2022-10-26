package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
            new CreateAction(out),
            new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
            new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
            new ReplaceAction(out),
            new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
            "Menu: " + ln
                             + "0. Replace Item" + ln
                             + "1. End menu" + ln
                             + "=== Edit item ===" + ln
                             + "Application changed successfully." + ln
                             + "Menu: " + ln
                             + "0. Replace Item" + ln
                             + "1. End menu" + ln
        );
    }

    @Test
    public void whenFindAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Input in = new StubInput(
            new String[] {"0", "1"}
        );
        UserAction[] actions = {
            new ShowAction(out),
            new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
            "Menu: " + ln
                             + "0. Show all items" + ln
                             + "1. End menu" + ln
                             + "== Show all items ==" + ln
                             + one + ln + two + ln
                             + "Menu: " + ln
                             + "0. Show all items" + ln
                             + "1. End menu" + ln
        );
    }

    @Test
    public void whenFindByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Input in = new StubInput(
                new String[] {"0", two.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu: " + ln
                        + "0. Find Item by name" + ln
                        + "1. End menu" + ln
                        + "=== Find items by name ===" + ln
                        + two + ln
                        + "Menu: " + ln
                        + "0. Find Item by name" + ln
                        + "1. End menu" + ln
        );
    }

    @Test
    public void whenFindByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("First item"));
        Item two = tracker.add(new Item("Second item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(two.getId()), "1"}
        );
        UserAction[] actions = {
                new FindByIDAction(out),
                new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu: " + ln
                        + "0. Find Item by ID" + ln
                        + "1. End menu" + ln
                        + "=== Find item by id ===" + ln
                        + two + ln
                        + "Menu: " + ln
                        + "0. Find Item by ID" + ln
                        + "1. End menu" + ln
        );
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Delete item"));
        Input in = new StubInput(
            new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
            new DeleteAction(out),
            new EndAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
            new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] action = {
            new EndAction()
        };
        new StartUI(out).init(in, tracker, action);
        assertThat(out.toString()).isEqualTo(
            "Menu: " + System.lineSeparator()
                + "0. End menu" + System.lineSeparator()
        );
    }
}