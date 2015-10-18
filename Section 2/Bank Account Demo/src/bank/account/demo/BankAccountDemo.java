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
        // "BankAccount" is the class
        // "a" is the object
        // we instantiate using new operator
        BankAccount a = new BankAccount(1122, "Md. Ashiqur Rahman", 1000);
        BankAccount b = new BankAccount(3444, "Roksana Akter Jolly", 10000);
        
        a.deposit(1000);
        a.withdraw(200);

        
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
