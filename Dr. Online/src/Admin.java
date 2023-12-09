import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private static String name;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(name);
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
	public Admin(String name) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Admin Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome back,");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 70, 136, 35);
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 456, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Patient");
		menuBar.add(mnNewMenu);
		
		JMenuItem mtm_Add = new JMenuItem("Add New Patient");
		mtm_Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_Patient ip = new Insert_Patient();
				ip.setVisible(true);
				ip.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		
		JMenuItem mtm_Pat = new JMenuItem("View All Patient Records");
		mtm_Pat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Patient vp = new View_Patient();
				vp.setVisible(true);
				vp.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mtm_Pat);
		mnNewMenu.add(mtm_Add);
		
		JMenuItem mtm_Del = new JMenuItem("Delete Patient");
		mtm_Del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_Patient del = new Delete_Patient();
				del.setVisible(true);
				del.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mtm_Del);
		
		JMenuItem mtm_UpdateP = new JMenuItem("Update Patient");
		mtm_UpdateP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Patient up = new Update_Patient();
				up.setVisible(true);
				up.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnNewMenu.add(mtm_UpdateP);
		
		JMenu mnDoctor = new JMenu("Doctor");
		menuBar.add(mnDoctor);
		
		JMenuItem mntmAddNewDoctor = new JMenuItem("Add New Doctor");
		mntmAddNewDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert_Dr inDr = new Insert_Dr();
				inDr.setVisible(true);
				inDr.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		
		JMenuItem mtm_DOC = new JMenuItem("View All Doctor Records");
		mtm_DOC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Doctor vD = new View_Doctor();
				vD.setVisible(true);
				vD.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnDoctor.add(mtm_DOC);
		mnDoctor.add(mntmAddNewDoctor);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Delete Doctor");
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete_DR delDR = new Delete_DR();
				delDR.setVisible(true);
				delDR.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnDoctor.add(mntmNewMenuItem_1_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Update Doctor");
		mntmNewMenuItem_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_DR uDR = new Update_DR();
				uDR.setVisible(true);
				uDR.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnDoctor.add(mntmNewMenuItem_2_1);
		
		JMenu mnNewMenu_2 = new JMenu("Topics");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Approve Patient Posted Topics");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Approval_Topics ap = new Approval_Topics();
				ap.setVisible(true);
				ap.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Close");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Sign Out");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Screen lg = new Login_Screen();
				lg.setVisible(true);
				dispose();
				lg.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JLabel lbl_name = new JLabel("");
		lbl_name.setText(name);
		lbl_name.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbl_name.setBounds(10, 103, 112, 35);
		contentPane.add(lbl_name);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images/admin(2).jpg"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
	}
}
