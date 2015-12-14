/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.server.console.demo;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmhasan
 */
public class Client {
    public Client() {
        try {
            Socket socket = new Socket("172.17.0.119", 8080);
            System.out.printf("Connected to server\n");
        } catch (IOException ex) {
            //Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
