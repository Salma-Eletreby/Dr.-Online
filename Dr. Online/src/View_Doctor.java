import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_Doctor extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel_1;
	private JButton btn_Refresh;
	private JButton btn_Close;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_Doctor frame = new View_Doctor();
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
	public View_Doctor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("View Doctor Records");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 44, 621, 232);
		contentPane.add(scrollPane);
		
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.createVerticalScrollBar();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setPreferredSize(new Dimension(400,100));
		
		DBase x = new DBase();
		generate(x);
		
		lblNewLabel_1 = new JLabel("Doctor Records");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(5, 5, 631, 33);
		contentPane.add(lblNewLabel_1);
		
		btn_Refresh = new JButton("Refresh");
		btn_Refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(x);
			}
		});
		btn_Refresh.setBounds(229, 279, 89, 23);
		contentPane.add(btn_Refresh);
		
		btn_Close = new JButton("Close");
		btn_Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Close.setBounds(328, 279, 89, 23);
		contentPane.add(btn_Close);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images/Doctor(big).jpg"));
		lblNewLabel.setBounds(0, 0, 641, 313);
		contentPane.add(lblNewLabel);
	}
	
	private void generate(DBase x)
	{
		try {
			Statement stmt1 = x.conn.createStatement();
			String sql1 = "select * from Records_DOC";
			ResultSet rs = stmt1.executeQuery(sql1);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
