/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
//import javax.swing.MultiUIDefaults.MultiUIDefaultsEnumerator.Type;

/**
 *
 * @author Vita
 */
public class RestaurantThread extends Thread{
    public static final int PORT = 8082;
    private Socket socket;
    private int serverNumber = 11; //change to database
    
    public RestaurantThread(Socket s) throws IOException {
		socket = s;
                start();
    }
    
    private boolean checkEmployee(int id){
        return serverNumber==id;
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
                //////lots of codes here :)
                Gson gson = new Gson();
                ///правильно розпарсити
               // ArrayList<String> members = gson.fromJson(str, ArrayList.class);
                File f = new File("f.txt");
                //f.createNewFile();
                PrintWriter out2 = new PrintWriter(f);
                out2.println(str);
                out2.close();
		/*out2.println(members.get(0));
					
                String method = members.get(0);
                if(method.equals("check")){
                    if(checkEmployee(Integer.parseInt(members.get(1)))){
                        //замінити на адекват
                        //new JFrame().setVisible(true);
                    };
                } */       
            }
        }
        catch (IOException ex) {
            Logger.getLogger(RestaurantThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}
