/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.demo;

/**
 *
 * @author kmhasan
 */
public class Student {
    private int id;
    private String name;
    private String address;
    private double totalCredits;
    private double totalCGP;

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public double getCGPA() {
        double cgpa = totalCGP / totalCredits;
        if (totalCredits == 0.0)
            return 0.0;
        else return cgpa;
    }
    
    public void addGrade(String letterGrade, double credits) {
        double numericGrade = 0.0;
        switch (letterGrade) {
            case "A+": numericGrade = 4.00; break;
            case "A" : numericGrade = 3.75; break;
            case "A-": numericGrade = 3.50; break;
            case "B+": numericGrade = 3.25; break;
            case "B" : numericGrade = 3.00; break;
            case "B-": numericGrade = 2.75; break;
            case "C+": numericGrade = 2.50; break;
            case "C" : numericGrade = 2.25; break;
            case "D" : numericGrade = 2.00; break;
            case "F" : numericGrade = 0.00; break;
        }
        totalCredits = totalCredits + credits;
        totalCGP = totalCGP + credits * numericGrade;
    }
    
    public String toString() {
        return id + " " + name + " " + address + " " + getCGPA();
    }
}
