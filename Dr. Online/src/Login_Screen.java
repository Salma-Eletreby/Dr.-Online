import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login_Screen extends JFrame {
	private JTextField tF_user;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen frame = new Login_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login_Screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Login Screen ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(127, 0, 175, 46);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dr Online!");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(127, 37, 175, 46);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(222, 83, 94, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(222, 141, 94, 21);
		getContentPane().add(lblNewLabel_2_1);
		
		tF_user = new JTextField();
		tF_user.setBounds(304, 83, 96, 20);
		getContentPane().add(tF_user);
		tF_user.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(304, 143, 96, 20);
		getContentPane().add(passwordField);
		
		JButton btn_Login = new JButton("LOGIN");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Type;
				
				String sql = "select USERTYPEID, FNAME from U_SER where USERNAME =? and PASS=?";
				String sql2 = "select USERTYPE_NAME from USER_TYPE where USERTYPE_ID = ?"; 
				
				DBase db = new DBase();
				PreparedStatement stmt,stmt2;
				
				try {
					stmt = db.conn.prepareStatement(sql);
					stmt.setString(1, tF_user.getText());
					stmt.setString(2, passwordField.getText());
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null, "Login Successful \nMain Menu Loading");
						
						stmt2 = db.conn.prepareStatement(sql2);
						stmt2.setInt(1, rs.getInt(1));
						ResultSet rs2 = stmt2.executeQuery();
						rs2.next();
						
						if(rs2.getString(1).equals("admin"))
						{
							Admin a = new Admin(rs.getString(2));
							a.setVisible(true);
							dispose();
							a.setDefaultCloseOperation(EXIT_ON_CLOSE);
						}
						else if(rs2.getString(1).equals("doctor"))
						{
							Doctors d = new Doctors(rs.getString(2));
							d.setVisible(true);
							dispose();
							d.setDefaultCloseOperation(EXIT_ON_CLOSE);
						}
						else if(rs2.getString(1).equals("patient"))
						{
							Patients p = new Patients(rs.getString(2));
							p.setVisible(true);
							dispose();
							p.setDefaultCloseOperation(EXIT_ON_CLOSE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Login Details");
						tF_user.setText("");
						passwordField.setText("");
					}
					
				} catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn_Login.setBounds(222, 187, 75, 23);
		getContentPane().add(btn_Login);
		
		JButton btn_Clear = new JButton("CLEAR");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tF_user.setText("");
				passwordField.setText("");
			}
		});
		btn_Clear.setBounds(325, 187, 75, 23);
		getContentPane().add(btn_Clear);
		
		JButton btn_Guest = new JButton("Sign In as Guest");
		btn_Guest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guest g = new Guest();
				g.setVisible(true);
				g.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btn_Guest.setBounds(222, 218, 178, 23);
		getContentPane().add(btn_Guest);
		
		JLabel Backgorund = new JLabel("New label");
		Backgorund.setIcon(new ImageIcon("Images/Login.JPG"));
		Backgorund.setBounds(0, 0, 436, 263);
		getContentPane().add(Backgorund);
	}
}

