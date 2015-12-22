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
        int bytesRead;

        try {
            serverSocket = new ServerSocket(PORT_NUMBER);
            while (true) {
                socket = serverSocket.accept();
                in = socket.getInputStream();
                messageBytes = new byte[MAX_MSG_LENGTH];
                while (true) {
                    bytesRead = in.read(messageBytes);
                    if (bytesRead < 0) {
                        break;
                    }
                    message = new String(messageBytes).substring(0, bytesRead);
                    System.out.printf("%s\n", message);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
