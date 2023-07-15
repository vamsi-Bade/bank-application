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
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendM {

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
					SendM window = new SendM("");
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
	public SendM(String account) {
		initialize();
		this.account=account;

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 718, 484);
		frame.setLocation(450,150);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Reciever's account no.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel.setBounds(71, 59, 270, 36);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(366, 64, 247, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Amount");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(71, 120, 153, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(366, 130, 245, 33);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter PIN");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(71, 206, 142, 36);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				return;
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnNewButton.setBounds(53, 352, 118, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Send");
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Conn c=new Conn();
				String pin,raccount;
				long amount,sbalance,rbalance;
				if(textField.getText().length()<11) {
					JOptionPane.showMessageDialog(null,"Account number is required");
					return;}
				else {
					if(textField.getText().equals(account))
					{
						JOptionPane.showMessageDialog(null,"enter reciever's Account number");
						return;}
					else
					raccount=textField.getText();
				}
				
				if(passwordField.getText().length()<4) {
					JOptionPane.showMessageDialog(null,"pin is required");
					return;
				}
				else
					pin=passwordField.getText();
				if(textField_1.getText().equals("")|| Integer.parseInt(textField_1.getText())<1 ) {
					JOptionPane.showMessageDialog(null,"Amount is required");
					return;}
				else
					amount=Long.parseLong(textField_1.getText());
				String query1="select balance from user where account='"+raccount+"';";
				String query2="select balance,pin from user where account='"+account+"';";
				
				try {
					ResultSet sender=c.s.executeQuery(query2);
					sender.next();
					if(sender.getString(2).equals(pin)) {
						sbalance=sender.getLong(1);
						ResultSet receiver=c.s.executeQuery(query1);
					if(receiver.next()){
						rbalance=receiver.getLong(1);
						if(sbalance<amount) {
							JOptionPane.showMessageDialog(null,"Insufficient balance");
							return;
						}
						else {
						int s,r,d;
						String q3="update user set balance="+(rbalance+amount)+" where account='"+raccount+"';";
						String q4="update user set balance="+(sbalance-amount)+" where account='"+account+"';";
						String q5="insert into transactions values('"+account+"','"+raccount+"',"+amount+");";
						r=c.s.executeUpdate(q3);
						s=c.s.executeUpdate(q4);
						d=c.s.executeUpdate(q5);
						if(s==1 && r==1 && d==1) {
							JOptionPane.showMessageDialog(null,"Transaction succesfull");
							frame.setVisible(false);
							return;
						}
						else {
							JOptionPane.showMessageDialog(null,"Transaction unsuccesfull");
							frame.setVisible(false);
							return;
						}
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"The user with this account no. doesn't exist");
						return;
					}}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect pin entered");
						return;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		btnNewButton_1.setBounds(545, 349, 101, 36);
		frame.getContentPane().add(btnNewButton_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 206, 247, 36);
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
		textField_1.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 textField_1.setEditable(true);}
	             else {
	            	 textField_1.setEditable(false);
	             }
	          }
	       });
		
		passwordField.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	        	 @SuppressWarnings("deprecation")
				String value = passwordField.getText();
	             int l = value.length();
	             if ((l<=3) && (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 passwordField.setEditable(true);}
	             else {
	            	 passwordField.setEditable(false);
	             }
	          }
	       });
		
	}
}
