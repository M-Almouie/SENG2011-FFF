/**
 * Author : Daniel Almouiee
 * Class to create a Customer Profile page
 * DONE
 */
//import com.sun.org.apache.bcel.internal.generic.FLOAD;
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
//import java.io.File;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
public class OutletProfileCreate extends JFrame implements Serializable{
	private static final long serialVersionUID = 1L;
	protected static JTextField tfOutletName;
	protected static JTextField tfStreetNum;
	protected static JTextField tfStreetName;
	protected static JTextField tfPostcode;
	protected static JTextField tfSuburb;
	protected static JTextField tfDescription;
	protected static JTextField tfScenrey;
    protected static JTextField tfCuisine;
	private JLabel lbOutletName;
	private JLabel lbStreetNum;
	private JLabel lbStreetName;
	private JLabel lbPostcode;
	private JLabel lbSuburb;
	private JLabel lbDescription;
	private JLabel lbScenrey;
    private JLabel lbCuisine;
	private JButton btnCreate;
    private JButton btnReset;
    private JLabel lblAvergePriceOf;
    private JTextField avgPriceTF;
    private JLabel lblCreateProfile;
    private JLabel c7;
	
	public OutletProfileCreate(Frame parent) {
		super("Profile Creation");
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 39};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0};
		JPanel panel = new JPanel(gbl_panel);
		panel.setBackground(Color.WHITE);
	    GridBagConstraints cs = new GridBagConstraints();
	    //setBounds(400, 400, 343, 321);
	    
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
        
        lblCreateProfile = new JLabel("Create Profile");
        lblCreateProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
        GridBagConstraints gbc_lblCreateProfile = new GridBagConstraints();
        gbc_lblCreateProfile.gridwidth = 3;
        gbc_lblCreateProfile.insets = new Insets(0, 0, 5, 5);
        gbc_lblCreateProfile.gridx = 2;
        gbc_lblCreateProfile.gridy = 0;
        panel.add(lblCreateProfile, gbc_lblCreateProfile);
		
        lbOutletName = new JLabel("Outlet Name: ");
        GridBagConstraints gbc_lbOutletName = new GridBagConstraints();
        gbc_lbOutletName.anchor = GridBagConstraints.WEST;
        gbc_lbOutletName.insets = new Insets(0, 0, 5, 5);
        gbc_lbOutletName.gridx = 1;
        gbc_lbOutletName.gridy = 2;
        panel.add(lbOutletName, gbc_lbOutletName);
		
		tfOutletName = new JTextField(20);
		tfOutletName.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfOutletName = new GridBagConstraints();
		gbc_tfOutletName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfOutletName.gridwidth = 4;
		gbc_tfOutletName.insets = new Insets(0, 0, 5, 5);
		gbc_tfOutletName.gridx = 2;
		gbc_tfOutletName.gridy = 2;
		panel.add(tfOutletName, gbc_tfOutletName);
		
		lbStreetNum = new JLabel("Street Number: ");
		GridBagConstraints gbc_lbStreetNum = new GridBagConstraints();
		gbc_lbStreetNum.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbStreetNum.insets = new Insets(0, 0, 5, 5);
		gbc_lbStreetNum.gridx = 1;
		gbc_lbStreetNum.gridy = 3;
		panel.add(lbStreetNum, gbc_lbStreetNum);
		
		tfStreetNum = new JTextField(20);
		tfStreetNum.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfStreetNum= new GridBagConstraints();
		gbc_tfStreetNum.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStreetNum.gridwidth = 4;
		gbc_tfStreetNum.insets = new Insets(0, 0, 5, 5);
		gbc_tfStreetNum.gridx = 2;
		gbc_tfStreetNum.gridy = 3;
		panel.add(tfStreetNum, gbc_tfStreetNum);
		
		lbStreetName = new JLabel("Street Name: ");
		GridBagConstraints gbc_lbStreetName= new GridBagConstraints();
		gbc_lbStreetName.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbStreetName.insets = new Insets(0, 0, 5, 5);
		gbc_lbStreetName.gridx = 1;
		gbc_lbStreetName.gridy = 4;
		panel.add(lbStreetName, gbc_lbStreetName);
		
		tfStreetName = new JTextField(20);
		tfStreetName.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfStreetName= new GridBagConstraints();
		gbc_tfStreetName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStreetName.gridwidth = 4;
		gbc_tfStreetName.insets = new Insets(0, 0, 5, 5);
		gbc_tfStreetName.gridx = 2;
		gbc_tfStreetName.gridy = 4;
		panel.add(tfStreetName, gbc_tfStreetName);
		
		lbSuburb = new JLabel("Suburb: ");
		GridBagConstraints gbc_lbSuburb= new GridBagConstraints();
		gbc_lbSuburb.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lbSuburb.gridx = 1;
		gbc_lbSuburb.gridy = 5;
		panel.add(lbSuburb, gbc_lbSuburb);
		
		tfSuburb = new JTextField(20);
		tfSuburb.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfSuburb= new GridBagConstraints();
		gbc_tfSuburb.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSuburb.gridwidth = 4;
		gbc_tfSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_tfSuburb.gridx = 2;
		gbc_tfSuburb.gridy = 5;
		panel.add(tfSuburb, gbc_tfSuburb);
		
		lbPostcode = new JLabel("Postcode : ");
		GridBagConstraints gbc_lbPostcode= new GridBagConstraints();
		gbc_lbPostcode.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_lbPostcode.gridx = 1;
		gbc_lbPostcode.gridy = 6;
		panel.add(lbPostcode, gbc_lbPostcode);
		
		tfPostcode = new JTextField(20);
		tfPostcode.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfPostcode= new GridBagConstraints();
		gbc_tfPostcode.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPostcode.gridwidth = 4;
		gbc_tfPostcode.insets = new Insets(0, 0, 5, 5);
		gbc_tfPostcode.gridx = 2;
		gbc_tfPostcode.gridy = 6;
		panel.add(tfPostcode, gbc_tfPostcode);
        lbCuisine = new JLabel("Cuisine : ");
        GridBagConstraints gbc_lbCuisinePref= new GridBagConstraints();
        gbc_lbCuisinePref.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lbCuisinePref.insets = new Insets(0, 0, 5, 5);
        gbc_lbCuisinePref.gridx = 1;
        gbc_lbCuisinePref.gridy = 7;
        panel.add(lbCuisine, gbc_lbCuisinePref);
        tfCuisine = new JTextField(20);
        tfCuisine.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_tfCuisine= new GridBagConstraints();
        gbc_tfCuisine.gridwidth = 4;
        gbc_tfCuisine.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfCuisine.insets = new Insets(0, 0, 5, 5);
        gbc_tfCuisine.gridx = 2;
        gbc_tfCuisine.gridy = 7;
        panel.add(tfCuisine, gbc_tfCuisine);
		
		lbDescription = new JLabel("Description : ");
		GridBagConstraints gbc_lbDescriptionPref= new GridBagConstraints();
        gbc_lbDescriptionPref.anchor = GridBagConstraints.SOUTHWEST;
        gbc_lbDescriptionPref.insets = new Insets(0, 0, 5, 5);
        gbc_lbDescriptionPref.gridx = 1;
        gbc_lbDescriptionPref.gridy = 8;
		panel.add(lbDescription, gbc_lbDescriptionPref);
		
		tfDescription = new JTextField(20);
		tfDescription.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfDescription= new GridBagConstraints();
		gbc_tfDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDescription.gridwidth = 4;
		gbc_tfDescription.insets = new Insets(0, 0, 5, 5);
		gbc_tfDescription.gridx = 2;
		gbc_tfDescription.gridy = 8;
		panel.add(tfDescription, gbc_tfDescription);
		
		lbScenrey = new JLabel("Scenery : ");
		GridBagConstraints gbc_lbScenrey= new GridBagConstraints();
		gbc_lbScenrey.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbScenrey.insets = new Insets(0, 0, 5, 5);
		gbc_lbScenrey.gridx = 1;
		gbc_lbScenrey.gridy = 9;
		panel.add(lbScenrey, gbc_lbScenrey);
		
		tfScenrey = new JTextField(20);
		tfScenrey.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_tfScenrey= new GridBagConstraints();
		gbc_tfScenrey.gridwidth = 4;
		gbc_tfScenrey.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfScenrey.insets = new Insets(0, 0, 5, 5);
		gbc_tfScenrey.gridx = 2;
		gbc_tfScenrey.gridy = 9;
		panel.add(tfScenrey, gbc_tfScenrey);
		 
        getContentPane().add(panel, BorderLayout.CENTER);
        
        lblAvergePriceOf = new JLabel("Average Price Of Meals : ");
        GridBagConstraints gbc_lblAvergePriceOf = new GridBagConstraints();
        gbc_lblAvergePriceOf.insets = new Insets(0, 0, 5, 5);
        gbc_lblAvergePriceOf.gridx = 1;
        gbc_lblAvergePriceOf.gridy = 10;
        panel.add(lblAvergePriceOf, gbc_lblAvergePriceOf);
        
        avgPriceTF = new JTextField(20);
        avgPriceTF.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_avgPriceTF = new GridBagConstraints();
        gbc_avgPriceTF.gridwidth = 4;
        gbc_avgPriceTF.insets = new Insets(0, 0, 5, 5);
        gbc_avgPriceTF.fill = GridBagConstraints.HORIZONTAL;
        gbc_avgPriceTF.gridx = 2;
        gbc_avgPriceTF.gridy = 10;
        panel.add(avgPriceTF, gbc_avgPriceTF);
        
        c7 = new JLabel();
		c7.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("7.jpg"); 
		c7.setIcon(icon);
        GridBagConstraints gbc_c7 = new GridBagConstraints();
        gbc_c7.gridwidth = 4;
        gbc_c7.gridheight = 2;
        gbc_c7.insets = new Insets(0, 0, 5, 5);
        gbc_c7.fill = GridBagConstraints.BOTH;
        gbc_c7.gridx = 2;
        gbc_c7.gridy = 11;
        panel.add(c7, gbc_c7);
        
        btnReset = new JButton("Reset Info");
        GridBagConstraints gbc_btnReset = new GridBagConstraints();
        gbc_btnReset.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnReset.gridwidth = 2;
        gbc_btnReset.insets = new Insets(0, 0, 0, 5);
        gbc_btnReset.gridx = 0;
        gbc_btnReset.gridy = 12;
        panel.add(btnReset, gbc_btnReset);
        
        btnCreate = new JButton("Create");
        GridBagConstraints gbc_btnCreate = new GridBagConstraints();
        gbc_btnCreate.anchor = GridBagConstraints.WEST;
        gbc_btnCreate.gridx = 6;
        gbc_btnCreate.gridy = 12;
        panel.add(btnCreate, gbc_btnCreate);
        btnCreate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkStreetNumFormat() == true && checkPostcodeFormat() == true && validInput() == true){
        			DBMain db = new DBMain();
        			JOptionPane.showMessageDialog(OutletProfileCreate.this,
        			"Hey there " + getTFOutletName() + "! You have successfully created a FFF Profile Page!",
        			"Login",JOptionPane.INFORMATION_MESSAGE);
        			int num = getRandomNumberInRange(10000, 1000000);
                    while(inNum(num)){
                        num = getRandomNumberInRange(10000, 1000000);
                    }
                    String sb = "Add,Outlets,Outlets,id," + Integer.toString(num) + ",name,'" + getTFOutletName() + "',streetNum,"
                            + Integer.toString(getTFStreetNum()) + ",street,'" + getTFStreetName() + "',suburb,'" + getTFSuburb()
                            + "',postcode," + Integer.toString(getTFPostcode()) + ",description,'" + getTFDescription() + "',scenery,'" + getTFScenrey() + "',averagePrice,"
                            + Float.toString(getAvgPriceTF()) + ",averageRating,0";
                    db.dbControl(sb);
                    db.dbControl("Add,Outlets,Tags,outletId," + Integer.toString(num) + ",tag,'" + getTFCuisine() + "'");
        			String un = Main.currentOutletUser.username;
        			String pw = Main.currentOutletUser.password;
        			OutletAccount u1 = new OutletAccount(pw, un,num++, getTFOutletName(),getTFStreetNum(), getTFStreetName(),
        					getTFSuburb(), getTFPostcode(), 0f,getTFDescription(),getTFScenrey(), getAvgPriceTF(), new ArrayList<Review>());
        			Main.currentOutletUser = u1;
        			Main.accessedOutlet = u1;
        			Main.outlets.add(u1);
        			try {
        			    FileOutputStream fos = new FileOutputStream("OutletUser.ser");
        			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
        			    oos.writeObject(Main.outlets);
        			    oos.close(); 
        			} catch(Exception ex) {
        			    ex.printStackTrace();
        			}
        			dispose();
        			OutletProfilePage CPP = new OutletProfilePage();
        			CPP.setVisible(true);
        			CPP.setLocationRelativeTo(null);
        		}
        		else{
        			 JOptionPane.showMessageDialog(OutletProfileCreate.this,
                             "Invalid postcode or Street Number inputs, please enter numbers for these categories",
                             "Create Profile Page",
                             JOptionPane.ERROR_MESSAGE);
        			 resetParameters();
        		}
        	}
        });
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	resetParameters();
            }
        });
 
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }
		
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    public String getTFCuisine() {
        return tfCuisine.getText().trim();
    }
    public float getAvgPriceTF() {
        return Float.parseFloat(avgPriceTF.getText().trim());
    }
    public String getTFOutletName()
	{
		//System.out.println("First name is: " + tfFirstName.getText().trim());
		return tfOutletName.getText().trim();
	}
	
	public int getTFStreetNum()
	{
		//System.out.println("Last name is: " + tfSurname.getText().trim());
		return Integer.parseInt(tfStreetNum.getText().trim());
		
	}
	
	public static String getTFSuburb()
	{
		//System.out.println("Suburb is: " + tfSuburb.getText().trim());
		return tfSuburb.getText().trim();
	}
	
	public String getTFStreetName()
	{
		//System.out.println("Age is: " + Integer.parseInt(tfAge.getText().trim()));
		return tfStreetName.getText().trim();
	}
	
	public int getTFPostcode()
	{
		int i = Integer.parseInt(tfPostcode.getText().trim());
		return i;
	}
	public static String getTFDescription()
	{
		return tfDescription.getText().trim();
	}
	
	public static String getTFScenrey()
	{
		return tfScenrey.getText().trim();
	}
	
	public boolean checkStreetNumFormat()
	{
		String curr = tfStreetNum.getText().trim();
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
		tfOutletName.setText("");
    	tfStreetNum.setText("");
    	tfPostcode.setText("");
    	tfSuburb.setText("");
    	tfStreetName.setText("");
    	tfDescription.setText("");
    	tfScenrey.setText("");
		avgPriceTF.setText("");
		tfCuisine.setText("");
	}
	
	public static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public boolean inNum(int num){
	    for(OutletAccount oa : Main.outlets){
	        if(num == oa.getID()){
	            return true;
            }
        }
        return false;
    }
	
	public boolean validInput()
	{
		if(tfOutletName.getText().trim().isEmpty() == true || tfStreetNum.getText().trim().isEmpty() == true
				|| tfSuburb.getText().trim().isEmpty() == true || tfPostcode.getText().trim().isEmpty() == true
				|| tfDescription.getText().trim().isEmpty() == true || tfStreetName.getText().trim().isEmpty() == true
				|| tfScenrey.getText().trim().isEmpty() == true)
		{
			return false;
		}
		return true;
	}
}