import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
public class SearchChoice extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	/**
	 * Create the dialog.
	 */
	public SearchChoice() {
		setBounds(100, 100, 500, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton sbnButton = new JButton("Search By Name");
			sbnButton.setBounds(34, 191, 170, 23);
			contentPanel.add(sbnButton);
			sbnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					SearchByName SBN = new SearchByName();
					SBN.setVisible(true);
					SBN.setLocationRelativeTo(null);
				}
			});
			sbnButton.setActionCommand("OK");
			getRootPane().setDefaultButton(sbnButton);
		}
		{
			JButton sbrButton = new JButton("Search By Preference");
			sbrButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					SearchByPref SBP = new SearchByPref();
					SBP.setVisible(true);
					SBP.setLocationRelativeTo(null);
				}
			});
			sbrButton.setBounds(250, 191, 179, 23);
			contentPanel.add(sbrButton);
			sbrButton.setActionCommand("Cancel");
		}
		
		JLabel lblChooseYourPrefered = new JLabel("Choose your preferred method of Searching Food Outlets:");
		lblChooseYourPrefered.setFont(new Font("Arial", Font.BOLD, 14));
		lblChooseYourPrefered.setBounds(10, 34, 457, 58);
		contentPanel.add(lblChooseYourPrefered);
		
		ImageIcon icon = new ImageIcon("1.jpg"); 
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setBounds(0,0,500,500);
        contentPanel.add(thumb);
		
	}
}