/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg5a;

/**
 *
 * @author kmhasan
 */
public class RationalNumber extends Number {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    public Number add(Number b) {
        RationalNumber x = this;
        RationalNumber y = (RationalNumber) b;
        int numerator = x.numerator * y.denominator + y.numerator * x.denominator;
        int denominator = x.denominator * y.denominator;
        RationalNumber z = new RationalNumber(numerator, denominator);
        return z;
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
}
