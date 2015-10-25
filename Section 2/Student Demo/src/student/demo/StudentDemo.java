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
//        Student s = new Student(542, "Abul", "Moghbazar");
//        s.addGrade("A+", 3);
//        s.addGrade("A", 1);
//        s.addGrade("B+", 3);
//        s.addGrade("A+", 3);
//        System.out.printf("%s %f\n", s.getName(), s.getCGPA());

//        Student students[];
//        students = new Student[1000];
        Student students[] = new Student[6];
        students[0] = new Student(542, "Babul", "Moghbazar");
        students[1] = new Student(412, "Abul", "Uttara");
        students[2] = new Student(326, "Kabul", "Kazipara");
        students[3] = new Student(110, "Putul", "Khamar Bari");
        students[4] = new Student(876, "Ratul", "Sobhanbagh");
        students[5] = new Student(378, "Tetul", "New Market");
        
        students[0].addGrade("B+", 3);
        students[1].addGrade("A+", 3);
        students[2].addGrade("C+", 3);
        students[2].addGrade("B+", 3);
        students[0].addGrade("D", 1);
        students[4].addGrade("F", 1);
        students[4].addGrade("B", 3);
        students[5].addGrade("C", 3);
        students[5].addGrade("B-", 3);
        students[3].addGrade("C+", 3);
        for (int i = 0; i < students.length; i++)
//            System.out.printf("%d %s %f\n", students[i].getId(), students[i].getName(), students[i].getCGPA());
            System.out.printf("%s\n", students[i]);
        
        int intArray[] = new int[4];
        intArray[0] = 56;
        intArray[1] = 14;
        intArray[2] = 23;
        intArray[3] = 29;
        Arrays.sort(intArray);
        for (int i = 0; i < intArray.length; i++)
            System.out.printf("%d ", intArray[i]);
        System.out.printf("\n");

        double doubleArray[] = {3.2, 2.14, 43.24, 66.23, 1.2, 5.6, 23.1, 34.2, 123};
        Arrays.sort(doubleArray);
        for (int i = 0; i < doubleArray.length; i++)
            System.out.printf("%f ", doubleArray[i]);
        System.out.printf("\n");

        String stringArray[] = {"Monkey", "Donkey", "Wolverine", "Elephant", "Lion", "Lamb"};
        Arrays.sort(stringArray);
        for (int i = 0; i < stringArray.length; i++)
            System.out.printf("%s ", stringArray[i]);
        System.out.printf("\n");
    }
    
}
