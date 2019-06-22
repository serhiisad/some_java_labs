package task1;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CommonUlits {

    public static void prepareFile(String filename, IOStrategy strategy){

        Random rand = new Random();
        ArrayList<Double> list = new ArrayList<>();
        for(int i =0; i < 100; i++){
            double num = ThreadLocalRandom.current().nextDouble(-50.0, 50.0);
            list.add(num);
        }
        strategy.writeFile(filename, list);

    }

    public static ArrayList<Double> getProcessedNumbers(ArrayList<Double>list){

        double first_negative = 0;
        for (double el: list) {
            if (el < 0){
                first_negative = el;
                System.out.println("First negative" + el);
                break;
            }
        }
        if(first_negative == 0) throw new ValueException("No negative numbers");
        //
        double fiftieth= list.get(49);
        System.out.println("50th" + fiftieth);

        ArrayList<Double> processed_list = new ArrayList<>();
        for (double el: list) {
            processed_list.add( Math.round((el / ((first_negative + fiftieth)/2))*100.0)/100.0);
        }
        System.out.println("LIST" + list);
        System.out.println("Processed" + processed_list);
        return processed_list;
    }

//    public static void main(String[] args) {
////        task1.IOStrategy strategy = new task1.TextIOStrategy();
//        IOStrategy strategy = new TextIOStrategy();
//
//        ArrayList<Double> list = strategy.readFile("input.txt");
//        System.out.println("Before: " + list);
//
//        ArrayList<Double> processed_list = task1.CommonUlits.getProcessedNumbers(list);
//        System.out.println("After 1: " + processed_list);
//
//        ArrayList<Double> processed_list1 = task1.CommonUlits.getProcessedNumbers(processed_list);
//        System.out.println("After 2: " + processed_list1);
//
//        ArrayList<Double> processed_list2 = task1.CommonUlits.getProcessedNumbers(processed_list1);
//        System.out.println("After 3: " + processed_list2);
//
//
//    }
}



