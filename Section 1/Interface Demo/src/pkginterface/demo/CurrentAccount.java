/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.demo;

/**
 *
 * @author kmhasan
 */
public class CurrentAccount extends BankAccount {

    public CurrentAccount(int accountNumber, String accountName, double balance) {
        super(accountNumber, accountName, balance);
    }

    @Override
    public void withdraw(int amount) {
        super.withdraw(amount + 20);
    }
    
}
