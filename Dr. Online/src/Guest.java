import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Guest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guest frame = new Guest();
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
	public Guest() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Images/icon.jpg"));
		setTitle("Guest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome, Guest!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 0, 440, 66);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("We reccomend creating an account to get the most of Dr Online.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 45, 426, 25);
		contentPane.add(lblNewLabel_2);
		
		JButton btn_Topics = new JButton("Topics");
		btn_Topics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				top_view x = new top_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btn_Topics.setBounds(81, 95, 89, 23);
		contentPane.add(btn_Topics);
		
		JButton btn_replies = new JButton("Replies");
		btn_replies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reply_view x = new reply_view();
				x.setVisible(true);
				x.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		btn_replies.setBounds(178, 95, 89, 23);
		contentPane.add(btn_replies);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btn_Exit.setBounds(277, 95, 89, 23);
		contentPane.add(btn_Exit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 450, 300);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("Images/Guest.jpg"));
	}
}
