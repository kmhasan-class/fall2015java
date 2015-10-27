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
//        String names[] = new String[4];
//        names[0] = "Rakib";
//        names[1] = "Hasan";
//        names[2] = "Tawseef";
//        names[3] = "Rajon";
//        names[1] = "Monirul";
//        for (int i = 0; i < names.length; i++)
//            System.out.printf("%s\n", names[i]);
        
        ArrayList<String> names = new ArrayList<>();
        names.add("Rakib");
        names.add("Hasan");
        names.add("Tawseef");
        names.remove(0);
        names.set(0, "Masud");
        names.add("Ashiq");
        for (int i = 0; i < names.size(); i++)
            System.out.printf("%s\n", names.get(i));
    }
    
}
