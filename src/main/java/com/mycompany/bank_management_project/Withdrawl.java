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

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;

/**
 *
 * @author user
 */
public class Withdrawl extends JFrame implements ActionListener {

    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    
    Withdrawl(String pin){
         this.pin = pin;
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
         
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS TK.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190,350,400,20);
        l3.add(l1);
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setBounds(190,400,400,20);
        l3.add(l2);
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(190,450,330,30);
        l3.add(t1);
        
         
        b1 = new JButton("WITHDRAW");
        b1.setBounds(390,588,150,35);
        b1.addActionListener(this);
        l3.add(b1);
        
        b2 = new JButton("BACK");
        b2.setBounds(390,633,150,35);
         b2.addActionListener(this);
        l3.add(b2);
        
        setLayout(null);
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String amount = t1.getText();
            Date date = new Date();
            if(e.getSource()== b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }
                else{
                    DBConnection c = new DBConnection();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                    int balance =0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance = balance + Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance = balance - Integer.parseInt(rs.getString("amount"));
                        }
                        
                    }
                     if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                     c.s.executeUpdate("insert into bank(pin, date, type, amount) values('" + pin + "', '" +date + "', 'Withdraw', '" +amount + "')");
                     JOptionPane.showMessageDialog(null, "TK "+amount+" Debited Successfully");
                     setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(e.getSource()==b2){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                    }
            
            else{
                   }
            
        }catch(Exception ae){
            ae.printStackTrace();
            System.out.println("error: "+e);
        }
        
    }
        
      public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
    
}
