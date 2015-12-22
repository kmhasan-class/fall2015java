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
public class ThreadedServer implements Runnable {

    private String username;
    private InputStream in;

    public ThreadedServer(InputStream in, String username) {
        this.in = in;
        this.username = username;
    }

    @Override
    public void run() {
        Date date;
        int bytesRead;
        byte messageBytes[] = new byte[1000];

        String message;

        while (true) {
            try {
                date = new Date();
                bytesRead = in.read(messageBytes);
                if (bytesRead < 0) {
                    break;
                }
                message = new String(messageBytes).substring(0, bytesRead);
                System.out.printf("[%s][%s]: %s\n", date, username, message.substring(new String("/MESSAGE:").length()));
            } catch (IOException ex) {
                Logger.getLogger(ThreadedServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
