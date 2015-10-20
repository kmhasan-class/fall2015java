/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.io.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class FileIODemo {
    public static void writeFile() {
        RandomAccessFile output;
        // Exception Handling
        // Read up Chapter 11 from Java How to Program
        try {
            output = new RandomAccessFile("output.txt", "rw");
            //output.setLength(0);
            output.seek(output.length());
            output.writeBytes("ki ase gebone?\n");
        } catch (FileNotFoundException e) {
            System.out.printf("Could not find file\n");
        } catch (IOException e) {
            System.out.printf("Could not write to file\n");
        }
    }
    
    public static void readFile() {
        RandomAccessFile input;
        try {
            input = new RandomAccessFile("output.txt", "r");
            String line;

//            while ((line = input.readLine()) != null) {
//            while (true) {
            for (;;) {
                line = input.readLine();
                if (line == null)
                    break;
                System.out.printf("%s\n", line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileIODemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        writeFile();
        readFile();
    }
    
}
