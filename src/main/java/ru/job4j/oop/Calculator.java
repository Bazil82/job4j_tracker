package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return x / y;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int res = sum(10);
        System.out.println(res);
        res = minus(3);
        System.out.println(res);
        Calculator calculator = new Calculator();
        res = calculator.divide(2);
        System.out.println(res);
        res = calculator.sumAllOperation(5);
        System.out.println(res);
    }
}
