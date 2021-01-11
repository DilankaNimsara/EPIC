import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

public class Printer {


    public static volatile boolean isAllocated = false;
    public static volatile int printedPaperCount = 1;
    public static volatile int printedCartridgeCount = 0;
    public static volatile int paperCount = 250;
    public volatile int MAX_TRAY_PAPER_COUNT = 250;
    public volatile int MAX_INK_CART_COUNT = 50;
    public volatile boolean isPaperIsFulled = false;
    public volatile boolean isCartridgeIsFulled = false;

    public Printer() {
        new PaperRefill(this).start();
        new CartridgeRefill(this).start();
    }

    public void cartridgeRefilling() {
        synchronized (this) {
            printedCartridgeCount = 0;
            try {
                System.out.println("Cartridge Refilled.!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isCartridgeIsFulled = true;
            isAllocated = false;
            this.notifyAll();
        }
    }

    public void papersRefilling() {
        synchronized (this) {
            printedPaperCount = 0;
            try {
                System.out.println("Papers Refilled.!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isPaperIsFulled = true;
            isAllocated = false;
            this.notifyAll();
        }
    }

    public void print() {

        synchronized (this) {

            isAllocated = true;

            for (int i = 1; i <= paperCount; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i + " Document printed.");
                System.out.println(Thread.currentThread().getName() + " : " + i + " Document printed." + printedPaperCount + " --- " + printedCartridgeCount);

                printedPaperCount++;
                if (printedPaperCount % 10 == 0) {
                    printedCartridgeCount++;
                }

                while (printedCartridgeCount == MAX_INK_CART_COUNT || printedPaperCount == MAX_TRAY_PAPER_COUNT) {
                    if (printedCartridgeCount == MAX_INK_CART_COUNT) {
                        try {
                            isCartridgeIsFulled = false;
                            isAllocated = true;
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (printedPaperCount == MAX_TRAY_PAPER_COUNT) {
                        try {
                            isPaperIsFulled = false;
                            isAllocated = true;
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isAllocated = false;
        }
    }

}
