package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                rsl[count] = item;
                count++;
            }
        }
        rsl = Arrays.copyOf(rsl, count);
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int ind = indexOf(id);
        boolean rsl = ind != -1;
        if (rsl) {
            item.setId(id);
            items[ind] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int ind = indexOf(id);
        boolean rsl = ind != -1;
        if (rsl) {
            items[ind] = null;
            System.arraycopy(items, ind + 1, items, ind, size - ind - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }

}