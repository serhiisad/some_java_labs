package task1;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, true);
        RandomNums nums = new RandomNums();
        NumsGenerator gen = new NumsGenerator(nums, semaphore);
        ArithmMeanCalculator calc = new ArithmMeanCalculator(nums, semaphore);
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("Mean: " + calc.getMean());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
