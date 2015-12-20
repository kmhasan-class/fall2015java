/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10aclient;

import java.io.IOException;
import java.io.InputStream;
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
        String clientMessage;
        String serverMessage;
        String username = "John Doe";
        byte messageBytes[] = new byte[1000];
        
        try {
            Socket socket = new Socket("172.17.0.119", 9876);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            
            clientMessage = "HELLO";
            out.write(clientMessage.getBytes());
            int bytesRead = in.read(messageBytes);
            serverMessage = new String(messageBytes).substring(0, bytesRead);
            System.out.printf("Client received %s from server\n", serverMessage);
            if (serverMessage.equals("HELLO")) {
                clientMessage = "USERNAME:" + username;
                out.write(clientMessage.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
