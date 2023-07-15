import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cmobile {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private String account;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cmobile window = new Cmobile("");
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
	public Cmobile(String account) {
		initialize();
		this.account=account;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 614, 486);
		frame.setLocation(450,150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Old Phone number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setBounds(24, 63, 221, 26);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(316, 63, 194, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Phone Number");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(24, 136, 243, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(316, 132, 194, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(24, 214, 221, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(316, 214, 194, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String ophone,ophone1,nphone,password;
				String q="select phone,password from user where account='"+account+"';";
				
				if(textField.getText().length()<10) {
					JOptionPane.showMessageDialog(null," Old Phone number is required");
					return;
				}
				else
					ophone=textField.getText();
				
				if(textField_1.getText().length()<10) {
					JOptionPane.showMessageDialog(null," New Phone number is required");
					return;
				}
				else
					nphone=textField_1.getText();
				
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
					String q1="update user set phone='"+nphone+"' where account='"+account+"';";
					r.next();
					ophone1=r.getString(1);
					if(r.getString(2).equals(password)) {
						if(ophone1.equals(ophone) && nphone.equals(nphone)) {
							w=c.s.executeUpdate(q1);
							if(w==1) {
								JOptionPane.showMessageDialog(null,"phone no. successfully updated");
								frame.setVisible(false);
								return;
							}
							else {
								JOptionPane.showMessageDialog(null,"phone no. not updated");
								frame.setVisible(false);
								return;
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"Old Phone number is incorrect or same as New phone number");
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
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.setBounds(412, 347, 126, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				return;
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnNewButton_1.setBounds(10, 347, 115, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		textField.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<10) {
	            	 textField.setEditable(true);}
	            	 else if((l==10)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField.setEditable(true);
	            	 }
	             } else {
	            	 textField.setEditable(false);
	             }
	          }
	       });
		
		textField_1.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField_1.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<10) {
	            	 textField_1.setEditable(true);}
	            	 else if((l==10)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField_1.setEditable(true);
	            	 }
	             } else {
	            	 textField_1.setEditable(false);
	             }
	          }
	       });
	}
}
