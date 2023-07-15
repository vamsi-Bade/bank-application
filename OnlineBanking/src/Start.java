import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start{

	private JFrame frmNetbanking;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frmNetbanking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}
	private Image scale(Image im,int w,int h){
		Image image=im.getScaledInstance(w, h, Image.SCALE_FAST);
		return image;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNetbanking = new JFrame();
		frmNetbanking.getContentPane().setBackground(new Color(255, 255, 255));
		frmNetbanking.getContentPane().setForeground(new Color(241, 240, 239));
		frmNetbanking.setLocation(400, 60);
		frmNetbanking.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 10));
		frmNetbanking.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ONLINE BANKING");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(234, 10, 278, 98);
		frmNetbanking.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New User");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNetbanking.setVisible(false);
				new Signup();
			}
		});
		btnNewButton.setFont(new Font("Californian FB", Font.BOLD, 14));
		btnNewButton.setBounds(164, 435, 105, 37);
		frmNetbanking.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Existing User");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNetbanking.setVisible(false);
				new Login();
			}
		});
		btnNewButton_1.setFont(new Font("Californian FB", Font.BOLD, 14));
		btnNewButton_1.setBounds(482, 435, 135, 37);
		frmNetbanking.getContentPane().add(btnNewButton_1);
		
		JLabel newuser = new JLabel("newuser");
		newuser.setBounds(158, 317, 111, 91);
		ImageIcon newu = new ImageIcon("newuser.png");
		newu=new ImageIcon(scale(newu.getImage(),newuser.getWidth(),newuser.getHeight()));
		newuser.setIcon(newu);
		frmNetbanking.getContentPane().add(newuser);
		
		JLabel existuser = new JLabel("");
		existuser.setBounds(500, 317, 105, 91);
		newu = new ImageIcon("existuser.png");
		newu=new ImageIcon(scale(newu.getImage(),existuser.getWidth(),existuser.getHeight()));
		existuser.setIcon(newu);
		frmNetbanking.getContentPane().add(existuser);
		
		JLabel logo = new JLabel("New label");
		logo.setBounds(269, 94, 200, 196);
		newu = new ImageIcon("logo.png");
		newu=new ImageIcon(scale(newu.getImage(),logo.getWidth(),logo.getHeight()));
		logo.setIcon(newu);
		frmNetbanking.getContentPane().add(logo);

		
		frmNetbanking.setTitle("NetBanking");
		frmNetbanking.setSize(746,734);
		frmNetbanking.setVisible(true);
		frmNetbanking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
