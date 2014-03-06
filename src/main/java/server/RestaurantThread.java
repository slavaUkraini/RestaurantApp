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
import java.util.LinkedList;
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
        return (serverNumber==id)||(id==22);//замінити на базу даних, а не цю херню, блять
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
                /*File f = new File("f.txt");
                f.createNewFile();
                PrintWriter out2 = new PrintWriter(f);
                out2.println(str);
                out2.println(s.getMethod());
                out2.close();*/
                Request jsonRequest = gson.fromJson(str, Request.class);                
                String method = jsonRequest.getMethod();
                if(method.equals("check")){
                    boolean response = checkEmployee(Integer.parseInt(jsonRequest.getParam(0)));
                    out.println(response);
                }      
                else if(method.equals("addTable")){
                    String response;
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    int serverId= Integer.parseInt(jsonRequest.getParam(1));
                    if ((SessionInfo.getReference().serverNumber(id)!=serverId)&&(SessionInfo.getReference().serverNumber(id)!=0)){
                        response="Wrong table";
                    }
                    else if(!SessionInfo.getReference().tableExist(id)){
                        //якщо столик вільний, і його ніхто не обслуговує
                        SessionInfo.getReference().addTable(id, serverId);
                        response = "true";
                    }
                    else{
                        response = "true";
                    } 
                    out.println(response);
                }
                else if(method.equals("getTables")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    LinkedList<Integer> ll = (LinkedList<Integer>) SessionInfo.getReference().getTables(id);
                    if (ll.size()==0)
                        out.println("null");
                    else out.println(gson.toJson(ll));
                }
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
