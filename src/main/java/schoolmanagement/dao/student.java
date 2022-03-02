package schoolmanagement.dao;


import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 

public class student {

Database obj = new Database(); 
Connection connect = obj.MysqlDbConnection(); 
public boolean studentlogin(String TeacID, String Tpass) throws SQLException{ 
	PreparedStatement ps = connect.prepareStatement("select * from School_management loginid=?? && password=?");
	ps.setString(1,TeacID); 
	ps.setString(2,Tpass); 
	ResultSet result = ps.executeQuery();
	if(result.next())
	{ return true; 
	} 
	else{ 
		return false;
		} }
public boolean insertstudentdetails( String studentname,String dob,String gender,String parentsname,String address,String number) throws SQLException{ 
	PreparedStatement ps = connect.prepareStatement("insert into School_management values (?,?,?,?,?,?)");
	ps.setString(1, studentname); 
	ps.setString(2, dob);
	ps.setString(3,gender);
	ps.setString(4,parentsname); 
	ps.setString(5, address);
	ps.setString(6,number); 
	int affectedRows=ps.executeUpdate();
	if(affectedRows>0) return true; else return false; 
	} 
public ResultSet studentDetails(String studentname) throws SQLException{
	PreparedStatement ps = connect.prepareStatement("select * from School_Management where studentname"); 
	ps.setString(1, studentname); 
	ResultSet result = ps.executeQuery();
	return result; }
public boolean Deletestudentdetails(String studentname) throws SQLException{
	PreparedStatement ps = connect.prepareStatement("delete from School_Management where studentname=?"); 
	ps.setString(1, studentname);
	int affectedRows = ps.executeUpdate();
	if(affectedRows>0) return true; 
	else return false; 
	} 
public boolean studentlogout() throws SQLException{
	connect.close();
	return true; 
	} 
}






