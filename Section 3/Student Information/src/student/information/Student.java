/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information;

/**
 *
 * @author kmhasan
 */
public class Student {
    private int id;
    private String name;
    private String address;
    private double totalCGPA;
    private double totalCredits;

    public Student() {
    }

    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
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

    public double getCgpa() {
        return totalCGPA / totalCredits;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTotalCredits() {
        return totalCredits;
    }
    
    public void addGrade(String grade, double credits) {
        double numericGrade = 0.0;
        switch (grade) {
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
        totalCGPA = totalCGPA + numericGrade * credits;
    }
    
    public String toString() {
        return id + " " + name + " " + getCgpa();
    }
}
