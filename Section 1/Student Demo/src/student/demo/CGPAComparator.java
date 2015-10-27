/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.demo;

import java.util.Comparator;

/**
 *
 * @author kmhasan
 */
public class CGPAComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        if (s1.getCGPA() < s2.getCGPA())
            return +1;
        else if (s1.getCGPA() > s2.getCGPA())
            return -1;
        else return 0;
    }
    
}
