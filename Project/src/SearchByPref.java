import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.TextField;
import java.awt.Font;
import java.awt.SystemColor;
public class SearchByPref extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String st;
	private JLabel c12;
	/**
	 * Create the dialog.
	 */
	public SearchByPref() {
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
			TextField cusPrefTF = new TextField();
			cusPrefTF.setBackground(SystemColor.inactiveCaption);
			cusPrefTF.setBounds(279, 71, 100, 22);
			contentPanel.add(cusPrefTF);
		
		
			TextField avgPriceTF = new TextField();
			avgPriceTF.setBackground(SystemColor.inactiveCaption);
			avgPriceTF.setBounds(279, 99, 100, 22);
			contentPanel.add(avgPriceTF);
		
		
			TextField postCodeTF = new TextField();
			postCodeTF.setBackground(SystemColor.inactiveCaption);
			postCodeTF.setBounds(279, 127, 100, 22);
			contentPanel.add(postCodeTF);
		
			TextField ratingPrefTF = new TextField();
			ratingPrefTF.setBackground(SystemColor.inactiveCaption);
			ratingPrefTF.setBounds(279, 155, 100, 22);
			contentPanel.add(ratingPrefTF);
			
		
		
			JLabel titleLB = new JLabel("Search By Preferences");
			titleLB.setFont(new Font("Arial", Font.BOLD, 20));
			titleLB.setBounds(141, 11, 238, 30);
			contentPanel.add(titleLB);
		
		
			JLabel cusPrefLB = new JLabel("Cusine Preference :");
			cusPrefLB.setFont(new Font("Arial", Font.BOLD, 12));
			cusPrefLB.setBounds(10, 71, 153, 14);
			contentPanel.add(cusPrefLB);
		
		
			JLabel avgPriceLB = new JLabel("Average Price :");
			avgPriceLB.setFont(new Font("Arial", Font.BOLD, 12));
			avgPriceLB.setBounds(10, 103, 153, 14);
			contentPanel.add(avgPriceLB);
		
		
			JLabel postcodeLB = new JLabel("PostCode :");
			postcodeLB.setFont(new Font("Arial", Font.BOLD, 12));
			postcodeLB.setBounds(10, 127, 153, 14);
			contentPanel.add(postcodeLB);
		
		
			JLabel RatingPrefLB = new JLabel("Rating Preference (Out Of 5) :");
			RatingPrefLB.setFont(new Font("Arial", Font.BOLD, 12));
			RatingPrefLB.setBounds(10, 155, 185, 14);
			contentPanel.add(RatingPrefLB);
			
				JButton searchButton = new JButton("Search");
				searchButton.setBounds(58, 297, 105, 23);
				contentPanel.add(searchButton);
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String tp0 = "Print,Outlets,Outlets";
                        String tp1 = ",tag,";
						String tp2 = getInputString(cusPrefTF);
						String tp3 = ",postcode,";
						String tp4 = getInputString(postCodeTF);
						String tp5 = ",averagePrice,";
						String tp6 = getInputString(avgPriceTF);
						String tp7 = ",averageRating,";
						String tp8 = getInputString(ratingPrefTF);
						StringBuilder sb = new StringBuilder();
                        sb.append(tp0);
                        if(!(tp2.equals(""))){
                            sb.append(tp1);
                            sb.append("'");
                            sb.append(tp2);
                            sb.append("'");
                        }
                        if(!(tp4.equals(""))){
                            sb.append(tp3);
                            sb.append(tp4);
                        }
                        if(!(tp6.equals(""))){
                            sb.append(tp5);
                            sb.append(tp6);
                        }
                        if(!(tp8.equals(""))){
                            sb.append(tp7);
                            sb.append(tp8);
                        }
						st = sb.toString();
						DBMain DB = new DBMain();
						DB.dbControl(st);
						dispose();
						ResultSearch RS = new ResultSearch(DB.getDl(), getInputString(postCodeTF));
						RS.setVisible(true);
						RS.setLocationRelativeTo(null);
					}
				});
				searchButton.setActionCommand("OK");
				getRootPane().setDefaultButton(searchButton);
				
				
					JButton resetButton = new JButton("Reset");
					resetButton.setBounds(198, 297, 100, 23);
					contentPanel.add(resetButton);
					resetButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							resetParameters(cusPrefTF);
							resetParameters(postCodeTF);
							resetParameters(avgPriceTF);
							resetParameters(ratingPrefTF);
						}
					});
					resetButton.setActionCommand("Cancel");
					
					
						JButton cancelButton = new JButton("Cancel");
						cancelButton.setBounds(319, 297, 100, 23);
						contentPanel.add(cancelButton);
						
						c12 = new JLabel();
						c12.setBackground(SystemColor.text);
						ImageIcon icon = new ImageIcon("12.jpg"); 
						c12.setIcon(icon);
						c12.setBounds(134, 183, 270, 104);
						contentPanel.add(c12);
						cancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dispose();
                                if(Main.currentUser != null){
                                    CustomerProfilePage CPP = new CustomerProfilePage();
                                    CPP.setVisible(true);
                                    CPP.setLocationRelativeTo(null);
                                } else if(Main.currentOutletUser != null){
                                    OutletProfilePage OPP = new OutletProfilePage();
                                    OPP.setVisible(true);
                                    OPP.setLocationRelativeTo(null);
                                }
							}
						});
		
		
		
	}
	
	public String getInputString(TextField tf)
	{
		return tf.getText();
	}
	
	public void resetParameters(TextField tf)
	{
		tf.setText("");
	}
}