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
public class ComplexNumber extends Number {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }
    
    @Override
    public Number add(Number b) {
        ComplexNumber x = this;
        ComplexNumber y = (ComplexNumber) b;
        double real = x.real + y.real;
        double imaginary = x.imaginary + y.imaginary;
        ComplexNumber z = new ComplexNumber(real, imaginary);
        return z;
    }
    
    public String toString() {
        return real + " + " + imaginary + " * i";
    }
}
