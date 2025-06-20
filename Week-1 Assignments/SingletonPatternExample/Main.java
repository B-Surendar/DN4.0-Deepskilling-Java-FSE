package SingletonPatternExample;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        System.out.println("Starting the application.");

        Logger logger2 = Logger.getInstance();
        System.out.println("Performing some operations.");

        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same. Singleton verified.");
        } else {
            System.out.println("Different instances exist. Singleton failed.");
        }
    }
}
