/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6a;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class Lab6a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Officer(101, "Md. Rakibul Hasan", "Manager", 10000, 2000, 1000));
        employees.add(new Officer(102, "Hasan Tareque", "Managing Director", 100000, 50000, 10000));
        employees.add(new Labor(102, "Monirul Hasan", "Cleaner", 5000, 50));
        
        for (Employee e: employees)
            System.out.printf("%s\n", e);
        
        double totalMonthlySalary = 0.0;
        for (Employee e: employees)
            totalMonthlySalary = totalMonthlySalary + e.getMonthlySalary();
        
        System.out.printf("Total monthly salary: %f\n", totalMonthlySalary);
    }
    
}
