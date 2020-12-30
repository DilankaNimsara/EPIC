public class PaperRefill extends Thread{
    @Override
    public void run() {
        System.out.println("Paper Refill....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
