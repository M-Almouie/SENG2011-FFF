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
import java.awt.SystemColor;
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
import javax.swing.SwingConstants;
import java.awt.Color;
//import javax.swing.border.EmptyBorder;
//import javax.swing.border.LineBorder;
public class EditOutletProfile extends JFrame implements Serializable{
	private static final long serialVersionUID = 1L;
	protected static JTextField tfOutletName;
	protected static JTextField tfStreetNum;
	protected static JTextField tfStreetName;
	protected static JTextField tfPostcode;
	protected static JTextField tfSuburb;
	protected static JTextField tfDescription;
	protected static JTextField tfScenrey;
    protected static JTextField tfCuisine;
    protected static JTextField avgPriceTF;
	private JLabel lbOutletName;
	private JLabel lbStreetNum;
	private JLabel lbStreetName;
	private JLabel lbPostcode;
	private JLabel lbSuburb;
	private JLabel lbDescription;
	private JLabel lbScenrey;
    private JLabel lbCuisine;
    private JLabel lblAvergePriceOf;
	private JButton btnCreate;
    private JButton btnReset;
    private JLabel lblChangeOutletProfile;
    private JLabel c6;
    private JButton btnNewButton;
	
	public EditOutletProfile(Frame parent) {
		super("Profile Creation");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 47};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
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
        
               lblChangeOutletProfile = new JLabel("Change Outlet Profile");
               GridBagConstraints gbc_lblChangeOutletProfile = new GridBagConstraints();
               gbc_lblChangeOutletProfile.gridwidth = 3;
               gbc_lblChangeOutletProfile.insets = new Insets(0, 0, 5, 5);
               gbc_lblChangeOutletProfile.gridx = 1;
               gbc_lblChangeOutletProfile.gridy = 0;
               panel.add(lblChangeOutletProfile, gbc_lblChangeOutletProfile);
               lblChangeOutletProfile.setFont(new Font("Tahoma", Font.BOLD, 20));
               lblChangeOutletProfile.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		gbc_tfOutletName.insets = new Insets(0, 0, 5, 0);
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
		gbc_tfStreetNum.insets = new Insets(0, 0, 5, 0);
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
		gbc_tfStreetName.insets = new Insets(0, 0, 5, 0);
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
        gbc_tfSuburb.insets = new Insets(0, 0, 5, 0);
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
		gbc_tfPostcode.insets = new Insets(0, 0, 5, 0);
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
		gbc_tfCuisine.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCuisine.gridwidth = 4;
		gbc_tfCuisine.insets = new Insets(0, 0, 5, 0);
		gbc_tfCuisine.gridx = 2;
		gbc_tfCuisine.gridy = 7;
		panel.add(tfCuisine, gbc_tfCuisine);
		
		lbDescription = new JLabel("Description : ");
		GridBagConstraints gbc_lbCusinePref= new GridBagConstraints();
		gbc_lbCusinePref.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lbCusinePref.insets = new Insets(0, 0, 5, 5);
		gbc_lbCusinePref.gridx = 1;
		gbc_lbCusinePref.gridy = 8;
		panel.add(lbDescription, gbc_lbCusinePref);
		
		JPanel bp = new JPanel();
		 
        getContentPane().add(panel, BorderLayout.NORTH);
        
        tfDescription = new JTextField(20);
        tfDescription.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_tfDescription= new GridBagConstraints();
        gbc_tfDescription.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfDescription.gridwidth = 4;
        gbc_tfDescription.insets = new Insets(0, 0, 5, 0);
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
        gbc_tfScenrey.fill = GridBagConstraints.HORIZONTAL;
        gbc_tfScenrey.gridwidth = 4;
        gbc_tfScenrey.insets = new Insets(0, 0, 5, 0);
        gbc_tfScenrey.gridx = 2;
        gbc_tfScenrey.gridy = 9;
        panel.add(tfScenrey, gbc_tfScenrey);
        lblAvergePriceOf = new JLabel("Average Price Of Meals : ");
        GridBagConstraints gbc_lblAvergePriceOf = new GridBagConstraints();
        gbc_lblAvergePriceOf.anchor = GridBagConstraints.WEST;
        gbc_lblAvergePriceOf.insets = new Insets(0, 0, 5, 5);
        gbc_lblAvergePriceOf.gridx = 1;
        gbc_lblAvergePriceOf.gridy = 10;
        panel.add(lblAvergePriceOf, gbc_lblAvergePriceOf);
        avgPriceTF = new JTextField(20);
        avgPriceTF.setBackground(SystemColor.inactiveCaption);
        GridBagConstraints gbc_avgPriceTF = new GridBagConstraints();
        gbc_avgPriceTF.gridwidth = 4;
        gbc_avgPriceTF.insets = new Insets(0, 0, 5, 0);
        gbc_avgPriceTF.fill = GridBagConstraints.HORIZONTAL;
        gbc_avgPriceTF.gridx = 2;
        gbc_avgPriceTF.gridy = 10;
        panel.add(avgPriceTF, gbc_avgPriceTF);
        
        c6 = new JLabel();
		c6.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("6.jpg"); 
		
