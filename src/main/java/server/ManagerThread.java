/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vita
 */
public class ManagerThread extends Thread{
    public static final int PORT = 8082;
    private Socket socket;
    private int serverNumber = 11; //change to database
    
    public ManagerThread(Socket s) throws IOException {
		socket = s;
                start();
    }
    @Override
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            while(true){
                String str = in.readLine();
                if(str == null)
                    continue;
                Gson gson = new Gson();
                Request jsonRequest = gson.fromJson(str, Request.class);                
                String method = jsonRequest.getMethod();
                if(method.equals("check")){
                    //
                }      
               
            }
        }
        catch (IOException ex) {
            Logger.getLogger(ManagerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
