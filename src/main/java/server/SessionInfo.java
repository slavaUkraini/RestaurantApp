package server;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vita
**/

public class SessionInfo {
   public static final int maxTables = 111;
   private static SessionInfo reference;
   private int[] tables = new int[maxTables];
     
     private SessionInfo(){
         for(int i = 0; i<111; i++){
             tables[i]=0;
         }
     }
     public static SessionInfo getReference(){
         if (reference==null){
             reference = new SessionInfo();
         }
         return reference;
     }
     public boolean tableExist(int id){
         return tables[id]!=0;
     }
     public void addTable(int id, int serverId){
         tables[id] = serverId;
     }
     public void deleteTable(int id){
         tables[id]=0;
     }
     public int serverNumber(int id){
         return tables[id];
     }
}
