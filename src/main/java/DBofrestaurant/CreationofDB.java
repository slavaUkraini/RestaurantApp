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
import server.SessionInfo;
/**
 *
 * @angelika
 */
public class CreationofDB {
       private static Object con; 
    //створюємо нашу базу даних
       
       public CreationofDB(){
           initialization("");
       }
    private void initialization(String name) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement work = con.prepareStatement("create table if not exists 'WORKERS' ('Id' INTEGER PRIMARY KEY UNIQUE, 'NAME' text UNIQUE, 'SURNAME' text UNIQUE, 'EXPERIENSE' INTEGER, 'POST' text, 'SALARY' REAL);");
            int result = work.executeUpdate();
               work.close();
            PreparedStatement manag = con.prepareStatement("create table if not exists 'MANAGER' ('Id' INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' text UNIQUE, 'SURNAME' text UNIQUE , 'EXPERIENSE' INTEGER, 'SALARY' REAL);");
            
            int result2 = manag.executeUpdate();
                //manag.close();
            PreparedStatement men = con.prepareStatement("create table if not exists 'MENU' ('Id' INTEGER PRIMARY KEY UNIQUE, 'CATEGORY' text, 'NAME' text UNIQUE, 'COMPOUND' text, 'PRICE' REAL);");
            int result3 = men.executeUpdate();
                //men.close();
            PreparedStatement order = con.prepareStatement("create table if not exists 'ORDERS' ('Id' INTEGER PRIMARY KEY UNIQUE, 'COMPOUND_OF_ORDERS' text, 'CASHIER' text, 'ALL PRICE' REAL);");
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
    //додаю працівників
     public void insertWorks(int id,String name,String surname, int experiense, String post, double salary){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO WORKERS(ID,NAME,SURNAME,EXPERIENSE,POST,SALARY) VALUES (?,?,?,?,?,?)");
            statement.setInt(1,id);
            statement.setString(2,name);
            statement.setString(3,surname);
            statement.setInt(4,experiense);
            statement.setString(5,post);
            statement.setDouble(6,salary);
            int result = statement.executeUpdate();
            //
            /*statement.setInt(1,334);
            statement.setString(2,"Оксана");
            statement.setString(3,"Нижник");
            statement.setInt(4,5);
            statement.setString(5,"Бармен");
            statement.setDouble(6,5000);
            int result1 = statement.executeUpdate();
            //
            statement.setInt(1,555);
            statement.setString(2,"Альона");
            statement.setString(3,"Кулик");
            statement.setInt(4,4);
            statement.setString(5,"Рецепшен");
            statement.setDouble(6,4300);
            int result2 = statement.executeUpdate();
            //
            statement.setInt(1,564);
            statement.setString(2,"Віта");
            statement.setString(3,"Матвійчук");
            statement.setInt(4,5);
            statement.setString(5,"Офіціант");
            statement.setDouble(6,4500);
            int result4 = statement.executeUpdate();*/

            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
     //додаю менеджера
     public void insertManager(String name,String surname, int experiense, double salary){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT  INTO MANAGER(NAME,SURNAME,EXPERIENSE,SALARY) VALUES (?,?,?,?)");
            statement.setString(1,name);
            statement.setString(2,surname);
            statement.setInt(3,experiense);
            statement.setDouble(4,salary);
            
            /*statement.setString(1,"Віктор");
            statement.setString(2,"Тихонов");
            statement.setInt(3,4);
             
            statement.setDouble(4,5000);
            */
            int result5 = statement.executeUpdate();
            /*statement.setString(1,"Вікторія");
            statement.setString(2,"Орлюк");
            statement.setInt(3,6);
            statement.setDouble(4,7000);
            
            int result6 = statement.executeUpdate(); */
            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
     //додаю меню
      public void insertMenu (int id,String category, String name, String compound, int price){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement = con.prepareStatement("INSERT INTO MENU(ID,CATEGORY,NAME,COMPOUND,PRICE) VALUES (?,?,?,?,?)");
            statement.setInt(1,id);
            statement.setString(2,category);
            statement.setString(3,name);
            statement.setString(4,compound);
            statement.setInt(5,price);
            int result7 = statement.executeUpdate();
            //
            /*statement.setInt(1,223);
            statement.setString(2,"піца");
            statement.setString(3,"Піца з куркою");
            statement.setString(4," маринована курка,цибуля,соус делікат,мариновані огірки");
            statement.setInt(5,45);
            int result8 = statement.executeUpdate();
            //
            statement.setInt(1,111);
            statement.setString(2,"десерти");
            statement.setString(3,"Полуничне морозиво");
            statement.setString(4,"морозиво пломбір, полуничний наповнювач");
            statement.setInt(5,15);
            int result9 = statement.executeUpdate();
            */

            statement.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      public void DeleteManagers(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MANAGER WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      //видалення працівника за айді
        public void DeleteWORKERS(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM WORKERS WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
        // видалення за ім'ям
        public void DeleteWORKERSofNAME( String name){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM WORKERS WHERE NAME=?");
            statement1.setString(1,name);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      public void DeleteMenu(int id){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MENU WHERE Id=?");
            statement1.setInt(1, id);
            
            int result = statement1.executeUpdate();

            statement1.close();
        }catch (SQLException e){
            System.out.println("Не правильно введенні дані");
            e.printStackTrace();
        }
    }
      //видалення страви за ім'ям
      public void DeleteMenuOFNAME(String name){
        try{
            Connection con = DriverManager.getConnection("jdbc:sqlite:restaurant.db");
            PreparedStatement statement1 = con.prepareStatement("DELETE FROM MENU WHERE NAME=?");
            statement1.setString(1,name);
            
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
        //object1.insertWorks(999, "Олег", "Королюк", 3, "Офіціант", 2200);
        //object1.insertWorks(334, "Оксана","Нижник",5,"Бармен", 5000);
        //object1.insertWorks(555, "Альона","Кулик",4,"Рецепшен", 4300);
       // object1.insertWorks(564, "Віта","Матвійчук",5,"Офіціант", 4500);
        object1.DeleteWORKERSofNAME("Тарас");
        
        //object1.insertManager("Віктор", "Тихонов",4,5000);
        //object1.insertManager("Вікторія", "Орлюк",6,7000);
        object1.insertMenu(121,"піца","Hawaiian","курка,моцарела,соус барбекю", 30);
        object1.insertMenu(324, "десерти", "чіз кейк", "", 10);
        }
  }

