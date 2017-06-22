/**
 * Author : Daniel Almouiee
 * Class to create a Customer Profile page
 * DONE
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class CustomerProfileCreatePage extends JFrame implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static JTextField tfFirstName;
	protected static JTextField tfSurname;
	protected static JTextField tfAge;
	protected static JTextField tfSuburb;
	protected static JTextField tfPostcode;
	protected static JTextField tfCusinePref;
	protected static JTextField tfStatus;
	private JLabel lbFirstName;
	private JLabel lbSurname;
	private JLabel lbDOB;
	private JLabel lbSuburb;
	private JLabel lbPostcode;
	private JLabel lbCusinePref;
	private JLabel lbStatus;
	private JButton btnCreate;
    private JButton btnReset;
    private JLabel lblProfileCreation;
    private JLabel c3;
	
	public CustomerProfileCreatePage(Frame parent) {
		super("Profile Creation");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		JPanel panel = new JPanel(gbl_panel);
		panel.setBackground(Color.WHITE);
	    GridBagConstraints cs = new GridBagConstraints();
	    setSize(500,400);
	   // setBounds(400, 400, 465, 263);
	    
        cs.fill = GridBagConstraints.HORIZONTAL;
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
		cs.gridx = 1;
		cs.gridy = 0;
		cs.gridwidth = 2;
        
               lblProfileCreation = new JLabel("Profile Creation");
               GridBagConstraints gbc_lblProfileCreation = new GridBagConstraints();
               gbc_lblProfileCreation.gridwidth = 4;
               gbc_lblProfileCreation.insets = new Insets(0, 0, 5, 5);
               gbc_lblProfileCreation.gridx = 2;
               gbc_lblProfileCreation.gridy = 0;
               panel.add(lblProfileCreation, gbc_lblProfileCreation);
               lblProfileCreation.setBackground(Color.WHITE);
               lblProfileCreation.setForeground(Color.BLACK);
               lblProfileCreation.setHorizontalAlignment(SwingConstants.CENTER);
               lblProfileCreation.setFont(new Font("Tahoma", Font.BOLD, 20));
		
        lbFirstName = new JLabel("First Name: ");
        GridBagConstraints gbc_lbFirstName = new GridBagConstraints();
        gbc_lbFirstName.anchor = GridBagConstraints.WEST;
        gbc_lbFirstName.insets = new Insets(0, 0, 5, 5);
        gbc_lbFirstName.gridx = 2;
        gbc_lbFirstName.gridy = 2;
        panel.add(lbFirstName, gbc_lbFirstName);
		
		tfFirstName = new JTextField(20);
		tfFirstName.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfFirstName = new GridBagConstraints();
		gbc_tfFirstName.gridwidth = 4;
		gbc_tfFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_tfFirstName.gridx = 3;
		gbc_tfFirstName.gridy = 2;
		panel.add(tfFirstName, gbc_tfFirstName);
		
		lbSurname = new JLabel("Surname: ");
		GridBagConstraints gbc_lbSurname = new GridBagConstraints();
		gbc_lbSurname.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lbSurname.gridx = 2;
		gbc_lbSurname.gridy = 3;
		panel.add(lbSurname, gbc_lbSurname);
		
		tfSurname = new JTextField(20);
		tfSurname.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfSurname= new GridBagConstraints();
		gbc_tfSurname.gridwidth = 4;
		gbc_tfSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSurname.insets = new Insets(0, 0, 5, 0);
		gbc_tfSurname.gridx = 3;
		gbc_tfSurname.gridy = 3;
		panel.add(tfSurname, gbc_tfSurname);
		
		lbDOB = new JLabel("Age: ");
		GridBagConstraints gbc_lbDOB= new GridBagConstraints();
		gbc_lbDOB.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbDOB.insets = new Insets(0, 0, 5, 5);
		gbc_lbDOB.gridx = 2;
		gbc_lbDOB.gridy = 4;
		panel.add(lbDOB, gbc_lbDOB);
		
		tfAge = new JTextField(20);
		tfAge.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfAge= new GridBagConstraints();
		gbc_tfAge.gridwidth = 4;
		gbc_tfAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAge.insets = new Insets(0, 0, 5, 0);
		gbc_tfAge.gridx = 3;
		gbc_tfAge.gridy = 4;
		panel.add(tfAge, gbc_tfAge);
		
		lbPostcode = new JLabel("Postcode: ");
		GridBagConstraints gbc_lbPostcode= new GridBagConstraints();
		gbc_lbPostcode.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lbPostcode.gridx = 2;
		gbc_lbPostcode.gridy = 5;
		panel.add(lbPostcode, gbc_lbPostcode);
		
		tfPostcode = new JTextField(20);
		tfPostcode.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfPostcode= new GridBagConstraints();
		gbc_tfPostcode.gridwidth = 4;
		gbc_tfPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_tfPostcode.gridx = 3;
		gbc_tfPostcode.gridy = 5;
		panel.add(tfPostcode, gbc_tfPostcode);
		
		lbSuburb = new JLabel("Suburb: ");
		GridBagConstraints gbc_lbSuburb= new GridBagConstraints();
		gbc_lbSuburb.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lbSuburb.gridx = 2;
		gbc_lbSuburb.gridy = 6;
		panel.add(lbSuburb, gbc_lbSuburb);
		
		tfSuburb = new JTextField(20);
		tfSuburb.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfSuburb= new GridBagConstraints();
		gbc_tfSuburb.gridwidth = 4;
		gbc_tfSuburb.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSuburb.insets = new Insets(0, 0, 5, 0);
		gbc_tfSuburb.gridx = 3;
		gbc_tfSuburb.gridy = 6;
		panel.add(tfSuburb, gbc_tfSuburb);
		
		lbCusinePref = new JLabel("Cusine Preference: ");
		GridBagConstraints gbc_lbCusinePref= new GridBagConstraints();
		gbc_lbCusinePref.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbCusinePref.insets = new Insets(0, 0, 5, 5);
		gbc_lbCusinePref.gridx = 2;
		gbc_lbCusinePref.gridy = 7;
		panel.add(lbCusinePref, gbc_lbCusinePref);
		
		
		tfCusinePref = new JTextField(20);
		tfCusinePref.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfCusinePref= new GridBagConstraints();
		gbc_tfCusinePref.gridwidth = 4;
		gbc_tfCusinePref.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCusinePref.insets = new Insets(0, 0, 5, 0);
		gbc_tfCusinePref.gridx = 3;
		gbc_tfCusinePref.gridy = 7;
		panel.add(tfCusinePref, gbc_tfCusinePref);
		
		lbStatus = new JLabel("Status: ");
		GridBagConstraints gbc_lbStatus= new GridBagConstraints();
		gbc_lbStatus.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lbStatus.gridx = 2;
		gbc_lbStatus.gridy = 8;

        getContentPane().add(panel, BorderLayout.CENTER);
        
		
		tfStatus = new JTextField(20);
		tfStatus.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfStatus= new GridBagConstraints();
		gbc_tfStatus.gridwidth = 4;
		gbc_tfStatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStatus.insets = new Insets(0, 0, 5, 0);
		gbc_tfStatus.gridx = 3;
		gbc_tfStatus.gridy = 8;
		panel.add(tfStatus, gbc_tfStatus);
        
		c3 = new JLabel();
		c3.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("3.jpg"); 
		c3.setIcon(icon);
        GridBagConstraints gbc_c3 = new GridBagConstraints();
        gbc_c3.gridheight = 2;
        gbc_c3.insets = new Insets(0, 0, 0, 5);
        gbc_c3.fill = GridBagConstraints.BOTH;
        gbc_c3.gridx = 3;
        gbc_c3.gridy = 9;
        panel.add(c3, gbc_c3);
        
        btnReset = new JButton("Reset Info");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.anchor = GridBagConstraints.WEST;
        gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
        gbc_btnCancel.gridx = 1;
        gbc_btnCancel.gridy = 10;
        panel.add(btnReset, gbc_btnCancel);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	resetParameters();
            }
        });
        
        btnCreate = new JButton("Create");
        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
        gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCreate.gridx = 7;
        gbc_btnCreate.gridy = 10;
        panel.add(btnCreate, gbc_btnCreate);
        btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkAgeFormat() == true && checkPostcodeFormat() == true && validInput() == true){
        			JOptionPane.showMessageDialog(CustomerProfileCreatePage.this,
        			"Hey there " + getTFFirstName() + "! You have successfully created a FFF Profile Page!",
        			"Login",JOptionPane.INFORMATION_MESSAGE);
        			int num = getRandomNumberInRange(10000, 1000000);
        			String un = Main.currentUser.username;
        			String pw = Main.currentUser.password;
        			Customer c1 = new Customer(un, pw,getTFSurname(), getTFFirstName(),getTFAge(), getTFSuburb(),
        					getTFPostcode(), num++, getTFCusinePref(), getTFStatus(), new ArrayList<Review>());
        			Main.currentUser = c1;
        			Main.customers.add(c1);
        			try {
        			    FileOutputStream fos = new FileOutputStream("CustomerUser.ser");
        			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
        			    oos.writeObject(Main.customers);
        			    oos.close(); 
        			} catch(Exception ex) {
        			    ex.printStackTrace();
        			}
        			dispose();
        			CustomerProfilePage CPP = new CustomerProfilePage();
        			CPP.setVisible(true);
        			CPP.setLocationRelativeTo(null);
        		}
        		else{
        			 JOptionPane.showMessageDialog(CustomerProfileCreatePage.this,
                             "Invalid postcode or age inputs, please enter numbers for these categories",
                             "Create Profile Page",
                             JOptionPane.ERROR_MESSAGE);
        			 resetParameters();
        		}
        	}
        });
 
       
        setResizable(true);
    }
		
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	public String getTFFirstName()
	{
		//System.out.println("First name is: " + tfFirstName.getText().trim());
		return tfFirstName.getText().trim();
	}
	
	public String getTFSurname()
	{
		//System.out.println("Last name is: " + tfSurname.getText().trim());
		return tfSurname.getText().trim();
	}
	
	public static String getTFSuburb()
	{
		//System.out.println("Suburb is: " + tfSuburb.getText().trim());
		return tfSuburb.getText().trim();
	}
	
	public int getTFAge()
	{
		//System.out.println("Age is: " + Integer.parseInt(tfAge.getText().trim()));
		return Integer.parseInt(tfAge.getText().trim());
	}
	
	public int getTFPostcode()
	{
		int i = Integer.parseInt(tfPostcode.getText().trim());
		return i;
	}
	
	public static String getTFCusinePref()
	{
		return tfCusinePref.getText().trim();
	}
	
	public static String getTFStatus()
	{
		return tfStatus.getText().trim();
	}
	
	public boolean checkAgeFormat()
	{
		String curr = tfAge.getText().trim();
		for (int ctr = 0; ctr < curr.length(); ctr++) {
            if ("1234567890".contains(Character.valueOf(curr.charAt(ctr)).toString())) {
                continue;
            } else {
                return false;
            }
        }
		return true;
	}
	
	public boolean checkPostcodeFormat()
	{
		String curr = tfPostcode.getText().trim();
		for (int ctr = 0; ctr < curr.length(); ctr++) {
            if ("1234567890".contains(Character.valueOf(curr.charAt(ctr)).toString())) {
                continue;
            } else {
                return false;
            }
        }
		return true;
	}
	
	public void resetParameters()
	{
		tfFirstName.setText("");
    	tfSurname.setText("");
    	tfSuburb.setText("");
    	tfPostcode.setText("");
    	tfAge.setText("");
    	tfCusinePref.setText("");
    	tfStatus.setText("");
	}
	
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public boolean validInput()
	{
		if(tfFirstName.getText().trim().isEmpty() == true || tfSurname.getText().trim().isEmpty() == true
				|| tfPostcode.getText().trim().isEmpty() == true || tfSuburb.getText().trim().isEmpty() == true
				|| tfCusinePref.getText().trim().isEmpty() == true || tfAge.getText().trim().isEmpty() == true
				|| tfStatus.getText().trim().isEmpty() == true)
		{
			return false;
		}
		return true;
	}
}