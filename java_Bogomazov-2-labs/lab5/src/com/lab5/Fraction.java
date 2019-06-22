package com.lab5;


public class Fraction {

    private Double numerator;
    private Double denominator;


    public Fraction(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public double getResult(){
        return numerator/denominator;
    }

    public int getWholePart() throws CustomDIvByZeroException{
        if(numerator == null){
            throw new NullPointerException("numerator is null!");
        }
        if(denominator == null){
            throw new NullPointerException("denominator is null");
        }
        if(denominator.doubleValue() == 0){
            throw new CustomDIvByZeroException("denominator cannot be zero! ");
        }

        return (int)getResult();
    }

}
