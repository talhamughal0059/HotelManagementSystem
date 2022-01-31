
package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class PickUp extends JFrame implements ActionListener{
    
     JTable t1;
     Choice h2;
     JCheckBox c2;
     JButton b1,b2,b3;
     
    PickUp(){
        
        JLabel l1 = new JLabel("PickUp Service");
        l1.setFont(new Font("Tahoma",Font.BOLD,22));
        l1.setForeground(Color.BLUE);
        l1.setBounds(420, 20, 300, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Brand of Car");
        l2.setFont(new Font("Tahoma",Font.BOLD,18));
        l2.setForeground(Color.BLACK);
        l2.setBounds(50, 100, 140, 20);
        add(l2);
        
        h2 = new Choice();

        
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("Select * from driver");
            while(rs.next()){
                h2.add(rs.getString("company"));
            }
            
        }catch(Exception e){
            
            
        }
        
        h2.setBounds(200, 100, 180, 30);
        add(h2);
        
        t1 = new JTable();
        t1.setBounds(0, 200, 1000, 300);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(290, 530, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550, 530, 150, 30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Name");
        l3.setFont(new Font("Tahoma",Font.PLAIN,20));
        l3.setForeground(Color.BLACK);
        l3.setBounds(45, 160, 120, 30);
        add(l3);
        
        JLabel l4 = new JLabel("age");
        l4.setFont(new Font("Tahoma",Font.PLAIN,20));
        l4.setForeground(Color.BLACK);
        l4.setBounds(200, 160, 300, 30);
        add(l4);
        
        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("Tahoma",Font.PLAIN,20));
        l5.setForeground(Color.BLACK);
        l5.setBounds(330, 160, 300, 30);
        add(l5);
        
        JLabel l6 = new JLabel("Company");
        l6.setFont(new Font("Tahoma",Font.PLAIN,20));
        l6.setForeground(Color.BLACK);
        l6.setBounds(460, 160, 300, 30);
        add(l6);
        
        JLabel l7 = new JLabel("Brand");
        l7.setFont(new Font("Tahoma",Font.PLAIN,20));
        l7.setForeground(Color.BLACK);
        l7.setBounds(610, 160, 300, 30);
        add(l7);
        
        JLabel l8 = new JLabel("Availability");
        l8.setFont(new Font("Tahoma",Font.PLAIN,20));
        l8.setForeground(Color.BLACK);
        l8.setBounds(750, 160, 300, 30);
        add(l8);
        
        JLabel l9 = new JLabel("Lacation");
        l9.setFont(new Font("Tahoma",Font.PLAIN,20));
        l9.setForeground(Color.BLACK);
        l9.setBounds(900, 160, 300, 30);
        add(l9);
                
          getContentPane().setBackground(Color.WHITE);
          
          
        setLayout(null);
        setBounds(300,180,1000,620);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){                                                //methord over.R  (obj)
         
         if (ae.getSource() == b1){
             
              try{
           conn c = new conn();
           
           String str = "select * from driver where company = '"+ h2.getSelectedItem()+"'";
         
               ResultSet  rs = c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
               
         }catch(Exception e){
         System.out.println(e);
         }
             
         }else if (ae.getSource() == b2){
             new Reception().setVisible(true);
           this.setVisible(false);
         }
     }
    public static void main(String[] args){
         new PickUp().setVisible(true);
     }
}

