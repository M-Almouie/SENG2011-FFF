import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Logout extends JDialog {

	private static final long serialVersionUID = 1L;
	/**
	 * Create the dialog.
	 */
	public Logout() {
		setBounds(100, 100, 450, 180);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						Options op = new Options();
						op.setVisible(true);
						op.setLocationRelativeTo(null);
					}
				});
				{
					JButton yesButton = new JButton("Yes");
					buttonPane.add(yesButton);
					yesButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if(Welcome.choice == true){
								Main.currentUser = null;
								dispose();
								Login lg = new Login(Main.frame);
								lg.setVisible(true);
								dispose();
							}else{
								Main.currentOutletUser = null;
								dispose();
								LoginOutlet lg = new LoginOutlet(Main.frame);
								lg.setVisible(true);
								lg.setLocationRelativeTo(null);
								dispose();
							}
						}
					});
					yesButton.setActionCommand("OK");
					getRootPane().setDefaultButton(yesButton);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblAreYouSure = new JLabel("Are You sure you want to proceed to LogOut?");
			getContentPane().add(lblAreYouSure, BorderLayout.CENTER);
			lblAreYouSure.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
			lblAreYouSure.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}

}
