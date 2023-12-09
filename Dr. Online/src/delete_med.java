import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class delete_med extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete_med frame = new delete_med();
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
	public delete_med() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 86, 416, 16);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Delete Med: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 46, 120, 29);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(134, 46, 130, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medication_Dbase db = new Medication_Dbase();
				int id = (Integer.parseInt(textField.getText()));
				String [] result = new String[4];
				result = db.view_med(id);
				if (result[0]!= null) {
					try {
						Statement stmt =db.conn.createStatement();
						String sql = "select * from MEDECINE where MED_ID = "+textField.getText();
						ResultSet rs = stmt.executeQuery(sql);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						int answer = JOptionPane.showConfirmDialog(null, "Is this the medication you would like to delete?");
						if (answer == JOptionPane.YES_OPTION) {
							db.delete (Integer.parseInt(textField.getText()));
							JOptionPane.showMessageDialog(null, "Deleted");
							dispose();
						
						} else {
							JOptionPane.showMessageDialog(null, "Not deleted");
							dispose();
						}
					} catch (SQLException ef) {
						// TODO Auto-generated catch block
						ef.printStackTrace();
					}
				} else 
					JOptionPane.showMessageDialog(null, "No Medication Found!");	
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(277, 46, 101, 28);
		contentPane.add(btnNewButton);
		
		
		JLabel background = new JLabel("Bg");
		background.setIcon(new ImageIcon("Images/medecine.jpg"));
		background.setBounds(0, 0, 436, 276);
		contentPane.add(background);
	}
}
