/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.console.demo;

import java.io.IOException;
import java.io.InputStream;
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
        try {
            ServerSocket serverSocket = new ServerSocket(3668);
            System.out.printf("Server running on port 3668\n");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.printf("Connected with client %s\n", socket);
                
                InputStream in = socket.getInputStream();
                byte messageBytes[] = new byte[70];
                in.read(messageBytes);
                String message = new String(messageBytes);
                System.out.printf("Received [%s]\n", message);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
