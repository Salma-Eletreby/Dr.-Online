import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Approval_Topics extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Approval_Topics frame = new Approval_Topics();
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
	public Approval_Topics() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Topics To Approve");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 416, 179);
		contentPane.add(scrollPane);
		
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable source = (JTable)e.getSource();
		        int row = source.rowAtPoint( e.getPoint() );
		        int column = source.columnAtPoint( e.getPoint() );
		        
		        Object ID =table.getModel().getValueAt(row, column);
				
				Approval_Topics_2 ap = new Approval_Topics_2(ID);
				ap.setVisible(true);
				dispose();
				ap.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		table.setEnabled(false);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);
		
		DBase x = new DBase();
		generate(x);
		
		JLabel lblNewLabel_1 = new JLabel("Topics To Approve");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 416, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Click on desired Topic ID to view details and submit approval");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 20, 416, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Exit.setBounds(221, 229, 89, 23);
		contentPane.add(btn_Exit);
		
		JButton btn_ref = new JButton("Refresh");
		btn_ref.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate(x);
			}
		});
		btn_ref.setBounds(119, 229, 89, 23);
		contentPane.add(btn_ref);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("Images/disccusion.jpg"));
		lblNewLabel.setBounds(0, 0, 436, 263);
		contentPane.add(lblNewLabel);
	}
	
	private void generate(DBase x) {
		// TODO Auto-generated method stub
		try {
			Statement stmt1 = x.conn.createStatement();
			String sql1 = "select T_ID, DATE_CREATED, Approved, user_name from need_approval";
			ResultSet rs = stmt1.executeQuery(sql1);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}