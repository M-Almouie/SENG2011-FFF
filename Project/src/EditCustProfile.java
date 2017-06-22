/**
 * Author : Daniel Almouiee
 * Class to create a Customer Profile page
 * DONE
 */
import java.awt.BorderLayout;
import java.awt.Font;
//import java.awt.Color;
//import java.awt.EventQueue;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
public class EditCustProfile extends JFrame implements Serializable{
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
    private JLabel lblChangePersonalProfile;
    private JLabel c5;
    private JButton btnBack;
    
	public EditCustProfile(Frame parent) {
		super("Edit Profile");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 36};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		JPanel panel = new JPanel(gbl_panel);
		panel.setBackground(Color.WHITE);
	    GridBagConstraints cs = new GridBagConstraints();
	    //setBounds(400, 400, 465, 263);
	    
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
        
               lblChangePersonalProfile = new JLabel("Change Personal Profile");
               GridBagConstraints gbc_lblChangePersonalProfile = new GridBagConstraints();
               gbc_lblChangePersonalProfile.gridwidth = 3;
               gbc_lblChangePersonalProfile.insets = new Insets(0, 0, 5, 5);
               gbc_lblChangePersonalProfile.gridx = 2;
               gbc_lblChangePersonalProfile.gridy = 0;
               panel.add(lblChangePersonalProfile, gbc_lblChangePersonalProfile);
               lblChangePersonalProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
               lblChangePersonalProfile.setHorizontalAlignment(SwingConstants.CENTER);
		
        lbFirstName = new JLabel("First Name: ");
        GridBagConstraints gbc_lbFirstName = new GridBagConstraints();
        gbc_lbFirstName.anchor = GridBagConstraints.WEST;
        gbc_lbFirstName.insets = new Insets(0, 0, 5, 5);
        gbc_lbFirstName.gridx = 1;
        gbc_lbFirstName.gridy = 2;
        panel.add(lbFirstName, gbc_lbFirstName);
		
		tfFirstName = new JTextField(20);
		tfFirstName.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfFirstName = new GridBagConstraints();
		gbc_tfFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFirstName.gridwidth = 5;
		gbc_tfFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_tfFirstName.gridx = 3;
		gbc_tfFirstName.gridy = 2;
		panel.add(tfFirstName, gbc_tfFirstName);
		
		lbSurname = new JLabel("Surname: ");
		GridBagConstraints gbc_lbSurname = new GridBagConstraints();
		gbc_lbSurname.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lbSurname.gridx = 1;
		gbc_lbSurname.gridy = 3;
		panel.add(lbSurname, gbc_lbSurname);
		
		tfSurname = new JTextField(20);
		tfSurname.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfSurname= new GridBagConstraints();
		gbc_tfSurname.gridwidth = 5;
		gbc_tfSurname.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSurname.insets = new Insets(0, 0, 5, 0);
		gbc_tfSurname.gridx = 3;
		gbc_tfSurname.gridy = 3;
		panel.add(tfSurname, gbc_tfSurname);
		
		lbDOB = new JLabel("Age: ");
		GridBagConstraints gbc_lbDOB= new GridBagConstraints();
		gbc_lbDOB.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbDOB.insets = new Insets(0, 0, 5, 5);
		gbc_lbDOB.gridx = 1;
		gbc_lbDOB.gridy = 4;
		panel.add(lbDOB, gbc_lbDOB);
		
		tfAge = new JTextField(20);
		tfAge.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfAge= new GridBagConstraints();
		gbc_tfAge.gridwidth = 5;
		gbc_tfAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAge.insets = new Insets(0, 0, 5, 0);
		gbc_tfAge.gridx = 3;
		gbc_tfAge.gridy = 4;
		panel.add(tfAge, gbc_tfAge);
		
		lbPostcode = new JLabel("Postcode: ");
		GridBagConstraints gbc_lbPostcode= new GridBagConstraints();
		gbc_lbPostcode.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lbPostcode.gridx = 1;
		gbc_lbPostcode.gridy = 5;
		panel.add(lbPostcode, gbc_lbPostcode);
		
		tfPostcode = new JTextField(20);
		tfPostcode.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfPostcode= new GridBagConstraints();
		gbc_tfPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPostcode.gridwidth = 5;
		gbc_tfPostcode.insets = new Insets(0, 0, 5, 0);
		gbc_tfPostcode.gridx = 3;
		gbc_tfPostcode.gridy = 5;
		panel.add(tfPostcode, gbc_tfPostcode);
		
		lbSuburb = new JLabel("Suburb: ");
		GridBagConstraints gbc_lbSuburb= new GridBagConstraints();
		gbc_lbSuburb.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lbSuburb.gridx = 1;
		gbc_lbSuburb.gridy = 6;
		panel.add(lbSuburb, gbc_lbSuburb);
		
		JPanel bp = new JPanel();
		 
        getContentPane().add(panel, BorderLayout.NORTH);
        
        tfSuburb = new JTextField(20);
        tfSuburb.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_tfSuburb= new GridBagConstraints();
        gbc_tfSuburb.gridwidth = 5;
        gbc_tfSuburb.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfSuburb.insets = new Insets(0, 0, 5, 0);
        gbc_tfSuburb.gridx = 3;
        gbc_tfSuburb.gridy = 6;
        panel.add(tfSuburb, gbc_tfSuburb);
        
        lbCusinePref = new JLabel("Cuisine Preference: ");
        GridBagConstraints gbc_lbCusinePref= new GridBagConstraints();
        gbc_lbCusinePref.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lbCusinePref.insets = new Insets(0, 0, 5, 5);
        gbc_lbCusinePref.gridx = 1;
        gbc_lbCusinePref.gridy = 7;
        panel.add(lbCusinePref, gbc_lbCusinePref);
        
