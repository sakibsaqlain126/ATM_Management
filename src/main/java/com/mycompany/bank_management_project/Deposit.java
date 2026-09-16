/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class Deposit extends JFrame implements ActionListener  {
      String pin ;
      JTextField t1,t2;
      JButton b1,b2,b3;
      JLabel l1,l2,l3;
    
    Deposit(String pin){
        
        
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1= new JLabel("Enter Amount You Want TO DEPOSIT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,350,400,35);
        l3.add(l1);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
//        t1.setForeground(Color.WHITE);
//        t1.setBackground(Color.red);
       t1.setBounds(190,420,320,25);
        l3.add(t1);
        
        
        b1 = new JButton("DEPOSIT");
        b1.setBounds(390,588,150,35);
        l3.add(b1);
        b1.addActionListener(this);
          
          
        b2 = new JButton("BACK");
        b2.setBounds(390,633,150,35);
        l3.add(b2);
        b2.addActionListener(this); 
        
        
        setSize(960,1080);
        setUndecorated(true);
        setLocation(500,0);
        setVisible(true);
        
    
    }
    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
      try{
           String amount = t1.getText();
           Date date = new Date(System.currentTimeMillis());
           if(e.getSource()==b1){
               if(t1.getText().equals("")){
                   JOptionPane.showMessageDialog(null, "Please Enter the amount You Want to Enter");
               }
               else{
                   DBConnection c1 = new DBConnection();
                  String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('"+ pin + "', '"+ date + "', 'Deposit', '"+ amount + "')";
                  c1.s.executeUpdate(query);
                  JOptionPane.showMessageDialog(null, "TK "+amount+" Deposited Successfully ");
                  setVisible(false);
                  new Transactions(pin).setVisible(true);
                  
               }
           }else if(e.getSource()==b2){
               setVisible(false);
               new Transactions(pin).setVisible(true);
           }
      } catch(Exception ae){
            ae.printStackTrace();
        }
        
    }
     
    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
