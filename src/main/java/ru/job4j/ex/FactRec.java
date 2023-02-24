package ru.job4j.ex;

public class FactRec {
    public static int calc(int n) {
        int res = 0;
        if (n == 0 || n == 1) {
            res = 1;
        } else {
            res = calc(n - 1) * n;
        }
        return res;
    }

    public static void main(String[] args) {
        int rsl = calc(3);
        System.out.println(rsl);
    }
}
