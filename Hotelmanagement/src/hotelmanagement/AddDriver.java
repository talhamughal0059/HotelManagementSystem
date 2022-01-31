
package hotelmanagement;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
    
     JTextField t1,t2,t3,t4,t5;
     JComboBox c1,c2;
     JButton b1,b2;
    
    AddDriver(){
        JLabel title = new JLabel("Add Drivers");
        title.setFont(new Font("Tahoma",Font.BOLD,19));
        title.setBounds(150, 20, 120, 20);
        add(title);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        name.setBounds(60, 70, 100, 30);
        add(name);
        
        t1 = new JTextField();
        t1.setBounds(200, 70, 150, 30);
        add(t1);
        
        JLabel age = new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        age.setBounds(60, 110, 100, 30);
        add(age);
        
        t2 = new JTextField();
        t2.setBounds(200, 110, 150, 30);
        add(t2);
        
        JLabel gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        gender.setBounds(60, 150, 100, 30);
        add(gender);
        
        c1 = new JComboBox(new String[] {"Male","Female"});
        c1.setBounds(200, 150, 150, 30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        
        JLabel car = new JLabel("Car Company");
        car.setFont(new Font("Tahoma",Font.PLAIN,17));
        car.setBounds(60, 190, 100, 30);
        add(car);
        
        t3 = new JTextField();
        t3.setBounds(200, 190, 150, 30);
        add(t3);
        
        JLabel model = new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,17));
        model.setBounds(60, 230, 100, 30);
        add(model);
        
        t4 = new JTextField();
        t4.setBounds(200, 230, 150, 30);
        add(t4);
        
        JLabel available = new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,17));
        available.setBounds(60, 270, 100, 30);
        add(available);
        
        c2 = new JComboBox(new String[] {"Available","Busy"});
        c2.setBounds(200, 270, 150, 30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        JLabel lacation = new JLabel("Lacation");
        lacation.setFont(new Font("Tahoma",Font.PLAIN,17));
        lacation.setBounds(60, 310, 100, 30);
        add(lacation);
        
        t5 = new JTextField();
        t5.setBounds(200, 310, 150, 30);
        add(t5);
        
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        b1.setBounds(60, 370, 130, 30);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        b2.setBounds(215, 370, 130, 30);
        add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/first 1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 330, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(390, 50, 500, 350);
        add(l1);
        
         getContentPane().setBackground(Color.WHITE);
        
        setBounds(360, 200, 900, 470);
        setLayout(null);
        setVisible(true);
    }
    
        
    public void actionPerformed(ActionEvent ae){
       
        
        if(ae.getSource()==b1){
            String name = t1.getText();
            String age = t2.getText();
            String gender = (String)c1.getSelectedItem();
            String company = t3.getText();
            String brand = t4.getText();
            String available = (String)c2.getSelectedItem();
            String lacation = t5.getText();
            
           conn c = new conn();
           
           String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+lacation+"')";
           try{
           c.s.executeUpdate(str);
           JOptionPane.showMessageDialog(null, "Driver Successfully Added"); 
            this.setVisible(false);
                   
        }catch(Exception e){
            System.out.print(e);
        }
        }else if(ae.getSource()==b2){
           setVisible(false);
        }
        
        
        
    }
    
    
    public static void main(String[] args){
        new AddDriver().setVisible(true);
    }
    
}

