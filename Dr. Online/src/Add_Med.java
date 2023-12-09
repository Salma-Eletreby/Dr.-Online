import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Add_Med extends JFrame {

	private JPanel contentPane;
	private JTextField pat_id;
	private JTextField med_id;
	private JTextField med_name;
	private JTextField med_desc;
	private JTextField med_price;
	private JTextField med_sd;
	private JTextField med_ed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Med frame = new Add_Med();
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
	public Add_Med() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Add Medication");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Medication Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(117, 16, 205, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("*Patient ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(33, 47, 173, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("*Medication ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(33, 73, 173, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Start Date (DD-MMM-YY) ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(33, 177, 173, 26);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("End Date (DD-MMM-YY) ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(33, 203, 173, 26);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("*Medication Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(33, 99, 173, 26);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Medication Description");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(33, 125, 173, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Medication Price");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(33, 151, 173, 25);
		contentPane.add(lblNewLabel_7);
		
		pat_id = new JTextField();
		pat_id.setBounds(209, 53, 175, 20);
		contentPane.add(pat_id);
		pat_id.setColumns(10);
		
		med_id = new JTextField();
		med_id.setBounds(209, 79, 78, 20);
		contentPane.add(med_id);
		med_id.setColumns(10);
		med_id.setToolTipText("Press records to check if the medication you are taking is in the system");
		
		med_name = new JTextField();
		med_name.setBounds(209, 105, 175, 20);
		contentPane.add(med_name);
		med_name.setColumns(10);
		
		med_desc = new JTextField();
		med_desc.setBounds(209, 131, 175, 20);
		contentPane.add(med_desc);
		med_desc.setColumns(10);
		
		med_price = new JTextField();
		med_price.setBounds(209, 156, 175, 20);
		contentPane.add(med_price);
		med_price.setColumns(10);
		
		med_sd = new JTextField();
		med_sd.setBounds(209, 183, 175, 20);
		contentPane.add(med_sd);
		med_sd.setColumns(10);
		
		med_ed = new JTextField();
		med_ed.setBounds(209, 209, 175, 20);
		contentPane.add(med_ed);
		med_ed.setColumns(10);
		
		Medication_Dbase x= new Medication_Dbase();
		
		JButton add_data = new JButton("Add Data");
		add_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (pat_id.getText().isEmpty()||med_id.getText().isEmpty()||med_name.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "You missed a mandatory field ");
					else {
						Float medprice = (float) 0.0;
						int patid=Integer.parseInt(pat_id.getText());
						int medid = Integer.parseInt(med_id.getText());
						String medname = med_name.getText();
						String medesc = med_desc.getText();
						String startdate =  med_sd.getText();
						String enddate =  med_ed.getText();	
						if (med_desc.getText().isEmpty())
							medesc="";
						if (!med_price.getText().isEmpty())
							medprice = Float.parseFloat(med_price.getText());
						if (med_sd.getText().isEmpty())
							startdate="";
						if (med_ed.getText().isEmpty())
							enddate="";
						x.insert(patid, medid, medname, medesc, medprice, startdate, enddate);
						dispose();
				}
				}catch (java.lang.NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Medication ID, Patient ID and Price should be in number format. Please change it accordingly.");
				}
			}
		});
		add_data.setForeground(Color.DARK_GRAY);
		add_data.setBackground(UIManager.getColor("Button.background"));
		add_data.setFont(new Font("Tahoma", Font.BOLD, 14));
		add_data.setBounds(10, 240, 109, 26);
		contentPane.add(add_data);
		
		JButton clear_all = new JButton("Clear All");
		clear_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pat_id.setText("");
				med_id.setText("");
				med_name.setText("");
				med_desc.setText("");
				med_price.setText("");
				med_sd.setText("");
				med_ed.setText("");
			}
		});
		clear_all.setForeground(Color.DARK_GRAY);
		clear_all.setFont(new Font("Tahoma", Font.BOLD, 14));
		clear_all.setBackground(UIManager.getColor("Button.background"));
		clear_all.setBounds(124, 240, 109, 26);
		contentPane.add(clear_all);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.setBackground(UIManager.getColor("Button.background"));
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_exit.setBounds(237, 240, 109, 26);
		contentPane.add(btn_exit);
		
		JButton btn_Chk = new JButton("Records");
		btn_Chk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Med_view med = new Med_view();
				med.setVisible(true);
				med.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		btn_Chk.setBounds(297, 77, 87, 23);
		contentPane.add(btn_Chk);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/medecine.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
	}
}
