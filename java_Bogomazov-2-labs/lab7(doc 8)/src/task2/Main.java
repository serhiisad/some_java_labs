package task2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Radiuses radiuses = new Radiuses();
        Semaphore semaphore = new Semaphore(2);
        RadiusGenerator gen1 = new RadiusGenerator(1, semaphore, radiuses);
        RadiusGenerator gen2 = new RadiusGenerator(2, semaphore, radiuses);
        SquareCalculator calc = new SquareCalculator(semaphore, radiuses);
    }
}
