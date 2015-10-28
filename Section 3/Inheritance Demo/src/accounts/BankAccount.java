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
public class BankAccount {
    private int accountNumber;
    private String accountName;
    protected double balance;

    public BankAccount() {
    }

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }
    
    public void withdraw(int amount) {
        if (amount <= balance && amount > 0)
            balance = balance - amount;
    }
    
    public void deposit(int amount) {
        if (amount > 0)
            balance = balance + amount;
    }
    
    @Override
    public String toString() {
        return accountNumber + " " + accountName + " " + balance;
    }
}
