
package hotelmanagement;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class UpdateRoom extends JFrame implements ActionListener{
    
     JTextField t1,t2,t3;
     JButton b1,b2,b3;
     Choice c2;
    
    UpdateRoom(){
        
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.BOLD,19));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 10, 250, 30);
        add(l1);
        
        JLabel l2 = new JLabel("Guest ID");
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setBounds(30, 80, 120, 20);
        add(l2);
        
                c2= new Choice();  
        try{
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from  customer");
             c2.setBounds(200, 80, 150, 30);
            add(c2);
            while(rs.next()){
                c2.add(rs.getString("number"));
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
        
        JLabel l4 = new JLabel("Availability");
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        l4.setBounds(30, 180, 120, 20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(200, 180, 150, 30);
        add(t2);
        
        JLabel l5 = new JLabel("Clean Status");
        l5.setFont(new Font("Tahoma",Font.PLAIN,17));
        l5.setBounds(30, 230, 120, 20);
        add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200, 230, 150, 30);
        add(t3);
        
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(120, 290, 120, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(5,350, 120, 30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(230, 350, 120, 30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/rooms.jpg"));
        Image i2 = i1.getImage().getScaledInstance(640, 480, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(400, 10, 590, 450);
        add(l6);
        
        getContentPane().setBackground(Color.WHITE);
          
        setBounds(360, 200, 900, 470);
        setLayout(null);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room = null;
           String s1 = (String)c2.getSelectedItem();  
           conn c = new conn();
           
           try{
           ResultSet rs = c.s.executeQuery("select * from customer where number = '"+s1+"'");
          
           while (rs.next()){
           
               t1.setText(rs.getString("room"));
                room = rs.getString("room");
           
           }
           
            ResultSet rs2 = c.s.executeQuery("select * from room where room = '"+room+"'");
            while(rs2.next()){
                t2.setText(rs2.getString("available"));
                 t3.setText(rs2.getString("status"));
            }
           
           }catch(Exception e){
           System.out.println(e);
           }
           
        }else if(ae.getSource()==b2){
            
            try{
                conn c = new conn();
                
                  String room = t1.getText();
                  String available = t2.getText();
                  String status = t3.getText();
                  
                  String str = "update room set available = '"+available+"',  status = '"+status+"' where room = '"+room+"'";
                  c.s.executeUpdate(str);
                  JOptionPane.showConfirmDialog(null, "Room Updated Successfully");
                  new Reception().setVisible(true);
                  this.setVisible(false);
                
            }catch(Exception e){
                
            }
        }else if(ae.getSource()==b3){
            
              new Reception().setVisible(true);
              this.setVisible(false);
          }
        
    }
     public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }
}
