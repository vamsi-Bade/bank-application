import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Home {

	private JFrame frame;
	private String account;
	private String name;
	private char g;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home("","",' ');
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home(String account,String name,char g) {
		this.account=account;
		this.name=name;
		this.g=g;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Conn c=new Conn();
		frame = new JFrame();
		frame.setBounds(100, 100, 1010, 834);
		frame.setVisible(true);
		frame.setLocation(320, 20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Send Money");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SendM(account);
			}
		});
		btnNewButton.setBounds(64, 274, 164, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check Balance");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query="select balance from user where account='"+account+"';";
				try {
					ResultSet r=c.s.executeQuery(query);
					r.next();
					JOptionPane.showMessageDialog(null,"Your Balance is "+r.getString(1)+"" );
					return;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(64, 357, 164, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Transactions");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new history(account);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(64, 444, 194, 45);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Change Mobile No.");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cmobile(account);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(670, 274, 194, 45);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Change Email");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cmail(account);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_4.setBounds(671, 357, 178, 45);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Change Password");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Cpassword(account);
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_5.setBounds(670, 444, 204, 45);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Account Management");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel.setBounds(660, 202, 244, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Transaction Management");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(33, 207, 310, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel greeting = new JLabel("");
		String greet="Hello";
		if(g=='M')
			greet+=" Mr.";
		else
			greet+=" Ms.";
		greet+=name;
		greeting.setText(greet);
		greeting.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		greeting.setBounds(33, 84, 278, 45);
		frame.getContentPane().add(greeting);
		
		JButton btnNewButton_6 = new JButton("Exit");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_6.setBounds(64, 686, 139, 45);
		frame.getContentPane().add(btnNewButton_6);
	}
}
