import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Signup {

	private JFrame frmSignup;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JPasswordField passwordField;
	private JTextField textField_10;
	private JPasswordField passwordField_1;
	@SuppressWarnings("unused")
	private JTextField formattedTextField;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					window.frmSignup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Signup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignup = new JFrame();
		frmSignup.setTitle("SignUp");
		frmSignup.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 20));
		frmSignup.setSize(870,813);
		frmSignup.setLocation(400,20);
		frmSignup.setVisible(true);
		frmSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSignup.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Give your details");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		lblNewLabel.setBounds(36, 10, 204, 62);
		frmSignup.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FirstName");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(36, 82, 103, 49);
		frmSignup.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setBounds(146, 92, 128, 32);
		frmSignup.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MiddleName");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(284, 82, 128, 49);
		frmSignup.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_1.setBounds(416, 90, 141, 32);
		frmSignup.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("LastName");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_3.setBounds(581, 85, 114, 42);
		frmSignup.getContentPane().add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField_2.setBounds(705, 90, 141, 32);
		frmSignup.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("D O B");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_4.setBounds(36, 151, 80, 32);
		frmSignup.getContentPane().add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(146, 151, 204, 32);
		frmSignup.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_5.setBounds(36, 223, 94, 24);
		frmSignup.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnNewRadioButton.setBounds(173, 227, 103, 21);
		frmSignup.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		rdbtnNewRadioButton_1.setBounds(299, 227, 94, 21);
		frmSignup.getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup gender = new ButtonGroup();
		gender.add(rdbtnNewRadioButton_1);
		gender.add(rdbtnNewRadioButton);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile No.");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_6.setBounds(36, 273, 119, 24);
		frmSignup.getContentPane().add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_3.setBounds(173, 273, 165, 32);
		frmSignup.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(82, 307, 256, 24);
		frmSignup.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Address");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_8.setBounds(36, 460, 88, 32);
		frmSignup.getContentPane().add(lblNewLabel_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(173, 460, 278, 42);
		frmSignup.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("City");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_9.setBounds(36, 527, 46, 32);
		frmSignup.getContentPane().add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(173, 532, 157, 32);
		frmSignup.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("State");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_10.setBounds(36, 585, 114, 39);
		frmSignup.getContentPane().add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(173, 593, 157, 32);
		frmSignup.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Country");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_11.setBounds(36, 657, 94, 37);
		frmSignup.getContentPane().add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setBounds(173, 664, 157, 32);
		frmSignup.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Email");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_12.setBounds(490, 269, 67, 32);
		frmSignup.getContentPane().add(lblNewLabel_12);
		
		textField_8 = new JTextField();
		textField_8.setBounds(590, 275, 256, 30);
		frmSignup.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Account No.");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_13.setBounds(36, 325, 128, 32);
		frmSignup.getContentPane().add(lblNewLabel_13);
		
		textField_9 = new JTextField();
		textField_9.setBounds(173, 330, 186, 32);
		frmSignup.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Password");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_14.setBounds(36, 389, 128, 32);
		frmSignup.getContentPane().add(lblNewLabel_14);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(173, 394, 186, 32);
		frmSignup.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("register");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				long balance;
				String name,dob,city,state,country,address,password,email,card,acc,phone;
				int pin,check;
				char g=' ';
				if(rdbtnNewRadioButton.isSelected())
					g='M';
				else if(rdbtnNewRadioButton_1.isSelected())
					g='F';
				if((textField.getText().equals("")) || (textField_2.getText().equals(""))) {
					JOptionPane.showMessageDialog(null,"name is required");
					return;
				}
				else
					name=String.join(" ",textField.getText(),textField_1.getText(),textField_2.getText());
				
				if(((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().equals("")) {
					JOptionPane.showMessageDialog(null,"DOB is required");
					return;
				}
				else
					dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
				if(g==' '){
					JOptionPane.showMessageDialog(null,"Gender is required");
					return;
				}
				if(textField_3.getText().length()<10) {
					JOptionPane.showMessageDialog(null,"Phone number is required");
					return;
				}
				else
					phone=textField_3.getText();
				
				if(textField_9.getText().length()<11) {
					JOptionPane.showMessageDialog(null,"Account number is required");
					return;}
				else
					acc=textField_9.getText();
				if(textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Balance is required");
					return;}
				else
					balance=Long.parseLong(textField_10.getText());
				if(passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"password is required");
					return;
				}
				else
					password=passwordField.getText();
				if(textField_11.getText().length()<16 ) {
					JOptionPane.showMessageDialog(null,"Card number is required");
					return;
				}
				else
					card=textField_11.getText();
				if(passwordField_1.getText().length()<4) {
					JOptionPane.showMessageDialog(null,"pin is required");
					return;
				}
				else
					pin=Integer.parseInt(passwordField_1.getText());
				
				city=textField_5.getText();
				state=textField_6.getText();
				country=textField_7.getText();
				address=textField_4.getText();
				email=textField_8.getText();
				
				try {
					Conn c=new Conn();
					String query="insert into user values('"+name+"','"+dob+"','"+g+"','"+phone+"','"+email+"','"+acc+"',"+balance+",'"+password+"','"+card+"',"+pin+",'"+address+"','"+city+"','"+state+"','"+country+"');";
					check=c.s.executeUpdate(query);
					if(check==1) {
						frmSignup.setVisible(false);
						new Login();}
				}
				catch(SQLIntegrityConstraintViolationException ec) {
					JOptionPane.showMessageDialog(null,"User with Account no. already exists");
					return;
				}
				catch(Exception ec) {
					System.out.println(ec);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnNewButton.setBounds(688, 712, 128, 42);
		frmSignup.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_15 = new JLabel("Balance");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_15.setBounds(490, 325, 94, 32);
		frmSignup.getContentPane().add(lblNewLabel_15);
		
		textField_10 = new JTextField();
		textField_10.setBounds(590, 330, 165, 32);
		frmSignup.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("PIN");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_16.setBounds(490, 463, 77, 27);
		frmSignup.getContentPane().add(lblNewLabel_16);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(590, 460, 114, 30);
		frmSignup.getContentPane().add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSignup.setVisible(false);
				new Start();
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton_1.setBounds(36, 718, 119, 32);
		frmSignup.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_17 = new JLabel("Card No.");
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_17.setBounds(490, 399, 94, 27);
		frmSignup.getContentPane().add(lblNewLabel_17);
		
		textField_11 = new JTextField();
		textField_11.setBounds(590, 395, 198, 32);
		frmSignup.getContentPane().add(textField_11);
		textField_11.setColumns(10);

		

		
		textField_3.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField_3.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<10) {
	            			 lblNewLabel_7.setText("* Enter valid number *");
	            	 textField_3.setEditable(true);
	            	 lblNewLabel_7.setText("");}
	            	 else if((l==10)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField_3.setEditable(true);
	            		 else
	            		 textField_3.setEditable(false);
	            	 }
	             } else {
	            	 textField_3.setEditable(false);
	            	 lblNewLabel_7.setText("* Enter only numeric digits(0-9) *");
	             }
	          }
	       });
		
		textField_9.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField_9.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<11) {
	            	 textField_9.setEditable(true);
	            	}
	            	 else if((l==11)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField_9.setEditable(true);
	            		 else
	            		 textField_9.setEditable(false);
	            	 }
	             } else {
	            	 textField_9.setEditable(false);
	            	 
	             }
	          }
	       });
		textField_11.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             String value = textField_11.getText();
	             int l = value.length();
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 if(l<16) {
	            	 textField_11.setEditable(true);
	            	}
	            	 else if((l==16)){
	            		 if(ke.getKeyChar()=='\u0008')
	            			 textField_11.setEditable(true);
	            		 else
	            		 textField_11.setEditable(false);
	            	 }
	             } else {
	            	 textField_11.setEditable(false);
	            	 
	             }
	          }
	       });
		
		textField_10.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 textField_10.setEditable(true);}
	             else {
	            	 textField_10.setEditable(false);
	             }
	          }
	       });
		passwordField_1.addKeyListener(new KeyAdapter(){
	         public void keyPressed(KeyEvent ke) {
	        	 @SuppressWarnings("deprecation")
				String value = passwordField_1.getText();
	             int l = value.length();
	             if ((l<=3) && (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar()=='\u0008')) {
	            	 passwordField_1.setEditable(true);}
	             else {
	            	 passwordField_1.setEditable(false);
	             }
	          }
	       });

}
}
