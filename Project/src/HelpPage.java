import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import java.awt.List;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Font;
import java.awt.Color;
public class HelpPage extends JFrame {
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpPage frame = new HelpPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public HelpPage() {
		setTitle("FFF user's guide");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List list = new List();
		list.setMultipleSelections(false);
		list.setBounds(10, 10, 154, 251);
        list.add("Create an account");
        list.add("Logout");
        list.add("Delete account");
        list.add("Edit profile");
        list.add("Change account details");
        list.add("Search food outlet");
        
		contentPane.add(list);
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(138, 10, 26, 251);
		contentPane.add(scrollbar);
		TextArea textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setText("FineFoodFinder\nUser's Guide");
		textArea.setFont(new Font("Dialog", Font.PLAIN, 24));
		list.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(list.getSelectedItem() == ("Search food outlet") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("Search food outlet:\nLog in ->click\non the 'search outlet'\non the left ->\nchoose 'search by\nname'or'search by\nreference'->sort\nthe result(if you wish)");
		        };		        
		        if(list.getSelectedItem() == ("Change account details") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("Change username and password:\nLog in -> click\non the 'option' button\non the right ->\nclick on 'Change details'");
		        };
		        if(list.getSelectedItem() == ("Create an account") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("Create an account:\nIn the main menu\nclick on 'register' button\non the left ->\nselect the type of\n user->enter your Username\nand password->complete your\nprofile");
		        };
		        if(list.getSelectedItem() == ("Logout") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("LogOut:\nIn the 'option' menu\nclick on the 'LogOut'\nbutton");
		        		             
		        };
		        if(list.getSelectedItem() == ("Delete account") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("Delete account:\nLog in -> click\non the 'option' button\non the right ->click\n on 'Delete Account'");
		        };
		        if(list.getSelectedItem() == ("Edit profile") && list.isIndexSelected(list.getSelectedIndex())){
		        	textArea.setText("Edit profile:\nLog in -> click on\nthe 'option' button on \nthe right->click on \n'Edit Profile'");
		        };
			}			
		});
		
 
		
		textArea.setBounds(170, 10, 336, 586);
		contentPane.add(textArea);
	}
}