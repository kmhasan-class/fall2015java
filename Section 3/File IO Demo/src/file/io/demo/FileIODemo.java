/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.io.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author kmhasan
 */
public class FileIODemo {
    public static void writeDemo() {
        try {
            RandomAccessFile output = new RandomAccessFile("output.txt", "rw");
            /*
            // To remove all content of a file and to start writing from
            // the beginning
            output.setLength(0);
            output.writeBytes("CSE2015\n");
            */
            // To add something to the existing file without destroying anything
            output.seek(output.length());
            output.writeBytes("CSE1034\n");
        } catch (FileNotFoundException e) {
            System.out.printf("We did not find output.txt\n");
        } catch (IOException e) {
            System.out.printf("Could not write to file output.txt\n");
        }
    }
    
    public static void readDemo() {
        try {
            RandomAccessFile input = new RandomAccessFile("output.txt", "r");
            String line;
//            while ((line = input.readLine()) != null)
            while (true) {
                line = input.readLine();
                if (line == null)
                    break;
                System.out.printf("%s\n", line);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("Could not find file output.txt\n");
        } catch (IOException e) {
            System.out.printf("Could not read from file\n");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //writeDemo();
        readDemo();
    }
}
