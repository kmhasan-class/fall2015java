/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Server {

    final int PORT_NUMBER = 9867;
    final int MSG_LENGTH = 1000;

    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.printf("Server running at port: %d\n", PORT_NUMBER);

            while (true) {
                Socket socket = serverSocket.accept();

                InputStream in = socket.getInputStream();
                byte messageBytes[] = new byte[MSG_LENGTH];
                int bytesRead = in.read(messageBytes);
                String message = new String(messageBytes);
                message = message.substring(0, bytesRead);
                String username = message.substring(new String("/USERNAME:").length());
                System.out.printf("Connected with %s @ %s\n", username, socket.getInetAddress());

                ThreadedServer threadedServer = new ThreadedServer(in, username);
                threadedServer.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
