import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cpassword {

	private JFrame frame;
	private String account;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cpassword window = new Cpassword("");
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
	public Cpassword(String account) {
		this.account=account;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 453);
		frame.setLocation(450,150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Old Password");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(33, 83, 191, 32);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(275, 83, 191, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(33, 173, 205, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(275, 173, 191, 30);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String q="select password from user where account='"+account+"';";
				String opass,npass;
				
				if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"password is required");
					return;
				}
				else
					opass=passwordField.getText();
				
				if(passwordField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"password is required");
					return;
				}
				else
					npass=passwordField_1.getText();
				
				Conn c=new Conn();
				try {
					ResultSet r=c.s.executeQuery(q);
					int w;
					String q1="update user set password='"+npass+"' where account='"+account+"';";
					r.next();
					if(r.getString(1).equals(opass) && !opass.equals(npass)) {
						w=c.s.executeUpdate(q1);
						if(w==1) {
							JOptionPane.showMessageDialog(null,"password successfully updated");
							frame.setVisible(false);
							return;
						}
						else {
							JOptionPane.showMessageDialog(null,"password not updated");
							frame.setVisible(false);
							return;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"old password is incorrect or same as new password");
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(415, 293, 116, 32);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(33, 293, 123, 32);
		frame.getContentPane().add(btnNewButton_1);
	}
}
