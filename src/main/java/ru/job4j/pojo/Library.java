package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book one = new Book("One", 100);
        Book two = new Book("Two", 200);
        Book three = new Book("Three", 300);
        Book four = new Book("Clean code", 400);
        Book[] books = new Book[4];
        books[0] = one;
        books[1] = two;
        books[2] = three;
        books[3] = four;
        for (int i = 0; i < books.length; i++) {
            Book thisBook = books[i];
            System.out.println(thisBook.getName() + " - " + thisBook.getPages());
        }
        System.out.println();
        Book temp = books[2];
        books[2] = books[0];
        books[0] = temp;
        for (int i = 0; i < books.length; i++) {
            Book thisBook = books[i];
            System.out.println(thisBook.getName() + " - " + thisBook.getPages());
        }
        System.out.println();
        for (int i = 0; i < books.length; i++) {
            Book thisBook = books[i];
            if ("Clean code".equals(thisBook.getName())) {
                System.out.println(thisBook.getName() + " - " + thisBook.getPages());
            }
        }
    }
}
