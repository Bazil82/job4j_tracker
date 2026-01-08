package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        } else if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }

    public static void main(String[] args) {
        Jukebox onePlay = new Jukebox();
        Jukebox twoPlay = new Jukebox();
        Jukebox threePlay = new Jukebox();
        onePlay.music(1);
        twoPlay.music(2);
        threePlay.music(3);
    }
}
