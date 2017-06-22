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
public class LoginOutlet extends JDialog {
	
	private static final long serialVersionUID = 1L;
	protected static JTextField tfUsername;
    protected static JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean pass;
    private JLabel lblFoodOutletLogin;
 
    public LoginOutlet(Frame parent) {
        super(parent, "Food Outlet Login", true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        lbUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lbUsername.setBounds(74, 88, 70, 17);
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.setLayout(null);
        panel.add(lbUsername);
 
        tfUsername = new JTextField(20);
        tfUsername.setBounds(264, 86, 81, 20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 3;
        panel.add(tfUsername);
 
        lbPassword = new JLabel("Password: ");
        lbPassword.setFont(new Font("Arial", Font.BOLD, 12));
        lbPassword.setBounds(74, 148, 70, 17);
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword);
 
        pfPassword = new JPasswordField(20);
        pfPassword.setBounds(264, 146, 81, 20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 3;
        panel.add(pfPassword);
        panel.setBorder(new LineBorder(Color.GRAY));
 
        getContentPane().add(panel, BorderLayout.CENTER);
        
        lblFoodOutletLogin = new JLabel("Food Outlet Login");
        lblFoodOutletLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblFoodOutletLogin.setBounds(121, 11, 182, 30);
        panel.add(lblFoodOutletLogin);
 
      setSize(500,400);
      setLocationRelativeTo(parent);
      setResizable(true);
      
      
      
              btnLogin = new JButton("Login");
              btnLogin.setBounds(115, 224, 65, 23);
              panel.add(btnLogin);
              btnCancel = new JButton("Cancel");
              btnCancel.setBounds(239, 224, 77, 23);
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
                  	
                  	if (Authentication() == true) {
                          JOptionPane.showMessageDialog(LoginOutlet.this,
                                  "Hey there " + getUsername() + "! You have successfully logged into FFF.",
                                  "Food Outlet Login",
                                  JOptionPane.INFORMATION_MESSAGE);
                          pass = true;
                          dispose();
                          OutletProfilePage CPP = new OutletProfilePage();
                          CPP.setVisible(true);
                          CPP.setLocationRelativeTo(null);
                      } else {
                          JOptionPane.showMessageDialog(LoginOutlet.this,
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
        
        for(int i = 0; i < Main.outlets.size(); i++)
        {
            if(Main.outlets.get(i).username.compareTo(username) == 0 
               && Main.outlets.get(i).password.compareTo(password) == 0)
            {
            	Main.currentOutletUser = Main.outlets.get(i);
            	Main.accessedOutlet = Main.currentOutletUser;
                return true;
            }
        }
        return false;
    }
    
}