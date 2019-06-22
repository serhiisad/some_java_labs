package task2;

import java.util.concurrent.Semaphore;

public class SquareCalculator implements Runnable {

    private Radiuses radiuses;
    private Semaphore semaphore;
    public Thread t;

    public SquareCalculator(Semaphore semaphore, Radiuses radiuses) {
        this.radiuses = radiuses;
        this.semaphore = semaphore;
        this.t = new Thread(this);
        this.t.start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);
            double square = Math.PI * Math.pow(radiuses.arithmMean(), 2);
            System.out.println("Square is: " + square);
            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
