import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class update_medpat extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField med_id;
	private JTextField sd;
	private JTextField ed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_medpat frame = new update_medpat();
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
	public update_medpat() {
		setTitle("Update Medicine Data for Patient");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*Patient ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 138, 33);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(148, 21, 164, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("*Medication ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 64, 138, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Start Date:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 130, 138, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("End Date : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 174, 138, 33);
		contentPane.add(lblNewLabel_3);
		
		med_id = new JTextField();
		med_id.setBounds(148, 64, 164, 33);
		contentPane.add(med_id);
		med_id.setColumns(10);
		
		sd = new JTextField();
		sd.setColumns(10);
		sd.setBounds(148, 130, 174, 33);
		contentPane.add(sd);
		
		ed = new JTextField();
		ed.setColumns(10);
		ed.setBounds(148, 174, 174, 33);
		contentPane.add(ed);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.setBackground(UIManager.getColor("Button.background"));
		btn_exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_exit.setBounds(248, 218, 109, 26);
		contentPane.add(btn_exit);
		
		JButton btn_update = new JButton("Update");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Medication_Dbase db= new Medication_Dbase();
					if (id.getText().isEmpty()||med_id.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "You missed a mandatory field ");
					else {
						if (sd.getText().isEmpty())
							sd.setText("");
						if (ed.getText().isEmpty())
							ed.setText("");
						db.updatemedpat(Integer.parseInt(id.getText()), Integer.parseInt(med_id.getText()), sd.getText(), ed.getText());
						db.close();
						dispose();
					}
				}catch (java.lang.NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Patient ID and Medication ID should be in number format. Please change it accordingly.");
				}
			}
		});
		btn_update.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_update.setBackground(UIManager.getColor("Button.background"));
		btn_update.setBounds(10, 218, 109, 26);
		contentPane.add(btn_update);
		
		JButton btn_clear = new JButton("Clear all");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				med_id.setText("");
				sd.setText("");
				ed.setText("");
			}
		});
		btn_clear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_clear.setBackground(UIManager.getColor("Button.background"));
		btn_clear.setBounds(129, 218, 109, 26);
		contentPane.add(btn_clear);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/medecine.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
		
		JButton btnMeds = new JButton("Meds");
		btnMeds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().isEmpty())
					JOptionPane.showMessageDialog(null,"You did not enter a Patient ID to check meds for");
				else {
					Med_viewpat x = new Med_viewpat(Integer.parseInt(id.getText()) );
					x.setVisible(true);
					x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				}
			}
		});
		btnMeds.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMeds.setBackground(UIManager.getColor("Button.background"));
		btnMeds.setBounds(323, 63, 103, 33);
		contentPane.add(btnMeds);
	}
}