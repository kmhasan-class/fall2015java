/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.information;

import java.util.Arrays;

/**
 *
 * @author kmhasan
 */
public class StudentInformation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student students[];
        students = new Student[5];
        students[0] = new Student(500, "Abul", "Uttara");
        students[1] = new Student(201, "Babul", "Kalabagan");
        students[2] = new Student(102, "Kabul", "Malibagh");
        students[3] = new Student(303, "Abul", "Mirpur");
        students[4] = new Student(204, "Putul", "Nakhalpara");

        students[0].addGrade("A+", 1);
        students[4].addGrade("A", 3);
        students[3].addGrade("B+", 3);
        students[3].addGrade("C+", 3);
        students[2].addGrade("C+", 3);
        students[1].addGrade("B+", 3);
        students[1].addGrade("A+", 3);
        
        CGPAComparator cgpaComparator = new CGPAComparator();
        Arrays.sort(students, cgpaComparator);
        
        for (int i = 0; i < students.length; i++)
            System.out.printf("%s\n", students[i]);
        // Homework #1: modify this code so that these information can be saved
        // in a text file
        
        // Homework #2: add another class for ID comparison and use it to
        // sort the student array by ascending order of ID
        /*
        double data[] = new double[5];
        data[0] = 8.33;
        data[1] = 8.10;
        data[2] = 17.9;
        data[3] = 4;
        data[4] = 90;
        System.out.printf("Before Sorting\n");
        for (int i = 0; i < data.length; i++)
            System.out.printf("%f\n", data[i]);
        Arrays.sort(data);
        System.out.printf("After Sorting\n");
        for (int i = 0; i < data.length; i++)
            System.out.printf("%f\n", data[i]);
        
        String names[] = new String[7];
        names[0] = "Abul";
        names[1] = "Babul";
        names[2] = "Kabul";
        names[3] = "Ratul";
        names[4] = "Putul";
        names[5] = "Mitul";
        names[6] = "Mofiz";
        Arrays.sort(names);
        for (int i = 0; i < names.length; i++)
            System.out.printf("%s\n", names[i]);
                */
    }
    
}
