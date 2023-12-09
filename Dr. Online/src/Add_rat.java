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
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Add_rat extends JFrame {

	private JPanel contentPane;
	private JTextField pat_ID;
	private JTextField dr_id;
	private JTextField comment;
	private JTextField txt_Date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField rat_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_rat frame = new Add_rat();
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
	public Add_rat() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Add new Rating");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pat_ID = new JTextField();
		pat_ID.setBounds(95, 43, 96, 20);
		contentPane.add(pat_ID);
		pat_ID.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Adding Rating");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 426, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("*Patient ID: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 31, 89, 39);
		contentPane.add(lblNewLabel);
		
		dr_id = new JTextField();
		dr_id.setColumns(10);
		dr_id.setBounds(95, 71, 96, 20);
		contentPane.add(dr_id);
		
		JLabel lblUsername = new JLabel("*Doctor ID:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(10, 59, 75, 39);
		contentPane.add(lblUsername);
		
		JLabel lblAge = new JLabel("Comment:");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(10, 88, 75, 39);
		contentPane.add(lblAge);
		
		comment = new JTextField();
		comment.setColumns(10);
		comment.setBounds(95, 100, 96, 56);
		contentPane.add(comment);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(10, 149, 75, 39);
		contentPane.add(lblDate);
		
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
         String strDate = dateFormat.format(date);  
		
		txt_Date = new JTextField();
		txt_Date.setEditable(false);
		txt_Date.setColumns(10);
		txt_Date.setBounds(95, 163, 96, 20);
		contentPane.add(txt_Date);
		txt_Date.setText(strDate);
		
		JLabel lblGender = new JLabel("*Rating");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(219, 59, 75, 39);
		contentPane.add(lblGender);
		
		JRadioButton RB_F = new JRadioButton("1");
		RB_F.setActionCommand("1");
		RB_F.setOpaque(false);
		buttonGroup.add(RB_F);
		RB_F.setBounds(271, 66, 75, 23);
		contentPane.add(RB_F);
		
		JRadioButton RB_M = new JRadioButton("2");
		RB_M.setActionCommand("2");
		RB_M.setOpaque(false);
		buttonGroup.add(RB_M);
		RB_M.setBounds(271, 89, 62, 23);
		contentPane.add(RB_M);
		
		JButton btn_Enter = new JButton("Enter");
		btn_Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {	int rating =0;
				rating = Integer.parseInt(buttonGroup.getSelection().getActionCommand());
				if (rat_ID.getText().isEmpty()||pat_ID.getText().isEmpty()||dr_id.getText().isEmpty()||rating==0)
			    	JOptionPane.showMessageDialog(null, "You missed a mandatory field");
				else {
					int ratid = Integer.parseInt(rat_ID.getText());
					int ID = Integer.parseInt(pat_ID.getText());
					int drid = Integer.parseInt(dr_id.getText());
					String ratcomm = comment.getText();
					if (comment.getText().isEmpty())
						ratcomm="";
					Rating_DBase db = new Rating_DBase();
					db.insert(ratid, ID, drid, ratcomm, rating);			
					db.close();
					dispose();
				}
			} catch (java.lang.NullPointerException ef) {
				JOptionPane.showMessageDialog(null, "You missed a mandatory field");}
			catch (java.lang.NumberFormatException ee) {
				JOptionPane.showMessageDialog(null, "You entered a field in the wrong format, please change it to a number.");
			}
			}
		});
		btn_Enter.setBounds(72, 194, 89, 23);
		contentPane.add(btn_Enter);
		
		JButton btn_Clear = new JButton("Clear");
		btn_Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pat_ID.setText("");
				dr_id.setText("");
				comment.setText("");
				buttonGroup.clearSelection();
			}
		});
		btn_Clear.setBounds(169, 194, 89, 23);
		contentPane.add(btn_Clear);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Exit.setBounds(268, 194, 89, 23);
		contentPane.add(btn_Exit);
		
		JRadioButton RB_M_1 = new JRadioButton("4");
		RB_M_1.setOpaque(false);
		buttonGroup.add(RB_M_1);
		RB_M_1.setActionCommand("4");
		RB_M_1.setBounds(271, 136, 62, 23);
		contentPane.add(RB_M_1);
		
		JRadioButton RB_M_2 = new JRadioButton("5");
		RB_M_2.setOpaque(false);
		buttonGroup.add(RB_M_2);
		RB_M_2.setActionCommand("5");
		RB_M_2.setBounds(271, 160, 62, 23);
		contentPane.add(RB_M_2);
		
		JRadioButton RB_F_1 = new JRadioButton("3");
		RB_F_1.setOpaque(false);
		buttonGroup.add(RB_F_1);
		RB_F_1.setActionCommand("3");
		RB_F_1.setBounds(271, 112, 75, 23);
		
		contentPane.add(RB_F_1);
		
		JLabel lblNewLabel_2 = new JLabel(" *Rating ID:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(213, 29, 81, 39);
		contentPane.add(lblNewLabel_2);
		
		rat_ID = new JTextField();
		rat_ID.setBounds(295, 39, 96, 20);
		contentPane.add(rat_ID);
		rat_ID.setColumns(10);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/Rating.jpg"));
		background.setBounds(0, 0, 456, 276);
		contentPane.add(background);
	}
}