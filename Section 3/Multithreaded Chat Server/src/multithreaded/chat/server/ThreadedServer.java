/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class ThreadedServer extends Thread {
    private InputStream in;
    private String username;

    public ThreadedServer(InputStream in, String username) {
        this.in = in;
        this.username = username;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                byte messageBytes[] = new byte[1000];
                int bytesRead = in.read(messageBytes);
                if (bytesRead < 0) {
                    break;
                }
                String message = new String(messageBytes);
                message = message.substring(new String("/MESSAGE:").length(), bytesRead);
                System.out.printf("[%s][%s]: %s\n", new Date(), username, message);
            } catch (IOException ex) {
                Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
