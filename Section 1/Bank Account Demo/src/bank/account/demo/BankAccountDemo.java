/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account.demo;

/**
 *
 * @author kmhasan
 */
public class BankAccountDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // we are instantiating object "a"
        // object "a" is an instance of class "BankAccount"
        BankAccount a = new BankAccount(100, "Md. Rakibul Hasan", 1000000.0);
        BankAccount b = new BankAccount(101, "Md. Ashiqur Rahman", 10000.0);
        b.deposit(200);
        a.withdraw(10000000);
        b.withdraw(100);
        
        
        System.out.printf("%d %s %.2f\n", 
                a.getAccountNumber(),
                a.getAccountName(),
                a.getBalance());
        System.out.printf("%d %s %.2f\n", 
                b.getAccountNumber(),
                b.getAccountName(),
                b.getBalance());
    }
    
}
