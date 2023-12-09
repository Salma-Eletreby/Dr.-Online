import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Doctors extends JFrame {
	public Doctors() {
	}
	
	private static String name;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctors frame = new Doctors(name);
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
	public Doctors(String name) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Doctors Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome back,");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 70, 168, 14);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Menu.background"));
		menuBar.setBounds(0, 0, 456, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Topics");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem view_topic = new JMenuItem("View Topics");
		view_topic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top_view x = new top_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		mnNewMenu.add(view_topic);
		
		JMenuItem add_topic = new JMenuItem("Add New Topic");
		mnNewMenu.add(add_topic);
		
		JMenuItem update_topic = new JMenuItem("Update Topic");
		mnNewMenu.add(update_topic);
		
		JMenuItem delete_topic = new JMenuItem("Delete Topic");
		mnNewMenu.add(delete_topic);
		
		JMenu mnNewMenu_1 = new JMenu("Replies");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem view_reply = new JMenuItem("View Replies");
		view_reply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reply_view x = new reply_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(view_reply);
		
		JMenuItem add_reply = new JMenuItem("Add Reply");
		mnNewMenu_1.add(add_reply);
		
		JMenuItem update_reply = new JMenuItem("Update Reply");
		mnNewMenu_1.add(update_reply);
		
		JMenuItem delete_reply = new JMenuItem("Delete Reply");
		mnNewMenu_1.add(delete_reply);
		
		JMenu mnNewMenu_2 = new JMenu("Medications");
		mnNewMenu_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem view_meds = new JMenuItem("View Medications");
		view_meds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Med_view x = new Med_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		mnNewMenu_2.add(view_meds);
		
		JMenu mnNewMenu_5 = new JMenu("Close");
		mnNewMenu_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sign out");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Screen lg = new Login_Screen();
				lg.setVisible(true);
				dispose();
				lg.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("Images/Dr(main).JPG"));
		background.setBounds(0, 0, 456, 276);
		contentPane.add(background);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(name);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 103, 112, 35);
		contentPane.add(lblNewLabel_1);
	}
}
