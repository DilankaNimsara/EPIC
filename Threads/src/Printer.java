public class Printer implements Runnable {

    public static int paperCount = 250;
    public static int cartridgeCount = 50;
    private int maxPrintingCount = 250;
    private int printedPaperCount = 0;

    public synchronized void cartridgeRefilling() {
        if (Printer.cartridgeCount == 0) {
            System.out.println("cartridgeRefilling");
            Printer.cartridgeCount = 50;


        }
        notifyAll();
    }

    public synchronized void papersRefilling() {
        if (Printer.paperCount == 0) {
            System.out.println("papersRefilling");
            Printer.paperCount = 250;
        }
        notifyAll();
    }

    @Override

    public void run() {

    }

    public synchronized void print() {

        for (int i = 1; i <= maxPrintingCount; i++) {
            System.out.println(i + " Document printed.");
            paperCount--;
            printedPaperCount++;

            if (i % 10 == 0) {
                cartridgeCount--;
            }
            if (cartridgeCount == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (paperCount == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
