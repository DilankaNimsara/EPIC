package com.dilanka_a;

public class Student extends Thread {

    Printer printer;

    public Student(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (Printer.isAllocated) {

        }
        Printer.isAllocated = true;
        printer.print();
    }
}
