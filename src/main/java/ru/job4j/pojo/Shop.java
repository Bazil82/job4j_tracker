package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] foods) {
        int res = -1;
        for (int i = 0; i < foods.length; i++) {
            if (foods[i] == null) {
                res = i;
                break;
            }
        }
        return res;
    }
}
