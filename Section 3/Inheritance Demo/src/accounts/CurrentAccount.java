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

    public CurrentAccount(int accountNumber, String accountName, double balance, double withdrawlFee) {
        super(accountNumber, accountName, balance);
        this.withdrawlFee = withdrawlFee;
    }
    
    @Override
    public void withdraw(int amount) {
//        super.withdraw(amount + (int) withdrawlFee);
        if (amount <= balance && amount > 0)
            balance = balance - amount - withdrawlFee;        
    }
}
