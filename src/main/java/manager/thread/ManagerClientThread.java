/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import server.Server;

/**
 *
 * @author Vita
 */
public class ManagerClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    
    public ManagerClientThread(InetAddress addr) throws java.lang.NullPointerException{
        try {
            socket = new Socket(addr, Server.PORT2);
        } catch (IOException e) {
            System.err.println("IOException |?|?|?|?|?|??|");
        }
        try {
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream())), true);
            start();
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException e2) {
                System.err.println("IO EXCEPTION");
            }
        }
    }
    
    public void closeThread(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Socket not closed");
        }
    }
}
