package beans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class DocDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital","root","Rushikesh@123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return con;
		
	}
	
	public static int insertDoctor(Doctor doc) {
		int status = 0;
		PreparedStatement ps;
		
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Insert into hosp(deptno,name,lastname,age,specialization,department) values(?,?,?,?,?,?)");
			
			ps.setInt(1,doc.getDeptno());
			ps.setString(2, doc.getName());
			ps.setString(3, doc.getLastname());
			ps.setInt(4, doc.getAge());
			ps.setString(5, doc.getSpecialization());
			ps.setString(6, doc.getDepartment());
			
			status = ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Doctor>getAllDoctor(){
		Connection con = getConnection();
		List<Doctor>list = new ArrayList<Doctor>();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from hosp");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Doctor doc = new Doctor();
				doc.setId(rs.getInt("id"));
				doc.setDeptno(rs.getInt("deptno"));
				doc.setName(rs.getString("name"));
				doc.setLastname(rs.getString("lastname"));
				doc.setAge(rs.getInt("age"));
				doc.setSpecialization(rs.getString("specialization"));
				doc.setDepartment(rs.getString("department"));
				list.add(doc);
			}
	      } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
	
	public static List<Doctor> getSpecialization(String specialization){
		Connection con = getConnection();
		List<Doctor>list = new ArrayList<Doctor>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from hosp where specialization = ?");
			ps.setString(1, specialization);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Doctor doc = new Doctor();
				doc.setId(rs.getInt("id"));
				doc.setDeptno(rs.getInt("deptno"));
				doc.setName(rs.getString("name"));
				doc.setLastname(rs.getString("lastname"));
				doc.setAge(rs.getInt("age"));
				doc.setSpecialization(rs.getString("specialization"));
				list.add(doc);
			}
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	public static boolean getDeptno(int deptno) {
		boolean flag = false;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps=con.prepareStatement("select * from hosp where deptno = ?");
			ps.setInt(1, deptno);
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public static int DeleteData(int id) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
		    ps = con.prepareStatement("Delete from hosp where id=?");
		    ps.setInt(1, id);
		    status = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	
	public static Doctor getDoctor(int id) {
		
		Connection con = getConnection();
		Doctor doc = new Doctor();
		PreparedStatement ps;
		try {
			ps= con.prepareStatement("select * from hosp where id =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				doc.setId(rs.getInt("id"));
				doc.setDeptno(rs.getInt("deptno"));
				doc.setName(rs.getString("name"));
				doc.setLastname(rs.getString("lastname"));
				doc.setAge(rs.getInt("age"));
				doc.setSpecialization(rs.getString("specialization"));
				doc.setDepartment(rs.getString("department"));
			}
		}catch (SQLException p1) {
			// TODO Auto-generated catch block
			p1.printStackTrace();
	}
		return doc;
	}
	
	
	
	
	public static int UpdateDoctor(int deptno, String name, String lastname, int age, String specialization, String department, int id) {
		int status = 0;
		PreparedStatement ps;
		try {
			Connection con = getConnection();
			ps = con.prepareStatement("Update hosp set deptno=?, name=?, lastname=?, age=?, specialization=?, department=? where id=?");
			ps.setInt(1, deptno);
			ps.setString(2, name);
			ps.setString(3, lastname);
			ps.setInt(4, age);
			ps.setString(5, specialization);
			ps.setString(6, department);
			ps.setInt(7, id);
			status = ps.executeUpdate();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
}
