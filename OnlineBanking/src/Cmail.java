import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cmail {

	private JFrame frame;
	private String account;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cmail window = new Cmail("");
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
	public Cmail(String account) {
		this.account=account;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 597, 446);
		frame.setLocation(450,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter New Email");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(31, 76, 193, 40);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(234, 80, 226, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(31, 161, 163, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 158, 226, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String q="select password from user where account='"+account+"';";
				String mail,password;
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Mail id is required");
					return;
				}
				else
					mail=textField.getText();
				
				if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"password is required");
					return;
				}
				else
					password=passwordField.getText();
				
				Conn c=new Conn();
				try {
					ResultSet r=c.s.executeQuery(q);
					int w;
					String q1="update user set email='"+mail+"' where account='"+account+"';";
					r.next();
					if(r.getString(1).equals(password)) {
						w=c.s.executeUpdate(q1);
						if(w==1) {
							JOptionPane.showMessageDialog(null,"email successfully updated");
							frame.setVisible(false);
							return;
						}
						else {
							JOptionPane.showMessageDialog(null,"email not updated");
							frame.setVisible(false);
							return;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"password is incorrect");
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(420, 327, 110, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(31, 329, 104, 30);
		frame.getContentPane().add(btnNewButton_1);
	}
}
