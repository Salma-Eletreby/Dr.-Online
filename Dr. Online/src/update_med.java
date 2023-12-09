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

public class update_med extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField med_name;
	private JTextField med_desc;
	private JTextField med_price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update_med frame = new update_med();
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
	public update_med() {
		setTitle("Update Medication Information");
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*Medication ID :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 138, 33);
		contentPane.add(lblNewLabel);
		
		id = new JTextField();
		id.setBounds(148, 20, 138, 29);
		contentPane.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("Records");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Med_view x = new Med_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(296, 19, 105, 30);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("*Medication Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 86, 159, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Med Description :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 130, 159, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Medication Price : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 174, 159, 33);
		contentPane.add(lblNewLabel_3);
		
		med_name = new JTextField();
		med_name.setBounds(190, 86, 174, 33);
		contentPane.add(med_name);
		med_name.setColumns(10);
		
		med_desc = new JTextField();
		med_desc.setColumns(10);
		med_desc.setBounds(190, 130, 174, 33);
		contentPane.add(med_desc);
		
		med_price = new JTextField();
		med_price.setColumns(10);
		med_price.setBounds(190, 174, 174, 33);
		contentPane.add(med_price);
		
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
			    try{	Medication_Dbase db= new Medication_Dbase();
			    	if (id.getText().isEmpty() || med_name.getText().isEmpty())
			    		JOptionPane.showMessageDialog(null, "You missed a mandatory field ");
			    	else {
			    		if (med_desc.getText().isEmpty())
			    			med_desc.setText("");
			    		if (med_price.getText().isEmpty())
			    			med_price.setText("0");
			    		db.update(Integer.parseInt(id.getText()), med_name.getText(), med_desc.getText(), Float.parseFloat(med_price.getText()));
			    		db.close();
			    		dispose();
			    	}
			    }catch (java.lang.NumberFormatException ee) {
					JOptionPane.showMessageDialog(null, "Medication ID and price should be in number format. Please change it accordingly.");
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
				med_name.setText("");
				med_desc.setText("");
				med_price.setText("");
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
	}
}