        tfCusinePref = new JTextField(20);
        tfCusinePref.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_tfCusinePref= new GridBagConstraints();
        gbc_tfCusinePref.gridwidth = 5;
        gbc_tfCusinePref.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfCusinePref.insets = new Insets(0, 0, 5, 0);
        gbc_tfCusinePref.gridx = 3;
        gbc_tfCusinePref.gridy = 7;
        panel.add(tfCusinePref, gbc_tfCusinePref);
        
        lbStatus = new JLabel("Status: ");
        GridBagConstraints gbc_lbStatus= new GridBagConstraints();
        gbc_lbStatus.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lbStatus.insets = new Insets(0, 0, 5, 5);
        gbc_lbStatus.gridx = 1;
        gbc_lbStatus.gridy = 8;
        //panel.add(lbStatus, gbc_lbStatus);
        
        tfStatus = new JTextField(20);
        tfStatus.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_tfStatus= new GridBagConstraints();
        gbc_tfStatus.gridwidth = 5;
        gbc_tfStatus.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfStatus.insets = new Insets(0, 0, 5, 0);
        gbc_tfStatus.gridx = 3;
        gbc_tfStatus.gridy = 8;
        //panel.add(tfStatus, gbc_tfStatus);
        
        c5 = new JLabel();
		c5.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("5.jpg"); 
		c5.setIcon(icon);
        GridBagConstraints gbc_c5 = new GridBagConstraints();
        gbc_c5.gridheight = 5;
        gbc_c5.insets = new Insets(0, 0, 0, 5);
        gbc_c5.fill = GridBagConstraints.BOTH;
        gbc_c5.gridx = 2;
        gbc_c5.gridy = 9;
        panel.add(c5, gbc_c5);
        
        btnReset = new JButton("Reset Info");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCancel.gridwidth = 2;
        gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
        gbc_btnCancel.gridx = 0;
        gbc_btnCancel.gridy = 13;
        panel.add(btnReset, gbc_btnCancel);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	resetParameters();
            }
        });
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		dispose();
        		Options Op = new Options();
        		Op.setVisible(true);
        		Op.setLocationRelativeTo(null);
        	}
        });
        GridBagConstraints gbc_btnBack = new GridBagConstraints();
        gbc_btnBack.insets = new Insets(0, 0, 0, 5);
        gbc_btnBack.gridx = 4;
        gbc_btnBack.gridy = 13;
        panel.add(btnBack, gbc_btnBack);
        
        btnCreate = new JButton("Edit");
        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
        gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
        gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnCreate.gridx = 6;
        gbc_btnCreate.gridy = 13;
        panel.add(btnCreate, gbc_btnCreate);
        btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkAgeFormat() == true && checkPostcodeFormat() == true && validInput() == true){
        			JOptionPane.showMessageDialog(EditCustProfile.this,
        			"Profile Successfully Edited!",
        			"Edit Profile",JOptionPane.INFORMATION_MESSAGE);
        			String un = Main.currentUser.username;
        			String pw = Main.currentUser.password;
        			int id = Main.currentUser.XID;
        			ArrayList<Review> reviews = Main.currentUser.reviews;


					if(!(getTFAge() == -1)){ Main.currentUser.setAge(getTFAge());}
					if(!(getTFSuburb().equals(""))) { Main.currentUser.setSuburb(getTFSuburb());}
					if(!(getTFCusinePref().equals(""))) { Main.currentUser.setCusinePreference(getTFCusinePref());}
					if(!(getTFFirstName().equals(""))) { Main.currentUser.setFirstname(getTFFirstName());}
					if(!(getTFPostcode() == -1)) { Main.currentUser.setPostcode(getTFPostcode());}
					if(!(getTFSurname().equals(""))) { Main.currentUser.setSurname(getTFSurname());}
					if(!(getTFStatus().equals(""))) { Main.currentUser.setStatus(getTFStatus());}
        			
        			//Main.currentUser = c1;
        			//Main.customers.add(c1);
        			try {
        			    FileOutputStream fos = new FileOutputStream("CustomerUser.ser");
        			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
        			    oos.writeObject(Main.customers); // write MenuArray to ObjectOutputStream
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
        			 JOptionPane.showMessageDialog(EditCustProfile.this,
                             "Invalid postcode or age inputs, please enter numbers for these categories",
                             "Edit Profile",
                             JOptionPane.ERROR_MESSAGE);
        			 resetParameters();
        		}
        	}
        });
   
        getContentPane().add(bp, BorderLayout.EAST);
 
        //pack();
        setSize(500, 420);
        setLocationRelativeTo(null);
        setResizable(false);
    }
		
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
        if(tfAge.getText().trim().equals("")) { return -1; }
        return Integer.parseInt(tfAge.getText().trim());
	}
	
	public int getTFPostcode()
	{
        if(tfPostcode.getText().trim().equals("")) { return -1; }
		return Integer.parseInt(tfPostcode.getText().trim());
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
	
	public boolean validInput()
	{
		if(tfFirstName.getText().trim().isEmpty() == true && tfSurname.getText().trim().isEmpty() == true
				&& tfPostcode.getText().trim().isEmpty() == true && tfSuburb.getText().trim().isEmpty() == true
				&& tfCusinePref.getText().trim().isEmpty() == true && tfAge.getText().trim().isEmpty() == true
				&& tfStatus.getText().trim().isEmpty() == true)
		{
			return false;
		}
		return true;
	}
}