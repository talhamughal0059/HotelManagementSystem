
package hotelmanagement;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    
     JTable t1;
    JButton b1,b2;
    
    Room(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/rooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(120, 50, 750, 480);
        add(icon);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setFont(new Font("Tahoma",Font.BOLD,15));
        l1.setBounds(30, 10, 130, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setFont(new Font("Tahoma",Font.BOLD,15));
        l2.setBounds(250, 10, 130, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setFont(new Font("Tahoma",Font.BOLD,15));
        l3.setBounds(470, 10, 70, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setFont(new Font("Tahoma",Font.BOLD,15));
        l4.setBounds(675, 10, 70, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setFont(new Font("Tahoma",Font.BOLD,15));
        l5.setBounds(850, 10, 70, 20);
        add(l5);
        
        t1 = new JTable();
        t1.setBounds(0, 40, 1000, 500);
        add(t1);
 
        b1 = new JButton("Load Data ");    
        b1.setFont(new Font("Tahoma",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200, 560, 120, 30);
        add(b1);
        
        b2 = new JButton("Back");   
        b2.setFont(new Font("Tahoma",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setBounds(680, 560, 120, 30);
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
           String str = "select * from room";
           ResultSet rs = c.s.executeQuery(str);
             
            t1.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e){}
            
        }else if(ae.getSource()==b2){
           new Reception().setVisible(true);
           this.setVisible(false);
        }
     }
     
     public static void main(String[] args){
         new Room().setVisible(true);
     }
        
    }