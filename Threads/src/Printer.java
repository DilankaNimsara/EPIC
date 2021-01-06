public class Printer implements Runnable {

    public static int paperCount = 250;
    public static int cartridgeCount = 50;
    private int maxPrintingCount = 250;
    private int printedPaperCount = 0;

    public void cartridgeRefilling() {
        if (cartridgeCount == 0) {
            cartridgeCount = 50;
            this.notifyAll();
//            for (int i = 1; i <= 50; i++) {
//                cartridgeCount++;
//                if (cartridgeCount == 50) {
//                    this.notifyAll();
//                }
//            }
        }
    }

    public void papersRefilling() {
        if (paperCount == 0) {
            paperCount = 250;
            this.notifyAll();
//            for (int i = 1; i <= 250; i += 50) {
//                paperCount++;
//                if (Printer.paperCount == 250) {
//                    this.notify();
//                }
//            }
        }
    }

    @Override

    public void run() {

    }

    public synchronized void print() {
        for (int i = 0; i < maxPrintingCount; i++) {
            System.out.println(i + " Document printed.");
            paperCount--;
            printedPaperCount++;
            if (i % 10 == 0) {
                cartridgeCount--;
                System.out.println(cartridgeCount);
            }
            if (cartridgeCount == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (paperCount == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
