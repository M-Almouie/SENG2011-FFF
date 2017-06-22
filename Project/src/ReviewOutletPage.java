import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
public class ReviewOutletPage extends JDialog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField ratingTF;
	private JTextField desTF;
	/**
	 * Create the dialog.
	 */
	
	public ReviewOutletPage() {
		setBounds(100, 100, 450, 214);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel Title = new JLabel("Review Outlet");
			GridBagConstraints gbc_Title = new GridBagConstraints();
			gbc_Title.anchor = GridBagConstraints.EAST;
			gbc_Title.insets = new Insets(0, 0, 5, 5);
			gbc_Title.gridx = 1;
			gbc_Title.gridy = 1;
			contentPanel.add(Title, gbc_Title);
		}
		{
			JLabel lblRateYourExperience = new JLabel("Rate your experience (out of 5) :");
			GridBagConstraints gbc_lblRateYourExperience = new GridBagConstraints();
			gbc_lblRateYourExperience.anchor = GridBagConstraints.WEST;
			gbc_lblRateYourExperience.insets = new Insets(0, 0, 5, 5);
			gbc_lblRateYourExperience.gridx = 1;
			gbc_lblRateYourExperience.gridy = 3;
			contentPanel.add(lblRateYourExperience, gbc_lblRateYourExperience);
		}
		{
			ratingTF = new JTextField(20);
			GridBagConstraints gbc_ratingTF = new GridBagConstraints();
			gbc_ratingTF.gridwidth = 2;
			gbc_ratingTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_ratingTF.insets = new Insets(0, 0, 5, 0);
			gbc_ratingTF.gridx = 4;
			gbc_ratingTF.gridy = 3;
			contentPanel.add(ratingTF, gbc_ratingTF);
		}
		{
			JLabel lblNewLabel = new JLabel("Descibe your experience (Max 10 words):");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.gridx = 1;
			gbc_lblNewLabel.gridy = 5;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			desTF = new JTextField(20);
			GridBagConstraints gbc_desTF = new GridBagConstraints();
			gbc_desTF.gridwidth = 2;
			gbc_desTF.insets = new Insets(0, 0, 5, 0);
			gbc_desTF.fill = GridBagConstraints.HORIZONTAL;
			gbc_desTF.gridx = 4;
			gbc_desTF.gridy = 5;
			contentPanel.add(desTF, gbc_desTF);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Make Review");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(checkAgeFormat() == true && checkWordCount() <= 10 && censor() == true)
						{
							makeReview();
							for(int j = 0; j < Main.outlets.size(); j++)
						    {
								if(Main.outlets.get(j).username.compareTo(Main.accessedOutlet.username) == 0 
										&& Main.outlets.get(j).password.compareTo(Main.accessedOutlet.username) == 0)
						        {
						       	Main.outlets.set(j, Main.accessedOutlet);
						       	break;
						        }
						    }
							JOptionPane.showMessageDialog(ReviewOutletPage.this,
									"Thanks for the review!",
									"Review Outlet",
									JOptionPane.INFORMATION_MESSAGE);
							try {
		        			    FileOutputStream fos = new FileOutputStream("OutletUser.ser");
		        			    ObjectOutputStream oos = new ObjectOutputStream(fos);   
		        			    oos.writeObject(Main.outlets); // write MenuArray to ObjectOutputStream
		        			    oos.close(); 
		        			} catch(Exception ex) {
		        			    ex.printStackTrace();
		        			}
							dispose();
							OutletProfilePage OPP = new OutletProfilePage();
							OPP.setVisible(true);
							OPP.setLocationRelativeTo(null);
						}else if(censor() == false)
						{
							JOptionPane.showMessageDialog(ReviewOutletPage.this,
									"Invalid review input, please do not use such derogatory language and be considerate.",
									"Review Outlet",
									JOptionPane.ERROR_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(ReviewOutletPage.this,
									"Invalid rating input, please enter a number between 0 and 5",
									"Review Outlet",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						OutletProfilePage OPP = new OutletProfilePage();
						OPP.setVisible(true);
						OPP.setLocationRelativeTo(null);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void makeReview()
	{
		if(Main.accessedOutlet.reviews.size() == 3)
		{
			Main.accessedOutlet.reviews.remove(Main.accessedOutlet.reviews.size() - 1);
		}
        if(Main.currentUser.reviews.size() == 3)
        {
            Main.currentUser.reviews.remove(Main.currentUser.reviews.size() - 1);
        }
		Review review = new Review(desTF.getText().trim());
		Main.accessedOutlet.reviews.add(0, review);
        Main.currentUser.reviews.add(0, review);
        float currTotal = Main.accessedOutlet.getNumRatings() * Main.accessedOutlet.getAR();
        currTotal += Float.parseFloat(ratingTF.getText().trim());
        Main.accessedOutlet.incNumRatings();
        float newAv = currTotal/Main.accessedOutlet.getNumRatings();
        Main.accessedOutlet.setAr(newAv);
        DBMain dbM = new DBMain();
        dbM.dbControl("Change,Outlets,Outlets,averageRating," + Float.toString(Main.accessedOutlet.getAR()) + ",;,id," + Integer.toString(Main.accessedOutlet.getID()));
	}
	public boolean checkAgeFormat()
	{
		String curr = ratingTF.getText().trim();
		for (int ctr = 0; ctr < curr.length(); ctr++) {
            if ("123450".contains(Character.valueOf(curr.charAt(ctr)).toString())) {
                continue;
            } else {
                return false;
            }
        }
		return true;
	}
	
	public int checkWordCount()
	{
		String s = desTF.getText().trim();
	    int wordCount = 0;

	    boolean word = false;
	    int endOfLine = s.length() - 1;

	    for (int i = 0; i < s.length(); i++) {
	        // if the char is a letter, word = true.
	        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
	            word = true;
	            // if char isn't a letter and there have been letters before,
	            // counter goes up.
	        } else if (!Character.isLetter(s.charAt(i)) && word) {
	            wordCount++;
	            word = false;
	            // last word of String; if it doesn't end with a non letter, it
	            // wouldn't count without this.
	        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
	            wordCount++;
	        }
	    }
	    return wordCount;
	}
	
	public boolean censor()
	{
		File file = new File("censorship.txt");

	    try {
	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	        	String line = sc.nextLine();
	        	Boolean found = Arrays.asList(desTF.getText().split(" ")).contains(line);
	        	if(found){
	        		return false;
	        	}
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		return true;
	}
}