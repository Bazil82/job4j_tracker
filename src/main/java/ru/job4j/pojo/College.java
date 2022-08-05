package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Vasiliy Kozlov");
        student.setGroup("ГФ-11-01");
        student.setReceiptDate(new Date());

        System.out.println("Student: " + student.getFullName() + " joined the group - "
                + student.getGroup() + " on " + student.getReceiptDate());
    }
}
