public class PaperRefill extends Thread {

    Printer printer;

    public PaperRefill(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (true) {
            fillPapers();
        }
    }

    public void fillPapers() {
        printer.papersRefilling();
    }

}
