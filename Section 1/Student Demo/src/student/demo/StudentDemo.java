/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.demo;

import java.util.Arrays;

/**
 *
 * @author kmhasan
 */
public class StudentDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student students[] = new Student[5];
        students[0] = new Student(123, "Abul", "Uttara");
        students[1] = new Student(874, "Babul", "MES");
        students[2] = new Student(223, "Kabul", "Banani");
        students[3] = new Student(398, "Ratul", "Abdullahpur");
        students[4] = new Student(654, "Putul", "Gajipur");

        students[0].addGrade("A+", 1.0);
        students[4].addGrade("B+", 3.0);
        students[4].addGrade("A+", 3.0);
        students[1].addGrade("C+", 3.0);
        students[2].addGrade("D", 1.0);
        students[3].addGrade("F", 1.0);
        students[3].addGrade("D", 3.0);
        students[1].addGrade("F", 3.0);
//        IDComparator idComparator = new IDComparator();
        CGPAComparator cgpaComparator = new CGPAComparator();
//        Arrays.sort(students, idComparator);
        Arrays.sort(students, cgpaComparator);
        for (int i = 0; i < 5; i++)
            System.out.printf("%s\n", students[i].toString());
        
        
        int intArray[] = new int[6];
        intArray[0] = 3;
        intArray[1] = 4;
        intArray[2] = 1;
        intArray[3] = 5;
        intArray[4] = 2;
        intArray[5] = 1;
        Arrays.sort(intArray);
        for (int i = 0; i < intArray.length; i++)
            System.out.printf("%d ", intArray[i]);
        System.out.printf("\n");
        
        double doubleArray[] = {5.3, 2.1, 4.36, 9.66, 6.784, 2.13};
        Arrays.sort(doubleArray);
        for (int i = 0; i < doubleArray.length; i++)
            System.out.printf("%f ", doubleArray[i]);
        System.out.printf("\n");

        String stringArray[] = {"Rakib", "Ashiq", "Abul", "Babul", "Kabul", "Ratul", "Putul", "Tetul"};
        Arrays.sort(stringArray);
        for (int i = 0; i < stringArray.length; i++)
            System.out.printf("%s ", stringArray[i]);
        System.out.printf("\n");
    }
    
}
