public class Student extends Thread {
    Printer printer;

    public Student(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        try {
            printer.print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
