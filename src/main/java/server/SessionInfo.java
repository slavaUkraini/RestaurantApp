package server;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vita
**/

class Tables{
   LinkedList<Integer> tables = new LinkedList<Integer>(); 
}
public class SessionInfo {
   public static final int maxTables = 111;
   public static final int maxServers = 50;
   private static SessionInfo reference;
   private int[] tables = new int[maxTables];
   private Tables[] servers = new Tables[maxServers];
     
     private SessionInfo(){
         for(int i = 0; i<maxTables; i++){
             tables[i]=0;
         }
         for (int i=0; i<maxServers;i++){
             servers[i]=new Tables();
         }
     }
     public static SessionInfo getReference(){
         if (reference==null){
             reference = new SessionInfo();
         }
         return reference;
     }
     synchronized public boolean tableExist(int id){
         return tables[id]!=0;
     }
     synchronized public void addTable(int id, int serverId){
         if(!tableExist(id)){
         tables[id] = serverId;
         servers[serverId].tables.add(id);
         }
     }
     public void deleteTable(int id){
         servers[serverNumber(id)].tables.remove(id);
         tables[id]=0;
     }
     public int serverNumber(int id){
         return tables[id];
     }
     public Iterable getTables(int id){
         return servers[id].tables;
     }
}
