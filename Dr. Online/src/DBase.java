import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class DBase 
{
	Connection conn;
	String user = "fe2008126";
	String pwd = "fe2008126";

	public DBase()
	{
		try 
		{
			conn= DriverManager.getConnection("jdbc:oracle:thin:@coestudb.qu.edu.qa:1521/STUD.qu.edu.qa",user, pwd);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void close()
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int insert_Pat(int PatID, String username, int age, String pass, String gender, String Fname, String Lname)
	{
		int answer = 0;
		
		String sql1="insert into PATIENT values(?,?,?)";
		String sql2 ="insert into U_SER values(?,?,?,?,?,?,?)";
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis); 
		
		PreparedStatement stmt1,stmt2;
		try 
		{
			conn.setAutoCommit(false);

			//for user table
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1,username);
			stmt2.setString(2, pass);
			stmt2.setDate(3, date);
			stmt2.setNString(4, gender);
			stmt2.setString(5, Fname);
			stmt2.setString(6, Lname);
			stmt2.setInt(7, 3330);
			stmt2.executeUpdate();
			
			//for patient table
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, PatID);
			stmt1.setString(2, username);
			stmt1.setInt(3, age);
			stmt1.executeUpdate();

			answer = JOptionPane.showConfirmDialog(null, "Do you want to save?");
			if(answer==JOptionPane.YES_OPTION)
			{
				conn.commit();
				JOptionPane.showMessageDialog(null, "Record Saved!");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Record not saved!");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return answer;
	}
	
	public String[] view(String user)
	{
		String[] info = new String[10];			

		try 
		{
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from Records_Pat where USERNAME='"+user+"'");
			

			while(rs.next())
			{
				info[0]=rs.getString(1);	//PAT_ID
				info[1] = rs.getString(2);	//AGE
				info[2] = rs.getString(3);	//user name
				info[3] = rs.getString(4);	//Password

				Date date = rs.getDate(5);
				DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
		        String strDate = dateFormat.format(date); 
				
		        info[4] = strDate;			//Date created
				info[5]= rs.getString(6);	//Gender
				info[6]= rs.getString(7);	//First name
				info[7]= rs.getString(8);	//Last name
				info[8]= Integer.toString(rs.getInt(9));	//user type
		
			}
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return info;
	}
	
	public int update_pat(int PatID, String username, int age, String pass, String gender, String Fname, String Lname)
	{
		int answer = 0;
		String sql1 ="update PATIENT set Age =? where PAT_ID=?";
		String sql2 ="update U_SER set PASS=?, GENDER=?, FNAME=?, LNAME=? where USERNAME=?";
		
		PreparedStatement stmt1,stmt2;
		try 
		{
			conn.setAutoCommit(false);

			//for patient table
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, age);
			stmt1.setInt(2, PatID);
			stmt1.executeUpdate();
			
			//for user table
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, pass);
			stmt2.setNString(2, gender);
			stmt2.setString(3,Fname);
			stmt2.setString(4,Lname);
			stmt2.setString(5, username);
			stmt2.executeUpdate();

			answer = JOptionPane.showConfirmDialog(null, "Do you want to save these changes?");
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
	
		return answer;
	}
	
	public int delete(String username)
	{
		int answer =0;
		String sql1 ="delete from U_SER where USERNAME=?";
		PreparedStatement stmt1;
		
		try 
		{
			conn.setAutoCommit(false);

			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1,username);
			stmt1.executeUpdate();
			
			answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?");
			if(answer==JOptionPane.YES_OPTION)
			{
				conn.commit();
				JOptionPane.showMessageDialog(null, "Record Deleted!");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Record not Deleted!");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return answer;
	}
	
	public int insert_DR(int DRID, String username, String pass, String gender, String Fname, String Lname, String sPEC, String pOS, String BIO)
	{
		int answer =0;
		String sql1="insert into DOCTOR values(?,?,?,?,?)";
		String sql2 ="insert into U_SER values(?,?,?,?,?,?,?)";
		
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis); 
		
		PreparedStatement stmt1,stmt2;
		try 
		{
			conn.setAutoCommit(false);

			//for user table
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1,username);
			stmt2.setString(2, pass);
			stmt2.setDate(3, date);
			stmt2.setNString(4, gender);
			stmt2.setString(5, Fname);
			stmt2.setString(6, Lname);
			stmt2.setInt(7, 2220);
			stmt2.executeUpdate();
			
			//for dr table
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setInt(1, DRID);
			stmt1.setString(2, BIO);
			stmt1.setString(3,pOS);
			stmt1.setString(4, sPEC);
			stmt1.setString(5, username);
			stmt1.executeUpdate();

			answer = JOptionPane.showConfirmDialog(null, "Do you want to save?");
			if(answer==JOptionPane.YES_OPTION)
			{
				conn.commit();
				JOptionPane.showMessageDialog(null, "Record Saved!");
			}
			else
			{
				conn.rollback();
				JOptionPane.showMessageDialog(null, "Record not saved!");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getErrorCode());
			if(e.getErrorCode()==1)
				JOptionPane.showMessageDialog(null, "This medication already exist for this patient, you can go back and update using update windown.");
			if(e.getErrorCode()==2291) 
				JOptionPane.showMessageDialog(null, "Patient with this ID does not exist. Please change accordingly.");
		}
		return answer;
	}
	
	public String[] view_DR(String name)
	{
		String[] info = new String[12];			

		try 
		{
			Statement stmt1 = conn.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from Records_Doc where USERNAME='"+name+"'");
			
			while(rs.next())
			{
				info[0]=rs.getString(1);	//ID
				info[1] = rs.getString(2);	//BIO
				info[2] = rs.getString(3);	//POS
				info[3] = rs.getString(4);	//SPEC
				info[4] = rs.getString(5);	//user
				info[5] = rs.getString(6);	//pass
				
				Date date = rs.getDate(7);
				DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
		        String strDate = dateFormat.format(date); 
				
				info[6]= strDate;			//date
				info[7]= rs.getString(8);	//gender
				info[8]= rs.getString(9);	//fname
				info[9]= rs.getString(10);	//lname
				info[10]= Integer.toString(rs.getInt(11));	//type
		
			}
		}

		catch (SQLException e) 
		{
			e.printStackTrace();
		}

		return info;
	}
	
	public int update_DR(int DRID, String username, String pass, String gender, String Fname, String Lname, String sPEC, String pOS, String BIO)
	{
		int answer =0;
		
		String sql1 ="update DOCTOR set DOC_BIODATA =?, POSID= ?, SPECID=? where DOC_ID=?";
		String sql2 ="update U_SER set PASS=?, GENDER=?, FNAME=?, LNAME=? where USERNAME=?"; 
		
		PreparedStatement stmt1,stmt2;
		try 
		{
			conn.setAutoCommit(false);

			//for doctor table
			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1,BIO);
			stmt1.setString(2, pOS);
			stmt1.setString(3, sPEC);
			stmt1.setInt(4, DRID);
			stmt1.executeUpdate();
			
			//for user table
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, pass);
			stmt2.setNString(2, gender);
			stmt2.setString(3,Fname);
			stmt2.setString(4,Lname);
			stmt2.setString(5, username);
			stmt2.executeUpdate();

			answer = JOptionPane.showConfirmDialog(null, "Do you want to save these changes?");
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
		return answer;
	}
	
	public int approval(String status, int ID)
	{
		int answer =0;
		String sql1 ="update TOPIC set APPROVED =? where T_ID=?";
		
		PreparedStatement stmt1;
		try 
		{
			conn.setAutoCommit(false);

			stmt1 = conn.prepareStatement(sql1);
			stmt1.setString(1,status);
			stmt1.setInt(2, ID);
			stmt1.executeUpdate();

			answer = JOptionPane.showConfirmDialog(null, "Do you want to save these changes?");
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
		
		return answer;
	}
}