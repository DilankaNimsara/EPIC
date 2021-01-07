public class Printer implements Runnable {

    public static int paperCount = 250;
    public static int cartridgeCount = 50;
    private final int maxPrintingCount = 250;
    private int printedPaperCount = 0;

    public synchronized void cartridgeRefilling() {
        if (Printer.cartridgeCount == 0) {
            System.out.println("cartridgeRefilling");
            Printer.cartridgeCount = 50;
        }
        notifyAll();
    }

    public synchronized void papersRefilling() {
        if (printedPaperCount % maxPrintingCount == 0) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("papersRefilling");
//            for (int i = 1; i <= 4; i++) {
//                Printer.paperCount += 50;
//            }
        }
        notifyAll();
    }

    @Override
    public void run() {
    }

    public synchronized void print() {
        for (int i = 1; i <= maxPrintingCount; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " Document printed.");
            printedPaperCount++;
            paperCount--;

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
//            if (i % maxPrintingCount == 0) {
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
