/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import accounts.BankAccount;

/**
 *
 * @author kmhasan
 */
public class CurrentAccount extends BankAccount {
    private double withdrawlFee;

    public CurrentAccount() {
        
    }
    
    public CurrentAccount(int accountNumber, String accountName, double balance, double withdrawlFee) {
        super(accountNumber, accountName, balance);
        this.withdrawlFee = withdrawlFee;
    }
    
    public double getWithdrawlFee() {
        return withdrawlFee;
    }
    
    public void withdraw(int amount) {
        if (amount + withdrawlFee <= balance && amount > 0)
            balance = balance - amount - withdrawlFee;
    }
}
