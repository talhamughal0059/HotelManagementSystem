
package hotelmanagement;



import java.sql.*;
 public class conn {
    
    Connection c;
    Statement s;
    public conn(){
        
    try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
       
//        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","mysql12345");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelproject","root","");
        s = c.createStatement();
    }catch(Exception e){
        System.out.println(e);
        e.printStackTrace();
    }
    }   
    
    public static void main(String args[]){
        new conn();
    }
}
