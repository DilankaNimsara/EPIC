public class CardridgeRefill extends Thread {

    Printer printer;

    public CardridgeRefill(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (true) {
                fillCartridges();
        }
    }

    public void fillCartridges() {
        printer.cartridgeRefilling();
    }

}
