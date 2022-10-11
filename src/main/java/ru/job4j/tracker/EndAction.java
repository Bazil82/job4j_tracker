package ru.job4j.tracker;

public class EndAction implements UserAction {
    @Override
    public String name() {
        return "End menu";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
