package ru.job4j.max;

public class Reduce {
    private int[] arrayTo;

    public void to(int[] array) {
        arrayTo = array;
    }

    public void print() {
        for (int i = 0; i < arrayTo.length; i++) {
            System.out.println(arrayTo[i]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
