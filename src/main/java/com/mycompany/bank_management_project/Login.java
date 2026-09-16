package com.mycompany.bank_management_project;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField ;
    JPasswordField  pinTextField ;
    Login() {
        setTitle("Automated Teller Machine");
        setLayout(null);
        
        setSize(800, 480);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 =i1.getImage().getScaledInstance(100, 100 , Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel jl1 = new JLabel(i3);
        jl1.setBounds(70,10,100,100);
        add(jl1);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno= new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField = new JTextField();        
        cardTextField.setBounds(300, 150, 230 , 30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        
        
        JLabel pin= new JLabel("Pin ");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        
        pinTextField = new JPasswordField();        
        pinTextField.setBounds(300, 220, 230 , 30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
        login = new JButton("Sign in ");
        login.setBounds(300,300 ,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this );
        add(login);
        
        clear = new JButton(" Clear ");
        clear.setBounds(430,300 ,100,30 );
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this );
        add(clear);
        
        signup = new JButton("Sign Up ");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {

    try {

        if (ae.getSource() == clear) {

            cardTextField.setText("");
            pinTextField.setText("");

        }
        else if (ae.getSource() == login) {

            DBConnection c = new DBConnection();

            String cardnumber = cardTextField.getText();
            String pinno = new String(pinTextField.getPassword());

            String query = "select * from login where cardno='"+ cardnumber + "' and pin='" + pinno + "'";

            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);

                new Transactions(pinno).setVisible(true);

            } else {

                JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN" );
            }
        }

        else if (ae.getSource() == signup) {

            setVisible(false);

            new SignupOne().setVisible(true);
        }

    }catch(Exception e) {

        System.out.println(e);
        e.printStackTrace();
    }
}
    

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}