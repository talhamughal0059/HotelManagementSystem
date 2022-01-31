
package hotelmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class CheckOut extends JFrame implements ActionListener{
    
     Choice h2;
     JTextField t1,t2;
     JButton b1,b2,b3;
    
    CheckOut(){
        
        JLabel l1 = new JLabel("Check Out");
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        l1.setBounds(110, 20, 250, 30);
        add(l1);
        
         JLabel l2 = new JLabel("Customer ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setBounds(30, 80, 120, 20);
        add(l2);
        
       
        
        
         h2= new Choice();  
        
        try{
            conn c = new conn();                                  //object new conn
            String str = "select * from customer";
            ResultSet rs = c.s.executeQuery(str);
             h2.setBounds(160, 80, 150, 30);
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
        t1.setBounds(160, 130, 150, 30);
        add(t1);
        
        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40, 200, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,200, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/tick.jpg"));
        Image i2 = i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        b3 = new JButton(i3);
        b3.setBounds(320, 80, 20, 20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/checkout.jpg"));
        Image i5 = i4.getImage().getScaledInstance(390, 380, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i6);
        l4.setBounds(350, 0, 420, 250);
        add(l4);
        
        
        getContentPane().setBackground(Color.WHITE);
          
        setBounds(390, 200, 800, 300);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){
            
            String id =h2.getSelectedItem();
             String room =t1.getText();
             String str = " delete from customer where number = '"+id+"'";
             String str2 = " update room set available = 'Available' where room = '"+room+"'";
             conn c = new conn();
             try{
                 c.s.executeUpdate(str);
                 c.s.executeUpdate(str2);
                 JOptionPane.showConfirmDialog(null, "Checkout Done");
                 
                new Reception().setVisible(true);
                this.setVisible(false);
                
             }catch(Exception e){
                 
             }
            
        }else if(ae.getSource()==b2){
            
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }else if(ae.getSource()==b3){
            
        
            conn c = new conn();
            String id = h2.getSelectedItem();
            
            try{
               ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");
               while (rs.next()){  
                t1.setText(rs.getString("room"));
               }
            }catch(Exception e){}
                  
    
        }
    }

     public static void main(String[] args){
        new CheckOut().setVisible(true);
    }
}
