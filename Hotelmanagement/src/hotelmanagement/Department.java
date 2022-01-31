
package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;



public class Department extends JFrame implements ActionListener{
    
     JTable t1;
     JCheckBox c2;
     JButton b1,b2,b3;
     
    Department(){
        
        t1 = new JTable();
        t1.setBounds(0, 50, 500, 300);
        add(t1);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(150, 400, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(380, 400, 150, 30);
        b2.addActionListener(this);
        add(b2);
        
        JLabel l3 = new JLabel("Department");
        l3.setFont(new Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.BLACK);
        l3.setBounds(70, 10, 120, 30);
        add(l3);
        
        JLabel l4 = new JLabel("Budget");
        l4.setFont(new Font("Tahoma",Font.BOLD,18));
        l4.setForeground(Color.BLACK);
        l4.setBounds(340, 10, 120, 30);
        add(l4);
        
        
                
          getContentPane().setBackground(Color.WHITE);
          
          
        setLayout(null);
        setBounds(450,200,700,500);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){                                                //methord over.R  (obj)
         
         if (ae.getSource() == b1){
             
              try{
           conn c = new conn();
           
           String str = "select * from department ";
         
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
         new Department().setVisible(true);
     }
}

