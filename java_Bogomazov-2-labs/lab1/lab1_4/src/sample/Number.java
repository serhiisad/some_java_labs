package sample;

public class Number {
    int num;

    Number(int num) {
        this.num = num;
    }

    int getNum() {
        return num;
    }

    void setNum(int num) {
        this.num = num;
    }

    boolean isPalindrome() {
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

    public String WriteOutput(){
        if(isPalindrome()){
            return "Number " + num + "\n is Palindrome";
        } else {
            return "Number " + num + "\n is not a Palindrome";
        }
    }
}
