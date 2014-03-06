/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DBofrestaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @angelika
 */
public class CreationofDB {
       private static Object con; 
    
    private void initialization(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement work = con.prepareStatement("create table if not exists 'WORKERS' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' text, 'EXPERIENSE' INTEGER, 'POST' text);");
            int result = work.executeUpdate();
               work.close();
            PreparedStatement manag = con.prepareStatement("create table if not exists 'MANAGER' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' text, 'EXPERIENSE' INTEGER);");
            int result2 = manag.executeUpdate();
                //manag.close();
            PreparedStatement men = con.prepareStatement("create table if not exists 'MENU' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'CATEGORY' text, 'NAME' text, 'COMPOUND' text, 'PRICE' REAL);");
            int result3 = men.executeUpdate();
                //men.close();
            PreparedStatement order = con.prepareStatement("create table if not exists 'ORDERS' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'COMPOUND_OF_ORDERS' text, 'CASHIER' text, 'ALL PRICE' REAL);");
            int result4 = order.executeUpdate();
                //order.close();
            
         work.close();
           
        } catch (ClassNotFoundException e) {
            System.out.println("Не знайшли драйвер JDBC");
            e.printStackTrace();
            System.exit(0);
        } catch (SQLException e) {
            System.out.println("Не вірний SQL запит");
            e.printStackTrace();
        }
    }
     private void insertWorks(String name, int experiense, String post){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO WORKERS(NAME,EXPERIENSE,POST) VALUES (?,?,?)");
            statement.setString(1,"Oleh");
            statement.setInt(2,4);
            statement.setString(3,"Офіціант");

            int result = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
     
     private void insertManager(String name, int experiense){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO MANAGER(NAME,EXPERIENSE) VALUES (?,?)");
            statement.setString(1,"Olena");
            statement.setInt(2,5);
            
            int result2 = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      private void insertMenu (String category, String name, String compound, int price){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO MENU(CATEGORY,NAME,COMPOUND,PRICE) VALUES (?,?,?,?)");
            statement.setString(1,"піца");
            statement.setString(2,"Barbecue");
            statement.setString(3,"курка,моцарела,соус барбекю");
            statement.setInt(4,30);
            int result2 = statement.executeUpdate();

            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      private void DeleteManagers(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MANAGER WHERE Id=?");
            statement1.setInt(1, 1);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
        private void DeleteWORKERS(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM WORKERS WHERE Id=?");
            statement1.setInt(1, 1);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      private void DeleteMenu(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MENU WHERE Id=?");
            statement1.setInt(1, 1);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      
      /*private void showAllDataWORKERS(){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
              try (Statement st = con.createStatement()) {
                  ResultSet res = st.executeQuery("SELECT * FROM WORKERS");
                  while (res.next()) {
                      String name = res.getString("NAME");
                      System.out.println (res.getShort("id")+" "+name);
                  }
                  res.close();
              }
        }catch(SQLException e){
            System.out.println("РќРµ РІС–СЂРЅРёР№ SQL Р·Р°РїРёС‚ РЅР° РІРёР±С–СЂРєСѓ РґР°РЅРёС…");
            e.printStackTrace();
        }
    }*/
    
public static void main(String[] args) throws SQLException {
    CreationofDB object1 = new CreationofDB();
        object1.initialization("");
       // object1.insertWorks("Oleh", 4,"Офіціант");
        //object1.insertManager("Olena", 5);
        object1.insertMenu("піца", "Barbecue","курка,моцарела,соус барбекю", 30);
        object1.DeleteMenu(1);
        
        }
  }

