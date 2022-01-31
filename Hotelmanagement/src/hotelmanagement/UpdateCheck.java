
package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class UpdateCheck extends JFrame implements ActionListener{
    
     JTextField t1,t2,t3,t4,t5;
     JButton b1,b2,b3;
     Choice h2;
    
    UpdateCheck(){
        
        JLabel l1 = new JLabel("Check in Details");
        l1.setFont(new Font("Tahoma",Font.BOLD,19));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90, 20, 250, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Customer ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setBounds(30, 80, 120, 20);
        add(l2);
        
         h2= new Choice();  
        try{
            conn c = new conn();
            h2.setBounds(200, 80, 150, 30);
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
            
            add(h2);
           
            while(rs.next()){
                h2.add(rs.getString("number"));
               
            }
             
        }catch(Exception e){
            
        }
        
        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        l3.setBounds(30, 130, 120, 20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200, 130, 150, 30);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        l4.setBounds(30, 180, 120, 20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200, 180, 150, 30);
        add(t2);
        
        JLabel l5 = new JLabel("Check-In");
        l5.setFont(new Font("Tahoma",Font.PLAIN,17));
        l5.setBounds(30, 230, 120, 20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);
        
        JLabel l6 = new JLabel("Amount Paid");
        l6.setFont(new Font("Tahoma",Font.PLAIN,17));
        l6.setBounds(30, 280, 120, 20);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200, 280, 150, 30);
        add(t4);
        
        JLabel l7 = new JLabel(" Pending Amount");
        l7.setFont(new Font("Tahoma",Font.PLAIN,17));
        l7.setBounds(30, 330, 140, 20);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200, 330, 150, 30);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(115, 375, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(5,420, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(230, 420, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/check.png"));
        Image i2 = i1.getImage().getScaledInstance(380, 380, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l9 = new JLabel(i3);
        l9.setBounds(400, 10, 430, 430);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(360, 200, 900, 500);
        setLayout(null);
        setVisible(true);
    }
    
    
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()==b1){
           
             
           try{
               String price = null;
               String room = null;
               String deposit = null;
               int amountPaid;
               
               conn c = new conn();
               String id = h2.getSelectedItem();
               String str = "select * from customer where number = '"+id+"'";
               ResultSet rs = c.s.executeQuery(str);
               while (rs.next()){                 

                     t1.setText(rs.getString("room"));
                     t2.setText(rs.getString("name"));
                     t3.setText(rs.getString("status"));
                     t4.setText(rs.getString("deposit"));
                     room = rs.getString("room");
                     deposit = rs.getString("deposit");
                   
               }
               ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
               while (rs2.next()){
           
               price = rs2.getString("price");
               amountPaid = Integer.parseInt(price)-Integer.parseInt(deposit);
               t5.setText(Integer.toString(amountPaid));
              
           
           }

             
           }catch(Exception e){
           System.out.println(e);
           }
             
         }else if(ae.getSource()==b2){
             
         }else if(ae.getSource()==b3){
            
              new Reception().setVisible(true);
              this.setVisible(false);
          }
     }
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
