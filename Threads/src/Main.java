public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();

        Thread std1 = new Thread(new Student(printer));
        std1.setName("student one ");
        std1.start();
        Thread std2 = new Thread(new Student(printer));
        std2.setName("student two ");
        std2.start();
        Thread std3 = new Thread(new Student(printer));
        std3.setName("student three ");
        std3.start();
        Thread std4 = new Thread(new Student(printer));
        std4.setName("student four ");
        std4.start();
        Thread std5 = new Thread(new Student(printer));
        std5.setName("student five ");
        std5.start();


    }
}
