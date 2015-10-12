/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.account;

/**
 *
 * @author kmhasan
 */
public class BankAccount {
    int accountNumber;
    String accountName; 
    int voterIdNumber;
    float balance;
    
    // in Java we call functions
    // as methods
    void withdraw(int amount) {
        if (amount > 0 && amount <= balance)
            balance = balance - amount;
    }
    
    void deposit(int amount) {
        balance = balance + amount;
    }
    
    float getBalance() {
        return balance;
    }
}
