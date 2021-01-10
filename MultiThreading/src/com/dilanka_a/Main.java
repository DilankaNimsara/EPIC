package com.dilanka_a;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.start();

        Thread cartridge = new Thread(new CartridgeRefill(printer));
        cartridge.start();

        Thread paper = new Thread(new PaperRefill(printer));
        paper.start();

        Thread student1 = new Thread(new Student(printer));
        student1.setName("Student 1 ");
        student1.start();

        Thread student2 = new Thread(new Student(printer));
        student2.setName("Student 2 ");
        student2.start();

        Thread student3 = new Thread(new Student(printer));
        student3.setName("Student 3 ");
        student3.start();

        Thread student4 = new Thread(new Student(printer));
        student4.setName("Student 4 ");
        student4.start();

        Thread student5 = new Thread(new Student(printer));
        student5.setName("Student 5 ");
        student5.start();


    }
}
