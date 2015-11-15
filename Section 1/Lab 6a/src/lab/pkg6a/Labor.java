/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg6a;

/**
 *
 * @author kmhasan
 */
public class Labor extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public Labor(int employeeId, String employeeName, String designation,
            double hourlyRate, double hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
    
    @Override
    public double getMonthlySalary() {
        return hourlyRate * hoursWorked;
    }
}
