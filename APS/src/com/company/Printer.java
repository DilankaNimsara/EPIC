package com.company;

public class Printer {

    int paperTraySizeMax = 250;
    int noOfCartridgesMax = 50;

    public synchronized void print() {
        for (int i = 1; i <= paperTraySizeMax; i++) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("print " + Thread.currentThread().getName() + " : " + i);

            if (i % 10 == 0) {

                while (!(noOfCartridgesMax == 0)) {
                    noOfCartridgesMax--;
                    break;
                }

                if (noOfCartridgesMax <= 0) {
                    Thread CartridgeRefill = new Thread(new CartridgeRefill());
                    CartridgeRefill.start();
                    try {
                        Thread.sleep(100);
                        CartridgeRefill.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    noOfCartridgesMax = 50;
                }
            }

            if (i == paperTraySizeMax) {
                Thread tpr = new Thread(new PaperRefill());
                tpr.start();
                try {
                    Thread.sleep(100);
                    tpr.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
