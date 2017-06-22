import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
/**
 * SENG2011 Project Fine Food Finder
 * @author Daniel Al Mouiee
 * Register Dialog page class 
 * DONE
 */
public class Register extends JDialog {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField tfNewUsername;
    private static JPasswordField pfNewPassword;
    private JLabel lbNewUsername;
    private JLabel lbNewPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JLabel lblCustomerLogin;
 
    public Register(Frame parent) {
    	super(parent, "Register", true);
    	setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        GridBagConstraints cs = new GridBagConstraints();
        setBounds(200, 200, 450, 221);
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbNewUsername = new JLabel("Username: ");
        lbNewUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lbNewUsername.setBounds(74, 88, 70, 17);
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.setLayout(null);
        panel.add(lbNewUsername);
 
        tfNewUsername = new JTextField(20);
        tfNewUsername.setBounds(304, 86, 81, 20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfNewUsername);
 
        lbNewPassword = new JLabel("Password: ");
        lbNewPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lbNewPassword.setBounds(74, 148, 70, 17);
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbNewPassword);
 
        pfNewPassword = new JPasswordField(20);
        pfNewPassword.setBounds(304, 146, 81, 20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfNewPassword);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        getContentPane().add(panel, BorderLayout.CENTER);
               
                      btnRegister = new JButton("Register");
                      btnRegister.setBounds(117, 242, 100, 23);
                      panel.add(btnRegister);
                      btnRegister.addActionListener(new ActionListener() {
 
                          public void actionPerformed(ActionEvent e) {
                              register();
                              if(checkInputsValid() == true && checkIfExists() == true)
                              {
                            	  JOptionPane.showMessageDialog(Register.this,
                            			  "Hey there " + getUsername() + "! You have successfully registered into FFF.",
                            			  "Login",
                            			  JOptionPane.INFORMATION_MESSAGE);
                            	  dispose();
                            	  CustomerProfileCreatePage CPCCDlg = new CustomerProfileCreatePage(Main.frame);
  		    					  CPCCDlg.setVisible(true);
  		    					  CPCCDlg.setLocationRelativeTo(null);
                              }else{
                            	  JOptionPane.showMessageDialog(Register.this,
                            			  "Invalid Username or Password or Username are already taken,"
                            			  + " please enter valid or unique credentials .",
                            			  "Registeration",
                            			  JOptionPane.ERROR_MESSAGE);
                              }
                          }
                      });
               
               btnCancel = new JButton("Cancel");
               btnCancel.setBounds(270, 242, 100, 23);
               panel.add(btnCancel);
               
               lblCustomerLogin = new JLabel("Customer Register");
               lblCustomerLogin.setHorizontalAlignment(SwingConstants.CENTER);
               lblCustomerLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
               lblCustomerLogin.setBounds(140, 10, 230, 43);
               panel.add(lblCustomerLogin);
               btnCancel.addActionListener(new ActionListener() {
 
                   public void actionPerformed(ActionEvent e) {
                       dispose();
                       Welcome wel = new Welcome();
                       wel.setVisible(true);
                       wel.setLocationRelativeTo(null);
                   }
               });
 
        setSize(500,400);
        setLocationRelativeTo(parent);
        setResizable(false);
        
        ImageIcon icon = new ImageIcon("1.jpg"); 
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setBounds(0,0,500,500);
        panel.add(thumb);
    }
 
    public static String getUsername() {
        return tfNewUsername.getText().trim();
    }
 
    public static String getPassword() {
        return new String(pfNewPassword.getPassword());
    }
    
    public Customer register()
    {
    	String username = getUsername();
        String password = getPassword();
        Customer c1 = new Customer(username,password,"","",
    			0,"",0, 0,"","", new ArrayList<Review>());
        Main.currentUser = c1;
    	return Main.currentUser;
    }
    
    public boolean checkInputsValid()
    {
    	if(getUsername().isEmpty() || getPassword().isEmpty())
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
}