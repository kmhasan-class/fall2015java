/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.console.demo;

import java.io.IOException;
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
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.printf("Server running on port 8080\n");
            
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.printf("Connected with %s\n", socket);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
