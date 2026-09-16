package com.mycompany.bank_management_project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// PDF imports
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class MiniStatement extends JFrame implements ActionListener {

    String pin;

    JButton b1, b2;
    JLabel l1, l2, l3, l4;

    public MiniStatement(String pin) {

        super("Mini Statement");
        this.pin = pin;
        getContentPane().setBackground(Color.WHITE);

        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);

        l2 = new JLabel("Grameen Bank");
        l2.setBounds(150, 20, 150, 20);
        add(l2);


        l3 = new JLabel();
        l3.setBounds(20, 80, 350, 20);
        add(l3);


        l4 = new JLabel();
        l4.setBounds(20, 400, 350, 20);
        add(l4);


        b1 = new JButton("Exit");
        b1.setBounds(20, 500, 100, 25);
        b1.addActionListener(this);
        add(b1);


        b2 = new JButton("Save PDF");
        b2.setBounds(140, 500, 120, 25);
        b2.addActionListener(this);
        add(b2);


        try {

            DBConnection c = new DBConnection();

            ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");

            while (rs.next()) {

                String cardNumber = rs.getString("cardno");

                l3.setText(
                        "Card Number: " + cardNumber.substring(0, 4)+ "XXXXXXXX"+ cardNumber.substring(12)
                                
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }



        try {

            int balance = 0;

            DBConnection c1 = new DBConnection();

            ResultSet rs = c1.s.executeQuery(  "SELECT * FROM bank where pin = '" + pin + "'");


            String statement = "<html>";


            while (rs.next()) {

                String date = rs.getString("date");
                String mode = rs.getString("type");
                String amount = rs.getString("amount");


                statement += date
                        + "&nbsp;&nbsp;&nbsp;"
                        + mode
                        + "&nbsp;&nbsp;&nbsp;"
                        + amount
                        + "<br><br>";


      
                if (mode.equals("Deposit")) {

                    balance += Integer.parseInt(amount);

                } else {

                    balance -= Integer.parseInt(amount);
                }
            }


            statement += "</html>";


            l1.setText(statement);


            l4.setText(   "Your total Balance is TK " + balance);


        } catch (Exception e) {

            e.printStackTrace();
        }


        setVisible(true);
    }


    public void generatePDF() {

        JFileChooser fileChooser = new JFileChooser();


        
        fileChooser.setSelectedFile(
                new File("MiniStatement_" + pin + ".pdf")
        );


        int option = fileChooser.showSaveDialog(this);

        if (option != JFileChooser.APPROVE_OPTION) {

            return;
        }


        File file = fileChooser.getSelectedFile();


      
        if (!file.getName().toLowerCase().endsWith(".pdf")) {

            file = new File(
                    file.getAbsolutePath() + ".pdf"
            );
        }


        Document document = new Document();


        try {

            PdfWriter.getInstance(
                    document, new FileOutputStream(file)
            );


            document.open();


          
            Font titleFont = new Font( Font.HELVETICA,18,Font.BOLD);


            Paragraph title = new Paragraph(
                    "Grameen Bank\neStatement\n\n",
                    titleFont
            );


            title.setAlignment(Element.ALIGN_CENTER);


            document.add(title);


       

            DBConnection c = new DBConnection();


      ResultSet rsLogin = c.s.executeQuery(
    "SELECT l.cardno, s.name " +
    "FROM login l " +
    "JOIN signup s ON l.formno = s.formno " +
    "WHERE l.pin = '" + pin + "'"
);


            if (rsLogin.next()) {

                String cardNumber =rsLogin.getString("cardno");
                 String accountName = rsLogin.getString("name");



                String maskedCard;


                if (cardNumber.length() >= 12) {

                    maskedCard =
                            cardNumber.substring(0, 4)
                            + "XXXXXXXX"
                            + cardNumber.substring(12);

                } else {

                    maskedCard = cardNumber;
                }


                document.add(new Paragraph("Account Name: " + accountName));
                document.add(new Paragraph("Card Number: " + maskedCard));
                document.add(new Paragraph("\n"));
               }

            document.add(new Paragraph("\n"));        
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            table.addCell("Date");
            table.addCell("Transaction");
            table.addCell("Amount");
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'" );


            int balance = 0;


            while (rs.next()) {

                String date = rs.getString("date");

                String mode = rs.getString("type");

                String amount = rs.getString("amount");

                
                table.addCell(date);

                table.addCell(mode);

                table.addCell(
                        "Tk " + amount
                );

                if (mode.equals("Deposit")) {

                    balance +=Integer.parseInt(amount);

                } else {

                    balance -= Integer.parseInt(amount);
                }
            }


  
            document.add(table);


            document.add( new Paragraph("\n"));


           
            Font balanceFont = new Font(Font.HELVETICA,14,Font.BOLD);


            Paragraph balanceText = new Paragraph("Current Balance: TK "+ balance, balanceFont);


            document.add(balanceText);


            document.add(new Paragraph("\nThank you for banking with Grameen Bank."));

            document.close();

            JOptionPane.showMessageDialog(this,"PDF Statement Generated Successfully!\n"+ file.getAbsolutePath());


        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error generating PDF: "+ e.getMessage() );
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {
                 this.setVisible(false);
        }
        else if (e.getSource() == b2) {
         generatePDF();
        }
    }

    public static void main(String[] args) {

        new MiniStatement("").setVisible(true);
    }
}