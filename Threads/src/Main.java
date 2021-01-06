public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread cartridgeRefill = new Thread((new CardridgeRefill(printer)));
        cartridgeRefill.start();

        Thread PaperRefill = new Thread(new PaperRefill(printer));
        PaperRefill.start();


        Thread student1 = new Student(printer);
        student1.setName("student 1");
        student1.start();

        Thread student2 = new Student(printer);
        student2.setName("student 2");
        student2.start();

        Thread student3 = new Student(printer);
        student3.setName("student 3");
        student3.start();



    }
}
