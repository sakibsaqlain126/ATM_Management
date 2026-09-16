/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_management_project;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author user
 */
public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nametf,fnametf,emailtf,addresstf,citytf,statetf,areacodetf ;
    JButton next;
    JDateChooser datechooser;
    JRadioButton male ,female,single,married;
    SignupOne(){
        setLayout(null);
        Random ran = new Random();
        random= Math.abs(ran.nextLong()% 9000L)+1000L;  //Generates a Random Form Number 
        
        
        JLabel formno = new JLabel("Application Form No. "+ random);   
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20, 600, 40);
        add(formno);
        
        JLabel personaldetail = new JLabel("Page 1 : Personal Details ");   
        personaldetail.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetail.setBounds(290,80,400,30);
        add(personaldetail);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
         nametf = new JTextField("");
        nametf.setFont(new Font("Raleway",Font.BOLD,14));
        nametf.setBounds(300,140,400,30);
        add(nametf);
        
        JLabel fname = new JLabel("Father Name : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametf = new JTextField("");
        fnametf.setFont(new Font("Raleway",Font.BOLD,14));
        fnametf.setBounds(300,190,400,30);
        add(fnametf);
        
        
         
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        
        datechooser = new JDateChooser();
        datechooser.setBounds(300, 240, 400, 30);
        datechooser.setForeground(new Color(105,105,105));
        add(datechooser);
        
        
        
        
        
        
        JLabel gender = new JLabel("Gender ");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        
        JLabel email = new JLabel("Email  ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf = new JTextField("");
        emailtf.setFont(new Font("Raleway",Font.BOLD,14));
        emailtf.setBounds(300,340 ,400,30);
        add(emailtf);
        
        
        JLabel martitialstatus = new JLabel("Maritial Status ");
        martitialstatus.setFont(new Font("Raleway",Font.BOLD,20));
        martitialstatus.setBounds(100,390,200,30);
        add(martitialstatus);
        
        
        single = new JRadioButton(" Single");
        single.setBounds(300,390, 100, 30);
        single.setBackground(Color.WHITE);
        add(single);
        
        married = new JRadioButton("Married");
        married.setBounds(450, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        ButtonGroup marriedstatusgroup = new ButtonGroup();
        marriedstatusgroup.add(single);
        marriedstatusgroup.add(married);
        
        
        
        
        
        
        
        
        
        
        
        
        
        JLabel address= new JLabel("Address ");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        
        addresstf = new JTextField("");
        addresstf.setFont(new Font("Raleway",Font.BOLD,14));
        addresstf.setBounds(300,440 ,400,30);
        add(addresstf);
        
        
        
        
        JLabel city= new JLabel("City  ");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);              
        
        citytf = new JTextField("");
        citytf.setFont(new Font("Raleway",Font.BOLD,14));
        citytf.setBounds(300,490 ,400,30);
        add(citytf);
        
        
        JLabel state= new JLabel("State  ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        statetf = new JTextField("");
        statetf.setFont(new Font("Raleway",Font.BOLD,14));
        statetf.setBounds(300,540 ,400,30);
        add(statetf);
        
        
        
        
        JLabel areacode= new JLabel("Area code ");
        areacode.setFont(new Font("Raleway",Font.BOLD,20));
        areacode.setBounds(100,590,200,30);
        add(areacode);
        
        areacodetf = new JTextField("");
        areacodetf.setFont(new Font("Raleway",Font.BOLD,14));
        areacodetf.setBounds(300,590 ,400,30);
        add(areacodetf);
        
        
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
              String formno = ""+random;  //here random is converted to string 
              String name =nametf.getText();
              String fname=fnametf.getText();
              String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
              String gender= null;
              
              if(male.isSelected()){
                   gender="Male";
              }
              else{
                  gender="Female";
              }
              
              String email = emailtf.getText();
              String marital=null;
              if(single.isSelected()){
                  marital="Single";
              }
              else{
                  marital="Married";
              }
              String address= addresstf.getText();
              String city= citytf.getText();
              String state= statetf.getText();
              String areacode= areacodetf.getText();
              
              try{
                  if(name.isEmpty()){
                       JOptionPane.showMessageDialog(null, "Name is required ");
                  }
                  else{
                      DBConnection c = new DBConnection();

String query =
    "INSERT INTO signup "
    + "(formno, name, father_name, dob, gender, email, "
    + "marital_status, address, city, state, areacode) "
    + "VALUES ('"
    + formno + "','"
    + name + "','"
    + fname + "','"
    + dob + "','"
    + gender + "','"
    + email + "','"
    + marital + "','"
    + address + "','"
    + city + "','"
    + state + "','"
    + areacode + "')";

c.s.executeUpdate(query);
setVisible(false);
new SignupTwo(formno).setVisible(true);
                  }
              }
              catch(Exception e){
                  e.printStackTrace();
              }
              
              
              
    }
    
    public static void main(String[] args) {
        new SignupOne();
    }


    
}
