import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Rating_DBase {
	Connection conn;
	String user ="fe2008126";
	String pwd = "fe2008126";
	public Rating_DBase () {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa",user, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close () {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert (int ratid, int patid,int drid, String ratcomment, int rating) {
		String sql = "insert into RATING values (?,?,?,?,?,?)";
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis); 
	    
		PreparedStatement stmt;
		try {
		conn.setAutoCommit(false);
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, ratid);
		stmt.setDate(2, date);
		stmt.setInt(3, rating);
		stmt.setString(4, ratcomment);
		stmt.setInt(5, patid);
		stmt.setInt(6, drid);
		stmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "If you left any thing empty, it will be saved as null");
		int answer = JOptionPane.showConfirmDialog(null, "Would you like to save?");
		if (answer == JOptionPane.YES_OPTION) {
			conn.commit();
			JOptionPane.showMessageDialog(null, "Record saved");
		} else {
			conn.rollback();
			JOptionPane.showMessageDialog(null, "Record not saved");
		}
		} catch (SQLException e) {
			System.out.println(e.getErrorCode());
			if(e.getErrorCode()==1)
				JOptionPane.showMessageDialog(null, "Rating ID already exists, use another one please.");
			if(e.getErrorCode()==2291)
				JOptionPane.showMessageDialog(null, "Either the Dr or Patient you entered does not exist, please change accordingly.");
			Add_rat x = new Add_rat();
			x.setVisible(true);
			x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		}
	}
	
	public String [] search (int deptno) {
		String [] deptinfo = new String [2];
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select dname, loc from dept where deptno ="+ deptno);
			while (rs.next())  {
				deptinfo[0]= rs.getString(1);
				deptinfo[1]=rs.getString(2);
			}
			if (deptinfo[0]==null)
				JOptionPane.showMessageDialog(null, "No record found");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deptinfo;		
	}
}
