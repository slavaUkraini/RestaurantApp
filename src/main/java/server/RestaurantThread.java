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
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
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
                        if (SessionInfo.getReference().serverNumber(id)!=serverId)
                        response="Wrong table";
                        else response = "true";
                    }
                    else{
                        response = "true";
                    } 
                    out.println(response);
                }
                else if(method.equals("closeTable")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    SessionInfo.getReference().deleteTable(id);
                }
                else if(method.equals("getTables")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    LinkedList<Integer> ll = (LinkedList<Integer>) SessionInfo.getReference().getTables(id);
                    if (ll.size()==0)
                        out.println("null");
                    else out.println(gson.toJson(ll));
                }
                else if(method.equals("clockedIn")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    //if (SessionInfo.getReference().clockedIn(id))
                    out.println(SessionInfo.getReference().clockedIn(id));
                }
                 else if(method.equals("clockIn")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    //if (SessionInfo.getReference().clockedIn(id))
                    SessionInfo.getReference().clockIn(id);
                }
                else if(method.equals("clockOut")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    //if (SessionInfo.getReference().clockedIn(id))
                    SessionInfo.getReference().clockOut(id);
                }
                else if(method.equals("getClocks")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    out.println(SessionInfo.getReference().getClocks(id));
                } 
                ////////////MANAGER/////////////
                else if(method.equals("addEmployee")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    String name = jsonRequest.getParam(1);
                    String surname = jsonRequest.getParam(2);
                    double salary = Double.parseDouble(jsonRequest.getParam(3));
                    //insert to database
                    out.println("true");
                }    
                else if(method.equals("addCategory")){
                    String name = jsonRequest.getParam(0);
                    //insert to database
                    out.println("true");
                }
                else if(method.equals("addDish")){
                    String category = jsonRequest.getParam(0);
                    String name = jsonRequest.getParam(1);
                    String description = jsonRequest.getParam(2);
                    double price = Double.parseDouble(jsonRequest.getParam(3));
                    //insert to database
                    out.println("true");
                }
                else if(method.equals("deleteCategory")){
                    String name = jsonRequest.getParam(0);
                    //delete from database
                }
                 else if(method.equals("deleteDish")){
                    String name = jsonRequest.getParam(0);
                    //delete from database
                }
                 else if(method.equals("deleteEmployee")){
                    int id = Integer.parseInt(jsonRequest.getParam(0));
                    //delete from database
                }
                else if(method.equals("changePass")){
                    //SessionInfo.password = jsonRequest.getParam(0);
                    File f = new File("Pass.txt");
                    if (!f.exists()){
                        f.createNewFile();
                    }
                    PrintWriter out2 = new PrintWriter(f);
                    out2.println(jsonRequest.getParam(0));
                    out2.close();
                } 
                else if(method.equals("checkPass")){
                    File f = new File("Pass.txt");
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String pass = br.readLine();
                    System.out.println(pass);
                    fr.close();
                    if(pass.equals(jsonRequest.getParam(0)))
                        out.println("true");
                    else out.println("false");
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