		btnReset = new JButton("Reset Info");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.WEST;
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 0;
		gbc_btnCancel.gridy = 11;
		panel.add(btnReset, gbc_btnCancel);
		btnReset.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	resetParameters();
		    }
		});
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Options op = new Options();
				op.setVisible(true);
				op.setLocationRelativeTo(null);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 11;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		btnCreate = new JButton("Edit");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.gridwidth = 2;
		gbc_btnCreate.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreate.gridx = 4;
		gbc_btnCreate.gridy = 11;
		panel.add(btnCreate, gbc_btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkStreetNumFormat() == true && checkPostcodeFormat() == true && validInput() == true){
					DBMain db = new DBMain();
					JOptionPane.showMessageDialog(EditOutletProfile.this,
					"Hey there " + getTFOutletName() + "! You have successfully edited your FFF Profile Page!",
					"Edit Outlet",JOptionPane.INFORMATION_MESSAGE);
					String un = Main.currentOutletUser.username;
					String pw = Main.currentOutletUser.password;
					ArrayList<Review> reviews = Main.currentOutletUser.reviews;
		            String sb = "Change,Outlets,Outlets";
		            OutletAccount currOutlet = null;
		            for(int j = 0; j < Main.outlets.size(); j++)
		            {
		                if(Main.outlets.get(j).username.compareTo(Main.currentOutletUser.username) == 0
		                        && Main.outlets.get(j).password.compareTo(Main.currentOutletUser.password) == 0)
		                {
		                    currOutlet = Main.outlets.get(j);
		                    break;
		                }
		            }
		            boolean fieldsEmpty = true;
		            if(!(getTFOutletName().equals(""))){ sb += ",name,'" + getTFOutletName() + "'"; currOutlet.setName(getTFOutletName()); fieldsEmpty = false;}
		            if(!(getTFStreetNum() == -1)) { sb += ",streetNum," + Integer.toString(getTFStreetNum());  currOutlet.setStreetNum(getTFStreetNum()); fieldsEmpty = false;}
		            if(!(getTFStreetName().equals(""))) { sb += ",street,'" + getTFStreetName() + "'";  currOutlet.setStreet(getTFStreetName()); fieldsEmpty = false;}
		            if(!(getTFSuburb().equals(""))) { sb += ",suburb,'" + getTFSuburb() + "'";  currOutlet.setSuburb(getTFSuburb()); fieldsEmpty = false;}
		            if(!(getTFPostcode() == -1)) { sb += ",postcode," + Integer.toString(getTFPostcode());  currOutlet.setPostcode(getTFPostcode()); fieldsEmpty = false;}
		            if(!(getTFDescription().equals(""))) { sb += ",description,'" + getTFDescription() + "'";  currOutlet.setDescrip(getTFDescription()); fieldsEmpty = false;}
		            if(!(getTFScenrey().equals(""))) { sb += ",scenery,'" + getTFScenrey() + "'";  currOutlet.setScenrey(getTFScenrey()); fieldsEmpty = false;}
		            if(!(getAvgPriceTF() == -1)) { sb += ",averagePrice," + Float.toString(getAvgPriceTF());  currOutlet.setAp(getAvgPriceTF()); fieldsEmpty = false;}
		            if(!(getTfCuisine().equals(""))) {
		                db.dbControl("Change,Outlets,Tags,tag,'" + getTfCuisine() + "',;,outletId," + Integer.toString(currOutlet.getID()));
		            }
		            sb += ",;,id," + Integer.toString(currOutlet.getID());
		            if(fieldsEmpty == false){
		                db.dbControl(sb);
		            }
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
					 JOptionPane.showMessageDialog(EditOutletProfile.this,
		                     "Invalid postcode or Street Number inputs, please enter numbers for these categories",
		                     "Create Profile Page",
		                     JOptionPane.ERROR_MESSAGE);
					 resetParameters();
				}
			}
		});
		c6.setIcon(icon);
        GridBagConstraints gbc_c6 = new GridBagConstraints();
        gbc_c6.gridheight = 2;
        gbc_c6.gridwidth = 3;
        gbc_c6.insets = new Insets(0, 0, 0, 5);
        gbc_c6.fill = GridBagConstraints.BOTH;
        gbc_c6.gridx = 1;
        gbc_c6.gridy = 12;
        panel.add(c6, gbc_c6);
   
        getContentPane().add(bp, BorderLayout.EAST);
 
        setSize(500, 420);
        setLocationRelativeTo(null);
        setResizable(false);
    }
		
//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    public float getAvgPriceTF() {
        if(avgPriceTF.getText().trim().equals("")) { return -1; }
        return Float.parseFloat(avgPriceTF.getText().trim());
    }
    public String getTfCuisine() {
        return tfCuisine.getText().trim();
    }
    public String getTFOutletName()
	{
		//System.out.println("First name is: " + tfFirstName.getText().trim());
		return tfOutletName.getText().trim();
	}
	
	public int getTFStreetNum()
	{
		//System.out.println("Last name is: " + tfSurname.getText().trim());
        if(tfStreetNum.getText().trim().equals("")) { return -1; }
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
	    if(tfPostcode.getText().equals("")) { return -1; }
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
	
	public boolean validInput()
	{
		if(tfOutletName.getText().trim().isEmpty() == true && tfStreetNum.getText().trim().isEmpty() == true
				&& tfSuburb.getText().trim().isEmpty() == true && tfPostcode.getText().trim().isEmpty() == true
				&& tfDescription.getText().trim().isEmpty() == true && tfStreetName.getText().trim().isEmpty() == true
				&& tfScenrey.getText().trim().isEmpty() == true && avgPriceTF.getText().trim().isEmpty() && tfCuisine.getText().trim().isEmpty())
		{
			return false;
		}
		return true;
	}
}