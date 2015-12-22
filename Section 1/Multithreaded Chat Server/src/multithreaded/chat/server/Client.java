/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.chat.server;

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
    final String SERVER_ADDRESS = "172.17.0.119";
    final int PORT_NUMBER = 9867;
    
    public Client() {
        Socket socket;
        String message;
        OutputStream out;
        String username;
        String inputLine;
        BufferedReader stdin;
        
        try {
            username = "John Doe";
            socket = new Socket(SERVER_ADDRESS, PORT_NUMBER);
            out = socket.getOutputStream();
            message = "/USERNAME:" + username;
            out.write(message.getBytes());
            
            stdin = new BufferedReader(new InputStreamReader(System.in));
            while ((inputLine = stdin.readLine()) != null) {
                if (inputLine.equals("/EXIT"))
                    break;
                message = "/MESSAGE:" + inputLine;
                out.write(message.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
