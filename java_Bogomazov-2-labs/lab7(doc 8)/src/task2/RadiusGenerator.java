package task2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class RadiusGenerator implements Runnable {
    public Thread t;
    private int index;
    private final int MAX = 100;
    private Radiuses radiuses;
    private Semaphore semaphore;

    public RadiusGenerator(int index, Semaphore semaphore, Radiuses radiuses) {
        this.t = new Thread(this);
        this.index = index;
        this.semaphore = semaphore;
        this.radiuses = radiuses;
        this.t.start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            System.out.println("Thread " + index + " started");
            Random gen = new Random();
            double radius = gen.nextDouble() * MAX;
            radiuses.add(radius);
            System.out.println("Radius" + index + ": " + radius);
            System.out.println("Thread " + index + " finished");
            semaphore.release(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
