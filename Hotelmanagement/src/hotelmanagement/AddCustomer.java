
package hotelmanagement;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
//import net.proteanit.sql.DbUtils;

public class AddCustomer extends JFrame implements ActionListener {
    
     JTextField t1,t2,t3,t4,t5;
     JRadioButton r1, r2;
     JComboBox c1;
     Choice c2;
     JButton b1,b2;
    
    AddCustomer(){
        
        JLabel l1 = new JLabel("NEW CUSTOMER FORM");
        l1.setFont(new Font("Tahoma",Font.BOLD,17));
        l1.setForeground(Color.BLACK);
        l1.setBounds(100, 20, 300, 30);
        add(l1);
        
        JLabel l2 = new JLabel("ID");                                                      //static
        l2.setFont(new Font("Tahoma",Font.PLAIN,17));
        l2.setForeground(Color.BLACK);
        l2.setBounds(30, 80, 100, 20);
        add(l2);
        
        c1 = new JComboBox(new String[] {"Passport","Voter-id Card","Driving License","Credit Card"});
        c1.setBounds(230, 80, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        JLabel l3 = new JLabel("Number");
        l3.setFont(new Font("Tahoma",Font.PLAIN,17));
        l3.setForeground(Color.BLACK);
        l3.setBounds(30, 130, 100, 20);
        add(l3);
        
        t1 = new JTextField();
        t1.setBounds(230, 130, 150, 30);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setFont(new Font("Tahoma",Font.PLAIN,17));
        l4.setForeground(Color.BLACK);
        l4.setBounds(30, 180, 100, 20);
        add(l4);
        
        t2 = new JTextField();
        t2.setBounds(230, 180, 150, 30);
        add(t2);
        
        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("Tahoma",Font.PLAIN,17));
        l5.setForeground(Color.BLACK);
        l5.setBounds(30, 230, 100, 20);
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font ("Tahoma",Font.PLAIN,14));
        r1.setBounds(230,230,70,30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font ("Tahoma",Font.PLAIN,14));
        r2.setBounds(300,230,70,30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        JLabel l6 = new JLabel("Country");
        l6.setFont(new Font("Tahoma",Font.PLAIN,17));
        l6.setForeground(Color.BLACK);
        l6.setBounds(30, 280, 100, 20);
        add(l6);
        
        t3 = new JTextField();
        t3.setBounds(230, 280, 150, 30);
        add(t3);
        
        JLabel l7 = new JLabel("Allocated Room Number");                   //dynamic db
        l7.setFont(new Font("Tahoma",Font.PLAIN,17));
        l7.setForeground(Color.BLACK);
        l7.setBounds(30, 330, 200, 20);
        add(l7);
        

        
        c2= new Choice();  
        try{
            conn c = new conn();
            String str = "select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                c2.add(rs.getString("room"));
            }
        }catch(Exception e){}
            c2.setBounds(230, 330, 150, 30);
            add(c2);
        
        
        JLabel l8 = new JLabel("Checked In");
        l8.setFont(new Font("Tahoma",Font.PLAIN,17));
        l8.setForeground(Color.BLACK);
        l8.setBounds(30, 380, 100, 20);
        add(l8);
        
        t4 = new JTextField();
        t4.setBounds(230, 380, 150, 30);
        add(t4);
        
        JLabel l9 = new JLabel("Deposit");
        l9.setFont(new Font("Tahoma",Font.PLAIN,17));
        l9.setForeground(Color.BLACK);
        l9.setBounds(30, 430, 100, 20);
        add(l9);
        
        t5 = new JTextField();
        t5.setBounds(230, 430, 150, 30);
        add(t5);
        
        b1 = new JButton("Add Customer");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30, 530, 150, 30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(220, 530, 150, 30);
        b2.addActionListener(this);
        add(b2);
        
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/add.customer.png"));
       Image i2 = i1.getImage().getScaledInstance(640, 480, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel l10 = new JLabel(i3);
       l10.setBounds(400, 50, 560, 540);
       add(l10);
     
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300,180,1000,650);
        setVisible(true);
        
    }
         public void actionPerformed(ActionEvent ae){
       
        
        if(ae.getSource()==b1){
           String id = (String)c1.getSelectedItem();
          String number = t1.getText();
          String name = t2.getText();
          String gender = null;
          if(r1.isSelected()){
            gender="male";
          }else if(r2.isSelected()){
            gender="Female";
          }
            
           String country = t3.getText();
           String room=c2.getSelectedItem();
           String status = t4.getText();
           String deposit = t5.getText();
           
            
         String str = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
         String str2 = "update room set available = 'Occupied' where room = '"+room+"'";
           
          try{
          conn c = new conn();
          c.s.executeUpdate(str);
          c.s.executeUpdate(str2);
          JOptionPane.showMessageDialog(null, "New Customer Added"); 
          new Reception().setVisible(true);
          this.setVisible(false);
           
         
                   
          }catch(Exception e){
          System.out.print(e);
         }
        }else if(ae.getSource()==b2){
               new Reception().setVisible(true);
             this.setVisible(false);
          }
        
    }
     public static void main(String[] args){
         new AddCustomer().setVisible(true);
     }
    
}
