/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package max.demo;

/**
 *
 * @author kmhasan
 */
public class MaxDemo {
    public int findMax(int array[]) {
        int max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i] > max)
                max = array[i];
        return max;
    }

    public Comparable findMax(Comparable array[]) {
        Comparable max = array[0];
        for (int i = 1; i < array.length; i++)
            if (array[i].compareTo(max) > 0)
                max = array[i];
        return max;
    }

    public MaxDemo() {
        int a[] = {4, 2, 54, 1, 54, 32, 43, 98, 32};
        String names[] = {"Abul", "Babul", "Mofiz", "Kabul"};
        int maxInt = findMax(a);
        Comparable maxName = findMax(names);
        System.out.printf("Max %d\n", maxInt);
        System.out.printf("%s\n", maxName);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new MaxDemo();
    }
    
}
