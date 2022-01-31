
package hotelmanagement;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;                              //db u tils  show values thorugh table 

public class EmployeeInfo extends JFrame implements ActionListener{
    
    JTable t1;
    JButton b1,b2;
    
    EmployeeInfo(){
        
        t1 = new JTable();
        t1.setBounds(0, 40, 1000, 500);
        add(t1);
        
        JLabel l1 = new JLabel("Name");
        l1.setFont(new Font("Tahoma",Font.BOLD,16));
        l1.setBounds(40, 10, 70, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setFont(new Font("Tahoma",Font.BOLD,16));
        l2.setBounds(170, 10, 70, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setFont(new Font("Tahoma",Font.BOLD,16));
        l3.setBounds(280, 10, 70, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setFont(new Font("Tahoma",Font.BOLD,16));
        l4.setBounds(410, 10, 70, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setFont(new Font("Tahoma",Font.BOLD,16));
        l5.setBounds(530, 10, 70, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setFont(new Font("Tahoma",Font.BOLD,16));
        l6.setBounds(650, 10, 70, 20);
        add(l6);
        
        JLabel l7 = new JLabel("ID Card");
        l7.setFont(new Font("Tahoma",Font.BOLD,16));
        l7.setBounds(780, 10, 70, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Email");
        l8.setFont(new Font("Tahoma",Font.BOLD,16));
        l8.setBounds(900, 10, 70, 20);
        add(l8);
        
        b1 = new JButton("Load Data ");    
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        b1.setBounds(260, 560, 120, 30);
        add(b1);
        
        b2 = new JButton("Back");   
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setBounds(600, 560, 120, 30);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300,180,1000,650);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==b1){
             try{
             conn c = new conn();
             String str = "select * from employee";
             ResultSet rs = c.s.executeQuery(str);
             
             t1.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
           new Reception().setVisible(true);
           this.setVisible(false);
        }
     }
     
     public static void main(String[] args){
         new EmployeeInfo().setVisible(true);
     }
}

