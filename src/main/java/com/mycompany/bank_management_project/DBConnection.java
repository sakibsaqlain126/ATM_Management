/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_project;


import java.sql.*;

public class DBConnection {
    Connection c;
    Statement s;
    
    public DBConnection(){
     try{

         c=DriverManager.getConnection("jdbc:mysql:///bms","root","sakib");
         s=c.createStatement();
     }   
     catch(Exception e)
      {
          System.out.println(e);
      }
     
    }
}
