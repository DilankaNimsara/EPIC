public class Student extends Thread {

    Printer printer;

    public Student(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        while (true) {
            if (!Printer.isAllocated) {
                Printer.isAllocated = true;
                printer.print();
                return;
            }
        }


    }
}
