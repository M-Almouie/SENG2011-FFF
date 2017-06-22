import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.SystemColor;
public class ChangeAccountDetails extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbOldUsername;
	private JLabel lbOldPassword;
	private JLabel lbOldPassword_1;
	private JLabel lbNewUsername;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField tfOldPassword;
	private static JPasswordField tfNewPassword;
	static private JTextField tfOldUsername;
	private static JTextField tfNewUsername;
	private JLabel lblChangeDetails;
	private JButton okButton;
	private JButton cancelButton;
	private JLabel c1;
	/**
	 * Create the dialog.
	 */
	public ChangeAccountDetails() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
        
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{33, 100, 19, 37, 26, 69, 92, 0};
		gbl_contentPanel.rowHeights = new int[]{20, 20, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_lbFirstName = new GridBagConstraints();
		gbc_lbFirstName.anchor = GridBagConstraints.EAST;
		gbc_lbFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lbFirstName.gridx = 1;
		gbc_lbFirstName.gridy = 0;
		GridBagConstraints gbc_tfFirstName = new GridBagConstraints();
		gbc_tfFirstName.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfFirstName.gridwidth = 4;
		gbc_tfFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_tfFirstName.gridx = 2;
		gbc_tfFirstName.gridy = 0;
		GridBagConstraints gbc_lbSurname = new GridBagConstraints();
		gbc_lbSurname.anchor = GridBagConstraints.WEST;
		gbc_lbSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lbSurname.gridx = 6;
		gbc_lbSurname.gridy = 0;
		GridBagConstraints gbc_lbDOB= new GridBagConstraints();
		gbc_lbDOB.anchor = GridBagConstraints.WEST;
		gbc_lbDOB.insets = new Insets(0, 0, 5, 5);
		gbc_lbDOB.gridx = 4;
		gbc_lbDOB.gridy = 1;
		GridBagConstraints gbc_tfAge= new GridBagConstraints();
		gbc_tfAge.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfAge.gridwidth = 2;
		gbc_tfAge.insets = new Insets(0, 0, 5, 5);
		gbc_tfAge.gridx = 5;
		gbc_tfAge.gridy = 1;
		GridBagConstraints gbc_lbPostcode= new GridBagConstraints();
		gbc_lbPostcode.gridwidth = 2;
		gbc_lbPostcode.anchor = GridBagConstraints.EAST;
		gbc_lbPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_lbPostcode.gridx = 1;
		gbc_lbPostcode.gridy = 2;
		GridBagConstraints gbc_tfPostcode= new GridBagConstraints();
		gbc_tfPostcode.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfPostcode.gridwidth = 4;
		gbc_tfPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_tfPostcode.gridx = 3;
		gbc_tfPostcode.gridy = 2;
		GridBagConstraints gbc_tfSurname= new GridBagConstraints();
		gbc_tfSurname.anchor = GridBagConstraints.NORTHWEST;
		gbc_tfSurname.gridwidth = 3;
		gbc_tfSurname.insets = new Insets(0, 0, 0, 5);
		gbc_tfSurname.gridx = 3;
		gbc_tfSurname.gridy = 2;
		
		lblChangeDetails = new JLabel("Change Details");
		lblChangeDetails.setForeground(Color.BLACK);
		lblChangeDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_lblChangeDetails = new GridBagConstraints();
		gbc_lblChangeDetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblChangeDetails.gridx = 3;
		gbc_lblChangeDetails.gridy = 0;
		contentPanel.add(lblChangeDetails, gbc_lblChangeDetails);
		lbOldUsername = new JLabel("Old Username: ");
		lbOldUsername.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lbOldUsername = new GridBagConstraints();
		gbc_lbOldUsername.anchor = GridBagConstraints.WEST;
		gbc_lbOldUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lbOldUsername.gridx = 1;
		gbc_lbOldUsername.gridy = 2;
		contentPanel.add(lbOldUsername, gbc_lbOldUsername);
		
		tfOldUsername = new JTextField();
		tfOldUsername.setBackground(SystemColor.inactiveCaption);
		tfOldUsername.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_formattedTextField = new GridBagConstraints();
		gbc_formattedTextField.gridwidth = 3;
		gbc_formattedTextField.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField.gridx = 3;
		gbc_formattedTextField.gridy = 2;
		contentPanel.add(tfOldUsername, gbc_formattedTextField);
		
		lbOldPassword_1 = new JLabel("Old Password:");
		lbOldPassword_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lbOldPassword = new GridBagConstraints();
		gbc_lbOldPassword.anchor = GridBagConstraints.WEST;
		gbc_lbOldPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lbOldPassword.gridx = 1;
		gbc_lbOldPassword.gridy = 3;
		contentPanel.add(lbOldPassword_1, gbc_lbOldPassword);
		
		tfOldPassword = new JPasswordField();
		tfOldPassword.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 3;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 3;
		gbc_passwordField.gridy = 3;
		contentPanel.add(tfOldPassword, gbc_passwordField);
		
		lbNewUsername= new JLabel("New Username:");
		lbNewUsername.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lbNewUsername = new GridBagConstraints();
		gbc_lbNewUsername.anchor = GridBagConstraints.WEST;
		gbc_lbNewUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lbNewUsername.gridx = 1;
		gbc_lbNewUsername.gridy = 5;
		contentPanel.add(lbNewUsername, gbc_lbNewUsername);
		
		tfNewUsername = new JTextField();
		tfNewUsername.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.gridwidth = 3;
		gbc_formattedTextField_1.insets = new Insets(0, 0, 5, 5);
		gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_1.gridx = 3;
		gbc_formattedTextField_1.gridy = 5;
		contentPanel.add(tfNewUsername,gbc_formattedTextField_1);
		
		lbOldPassword = new JLabel("New Password:");
		lbOldPassword.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lbNewPassword = new GridBagConstraints();
		gbc_lbNewPassword.anchor = GridBagConstraints.WEST;
		gbc_lbNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lbNewPassword.gridx = 1;
		gbc_lbNewPassword.gridy = 6;
		contentPanel.add(lbOldPassword, gbc_lbNewPassword);
		
		tfNewPassword = new JPasswordField();
		tfNewPassword.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.gridwidth = 3;
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_1.gridx = 3;
		gbc_passwordField_1.gridy = 6;
		contentPanel.add(tfNewPassword, gbc_passwordField_1);
		
        
		{
			okButton = new JButton("OK");
			GridBagConstraints gbc_okButton = new GridBagConstraints();
			gbc_okButton.insets = new Insets(0, 0, 5, 5);
			gbc_okButton.gridwidth = 2;
			gbc_okButton.gridx = 4;
			gbc_okButton.gridy = 7;
			contentPanel.add(okButton, gbc_okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(Welcome.choice == true){
						if (authenticate() == true && checkInputsValid() == true && checkIfExists() == true)
						{
							int i = getUserIndex();
							reRegister(i);
							JOptionPane.showMessageDialog(ChangeAccountDetails.this,
									"Hey there " + getNewUsername() + "! You have successfully changed your details!",
									"Login",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							CustomerProfilePage CPP = new CustomerProfilePage();
							CPP.setLocationRelativeTo(null);
							CPP.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(ChangeAccountDetails.this,
							"Invalid Username or Password or Username are already taken,"
                      			+ " please enter valid or unique credentials .",
                      			"Change Credentials",
                      			JOptionPane.ERROR_MESSAGE);
						}
					}else{
						if (authenticateOutlet() == true && checkInputsValid() == true && checkIfExistsOutlet() == true)
						{
							int i = getUserIndexOutlet();
							reRegisterOutlet(i);
							JOptionPane.showMessageDialog(ChangeAccountDetails.this,
									"Hey there " + getNewUsername() + "! You have successfully changed your details!",
									"Login",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
							OutletProfilePage OPP = new OutletProfilePage();
							OPP.setLocationRelativeTo(null);
							OPP.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(ChangeAccountDetails.this,
							"Invalid Username or Password or Username are already taken,"
                      			+ " please enter valid or unique credentials .",
                      			"Change Credentials",
                      			JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			
			okButton.setHorizontalAlignment(SwingConstants.LEFT);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		//contentPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblChangeDetails, lbOldUsername, tfOldUsername, lbOldPassword_1, tfOldPassword, lbNewUsername, tfNewUsername, lbOldPassword, tfNewPassword, okButton, cancelButton}));
		{
			cancelButton = new JButton("Cancel");
			GridBagConstraints gbc_cancelButton = new GridBagConstraints();
			gbc_cancelButton.insets = new Insets(0, 0, 5, 0);
			gbc_cancelButton.gridx = 6;
			gbc_cancelButton.gridy = 7;
			contentPanel.add(cancelButton, gbc_cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Options op = new Options();
					op.setLocationRelativeTo(null);
					op.setVisible(true);
				}
			});
			cancelButton.setHorizontalAlignment(SwingConstants.LEFT);
			cancelButton.setActionCommand("Cancel");
			
		}
		
		c1 = new JLabel();
		c1.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("2.jpg"); 
		c1.setIcon(icon);
		GridBagConstraints gbc_c1 = new GridBagConstraints();
		gbc_c1.gridheight = 4;
		gbc_c1.gridwidth = 2;
		gbc_c1.insets = new Insets(0, 0, 5, 5);
		gbc_c1.fill = GridBagConstraints.BOTH;
		gbc_c1.gridx = 1;
		gbc_c1.gridy = 9;
		contentPanel.add(c1, gbc_c1);
		
		/*
		ImageIcon icon = new ImageIcon("1.jpg"); 
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setBounds(0,0,500,500);
        contentPanel.add(thumb);
        */
        

	}
	
	public static String getNewUsername() {
        return tfNewUsername.getText().trim();
    }
 
    public static String getPassword() {
        return new String(tfNewPassword.getPassword());
    }
    
	public boolean authenticate()
	{
		String username = tfOldUsername.getText();
        String password = new String(tfOldPassword.getPassword());
        
        if( Main.currentUser.username.compareTo(username) == 0 && Main.currentUser.password.compareTo(password) == 0)
        {
        	return true;
        }
        return false;
	}
	
	public boolean authenticateOutlet()
	{
		String username = tfOldUsername.getText();
        String password = new String(tfOldPassword.getPassword());
        
        if( Main.currentOutletUser.username.compareTo(username) == 0 && Main.currentOutletUser.password.compareTo(password) == 0)
        {
        	return true;
        }
        return false;
	}
	
	public int getUserIndex()
	{
		String username = tfOldUsername.getText();
        String password = new String(tfOldPassword.getPassword());
        
        for(int i = 0; i < Main.customers.size(); i++)
        {
            if(Main.customers.get(i).username.compareTo(username) == 0 
               && Main.customers.get(i).password.compareTo(password) == 0)
            {
            	Main.currentUser = Main.customers.get(i);
                return i;
            }
        }
        return -1;
	}
	
	public int getUserIndexOutlet()
	{
		String username = tfOldUsername.getText();
        String password = new String(tfOldPassword.getPassword());
        
        for(int i = 0; i < Main.outlets.size(); i++)
        {
            if(Main.outlets.get(i).username.compareTo(username) == 0 
               && Main.outlets.get(i).password.compareTo(password) == 0)
            {
            	Main.currentOutletUser = Main.outlets.get(i);
                return i;
            }
        }
        return -1;
	}
	
	public Customer reRegister(int i)
	{
	    	String username = tfNewUsername.getText();
	        String password = new String(tfNewPassword.getPassword());
	        if(!(username.equals(""))) { Main.currentUser.username = username; }
			if(!(password.equals(""))) { Main.currentUser.password = password; }
	        
	        String oldusername = tfOldUsername.getText();
	        String oldpassword = new String(tfOldPassword.getPassword());
	        
	        for(int j = 0; j < Main.customers.size(); j++)
	        {
	            if(Main.customers.get(j).username.compareTo(oldusername) == 0 
	               && Main.customers.get(j).password.compareTo(oldpassword) == 0)
	            {
	            	Main.customers.set(j, Main.currentUser);
	            	break;
	            }
	        }
	        try {
			    FileOutputStream fos = new FileOutputStream("CustomerUser.ser");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
			    oos.writeObject(Main.customers); // write MenuArray to ObjectOutputStream
			    oos.close(); 
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
	    	return Main.currentUser;
	}
	public OutletAccount reRegisterOutlet(int i)
	{
	    	String username = tfNewUsername.getText();
	        String password = new String(tfNewPassword.getPassword());
	        Main.currentOutletUser.username = username;
	        Main.currentOutletUser.password = password;
	        
	        String oldusername = tfOldUsername.getText();
	        String oldpassword = new String(tfOldPassword.getPassword());
	        
	        for(int j = 0; j < Main.outlets.size(); j++)
	        {
	            if(Main.outlets.get(j).username.compareTo(oldusername) == 0 
	               && Main.outlets.get(j).password.compareTo(oldpassword) == 0)
	            {
	            	Main.outlets.set(j, Main.currentOutletUser);
	            	break;
	            }
	        }
	        try {
			    FileOutputStream fos = new FileOutputStream("OutletUser.ser");
			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
			    oos.writeObject(Main.outlets); // write MenuArray to ObjectOutputStream
			    oos.close(); 
			} catch(Exception ex) {
			    ex.printStackTrace();
			}
	        
	    	return Main.currentOutletUser;
	}
	    
	public boolean checkInputsValid()
	{
			if(getNewUsername().isEmpty() && getPassword().isEmpty())
	    	{
	    		return false;
	    	}
	    	return true;
	}
	    
	public boolean checkIfExists()
	{
	    	String username = tfNewUsername.getText();
	        for(int i = 0; i < Main.customers.size(); i++)
	        {
	            if(Main.customers.get(i).username.compareTo(username) == 0)
	            {
	                return false;
	            }
	        }
	        return true;
	}
	
	public boolean checkIfExistsOutlet()
	{
	    	String username = tfNewUsername.getText();
	        for(int i = 0; i < Main.outlets.size(); i++)
	        {
	            if(Main.outlets.get(i).username.compareTo(username) == 0)
	            {
	            	System.out.println("Found");
	                return false;
	            }
	        }
	        return true;
	}
}