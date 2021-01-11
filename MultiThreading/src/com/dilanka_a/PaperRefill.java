package com.dilanka_a;

public class PaperRefill implements Runnable {
    Printer printer;

    public PaperRefill(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {

        while (true) {
            if (printer.USED_PAPER_COUNT == printer.MAX_PAPER_TRAY_SIZE) {
                printer.paperRefill();
            }
        }

    }
}
