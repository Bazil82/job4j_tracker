package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        this.array = array;
    }

    public void printing() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.printing();
    }
}
