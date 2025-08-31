import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        long daemonSleep;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the state change interval in milliseconds:");
            daemonSleep = scanner.nextLong();
        }
        Supervisor supervisor = new Supervisor(daemonSleep);
        Thread supervisorThread = new Thread(supervisor, "supervisor-thread");
        supervisorThread.start();
    }
}