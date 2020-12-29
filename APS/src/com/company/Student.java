package com.company;

public class Student implements Runnable {

    Printer printer;

    public Student(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}
