/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clients;

import com.google.gson.Gson;
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
public class ClientThread extends Thread{
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    public ClientThread(InetAddress addr) throws NullPointerException {
        try {
            socket = new Socket(addr, Server.PORT);
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
        }
    }
    public String checkEmployee(int id) throws IOException{
        out.println("{\"method\":"+"\"check\""+",\"params\":["+id+"]}");
        return(in.readLine());
    }
    
    @Override
    public void run() {  
    }
    
    public void closeThread(){
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Socket not closed");
        }
    }

    public String toTable(int tableNumber, int userId) throws IOException {
        out.println("{\"method\":"+"\"addTable\""+",\"params\":[\""+tableNumber+"\",\""+userId+"\"]}");
        return(in.readLine());
    }
    public void closeTable(int id) {
        out.println("{\"method\":"+"\"closeTable\""+",\"params\":["+id+"]}");
    }

    public String getTables(int userId) throws IOException {
        out.println("{\"method\":"+"\"getTables\""+",\"params\":["+userId+"]}");
        return in.readLine();
    }
    public String[] getAllCategories() throws IOException{
        out.println("{\"method\":"+"\"getAllCategories\""+",\"params\":[]}");
        String response = in.readLine();
        Gson gson = new Gson();
        return gson.fromJson(response, String[].class);        
    }
    

    public String clockedIn(int userId) throws IOException {
        out.println("{\"method\":"+"\"clockedIn\""+",\"params\":["+userId+"]}");
        return in.readLine();
    }

    public void clockIn(int userId) {
        out.println("{\"method\":"+"\"clockIn\""+",\"params\":["+userId+"]}");
    }
     public void clockOut(int userId) {
        out.println("{\"method\":"+"\"clockOut\""+",\"params\":["+userId+"]}");
    }
     public String getClocks(int id) throws IOException{
        out.println("{\"method\":"+"\"getClocks\""+",\"params\":["+id+"]}");
        return in.readLine();
   
     }
}
