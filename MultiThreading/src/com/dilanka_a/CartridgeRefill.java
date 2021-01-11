package com.dilanka_a;

public class CartridgeRefill implements Runnable {

    Printer printer;

    public CartridgeRefill(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (true) {
            if (printer.USED_CARTRIDGE_COUNT == printer.MAX_CARTRIDGE_SIZE) {
                printer.cartridgeRefill();
            }
        }

    }
}
