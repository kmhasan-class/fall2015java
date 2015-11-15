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
public class Officer extends Employee {
    private double basicSalary;
    private double houseRent;
    private double conveyanceAllowance;
    
    public Officer(int employeeId, String employeeName, String designation,
            double basicSalary, double houseRent, double conveyanceAllowance) {
        super(employeeId, employeeName, designation);
        this.basicSalary = basicSalary;
        this.houseRent = houseRent;
        this.conveyanceAllowance = conveyanceAllowance;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHouseRent() {
        return houseRent;
    }

    public double getConveyanceAllowance() {
        return conveyanceAllowance;
    }
    
    @Override
    public double getMonthlySalary() {
        return basicSalary + houseRent + conveyanceAllowance;
    }

}
