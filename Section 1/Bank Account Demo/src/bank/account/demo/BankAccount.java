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
    // private, public, protected -- these are
    // access modifiers
    // we enforce "Encapsulation" with these modifiers
    private int accountNumber;
    private String accountName;
    private double balance;
    
    //default constructor
    public BankAccount() {
        accountNumber = 0;
        accountName = "";
        balance = 0;
    }
    
    // constructor
    public BankAccount(int number, String name, double amount) {
        accountNumber = number;
        accountName = name;
        balance = amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // methods provide "Abstraction"
    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    public void deposit(int amount) {
        if (amount > 0)
            balance = balance + amount;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountName() {
        return accountName;
    }
}
