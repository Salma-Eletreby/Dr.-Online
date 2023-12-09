import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Medication_Dbase {
	Connection conn;
	String user ="fe2008126";
	String pwd = "fe2008126";
	public Medication_Dbase () {
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
	
	public void insert (int patid, int medid, String medname, String meddesc, float medprice, String startdate, String enddate) {
		String sql = "insert into PAT_MED values (?,?,?,?)";
		PreparedStatement stmt,stmt2;
		try {
		conn.setAutoCommit(false);
		
		String sql2 = "select * from MEDECINE where MED_ID="+medid;
		stmt2 = conn.prepareStatement(sql2);
		//stmt2.setInt(1, medid);
		ResultSet rs = stmt2.executeQuery(sql2);
		if(!(rs.next()))
		{
			String sql1 = "insert into MEDECINE values (?,?,?,?)";
			PreparedStatement stmt1;
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, medid);
			stmt1.setString(2, medname);
			stmt1.setString(3, meddesc);
			stmt1.setFloat(4, medprice);
			stmt1.executeUpdate();
		}
		
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, patid);
		stmt.setInt(2, medid);
		stmt.setString(3, startdate);
		stmt.setString(4, enddate);
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
				JOptionPane.showMessageDialog(null, "This medication already exist for this patient, you can go back and update using update windown.");
			if(e.getErrorCode()==2291) 
				JOptionPane.showMessageDialog(null, "Patient with this ID does not exist. Please change accordingly.");
			Add_Med x = new Add_Med();
			x.setVisible(true);
			x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);			
		}
	}
	
	public void update (int ID, String name, String desc, float price) {
		String sql1 ="update MEDECINE set MED_NAME =?, MED_DESC =?, MED_PIRCE =? where MED_ID=?";
		PreparedStatement stmt1;
		try 
		{
			conn.setAutoCommit(false);
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString (1, name);
			stmt1.setString(2, desc);
			stmt1.setFloat(3, price);
			stmt1.setInt(4, ID);
			stmt1.executeUpdate();
			JOptionPane.showMessageDialog(null, "If you left any thing empty, it will be saved as null");
			int answer = JOptionPane.showConfirmDialog(null, "Do you want to save these changes?");
			if(answer==JOptionPane.YES_OPTION)
			{
				conn.commit();
				JOptionPane.showMessageDialog(null, "Record Updated");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Record not Updated!");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void updatemedpat (int ID, int medid, String sd, String ed) {
		String sql1 ="update PAT_MED set START_DATE =?, END_DATE =? where PATID=? AND MEDID =?";
		PreparedStatement stmt1;
		try 
		{
			conn.setAutoCommit(false);
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1, sd);
			stmt1.setString(2, ed);
			stmt1.setInt(3, ID);
			stmt1.setInt (4, medid);
			stmt1.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "If you left any thing empty, it will be saved as null");
			int answer = JOptionPane.showConfirmDialog(null, "Do you want to save these changes?");
			if(answer==JOptionPane.YES_OPTION)
			{
				conn.commit();
				JOptionPane.showMessageDialog(null, "Record Updated");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Record not Updated!");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void delete(int medid) {		
		try {
			conn.setAutoCommit(false);
			String sql1 ="delete from MEDECINE where MED_ID=?";
			PreparedStatement stmt2;
			stmt2 = conn.prepareStatement(sql1);
			stmt2.setInt(1, medid);
			stmt2.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String[] view_med(int id)
	{
		String[] info = new String[4];			

		try 
		{
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from MEDECINE where MED_ID='"+id+"'");		
			while(rs.next())
			{
				info[0]=  rs.getString(1);	//ID
				info[1] = rs.getString(2);	//NAME
				info[2] = rs.getString(3);	//DESC
				info[3] = rs.getString(4);	//PRICE						
			}
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return info;
	}
}


