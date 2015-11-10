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
public class BankAccount implements Comparable {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public BankAccount() {
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
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    public void deposit(int amount) {
        if (amount > 0)
            balance = balance + amount;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance + '}';
    }

    @Override
    public int compareTo(Object o) {
        BankAccount a = this;
        BankAccount b = (BankAccount) o;
        
        if (a.getBalance() < b.getBalance())
            return +1;
        else if (a.getBalance() > b.getBalance())
            return -1;
        else return 0;
    }
    
    
}
