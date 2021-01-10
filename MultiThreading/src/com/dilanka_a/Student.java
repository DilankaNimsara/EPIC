package com.dilanka_a;

public class Student implements Runnable {
    Printer printer;

    public Student(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {

        while (Printer.IS_PRINTER_ALLOCATED) {

        }
        Printer.IS_PRINTER_ALLOCATED = true;
        printer.print();


    }
}
