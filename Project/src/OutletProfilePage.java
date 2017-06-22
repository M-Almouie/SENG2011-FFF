/**
 * Author : Daniel Al Mouiee
 * Class to Draw the profile page if a customer
 * DONE
 */
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
//import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
//import javax.swing.JTable;
public class OutletProfilePage extends JDialog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
    OutletAccount currOutlet;
    private JLabel c8;
	
	public OutletProfilePage() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{31, 150, 97, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPanel.add(panel, gbc_panel);
		JLabel label;
        if(Main.currentOutletUser != null){
            currOutlet = Main.currentOutletUser;
        } else{
            currOutlet = Main.accessedOutlet;
        }
        label = new JLabel(currOutlet.getName());
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 2;
        gbc_label.gridy = 1;
        contentPanel.add(label, gbc_label);
        label.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Address:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel first = new JLabel(getStringStreetNum()+ ", " + currOutlet.getStreet()+", "+
		currOutlet.getSuburb());
		GridBagConstraints gbc_first = new GridBagConstraints();
		gbc_first.insets = new Insets(0, 0, 5, 5);
		gbc_first.gridx = 3;
		gbc_first.gridy = 4;
		contentPanel.add(first, gbc_first);
		
		JLabel lblNewLabel_1 = new JLabel("Description:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel second = new JLabel(currOutlet.getDescrip());
		GridBagConstraints gbc_second = new GridBagConstraints();
		gbc_second.insets = new Insets(0, 0, 5, 5);
		gbc_second.gridx = 3;
		gbc_second.gridy = 5;
		contentPanel.add(second, gbc_second);
		
		JLabel lblNewLabel_2 = new JLabel("Scenery:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel third = new JLabel(currOutlet.getScenrey());
		GridBagConstraints gbc_third = new GridBagConstraints();
		gbc_third.anchor = GridBagConstraints.NORTH;
		gbc_third.insets = new Insets(0, 0, 5, 5);
		gbc_third.gridx = 3;
		gbc_third.gridy = 6;
		contentPanel.add(third, gbc_third);
		ImageIcon icon = new ImageIcon("8.jpg"); 
		
		JLabel lblNewLabel_3 = new JLabel("Average Rating:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 7;
		contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		String rating = "";
		if(currOutlet.getNumRatings() == 0)
		{
			rating = "N/A";
		}else
		{
			rating = getRating();
		}
		JLabel lblNewLabel_5 = new JLabel(rating);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 7;
		contentPanel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Average Price:");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 8;
		contentPanel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel(getPrice());
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 3;
		gbc_lblNewLabel_7.gridy = 8;
		contentPanel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("Reviews:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 9;
		contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel firstReview = new JLabel(getReview(0));
		GridBagConstraints gbc_firstREview = new GridBagConstraints();
		gbc_firstREview.insets = new Insets(0, 0, 5, 5);
		gbc_firstREview.gridx = 2;
		gbc_firstREview.gridy = 9;
		contentPanel.add(firstReview, gbc_firstREview);
		
			c8 = new JLabel();
			c8.setBackground(SystemColor.text);
			c8.setIcon(icon);
			GridBagConstraints gbc_c8 = new GridBagConstraints();
			gbc_c8.gridwidth = 2;
			gbc_c8.gridheight = 7;
			gbc_c8.fill = GridBagConstraints.BOTH;
			gbc_c8.gridx = 3;
			gbc_c8.gridy = 9;
			contentPanel.add(c8, gbc_c8);
		
		JLabel secondreview = new JLabel(getReview(1));
		GridBagConstraints gbc_secondreview = new GridBagConstraints();
		gbc_secondreview.insets = new Insets(0, 0, 5, 5);
		gbc_secondreview.gridx = 2;
		gbc_secondreview.gridy = 10;
		contentPanel.add(secondreview, gbc_secondreview);
		
		JLabel thirdReview = new JLabel(getReview(2));
		GridBagConstraints gbc_thirdReview = new GridBagConstraints();
		gbc_thirdReview.insets = new Insets(0, 0, 5, 5);
		gbc_thirdReview.gridx = 2;
		gbc_thirdReview.gridy = 11;
		contentPanel.add(thirdReview, gbc_thirdReview);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		getContentPane().add(buttonPane, BorderLayout.NORTH);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[]{190, 151, 69, 69, 0};
		gbl_buttonPane.rowHeights = new int[]{23, 0};
		gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPane.setLayout(gbl_buttonPane);
		
		JButton btnNewButton_2 = new JButton("Search Food Outlets");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SearchChoice SC = new SearchChoice();
				SC.setVisible(true);
				SC.setLocationRelativeTo(null);
			}
		});

        if(Main.currentOutletUser == null){
            btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
            GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
            gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
            gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
            gbc_btnNewButton_2.gridx = 0;
            gbc_btnNewButton_2.gridy = 0;
            buttonPane.add(btnNewButton_2, gbc_btnNewButton_2);
        }

		JButton btnNewButton = new JButton("Options");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Options OP = new Options();
                 OP.setVisible(true);
                 OP.setLocationRelativeTo(null);
                 dispose();
			}
		});
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.gridwidth = 2;
        gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
        if(Main.currentOutletUser != null){
            gbc_btnNewButton.gridx = 1;
            gbc_btnNewButton.gridwidth = 1;
        } else{
            gbc_btnNewButton.gridx = 2;
        }
        buttonPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnReview = new JButton("Review This Outlet");
		btnReview.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currOutlet != null)
				{
					dispose();
					ReviewOutletPage ROP = new ReviewOutletPage();
					ROP.setVisible(true);
					ROP.setLocationRelativeTo(null);
				}
			}
		});
        if(Main.currentOutletUser == null){
            GridBagConstraints gbc_btnReview = new GridBagConstraints();
            gbc_btnReview.fill = GridBagConstraints.HORIZONTAL;
            gbc_btnReview.insets = new Insets(0, 0, 0, 5);
            gbc_btnReview.gridx = 1;
            gbc_btnReview.gridy = 0;
            buttonPane.add(btnReview, gbc_btnReview);
        }
	}
	public String getStringStreetNum()
	{
		String ageString = Integer.toString(currOutlet.getStreetNum());
		return ageString;
	}
	
	public String getReview(int i)
	{
		if(currOutlet.reviews.size() >= i + 1)
		{
			return currOutlet.reviews.get(i).printReview();
		}else
		{
			return "No Review Yet...";
		}
	}
	
	public String getRating()
	{
		String ratingString = Float.toString(currOutlet.getAR());
		return ratingString;
	}
	
	public String getPrice()
	{
		String priceString = Float.toString(currOutlet.getAP());
		return priceString;
	}
}