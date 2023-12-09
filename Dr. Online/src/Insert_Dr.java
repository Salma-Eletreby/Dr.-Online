import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Insert_Dr extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_User;
	private JPasswordField passwordField;
	private JTextField txt_Date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txt_Fname;
	private JTextField txt_Lname;
	private JTextField txt_type;
	private JTextField txt_SPEC;
	private JTextField txt_POS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert_Dr frame = new Insert_Dr();
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
	public Insert_Dr() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Add new Doctor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_ID = new JTextField();
		txt_ID.setBounds(85, 43, 96, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insert Doctor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 426, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Doctor ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 35, 75, 39);
		contentPane.add(lblNewLabel);
		
		txt_User = new JTextField();
		txt_User.setColumns(10);
		txt_User.setBounds(85, 71, 96, 20);
		contentPane.add(txt_User);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 63, 75, 39);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 119, 75, 39);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(85, 129, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 98, 75, 20);
		contentPane.add(lblDate);
		
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
         String strDate = dateFormat.format(date);  
		
		txt_Date = new JTextField();
		txt_Date.setEditable(false);
		txt_Date.setColumns(10);
		txt_Date.setBounds(85, 98, 96, 20);
		contentPane.add(txt_Date);
		txt_Date.setText(strDate);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(201, 23, 75, 39);
		contentPane.add(lblGender);
		
		JRadioButton RB_F = new JRadioButton("Female");
		RB_F.setActionCommand("F");
		RB_F.setOpaque(false);
		buttonGroup.add(RB_F);
		RB_F.setBounds(254, 32, 75, 23);
		contentPane.add(RB_F);
		
		JRadioButton RB_M = new JRadioButton("Male");
		RB_M.setActionCommand("M");
		RB_M.setOpaque(false);
		buttonGroup.add(RB_M);
		RB_M.setBounds(254, 56, 62, 23);
		contentPane.add(RB_M);
		
		JLabel lblAge_1 = new JLabel("First Name:");
		lblAge_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1.setBounds(198, 80, 75, 39);
		contentPane.add(lblAge_1);
		
		txt_Fname = new JTextField();
		txt_Fname.setColumns(10);
		txt_Fname.setBounds(273, 88, 96, 20);
		contentPane.add(txt_Fname);
		
		txt_Lname = new JTextField();
		txt_Lname.setColumns(10);
		txt_Lname.setBounds(273, 115, 96, 20);
		contentPane.add(txt_Lname);
		
		JLabel lblUserTypeId = new JLabel("User Type:");
		lblUserTypeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserTypeId.setBounds(198, 200, 75, 23);
		contentPane.add(lblUserTypeId);
		
		JLabel lblAge_1_1 = new JLabel("Last Name:");
		lblAge_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1_1.setBounds(198, 107, 75, 39);
		contentPane.add(lblAge_1_1);
		
		txt_type = new JTextField();
		txt_type.setText("2220");
		txt_type.setEditable(false);
		txt_type.setColumns(10);
		txt_type.setBounds(273, 200, 96, 20);
		contentPane.add(txt_type);
		
		JTextArea txt_BIO = new JTextArea();
		txt_BIO.setBounds(85, 160, 96, 45);
		contentPane.add(txt_BIO);
		
		JLabel lblNewLabel_2 = new JLabel("Bio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 154, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAge_1_2 = new JLabel("Specialty ID:");
		lblAge_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge_1_2.setBounds(198, 139, 89, 33);
		contentPane.add(lblAge_1_2);
		
		txt_SPEC = new JTextField();
		txt_SPEC.setColumns(10);
		txt_SPEC.setBounds(273, 145, 96, 20);
		contentPane.add(txt_SPEC);
		txt_SPEC.setToolTipText("<html>1100 = ENT<br>2200 = Neurology<br>3300 = Cardiology");
		
		txt_POS = new JTextField();
		txt_POS.setColumns(10);
		txt_POS.setBounds(273, 174, 96, 20);
		contentPane.add(txt_POS);
		txt_POS.setToolTipText("<html>1111 = General Physician<br>2222 = Consultant Physician<br>3333 = Resident Doctor<br>4444 = Surgeon<br>5555 = Specialist");
			 
		JLabel lblAge_1_1_1 = new JLabel("Position ID:");
		lblAge_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1_1_1.setBounds(198, 166, 75, 39);
		contentPane.add(lblAge_1_1_1);
		
		JButton btn_Enter = new JButton("Enter");
		btn_Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = Integer.parseInt(txt_ID.getText());
				String user = txt_User.getText();
				String pass = passwordField.getText();
				String fname = txt_Fname.getText();
				String lname = txt_Lname.getText();
				String gender = buttonGroup.getSelection().getActionCommand();
				
				String SPEC;
				if(txt_SPEC.getText().isBlank())
					SPEC=null;
				else
					SPEC = txt_SPEC.getText();
				
				String POS;
				if(txt_POS.getText().isBlank())
					POS=null;
				else
					POS = txt_POS.getText();

				String BIO;
				if(txt_POS.getText().isBlank())
					BIO= null;
				else
					BIO = txt_BIO.getText();
				
				DBase db = new DBase();
				int save = db.insert_DR(ID,user,pass,gender,fname,lname,SPEC,POS,BIO);
			
				db.close();
				
				if(save==JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btn_Enter.setBounds(70, 230, 89, 23);
		contentPane.add(btn_Enter);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_ID.setText("");
				txt_User.setText("");
				passwordField.setText("");
				txt_Fname.setText("");
				txt_Lname.setText("");
				buttonGroup.clearSelection();
				txt_SPEC.setText("");
				txt_POS.setText("");
				txt_BIO.setText("");
			}
		});
		btn_Clear.setBounds(169, 230, 89, 23);
		contentPane.add(btn_Clear);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Exit.setBounds(268, 230, 89, 23);
		contentPane.add(btn_Exit);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/Dr.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
	}
}
