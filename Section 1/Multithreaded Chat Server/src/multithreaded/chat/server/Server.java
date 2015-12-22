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
    final int MAX_MSG_LENGTH = 1000;

    public Server() {
        ServerSocket serverSocket;
        Socket socket;
        InputStream in;
        byte messageBytes[];
        String message;
        String username;
        Date date;
        int bytesRead;

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            System.out.printf("Chat server running on port: %d\n", PORT_NUMBER);
            while (true) {
                socket = serverSocket.accept();
                System.out.printf("Accepted connection from %s\n", socket.getInetAddress());
                
                in = socket.getInputStream();
                messageBytes = new byte[MAX_MSG_LENGTH];
                
                bytesRead = in.read(messageBytes);
                message = new String(messageBytes).substring(0, bytesRead);
                String tokens[] = message.split("\\:");
                if (!tokens[0].equals("/USERNAME")) {
                    System.err.printf("Client did not provide username\n");
                    continue;
                }
                
                username = tokens[1];
                System.out.printf("Username: [%s]\n", username);
                ThreadedServer threadedServer = new ThreadedServer(in, username);
                Thread thread = new Thread(threadedServer);
                thread.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
