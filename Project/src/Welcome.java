import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.SwingConstants;
/**
 * 
 * @author Daniel Al Mouiee
 * Class for Welcome screen
 * FIX UP
 */
public class Welcome extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected static boolean choice;
	
	/**
	 * Create the dialog.
	 */
	public Welcome() {
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fine Food Finder");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(159, 12, 188, 45);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please select what type of user you are:");
		lblNewLabel_1.setFont(new Font("Arial", Font.ITALIC, 16));
		lblNewLabel_1.setBounds(13, 113, 299, 67);
		contentPanel.add(lblNewLabel_1);
		setResizable(false);
		
		
	        
	        JButton btnNewButton = new JButton("Back");
	        btnNewButton.setBounds(168, 314, 144, 23);
	        contentPanel.add(btnNewButton);
	        JButton BtnCustomer = new JButton("Customer");
	        BtnCustomer.setBounds(72, 207, 144, 23);
	        contentPanel.add(BtnCustomer);
	        BtnCustomer.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		choice = true;
	        		dispose();
	        		if(Main.path == 1)
	        		{
	        			Login LoginDlg = new Login(Main.frame);
	        			LoginDlg.setLocationRelativeTo(null);
	        			LoginDlg.setVisible(true);
	        			
	        		}else if(Main.path == 2)
	        		{
	        			Register regDialog = new Register(Main.frame);
		    				regDialog.setVisible(true);
		    				regDialog.setLocationRelativeTo(null);
		    				regDialog.dispose();
	        		}
	        	}
	        });
	        getRootPane().setDefaultButton(BtnCustomer);
	        JButton BtnFoodOutlet = new JButton("Food Outlet");
	        BtnFoodOutlet.setBounds(301, 207, 144, 23);
	        contentPanel.add(BtnFoodOutlet);
	        BtnFoodOutlet.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		choice = false;
	        		dispose();
	        		if(Main.path == 1)
	        		{
	        			LoginOutlet LoginDlg = new LoginOutlet(Main.frame);
	        			LoginDlg.setLocationRelativeTo(null);
	        			LoginDlg.setVisible(true);
	        		}else if(Main.path == 2)
	        		{
		    				RegisterOutlet regDialog = new RegisterOutlet(Main.frame);
		    				regDialog.setVisible(true);
		    				regDialog.setLocationRelativeTo(null);
		    				regDialog.dispose();	
	        		}
	        	}
	        });
	        BtnFoodOutlet.setActionCommand("Cancel");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		dispose();
	        		Main main = new Main();
	        		Main.main(null);
	        	}
	        });
	        
	        ImageIcon icon = new ImageIcon("1.jpg"); 
		     JLabel thumb = new JLabel();
		     thumb.setIcon(icon);
		     thumb.setBounds(0,0,500,500);
		     contentPanel.add(thumb);
	}
}