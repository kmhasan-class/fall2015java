/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface.demo;

import java.util.Arrays;

/**
 *
 * @author kmhasan
 */
public class InterfaceDemo {
    public static Comparable findMax(Comparable array[]) {
        Comparable max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i].compareTo(max) > 0)
                max = array[i];
        return max;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BankAccount accounts[] = new BankAccount[4];
        accounts[0] = new CurrentAccount(101, "Abul", 1000.0);
        accounts[1] = new CurrentAccount(102, "Babul", 1000.0);
        accounts[2] = new SavingsAccount(103, "Kabul", 1000.0);
        accounts[3] = new CurrentAccount(104, "Ratul", 1000.0);
        accounts[1].withdraw(100);
        accounts[2].withdraw(200);
        accounts[3].withdraw(300);
        
        Arrays.sort(accounts);
        
        for (BankAccount account: accounts)
            System.out.printf("%s\n", account);
        
        System.out.printf("MAX %s\n", findMax(accounts));
    }
    
}
