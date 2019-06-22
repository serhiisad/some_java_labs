package task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNums {
    private List<Integer> nums;

    public RandomNums() {
        this.nums = Collections.synchronizedList(new ArrayList<>());
    }

    public void add() {
        synchronized (nums) {
            Random rnd = new Random();
            int randomNum = rnd.nextInt(Integer.MAX_VALUE);
            nums.add(randomNum);
        }
    }

    public int[] get() {
        return this.nums.stream().mapToInt(Integer::intValue).toArray();
    }

    public void clear() {
        synchronized (nums) {
            this.nums.clear();
        }
    }
}
