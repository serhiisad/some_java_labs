package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ArithmMeanCalculator implements Runnable {

    private Thread t;
    private final RandomNums nums;
    private List<Integer> arithmMeans;
    private Semaphore semaphore;

    public ArithmMeanCalculator(RandomNums nums, Semaphore semaphore) {
        this.arithmMeans = Collections.synchronizedList(new ArrayList<>());
        this.nums = nums;
        this.semaphore = semaphore;
        this.t = new Thread(this, "ArithmCalculator");
        this.t.start();
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaphore.acquire(1);
                int[] numArray = nums.get();
                System.out.println("Length: " + numArray.length);
                double sum = 0;
                for (int i : numArray)
                    sum += i / numArray.length;
                arithmMeans.add((int) sum);
                semaphore.release(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getMean() {
        int size = this.arithmMeans.size();
        if (size == 0)
            return 0;
        double sum = 0;
        for (int i = 0; i < size; i++)
            sum += (double) this.arithmMeans.get(i) / size;
        return (int) sum;
    }

}
