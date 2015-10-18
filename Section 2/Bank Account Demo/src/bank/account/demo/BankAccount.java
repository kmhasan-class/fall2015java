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
public class BankAccount {
    // private, public, protected -- these are access modifiers
    // we provide data security/safety using these modifiers
    // this concept is known as ENCAPSULATION
    private int accountNumber;
    private String accountName;
    private double balance;
    
    // Default Constructor
    public BankAccount() {
        accountNumber = 0;
        accountName = "";
        balance = 0;
    }
    
    // CONSTRUCTOR
    public BankAccount(int number, String name, double amount) {
        accountNumber = number;
        accountName = name;
        balance = amount;
    }
    
    public String getAccountName() {
        return accountName;
    }
    
    // FUNCTIONs in C = METHODs in Java
    public double getBalance() {
        return balance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public void deposit(int amount) {
        if (amount > 0)
            balance = balance + amount;
    }
    
    // ABSTRACTION -- we don't need to know how something works
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
}
