import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
	public Conn(){
		try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankm", "root", "0122");
            s=c.createStatement();    
		
		}catch(Exception e) {
		e.printStackTrace();
		}
	}
}
