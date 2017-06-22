import java.awt.*;
import java.awt.event.*;
/*import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
*/
import javax.swing.*;
import javax.swing.border.*;
/**
 * SENG2011 Project Fine Food Finder
 * @author Daniel Al Mouiee
 * Login dialog page class 
 * DONE
 */ 
public class Login extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JTextField tfUsername;
    protected static JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean pass;
    private JLabel lblCustomerLogin;
    public Login(Frame parent) {
        super(parent, "Customer Login", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
 
        tfUsername = new JTextField(20);
        tfUsername.setBounds(304, 86, 81, 20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 3;
               panel.setLayout(null);
        
               lbUsername = new JLabel("Username: ");
               lbUsername.setFont(new Font("Arial", Font.BOLD, 12));
               lbUsername.setBounds(74, 88, 70, 17);
               panel.add(lbUsername);
        panel.add(tfUsername);
 
        lbPassword = new JLabel("Password: ");
        lbPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lbPassword.setBounds(74, 148, 70, 17);
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword);
 
        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(304, 146, 81, 20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 3;
        panel.add(pfPassword);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        getContentPane().add(panel, BorderLayout.CENTER);
                
                lblCustomerLogin = new JLabel("Customer Login");
                lblCustomerLogin.setFont(new Font("Tahoma", Font.BOLD, 21));
                lblCustomerLogin.setBounds(148, 10, 193, 32);
                panel.add(lblCustomerLogin);
                
        setLocationRelativeTo(parent);
        setSize(500,400);
        setResizable(true);
        
        
       
        
                btnLogin = new JButton("Login");
                btnLogin.setBounds(97, 221, 65, 23);
                panel.add(btnLogin);
                btnCancel = new JButton("Cancel");
                btnCancel.setBounds(297, 221, 77, 23);
                panel.add(btnCancel);
                btnCancel.addActionListener(new ActionListener() {
 
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        Welcome wel = new Welcome();
                        wel.setVisible(true);
                        wel.setLocationRelativeTo(null);
                    }
                });
                btnLogin.addActionListener(new ActionListener() {
 
                    public void actionPerformed(ActionEvent e) {
                    	
                    	if (Login.Authentication() == true) {
                            JOptionPane.showMessageDialog(Login.this,
                                    "Hey there " + getUsername() + "! You have successfully logged into FFF.",
                                    "Login",
                                    JOptionPane.INFORMATION_MESSAGE);
                            pass = true;
                            dispose();
                            CustomerProfilePage CPP = new CustomerProfilePage();
                            CPP.setVisible(true);
                            CPP.setLocationRelativeTo(null);
                        } else {
                            JOptionPane.showMessageDialog(Login.this,
                                    "Invalid username or password",
                                    "Login",
                                    JOptionPane.ERROR_MESSAGE);
                            // reset username and password
                            tfUsername.setText("");
                            pfPassword.setText("");
                            pass = false;
                        }
                    }
                });
                
                ImageIcon icon = new ImageIcon("1.jpg"); 
                JLabel thumb = new JLabel();
                thumb.setIcon(icon);
                thumb.setBounds(0,0,500,500);
                panel.add(thumb);
                
                
    }
    
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public boolean isPass() {
        return pass;
    }
    
    public static boolean Authentication(){
    	 
        String username = tfUsername.getText();
        String password = new String(pfPassword.getPassword());
        
        for(int i = 0; i < Main.customers.size(); i++)
        {
            if(Main.customers.get(i).username.compareTo(username) == 0 
               && Main.customers.get(i).password.compareTo(password) == 0)
            {
            	Main.currentUser = Main.customers.get(i);
                return true;
            }
        }
        return false;
    }
}