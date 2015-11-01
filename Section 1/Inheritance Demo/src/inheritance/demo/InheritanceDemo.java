/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

import accounts.CurrentAccount;
import accounts.BankAccount;

/**
 *
 * @author kmhasan
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount a = new BankAccount(101, "Hasan", 5000.00);
        CurrentAccount b = new CurrentAccount(102, "Rakib", 5000.00, 20.00);
        a.deposit(500);
        a.withdraw(600);
        b.deposit(500);
        b.withdraw(600);
        System.out.printf("%s\n", a);
        System.out.printf("%s\n", b);
    }
    
}
