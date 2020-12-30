public class Printer {
    int noOfPapersMax = 250;
    int noOfCardridge = 50;

    public synchronized void print() throws InterruptedException {
        for (int i = 1; i <= noOfPapersMax; i++) {
            Thread.sleep(50);
            System.out.println("Print " + Thread.currentThread().getName() + ":" + i);
            if (i % 10 == 0) {
                noOfCardridge--;
            }
            if (noOfCardridge == 0) {
                Thread cr = new Thread(new CardridgeRefill());
                cr.start();
                cr.join();
                noOfCardridge = 50;
            }

        }
        Thread pr = new Thread(new PaperRefill());
        pr.start();
        pr.join();
    }
}
