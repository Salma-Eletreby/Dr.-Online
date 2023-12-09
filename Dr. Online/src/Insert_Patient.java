import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Insert_Patient extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_User;
	private JTextField txt_Age;
	private JPasswordField passwordField;
	private JTextField txt_Date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txt_Fname;
	private JTextField txt_Lname;
	private JTextField txt_type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Patient frame = new Insert_Patient();
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
	public Insert_Patient() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Add new Patient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(85, 39, 96, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Patient");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 426, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Patient ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 31, 75, 39);
		contentPane.add(lblNewLabel);
		
		txt_User = new JTextField();
		txt_User.setColumns(10);
		txt_User.setBounds(85, 67, 96, 20);
		contentPane.add(txt_User);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 59, 75, 39);
		contentPane.add(lblUsername);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(10, 88, 75, 39);
		contentPane.add(lblAge);
		
		txt_Age = new JTextField();
		txt_Age.setColumns(10);
		txt_Age.setBounds(85, 96, 96, 20);
		contentPane.add(txt_Age);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 115, 75, 39);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 125, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 143, 75, 39);
		contentPane.add(lblDate);
		
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
         String strDate = dateFormat.format(date);  
		
		txt_Date = new JTextField();
		txt_Date.setEditable(false);
		txt_Date.setColumns(10);
		txt_Date.setBounds(85, 151, 96, 20);
		contentPane.add(txt_Date);
		txt_Date.setText(strDate);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(201, 31, 75, 39);
		contentPane.add(lblGender);
		
		JRadioButton RB_F = new JRadioButton("Female");
		RB_F.setActionCommand("F");
		RB_F.setOpaque(false);
		buttonGroup.add(RB_F);
		RB_F.setBounds(254, 40, 75, 23);
		contentPane.add(RB_F);
		
		JRadioButton RB_M = new JRadioButton("Male");
		RB_M.setActionCommand("M");
		RB_M.setOpaque(false);
		buttonGroup.add(RB_M);
		RB_M.setBounds(254, 64, 62, 23);
		contentPane.add(RB_M);
		
		JLabel lblAge_1 = new JLabel("First Name:");
		lblAge_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1.setBounds(198, 88, 75, 39);
		contentPane.add(lblAge_1);
		
		txt_Fname = new JTextField();
		txt_Fname.setColumns(10);
		txt_Fname.setBounds(273, 96, 96, 20);
		contentPane.add(txt_Fname);
		
		txt_Lname = new JTextField();
		txt_Lname.setColumns(10);
		txt_Lname.setBounds(273, 123, 96, 20);
		contentPane.add(txt_Lname);
		
		JLabel lblUserTypeId = new JLabel("User Type:");
		lblUserTypeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserTypeId.setBounds(198, 143, 75, 39);
		contentPane.add(lblUserTypeId);
		
		JLabel lblAge_1_1 = new JLabel("Last Name:");
		lblAge_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1_1.setBounds(198, 115, 75, 39);
		contentPane.add(lblAge_1_1);
		
		txt_type = new JTextField();
		txt_type.setText("3330");
		txt_type.setEditable(false);
		txt_type.setColumns(10);
		txt_type.setBounds(273, 151, 96, 20);
		contentPane.add(txt_type);
		
		JButton btn_Enter = new JButton("Enter");
		btn_Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(txt_ID.getText());
				String user = txt_User.getText();
				String pass = passwordField.getText();
				int age = Integer.parseInt(txt_Age.getText());
				String fname = txt_Fname.getText();
				String lname = txt_Lname.getText();
				String gender = buttonGroup.getSelection().getActionCommand();
				
				DBase db = new DBase();
				int save = db.insert_Pat(ID,user,age,pass,gender,fname,lname);
				db.close();
				
				if(save==JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btn_Enter.setBounds(70, 182, 89, 23);
		contentPane.add(btn_Enter);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ID.setText("");
				txt_User.setText("");
				passwordField.setText("");
				txt_Age.setText("");
				txt_Fname.setText("");
				txt_Lname.setText("");
				buttonGroup.clearSelection();
			}
		});
		btn_Clear.setBounds(169, 182, 89, 23);
		contentPane.add(btn_Clear);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Exit.setBounds(268, 182, 89, 23);
		contentPane.add(btn_Exit);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/Pat.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
	}
}
