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
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class BalanceEnquiry extends JFrame implements ActionListener {
    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;
    BalanceEnquiry(String pin){
        this.pin=pin;
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(190, 350, 400, 35);
        l3.add(l1);
      
        b1 = new JButton("BACK");
        b1.setBounds(390, 633, 150, 35);
        b1.addActionListener(this);
        l3.add(b1);
        
        int balance =0;
        
        try{
            DBConnection c = new DBConnection();
            ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                String type = rs.getString("type");
                int amount = Integer.parseInt(rs.getString("amount"));
                if(type.equals("Deposit"))
                {
                    balance= balance + amount;
                }
                else if (type.equals("Withdraw") || type.equals("Withdrawl")){
                    balance= balance - amount ;
                }
            }
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
         l1.setText("Your Current Balance is Tk " + balance);
        
        
        
        setLayout(null);
        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
        
    }
    
    
    
    
    
      public static void main(String[] args) {
         new BalanceEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
}
