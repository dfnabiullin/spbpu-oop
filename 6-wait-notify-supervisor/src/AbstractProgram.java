import java.util.Random;

public class AbstractProgram implements Runnable {
    private final long daemonSleep;
    private final Object lock;
    private Status status = Status.UNKNOWN;

    AbstractProgram(long daemonSleep, Object lock) {
        this.daemonSleep = daemonSleep;
        this.lock = lock;
    }

    Status getStatus() {
        return this.status;
    }

    void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void run() {
        Runnable daemon = () -> {
            Random random = new Random();
            Status[] statuses = Status.values();
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(daemonSleep);
                    synchronized (lock) {
                        System.out.print(Thread.currentThread().getName() + " changed status from " + AbstractProgram.this.getStatus());
                        AbstractProgram.this.setStatus(statuses[random.nextInt(statuses.length - 1) + 1]);
                        System.out.println(" to " + AbstractProgram.this.getStatus());
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        Thread daemonThread = new Thread(daemon, "daemon-" + Thread.currentThread().getName());
        daemonThread.setDaemon(true);
        daemonThread.start();
        while (!Thread.currentThread().isInterrupted()) {
        }
        daemonThread.interrupt();
    }
}