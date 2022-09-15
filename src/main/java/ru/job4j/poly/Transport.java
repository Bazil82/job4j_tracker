package ru.job4j.poly;

public interface Transport {
    void travel();

    void passengers(int amount);

    int refuel(int fuel);
}
