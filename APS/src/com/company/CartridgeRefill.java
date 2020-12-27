package com.company;

public class CartridgeRefill implements Runnable {

    public int Cartridges;
    int noOfCartridgesMax = 50;

    @Override
    public void run() {
        System.out.println("Cartridges refilling....");
        while (Cartridges < noOfCartridgesMax) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Cartridges++;
        }
        System.out.println("Cartridges refilled....");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
