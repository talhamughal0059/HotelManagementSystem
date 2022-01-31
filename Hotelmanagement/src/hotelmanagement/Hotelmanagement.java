
package hotelmanagement;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Hotelmanagement extends JFrame implements ActionListener {
 Hotelmanagement(){
    setBounds(0,0,5500,3667);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotelmanagement/icons/f1.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1600, 900, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel l1 = new JLabel(i3);
    l1.setBounds(0, 0, 1600, 900);
    add(l1);
    
    JLabel l2 =new JLabel("Hotel Management System");
    l2.setBounds(20,700,1000,90);
    l2.setForeground(Color.white);
    l2.setFont(new Font("serif", Font.PLAIN,70));
    l1.add(l2);
    
    JButton b1 = new JButton("Next");
    b1.setBackground(Color.white);
    b1.setForeground(Color.black);
    b1.setBounds(1330, 750, 175, 50);
    b1.addActionListener(this);
    b1.setFont(new Font("serif", Font.PLAIN,25));
    l1.add(b1);
    
    setLayout(null);
    setVisible(true);
      while(true){
        l2.setVisible(false);
      try{
        Thread.sleep(600);
     }
     catch(Exception e){
     }
      l2.setVisible(true);
     try{
       Thread.sleep(600);
     }
      catch(Exception e){}
     }
}
    public void actionPerformed(ActionEvent ae){
        new Login().setVisible(true);
        this.setVisible(false);
    }
    public static void main(String[] args) {
        new Hotelmanagement();
       
    }
    
}
