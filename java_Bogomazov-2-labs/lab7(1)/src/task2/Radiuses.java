package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Radiuses {

    private final List<Double> radiuses;

    public Radiuses() {
        this.radiuses = Collections.synchronizedList(new ArrayList<>());
    }

    public void add(Double i) {
        synchronized (radiuses) {
            this.radiuses.add(i);
        }
    }

    public double[] get() {
        return this.radiuses.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public double sum() {
        double sum = 0;
        for(Double d: radiuses)
            sum += d;
        return sum;
    }

    public double arithmMean() {
        return sum() / radiuses.size();
    }

}
