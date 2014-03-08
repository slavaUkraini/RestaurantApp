/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Vita
 */
public class Server {
    public static final int PORT = 8081;
    public static final int PORT2 = 8082;
    public static void main(String args[]) {
   java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Server s = new Server();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public Server() throws IOException {
        ServerSocket s = new ServerSocket(PORT);
        ServerSocket s2 = new ServerSocket(PORT2);
        JOptionPane.showMessageDialog(new JFrame(), "Server started");
		try {
                    while (true) {
                        Socket socket = s.accept();
                        try {
                            new RestaurantThread(socket);
                            //new ManagerThread(socket);
                        } catch (IOException e) {
                            socket.close();
                        }
                        Socket socket2 = s.accept();
                        try {
                            new ManagerThread(socket2);
                        } catch (IOException e) {
                            socket2.close();
                        }
                    }
		} finally {
			s.close();
                        s2.close();
		}
	}
    }
