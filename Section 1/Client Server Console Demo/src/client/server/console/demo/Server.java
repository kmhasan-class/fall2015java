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
            ServerSocket serverSocket = new ServerSocket(3867);
            System.out.printf("Server running on port 3867\n");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.printf("Connected with %s\n", socket);
                InputStream in = socket.getInputStream();
                byte messageBytes[] = new byte[1000];

                while (true) {
                    int bytesRead = in.read(messageBytes);
                    if (bytesRead == -1)
                        break;
                    String message = new String(messageBytes);
                    System.out.printf("[%s:] %s\n", socket.getInetAddress(), message.substring(0, bytesRead));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
