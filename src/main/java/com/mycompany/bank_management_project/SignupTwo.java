/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_project;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author user
 */

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author user
 */
public class SignupTwo extends JFrame implements ActionListener {
    long random;
    JTextField nidnotf,nametf,fnametf,emailtf,addresstf,citytf,statetf,areacodetf,birthnumtf ;
    JButton next;
    JDateChooser datechooser;
    JRadioButton male ,single, syes,sno,acyes,acno ;
   JComboBox religion_val, catagory, income, edu, occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
       
        
        
        JLabel Additional_detail = new JLabel("Page 2 : Additional Details  ");   
        Additional_detail .setFont(new Font("Raleway",Font.BOLD,22));
        Additional_detail .setBounds(290,80,400,30);
        add(Additional_detail );
        
        JLabel religion= new JLabel("Religion ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
        String religions_combo[] = {"Islam", "Hindu", "Christian", "Buddhist"};
        religion_val = new JComboBox(religions_combo);
        religion_val.setBounds(300,140,400,30);
        religion_val.setBackground(Color.WHITE);
        add(religion_val);
        
        
        
        JLabel category = new JLabel("Category ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,190,200,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        String catagory_val[] = {"General", "OBC", "GC", "Other"};
        catagory = new JComboBox(catagory_val);
        catagory.setBounds(300,190,400,30);
        catagory.setBackground(Color.WHITE);
        add(catagory);


         
        JLabel Income = new JLabel("Income ");
        Income.setFont(new Font("Raleway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        
            String income_val[] = {"10000-20000","20000-40000","40000-60000","60000-80000"};
            income = new JComboBox(income_val);
            income.setBounds(300,240,400,30);
            income.setBackground(Color.WHITE);
            add(income);
        
      
        JLabel Educational = new JLabel("Educational ");
        Educational.setFont(new Font("Raleway",Font.BOLD,20));
        Educational.setBounds(100,290,200,30);
        add(Educational);
        
      
        JLabel Qualification  = new JLabel("Qualification  ");
        Qualification .setFont(new Font("Raleway",Font.BOLD,20));
        Qualification .setBounds(100,340,200,30);
        add(Qualification );
        

            String edu_val[] = {
         "Graduate",
         "Non Graduate",
         "Post Graduate",
         "Doctorate",
         "Other"
     };

     edu = new JComboBox(edu_val);

     edu.setBounds(300,320,400,30);
     edu.setBackground(Color.WHITE);
     add(edu);
   
        
        JLabel Occupation = new JLabel("Occupation");
        Occupation.setFont(new Font("Raleway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        
                String occupation_val[] = {
             "Self-Employed",
             "Business",
             "Student",
             "Other",
             "Retired"
         };

         occupation = new JComboBox(occupation_val);

         occupation.setBounds(300,390,400,30);
         occupation.setBackground(Color.WHITE);
         add(occupation);
        
        
      
        JLabel birthnum = new JLabel("Birth Number");
        birthnum.setFont(new Font("Raleway",Font.BOLD,20));
        birthnum.setBounds(100,440,200,30);
        add(birthnum);
        
        
        birthnumtf= new JTextField("");
        birthnumtf.setFont(new Font("Raleway",Font.BOLD,14));
        birthnumtf.setBounds(300,440 ,400,30);
        add(birthnumtf);
        
        
        JLabel nidno= new JLabel("National ID ");
        nidno.setFont(new Font("Raleway",Font.BOLD,20));
        nidno.setBounds(100,490,200,30);
        add(nidno);       
        
        
        nidnotf= new JTextField("");
        nidnotf.setFont(new Font("Raleway",Font.BOLD,14));
        nidnotf.setBounds(300,490 ,400,30);
        add(nidnotf);
        
        
        JLabel Senior_Citizen = new JLabel("Senior Citizen  ");
        Senior_Citizen.setFont(new Font("Raleway",Font.BOLD,20));
        Senior_Citizen.setBounds(100,540,200,30);
        add(Senior_Citizen);
        
        syes = new JRadioButton(" Yes");
        syes.setBounds(300,540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No ");
        sno.setBounds(450, 540,100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup serinor_cit_val = new ButtonGroup();
        serinor_cit_val.add(syes);
        serinor_cit_val.add(sno);
        
        
        
        
        JLabel Existing_Account= new JLabel("Existing Account");
        Existing_Account.setFont(new Font("Raleway",Font.BOLD,20));
        Existing_Account.setBounds(100,590,200,30);
        add(Existing_Account);
        
        
        acyes = new JRadioButton(" Yes");
        acyes.setBounds(300,590, 100, 30);
        acyes.setBackground(Color.WHITE);
        add(acyes);
        
        acno = new JRadioButton(" No ");
        acno.setBounds(450, 590,100, 30);
        acno.setBackground(Color.WHITE);
        add(acno);
        
        ButtonGroup acno_choice  = new ButtonGroup();
        acno_choice.add(acyes);
        acno_choice.add(acno);
        
        
      
        
        
        next = new JButton("Next");
        next.setBounds(620,660,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
        
        
        
        
    }
    
        @Override
public void actionPerformed(ActionEvent ae) {

    String religions = (String) religion_val.getSelectedItem();
    String cats = (String) catagory.getSelectedItem();
    String incomes = (String) income.getSelectedItem();
    String edus = (String) edu.getSelectedItem();
    String occupations = (String) occupation.getSelectedItem();

    String birthnums = birthnumtf.getText();
    String nidnos = nidnotf.getText();

    String Senior_Citizen=null;

    if (syes.isSelected()) {
        Senior_Citizen = "Yes";
    } else {
        Senior_Citizen = "No";
    }

    String Existing_Account;

    if (acyes.isSelected()) {
        Existing_Account = "Yes";
    } else {
        Existing_Account = "No";
    }

    try {

        DBConnection c = new DBConnection();

        String query =
            "INSERT INTO signupTwo "
            + "(formno, religion, category, income, education, occupation, "
            + "birth_number, national_id, senior_citizen, existing_account) "
            + "VALUES ('"
            + formno + "','"
            + religions + "','"
            + cats + "','"
            + incomes + "','"
            + edus + "','"
            + occupations + "','"
            + birthnums + "','"
            + nidnos + "','"
            + Senior_Citizen + "','"
            + Existing_Account + "')";

        c.s.executeUpdate(query);

       // JOptionPane.showMessageDialog(null,null);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                 

    } catch (Exception e) {
        e.printStackTrace();

        JOptionPane.showMessageDialog(null,
                "Database Error: " + e.getMessage());
    }
}
    
    public static void main(String[] args) {
        new SignupTwo("");
        
        
    }


    
}


