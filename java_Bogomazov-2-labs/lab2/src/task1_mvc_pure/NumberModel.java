package task1_mvc_pure;

// Model class

import java.util.*;

public class NumberModel extends Observable {


    private int num;
    private List<Observer> observers = new ArrayList<>();



    //    private String result;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isPalindrome() {

        int temp = num;
        int sum = 0;
        while(temp > 0) {
            sum = sum*10 + temp%10;
            temp = temp / 10;
        }
        if(sum == num){
            return true;
        }
        return false;
    }

//    public void checkForPalindrome(){
//        if(isPalindrome()){
//            result =  "Number " + num + "\n is Palindrome";
//        } else {
//            result =  "Number " + num + "\n is not a Palindrome";
//        }
//    }
//
//    public String getResult(){
//        return result;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberModel that = (NumberModel) o;
        return num == that.num &&
                Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, result);
    }

    @Override
    public String toString() {
        return "NumberModel{" +
                "num=" + num +
                '}';
    }
}
