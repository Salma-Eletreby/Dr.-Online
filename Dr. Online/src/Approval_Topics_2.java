import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.awt.event.ActionEvent;

public class Approval_Topics_2 extends JFrame {

	private JPanel contentPane;
	private JTextField txt_ID;
	private JTextField txt_Date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static Object ID;
	private JTextField txt_Title;
	private JTextField txt_Spec;
	private JTextField txt_type;
	private JTextField txt_User;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Approval_Topics_2 frame = new Approval_Topics_2(ID);
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
	public Approval_Topics_2(Object ID) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Approve Topic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Approval:");
		lblNewLabel_3.setBounds(10, 106, 79, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Topic Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 436, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Topic ID:");
		lblNewLabel_2.setBounds(10, 44, 60, 20);
		contentPane.add(lblNewLabel_2);
		
		txt_ID = new JTextField();
		txt_ID.setEditable(false);
		txt_ID.setBounds(100, 42, 96, 20);
		contentPane.add(txt_ID);
		txt_ID.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Date Created:");
		lblNewLabel_2_1.setBounds(10, 75, 100, 14);
		contentPane.add(lblNewLabel_2_1);
		
		txt_Date = new JTextField();
		txt_Date.setEditable(false);
		txt_Date.setColumns(10);
		txt_Date.setBounds(100, 72, 96, 20);
		contentPane.add(txt_Date);
		
		JRadioButton btn_Yes = new JRadioButton("Yes");
		buttonGroup.add(btn_Yes);
		btn_Yes.setBounds(100, 105, 111, 23);
		contentPane.add(btn_Yes);
		btn_Yes.setOpaque(false);
		btn_Yes.setActionCommand("Yes");
		
		JRadioButton btn_No = new JRadioButton("No");
		buttonGroup.add(btn_No);
		btn_No.setBounds(100, 132, 111, 23);
		contentPane.add(btn_No);
		btn_No.setOpaque(false);
		btn_No.setActionCommand("No");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Title:");
		lblNewLabel_2_1_1.setBounds(10, 165, 267, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		txt_Title = new JTextField();
		txt_Title.setText("<dynamic>");
		txt_Title.setEditable(false);
		txt_Title.setColumns(10);
		txt_Title.setBounds(100, 162, 150, 20);
		contentPane.add(txt_Title);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Specialty ID:");
		lblNewLabel_2_1_2.setBounds(206, 44, 100, 20);
		contentPane.add(lblNewLabel_2_1_2);
		
		txt_Spec = new JTextField();
		txt_Spec.setText("<dynamic>");
		txt_Spec.setEditable(false);
		txt_Spec.setColumns(10);
		txt_Spec.setBounds(296, 42, 96, 20);
		contentPane.add(txt_Spec);
		txt_Spec.setToolTipText("<html>1100 = ENT<br>2200 = Neurology<br>3300 = Cardiology");
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Topic Type ID:");
		lblNewLabel_2_1_2_1.setBounds(206, 72, 100, 20);
		contentPane.add(lblNewLabel_2_1_2_1);
		
		txt_type = new JTextField();
		txt_type.setText("<dynamic>");
		txt_type.setEditable(false);
		txt_type.setColumns(10);
		txt_type.setBounds(296, 70, 96, 20);
		contentPane.add(txt_type);
		txt_type.setToolTipText("<html>1000 = questionnaire<br>2000 = patient opinion<br>3000 = general information"
				+ "<br>4000 = discussion<br>5000 = new medication release <br>6000= research update");
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("Username: ");
		lblNewLabel_2_1_2_1_1.setBounds(206, 106, 100, 20);
		contentPane.add(lblNewLabel_2_1_2_1_1);
		
		txt_User = new JTextField();
		txt_User.setText("<dynamic>");
		txt_User.setEditable(false);
		txt_User.setColumns(10);
		txt_User.setBounds(296, 104, 96, 20);
		contentPane.add(txt_User);
		
		DBase x = new DBase();
		try {
			Statement stmt1 = x.conn.createStatement();
			ResultSet rs = stmt1.executeQuery("select * from need_approval where T_ID="+ID);

			if(rs.next())
			{
				txt_ID.setText(String.valueOf(rs.getInt(1)));
				
				Date date = rs.getDate(2);
				DateFormat dateFormat = new SimpleDateFormat("dd MMM YYYY");  
		        String strDate = dateFormat.format(date);
		        
		        txt_Date.setText(strDate);
		        txt_Title.setText(rs.getString(4));
		        txt_Spec.setText(String.valueOf(rs.getInt(5)));
		        txt_type.setText(String.valueOf(rs.getInt(6)));
		        txt_User.setText(rs.getString(7));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btn_Submit = new JButton("Submit");
		btn_Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String approval = buttonGroup.getSelection().getActionCommand();
				int id = Integer.valueOf(txt_ID.getText());
				int save = x.approval(approval, id);
				
				if(save==JOptionPane.YES_OPTION)
				{
					Approval_Topics ap = new Approval_Topics();
					ap.setVisible(true);
					dispose();
					ap.setDefaultCloseOperation(HIDE_ON_CLOSE);
				}
			}
		});
		btn_Submit.setBounds(109, 204, 89, 23);
		contentPane.add(btn_Submit);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Approval_Topics ap = new Approval_Topics();
				ap.setVisible(true);
				dispose();
				ap.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		btn_Exit.setBounds(221, 204, 89, 23);
		contentPane.add(btn_Exit);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images/disccusion.jpg"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
	}
}

