import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class history {

	private JFrame frame;
	private JTable table_1;
    private String account;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					history window = new history("");
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
	public history(String account) {
		initialize();
		this.account=account;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 671);
		frame.setLocation(450,150);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 62, 467, 440);
		frame.getContentPane().add(scrollPane);
		table_1 = new JTable();
		table_1.setRowSelectionAllowed(false);
		table_1.setEnabled(false);
		table_1.setFillsViewportHeight(true);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Object[] columns= {"To/From","Debit","Credit"};
		Object[] rows=new Object[3];
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		table_1.setForeground(new Color(0, 0, 0));
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(54, 555, 121, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Check");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conn c=new Conn();
				try {
					String q="select * from transactions where saccount='"+account+"' or raccount='"+account+"';";
					ResultSet r=c.s.executeQuery(q);
					while(r.next()) {
						if(r.getString(1).equals(account)) {
							rows[0]=r.getString(2);
							rows[1]=r.getString(3);
							rows[2]="-";
						}
						else {
							rows[0]=r.getString(1);
							rows[2]=r.getString(3);
							rows[1]="-";
						}
						model.addRow(rows);
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(501, 555, 106, 32);
		frame.getContentPane().add(btnNewButton_1);
		
	}
}
