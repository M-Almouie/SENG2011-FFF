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
public class CustomerProfilePage extends JDialog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel c4;
	
	public CustomerProfilePage() {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 168, 0, 97, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lbStatus = new JLabel(Main.currentUser.status);
		lbStatus.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lbStatus = new GridBagConstraints();
		gbc_lbStatus.insets = new Insets(0, 0, 5, 5);
		gbc_lbStatus.gridx = 3;
		gbc_lbStatus.gridy = 0;
		//contentPanel.add(lbStatus, gbc_lbStatus);
		
		JLabel lblNewLabel = new JLabel("My name is:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel first = new JLabel(Main.currentUser.getFirstName());
		GridBagConstraints gbc_first = new GridBagConstraints();
		gbc_first.insets = new Insets(0, 0, 5, 0);
		gbc_first.gridx = 5;
		gbc_first.gridy = 3;
		contentPanel.add(first, gbc_first);
		
		JLabel lblNewLabel_1 = new JLabel("My age is:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 4;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel second = new JLabel(getStringAge());
		GridBagConstraints gbc_second = new GridBagConstraints();
		gbc_second.insets = new Insets(0, 0, 5, 0);
		gbc_second.gridx = 5;
		gbc_second.gridy = 4;
		contentPanel.add(second, gbc_second);
		
		JLabel lblNewLabel_2 = new JLabel("I live in:");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		contentPanel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel third = new JLabel(Main.currentUser.suburb);
		GridBagConstraints gbc_third = new GridBagConstraints();
		gbc_third.anchor = GridBagConstraints.NORTH;
		gbc_third.insets = new Insets(0, 0, 5, 0);
		gbc_third.gridx = 5;
		gbc_third.gridy = 5;
		contentPanel.add(third, gbc_third);
		
		JLabel lblNewLabel_3 = new JLabel("My favourite Cuisine is:");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 6;
		contentPanel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel fourth = new JLabel(Main.currentUser.cusinePreference);
		GridBagConstraints gbc_fourth = new GridBagConstraints();
		gbc_fourth.insets = new Insets(0, 0, 5, 0);
		gbc_fourth.gridx = 5;
		gbc_fourth.gridy = 6;
		contentPanel.add(fourth, gbc_fourth);
		
		JLabel lblNewLabel_4 = new JLabel("My 3 latest reviews:");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		contentPanel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		c4 = new JLabel();
		c4.setBackground(SystemColor.text);
		ImageIcon icon = new ImageIcon("4.jpg"); 
		
		JLabel firstReview = new JLabel(getReview(0));
		GridBagConstraints gbc_firstREview = new GridBagConstraints();
		gbc_firstREview.insets = new Insets(0, 0, 5, 5);
		gbc_firstREview.gridx = 3;
		gbc_firstREview.gridy = 8;
		contentPanel.add(firstReview, gbc_firstREview);
		c4.setIcon(icon);
		GridBagConstraints gbc_c4 = new GridBagConstraints();
		gbc_c4.gridwidth = 2;
		gbc_c4.gridheight = 5;
		gbc_c4.insets = new Insets(0, 0, 0, 5);
		gbc_c4.fill = GridBagConstraints.BOTH;
		gbc_c4.gridx = 0;
		gbc_c4.gridy = 9;
		contentPanel.add(c4, gbc_c4);
		
		JLabel secondreview = new JLabel(getReview(1));
		GridBagConstraints gbc_secondreview = new GridBagConstraints();
		gbc_secondreview.insets = new Insets(0, 0, 5, 5);
		gbc_secondreview.gridx = 3;
		gbc_secondreview.gridy = 9;
		contentPanel.add(secondreview, gbc_secondreview);
		
		JLabel thirdReview = new JLabel(getReview(2));
		GridBagConstraints gbc_thirdReview = new GridBagConstraints();
		gbc_thirdReview.insets = new Insets(0, 0, 5, 5);
		gbc_thirdReview.gridx = 3;
		gbc_thirdReview.gridy = 10;
		contentPanel.add(thirdReview, gbc_thirdReview);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		getContentPane().add(buttonPane, BorderLayout.NORTH);
		GridBagLayout gbl_buttonPane = new GridBagLayout();
		gbl_buttonPane.columnWidths = new int[]{0, 0, 0, 0, 0, 190, 151, 0, 25, 69, 0, 0, 0};
		gbl_buttonPane.rowHeights = new int[]{23, 0};
		gbl_buttonPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		buttonPane.setLayout(gbl_buttonPane);
		
		JButton btnNewButton_2 = new JButton("Search Food Outlet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SearchChoice SC = new SearchChoice();
				SC.setVisible(true);
				SC.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		buttonPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
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
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridwidth = 4;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.gridx = 7;
		gbc_btnNewButton.gridy = 0;
		buttonPane.add(btnNewButton, gbc_btnNewButton);
	
		
	}
	public String getStringAge()
	{
		String ageString = Integer.toString(Main.currentUser.getAge());
		return ageString;
	}

    public String getReview(int i)
    {
        if(Main.currentUser.reviews.size() >= i + 1)
        {
            return Main.currentUser.reviews.get(i).printReview();
        }else
        {
            return "No Review Yet...";
        }
    }
}