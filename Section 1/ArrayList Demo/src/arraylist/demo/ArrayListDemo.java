/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylist.demo;

import java.util.ArrayList;

/**
 *
 * @author kmhasan
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String names[] = new String[5];
//        names[0] = "Rakib";
//        names[1] = "Ashiq";
//        names[2] = "Hasan";
//        names[3] = "Rajon";
//        names[4] = "Tawseef";
//        names[2] = "Masud";
//        
//        for (int i = 0; i < names.length; i++)
//            System.out.printf("%s\n", names[i]);
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Rakib");
        names.add("Ashiq");
        names.add("Hasan");
        names.set(2, "Masud");
        for (int i = 0; i < names.size(); i++)
            System.out.printf("%s\n", names.get(i));
    }
    
}
