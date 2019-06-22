package sample;

import java.util.Random;
import java.util.Arrays;

public class Array {
    private int[] numbers;

    public Array(int [] array) {
//        numbers = new int[length];
//        Random r = new Random();
//        for (int i = 0; i < length; i++) {
//            numbers[i] = r.nextInt()%100;
//        }
        numbers = new int[array.length];
        numbers = System.arraycopy(array, numbers, numbers.length);

    }


    public int minimalPosition(){
        int pos = 0;
        int min = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if(min > numbers[i]){
                min = numbers[i];
                pos = i;
            }
        }
        return pos;
    }

    
    
    public String toString(){
        String str = new String();
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] > 0) str += " ";
            str += numbers[i] + "\n";
        }
        return str;
    }

    public String sumBetweenFirstNegative() {
        int posFirst;
        int posSecond;

        int i = 0;
        try {

            while(numbers[i] > 0) {
                i++;
            }
            posFirst = i;
            i++;
        } catch (IndexOutOfBoundsException e){
            return "No negative numbers";
        }

        try {

            while(numbers[i] > 0) {
                i++;
            }
            posSecond = i;
        } catch (IndexOutOfBoundsException e){
            return "Only one negative number";
        }

        long sum = 0;
        for (int j = posFirst+1; j < posSecond; j++) {
            sum += numbers[j];
        }

        return String.valueOf(sum);
    }
}
