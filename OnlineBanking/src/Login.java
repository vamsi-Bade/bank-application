import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 845, 725);
		frame.setLocation(400,100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the Account No.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(46, 187, 232, 32);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(274, 187, 232, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(46, 276, 188, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Existing User Login");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel_2.setBounds(227, 73, 290, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String account,password,name;
				char g;
				if(textField.getText().length()<11) {
					JOptionPane.showMessageDialog(null,"Enter the Account number");
					return;
				}
				else
					account=textField.getText();
				if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the password");
					return;
				}
				else
					password=passwordField.getText();
				try {
					Conn c=new Conn();
					String query="select name,password,gender from user where account='"+account+"';";
					ResultSet result=c.s.executeQuery(query);
					if(result.next()) {
						if(result.getString(2).equals(password)) {
							frame.setVisible(false);
							g=result.getString(3).charAt(0);
							name=result.getString(1);
							new Home(account,name,g);
						}
						else {
							JOptionPane.showMessageDialog(null,"Incorrect password");
							return;
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"The User with this acoount no. doesn't exists");
						return;
					}
				}
				catch(Exception ec) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(511, 389, 126, 36);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Start();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1.setBounds(71, 393, 97, 32);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(274, 276, 232, 32);
		frame.getContentPane().add(passwordField);
		
		textField.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<11) {
	            	 textField.setEditable(true);
	            	}
	            	 else if((l==11)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField.setEditable(true);
	            		 else
	            		 textField.setEditable(false);
	            	 }
	             } else {
	            	 textField.setEditable(false);
	            	 
	             }
	          }
	       });
	}
}
