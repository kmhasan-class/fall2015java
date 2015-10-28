/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

/**
 *
 * @author kmhasan
 */
public class CreditCard extends BankAccount {
    private int creditLimit;
    
    public CreditCard(int accountNumber, String accountName, double balance, int creditLimit) {
        super(accountNumber, accountName, balance);
        this.creditLimit = creditLimit;
    }
    
    @Override
    public void withdraw(int amount) {
        if (-balance + amount <= creditLimit)
            balance = balance - amount;
    }
}
