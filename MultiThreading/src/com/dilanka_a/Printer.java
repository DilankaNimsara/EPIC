package com.dilanka_a;

public class Printer extends Thread {

    public static volatile int USED_PAPER_COUNT = 0;
    public static volatile int USED_CARTRIDGE_COUNT = 0;
    public static volatile boolean IS_PRINTER_ALLOCATED = false;
    public int PAPER_COUNT = 250;
    public int MAX_PAPER_TRAY_SIZE = 250;
    public int MAX_CARTRIDGE_SIZE = 50;
    public volatile boolean IS_PAPER_FULLED = false;
    public volatile boolean IS_CARTRIDGE_FULLED = false;

    public void cartridgeRefill() {
        synchronized (this) {
            USED_CARTRIDGE_COUNT = 0;
            try {
                System.out.println("Cartridge refilling...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IS_CARTRIDGE_FULLED = true;
            this.notify();

        }
    }

    public void paperRefill() {
        synchronized (this) {

            USED_PAPER_COUNT = 0;
            try {
                System.out.println("Paper Refilled...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IS_PAPER_FULLED = true;
            this.notify();

        }
    }

    public void print() {
        synchronized (this) {
            for (int i = 1; i <= PAPER_COUNT; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " Document Printed");
                USED_PAPER_COUNT++;
                if (i % 10 == 0) {
                    USED_CARTRIDGE_COUNT++;
                }

                while (USED_CARTRIDGE_COUNT == MAX_CARTRIDGE_SIZE || USED_PAPER_COUNT == MAX_PAPER_TRAY_SIZE) {
                    if (USED_CARTRIDGE_COUNT == MAX_CARTRIDGE_SIZE) {
                        try {
                            IS_CARTRIDGE_FULLED = false;
                            this.notifyAll();
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (USED_PAPER_COUNT == MAX_PAPER_TRAY_SIZE) {
                        try {
                            IS_PAPER_FULLED = false;
                            this.notifyAll();
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            if (IS_PAPER_FULLED || IS_CARTRIDGE_FULLED) {
                IS_PRINTER_ALLOCATED = false;
            }

        }
    }

}
