class Singer extends Thread {
    private final String line;
    private final int wait;
    private boolean isPaused;
    public Singer(String line, int wait) {
        this.line = line;
        this.wait = wait;
        this.isPaused = false;
    }
    public void pauseOnSinging() {
        isPaused = true;
        //suspend();
    }
    public synchronized void continueSinging() {
        isPaused = false;
        notify();
    }
    public void stopSinging() {
        interrupt();
    }
    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(line);
            try {
                Thread.sleep(wait);
            } catch (InterruptedException e) {
               // throw new RuntimeException(e);
            }
            synchronized (this) {
                while (isPaused) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                       // throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Singer singer1 = new Singer("line 1", 50);
        Singer singer2 = new Singer("line 2", 70);
        Singer singer3 = new Singer("line 3", 40);
        Singer singer4 = new Singer("line 4", 60);
        singer1.start();
        singer2.start();
        singer3.start();
        singer4.start();
        Thread.sleep(100);
        singer4.stopSinging();
        singer3.stopSinging();
        Thread.sleep(1000);
        //singer1.pauseOnSinging();
        singer1.continueSinging();
        singer1.stopSinging();
        Thread.sleep(500);
        singer2.stopSinging();
    }
}