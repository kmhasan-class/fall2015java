/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab10a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Server {
    public Server() {
        byte messageBytes[] = new byte[1000];
        String clientMessage;
        String serverMessage;
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            Socket socket = serverSocket.accept();
            
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            
            int bytesRead = input.read(messageBytes);
            clientMessage = new String(messageBytes).substring(0, bytesRead);
            
            if (clientMessage.equals("HELLO")) {
                serverMessage = "HELLO";
                output.write(serverMessage.getBytes());
                
                bytesRead = input.read(messageBytes);
                clientMessage = new String(messageBytes).substring(0, bytesRead);
                System.out.printf("Server received %s\n", clientMessage);
                // replace the following lines with split instead of substring
                String username = clientMessage.substring(9);
                System.out.printf("username is [%s]\n", username);
            } else {
                serverMessage = "NOHELLOFORYOU";
                output.write(serverMessage.getBytes());
                System.err.printf("Did not receive HELLO from client\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
