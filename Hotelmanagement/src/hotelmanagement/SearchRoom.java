
package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class SearchRoom extends JFrame implements ActionListener{
    
     JTable t1;
     JComboBox c1;
     JButton b1,b2;
     JCheckBox c2;
     
    SearchRoom(){
        
        JLabel l1 = new JLabel("Search For Room");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        l1.setBounds(100, 20, 300, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Room Bed type");
        l2.setFont(new Font("Tahoma",Font.PLAIN,18));
        l2.setForeground(Color.BLACK);
        l2.setBounds(50, 100, 140, 20);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        c1.setBounds(200, 100, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2 = new JCheckBox(" Only Display Available");
        c2.setBounds(650, 100, 160, 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
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
        
        JLabel l3 = new JLabel("Room Number");
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        l3.setForeground(Color.BLACK);
        l3.setBounds(50, 160, 120, 30);
        add(l3);
        
        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        l4.setForeground(Color.BLACK);
        l4.setBounds(250, 160, 300, 30);
        add(l4);
        
        JLabel l5 = new JLabel("Cleaning Satatus");
        l5.setFont(new Font("Tahoma",Font.PLAIN,17));
        l5.setForeground(Color.BLACK);
        l5.setBounds(450, 160, 300, 30);
        add(l5);
        
        JLabel l6 = new JLabel("Price");
        l6.setFont(new Font("Tahoma",Font.PLAIN,17));
        l6.setForeground(Color.BLACK);
        l6.setBounds(700, 160, 300, 30);
        add(l6);
        
        JLabel l7 = new JLabel("Bed Type");
        l7.setFont(new Font("Tahoma",Font.PLAIN,17));
        l7.setForeground(Color.BLACK);
        l7.setBounds(850, 160, 300, 30);
        add(l7);
                
          getContentPane().setBackground(Color.WHITE);
          
          
        setLayout(null);
        setBounds(300,180,1000,620);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){                                                //methord over.R  (obj)
         
         if (ae.getSource() == b1){
             
              try{
           conn c = new conn();
           ResultSet rs;
           String str = "select * from Room where type = '"+ c1.getSelectedItem()+"'";
           String str2 = "select * from Room where available = 'Available' AND type = '"+ c1.getSelectedItem()+"'";
           
           
           if (c2.isSelected()){
               
                rs = c.s.executeQuery(str2);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
               
            }else{
               
                 rs = c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
               
           }
 
         }catch(Exception e){
         System.out.println(e);
         }
             
         }else if (ae.getSource() == b2){
             new Reception().setVisible(true);
           this.setVisible(false);
         }
     }
    public static void main(String[] args){
         new SearchRoom().setVisible(true);
     }
}
