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

/**
 *
 * @author Vita
 */
public class Server {
    public static final int PORT = 8081;
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
		try {
			while (true) {
				Socket socket = s.accept();
				try {
                                    new RestaurantThread(socket);
				} catch (IOException e) {
					socket.close();
				}
			}
		} finally {
			s.close();
		}
	}
    }
