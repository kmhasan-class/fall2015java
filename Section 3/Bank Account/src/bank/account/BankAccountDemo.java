/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account;

/**
 *
 * @author kmhasan
 */
public class BankAccountDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 5;
        x = 10;
        x = x + 20;
        System.out.printf("%d\n", x);
        
        BankAccount a = new BankAccount();
        BankAccount b = new BankAccount();
        a.accountNumber = 100;
        a.accountName = "Md. Rakibul Hasan";
        a.balance = 500;
        b.accountNumber = 200;
        b.accountName = "Monirul Hasan";
        b.balance = 200;
        a.deposit(100);
        a.withdraw(1000);
        System.out.printf("%d %s %f\n", a.accountNumber, 
                a.accountName, a.balance);
        System.out.printf("%d %s %f\n", b.accountNumber,
                b.accountName, b.balance);
        // HomeWork: read chapter 3 of JHTP (9th Ed)
    }
    
}
