import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.SystemColor;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
public class SearchByName extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String st;
	private JLabel c11;
	/**
	 * Create the dialog.
	 */
	public SearchByName() {
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			
			TextField searchTF = new TextField();
			searchTF.setBounds(136, 127, 248, 22);
			contentPanel.add(searchTF);
			
			Label searchLB = new Label("Enter Food-Outlet Name for Search :");
			searchLB.setBackground(Color.WHITE);
			searchLB.setBounds(20, 84, 220, 22);
			contentPanel.add(searchLB);
			
			JLabel titleLB = new JLabel("Search By Name");
			titleLB.setFont(new Font("Arial", Font.BOLD, 20));
			titleLB.setBackground(Color.WHITE);
			titleLB.setBounds(161, 11, 189, 50);
			contentPanel.add(titleLB); 
			
			
			JButton resetButton = new JButton("Reset");
			resetButton.setBounds(22, 306, 89, 23);
			contentPanel.add(resetButton);
			
				JButton searchButton = new JButton("Search");
				searchButton.setBounds(189, 306, 88, 23);
				contentPanel.add(searchButton);
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String tp1 = "Print,Outlets,Outlets,name,";
						String tp2 = getInputString(searchTF);
						StringBuilder sb = new StringBuilder();
						sb.append(tp1);
						sb.append(tp2);
						st = sb.toString();
						DBMain DB = new DBMain();
						DB.dbControl(st);
						dispose();
						ResultSearch RS = new ResultSearch(DB.getDl(), "0");
						RS.setVisible(true);
						RS.setLocationRelativeTo(null);
					}
				});
				searchButton.setActionCommand("OK");
				getRootPane().setDefaultButton(searchButton);
				
					JButton cancelButton = new JButton("Cancel");
					cancelButton.setBounds(339, 306, 89, 23);
					contentPanel.add(cancelButton);
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
							if(Main.currentUser != null){
								CustomerProfilePage CPP = new CustomerProfilePage();
								CPP.setVisible(true);
								CPP.setLocationRelativeTo(null);
							} else if(Main.currentOutletUser != null){
								OutletProfilePage OPP = new OutletProfilePage();
								OPP.setVisible(true);
								OPP.setLocationRelativeTo(null);
							}
						}
					});
					cancelButton.setActionCommand("Cancel");
					
					c11 = new JLabel();
					c11.setBackground(SystemColor.text);
					ImageIcon icon = new ImageIcon("11.jpg"); 
					c11.setIcon(icon);
					c11.setBounds(129, 164, 299, 113);
					contentPanel.add(c11);
			resetButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchTF.setText("");
				}
			});
		
	}
	
	public String getInputString(TextField tf)
	{
		return tf.getText();
	}
}