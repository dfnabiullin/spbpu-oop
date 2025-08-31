public class Supervisor implements Runnable {
    private final long daemonSleep;
    private final Object lock = new Object();
    private int abstractProgramNumber = 0;

    public Supervisor(long daemonSleep) {
        this.daemonSleep = daemonSleep;
    }

    private int getAbstractProgramNumber() {
        return abstractProgramNumber;
    }

    private void setAbstractProgramNumber(int abstractProgramNumber) {
        this.abstractProgramNumber = abstractProgramNumber;
    }

    @Override
    public void run() {
        ProgramInstance abstractProgramInstance;
        synchronized (lock) {
            abstractProgramInstance = startAbstractProgram();
        }
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (lock) {
                switch (abstractProgramInstance.program().getStatus()) {
                    case STOPPING -> {
                        stopAbstractProgram(abstractProgramInstance);
                        abstractProgramInstance = startAbstractProgram();
                    }
                    case FATAL_ERROR -> {
                        stopAbstractProgram(abstractProgramInstance);
                        Thread.currentThread().interrupt();
                    }
                }
                lock.notifyAll();
            }
        }
    }

    private void stopAbstractProgram(ProgramInstance abstractProgramInstance) {
        abstractProgramInstance.thread().interrupt();
        try {
            abstractProgramInstance.thread().join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    private ProgramInstance startAbstractProgram() {
        int abstractProgramNumber = getAbstractProgramNumber();
        AbstractProgram abstractProgram = new AbstractProgram(daemonSleep, lock);
        Thread abstractProgramThread = new Thread(abstractProgram, "abstract-program-thread-" + abstractProgramNumber);
        setAbstractProgramNumber(abstractProgramNumber + 1);
        abstractProgramThread.start();
        System.out.print(Thread.currentThread().getName() + " changed status " + abstractProgramThread.getName() + " from " + abstractProgram.getStatus());
        abstractProgram.setStatus(Status.RUNNING);
        System.out.println(" to " + Status.RUNNING);
        return new ProgramInstance(abstractProgram, abstractProgramThread);
    }

    private record ProgramInstance(AbstractProgram program, Thread thread) {
    }
}