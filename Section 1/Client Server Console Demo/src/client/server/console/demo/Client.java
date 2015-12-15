/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.console.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Client {
    public Client() {
        try {
            Socket socket = new Socket("172.17.0.119", 3867);
            System.out.printf("My client connected with the server\n");
            OutputStream out = socket.getOutputStream();
            String message;
            
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            while ((message = stdin.readLine()) != null) {
                out.write(message.getBytes());
                out.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
