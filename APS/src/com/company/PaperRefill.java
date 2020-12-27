package com.company;

public class PaperRefill implements Runnable {
    int paperTraySizeMax = 250;
    int A4PackSize = 50;
    public int PaperRefill = 0;

    @Override
    public void run() {
        int i = 0;
        System.out.println("Paper refilling....");
        while (PaperRefill < paperTraySizeMax) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            PaperRefill += A4PackSize;
            System.out.println("adding A4 pack " + i);
        }
        System.out.println("Paper refilled....");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
