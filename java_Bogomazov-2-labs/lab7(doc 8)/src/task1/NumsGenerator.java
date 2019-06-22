package task1;

import java.util.concurrent.Semaphore;

public class NumsGenerator implements Runnable {

    private Thread t;
    private final RandomNums nums;
    private int counter = 0;
    private int maxLength = 10000000;
    private Semaphore semaphore;

    public NumsGenerator(RandomNums nums, Semaphore semaphore) {
        this.nums = nums;
        this.semaphore = semaphore;
        this.t = new Thread(this, "NumsGenerator");
        this.t.start();
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            while (true) {
                if (counter >= maxLength) {
                    semaphore.release(1);
                    semaphore.acquire(1);
                    nums.clear();
                    counter = 0;
                }
                nums.add();
                counter++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
