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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Delete_DR extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_name;
	private JTextField txt_DrUser;
	private JPasswordField passwordField;
	private JTextField txt_Date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txt_Fname;
	private JTextField txt_Lname;
	private JTextField txt_type;
	private JTextField txt_SPEC;
	private JTextField txt_POS;
	private JTextField txt_DOC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete_DR frame = new Delete_DR();
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
	public Delete_DR() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Delete Doctor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		contentPane.setLayout(null);

		txt_name = new JTextField();
		txt_name.setBounds(85, 31, 96, 20);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Doctor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 426, 28);
		contentPane.add(lblNewLabel_1);
		
		txt_DrUser = new JTextField();
		txt_DrUser.setEditable(false);
		txt_DrUser.setColumns(10);
		txt_DrUser.setBounds(85, 97, 96, 20);
		contentPane.add(txt_DrUser);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 89, 75, 39);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(10, 145, 75, 39);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setEditable(false);
		passwordField.setBounds(85, 155, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 124, 75, 20);
		contentPane.add(lblDate);
		
		txt_Date = new JTextField();
		txt_Date.setEditable(false);
		txt_Date.setColumns(10);
		txt_Date.setBounds(85, 124, 96, 20);
		contentPane.add(txt_Date);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(198, 70, 75, 28);
		contentPane.add(lblGender);
		
		JRadioButton RB_F = new JRadioButton("Female");
		RB_F.setActionCommand("F");
		RB_F.setOpaque(false);
		buttonGroup.add(RB_F);
		RB_F.setBounds(270, 73, 75, 23);
		contentPane.add(RB_F);
		
		JRadioButton RB_M = new JRadioButton("Male");
		RB_M.setActionCommand("M");
		RB_M.setOpaque(false);
		buttonGroup.add(RB_M);
		RB_M.setBounds(334, 73, 62, 23);
		contentPane.add(RB_M);
		
		JLabel lblAge_1 = new JLabel("First Name:");
		lblAge_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1.setBounds(198, 91, 75, 39);
		contentPane.add(lblAge_1);
		
		txt_Fname = new JTextField();
		txt_Fname.setEditable(false);
		txt_Fname.setColumns(10);
		txt_Fname.setBounds(273, 99, 96, 20);
		contentPane.add(txt_Fname);
		
		txt_Lname = new JTextField();
		txt_Lname.setEditable(false);
		txt_Lname.setColumns(10);
		txt_Lname.setBounds(273, 126, 96, 20);
		contentPane.add(txt_Lname);
		
		JLabel lblUserTypeId = new JLabel("User Type:");
		lblUserTypeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUserTypeId.setBounds(198, 211, 75, 23);
		contentPane.add(lblUserTypeId);
		
		JLabel lblAge_1_1 = new JLabel("Last Name:");
		lblAge_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1_1.setBounds(198, 118, 75, 39);
		contentPane.add(lblAge_1_1);
		
		txt_type = new JTextField();
		txt_type.setEditable(false);
		txt_type.setColumns(10);
		txt_type.setBounds(273, 211, 96, 20);
		contentPane.add(txt_type);
		
		JTextArea txt_BIO = new JTextArea();
		txt_BIO.setEditable(false);
		txt_BIO.setBounds(85, 186, 96, 45);
		contentPane.add(txt_BIO);
		
		JLabel lblNewLabel_2 = new JLabel("Bio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 180, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblAge_1_2 = new JLabel("Specialty ID:");
		lblAge_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge_1_2.setBounds(198, 150, 89, 33);
		contentPane.add(lblAge_1_2);
		
		txt_SPEC = new JTextField();
		txt_SPEC.setEditable(false);
		txt_SPEC.setColumns(10);
		txt_SPEC.setBounds(273, 157, 96, 20);
		contentPane.add(txt_SPEC);
		txt_SPEC.setToolTipText("<html>1100 = ENT<br>2200 = Neurology<br>3300 = Cardiology");
		
		txt_POS = new JTextField();
		txt_POS.setEditable(false);
		txt_POS.setColumns(10);
		txt_POS.setBounds(273, 185, 96, 20);
		contentPane.add(txt_POS);
		txt_POS.setToolTipText("<html>1111 = General Physician<br>2222 = Consultant Physician<br>3333 = Resident Doctor<br>4444 = Surgeon<br>5555 = Specialist");
			 
		JLabel lblAge_1_1_1 = new JLabel("Position ID:");
		lblAge_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge_1_1_1.setBounds(198, 177, 75, 39);
		contentPane.add(lblAge_1_1_1);

		JButton btn_Del = new JButton("Delete");
		btn_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DBase db = new DBase();
				int save = db.delete(txt_DrUser.getText());

				db.close();
				
				if(save==JOptionPane.YES_OPTION)
					dispose();
			}
		});
		btn_Del.setBounds(116, 235, 89, 23);
		contentPane.add(btn_Del);

		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel2 = new JLabel("Username:");
		lblNewLabel2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel2.setBounds(10, 22, 75, 39);
		contentPane.add(lblNewLabel2);
		btn_Exit.setBounds(235, 235, 89, 23);
		contentPane.add(btn_Exit);
		
		txt_ID = new JTextField();
		txt_ID.setColumns(10);
		txt_ID.setBounds(85, 30, 96, 20);
		contentPane.add(txt_ID);
		
		JButton btn_Chk = new JButton("Check");
		btn_Chk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBase db = new DBase();
				
				String name = (txt_name.getText());
				String [] result = new String[11];
				result = db.view_DR(name);
				
				if(result[0]!= null)
				{
					txt_DOC.setText(result[0]);
					txt_BIO.setText(result[1]);
					txt_POS.setText(result[2]);
					txt_SPEC.setText(result[3]);
					txt_DrUser.setText(result[4]);
					passwordField.setText(result[5]);
					txt_Date.setText(result[6]);
					if(result[7].equals("F"))
						RB_F.setSelected(true);
					else
						RB_M.setSelected(true);
					txt_Fname.setText(result[8]);
					txt_Lname.setText(result[9]);
					txt_type.setText(result[10]);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No Patient Found!");
				}
				
				db.close();
			}
		});
		btn_Chk.setBounds(191, 30, 89, 23);
		contentPane.add(btn_Chk);
		
		JLabel lblNewLabel_3 = new JLabel("Please ensure that this is the user you would like to delete:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(10, 52, 416, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Doctor ID: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 70, 75, 20);
		contentPane.add(lblNewLabel_4);
		
		txt_DOC = new JTextField();
		txt_DOC.setEditable(false);
		txt_DOC.setColumns(10);
		txt_DOC.setBounds(85, 70, 96, 20);
		contentPane.add(txt_DOC);

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/Dr.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
	}


}
