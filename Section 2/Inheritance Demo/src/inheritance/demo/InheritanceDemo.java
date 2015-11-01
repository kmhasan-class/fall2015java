/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance.demo;

import accounts.BankAccount;
import accounts.CurrentAccount;

/**
 *
 * @author kmhasan
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount a = new BankAccount(401, "Hasan", 5000.00);
        CurrentAccount b = new CurrentAccount(402, "Rakib", 5000.00, 50.00);
        a.deposit(500);
        a.deposit(200);
        a.withdraw(1000);
        a.withdraw(5000);
        b.deposit(500);
        b.deposit(200);
        b.withdraw(1000);
        b.withdraw(5000);
        System.out.printf("%s\n", a);
        System.out.printf("%s\n", b);
    }
}
