package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport {

    @Override
    public void travel() {
        System.out.print("How much will we go? ");
        Scanner input = new Scanner(System.in);
        int fuel = Integer.parseInt(input.nextLine());
        if (refuel(fuel) > 0) {
            System.out.println("Good. Now it's the passengers' turn");
            int amount = Integer.parseInt(input.nextLine());
            passengers(amount);
        }
    }

    @Override
    public void passengers(int amount) {
        if (amount > 0) {
            System.out.println("Doors are closing");
        } else {
            System.out.println("We wait..");
        }
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 50;
    }
}
