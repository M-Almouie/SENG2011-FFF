import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import javax.imageio.ImageIO;
import javax.swing.*;
/**
  * SENG2011 Project Fine Food Finder
  * @author Daniel Al Mouiee
  *	Main class to run application
  */
public class Main implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ArrayList<OutletAccount> outlets = new ArrayList<OutletAccount>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static JFrame frame = new JFrame("Fine Food Finder");
	protected static Customer currentUser;
	protected static OutletAccount currentOutletUser;
	protected static OutletAccount accessedOutlet;
	protected static int path = 0; //To check if user has chosen login or registration 
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
        DBMain dbm = new DBMain();
        dbm.dbControl("Make");
        //playMusic();
        try
        {
            FileInputStream fis = new FileInputStream("CustomerUser.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            customers = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          } catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
/*
        try
        {
            FileInputStream fis = new FileInputStream("OutletUser.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            outlets = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             ioe.printStackTrace();
             return;
          } catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
        //System.out.println(outlets.size());
        /*
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/Daniel Al Mouiee/Desktop/Y2s1/SENG2011/Lion-group-SENG2011/Project/src/test.png")))));
        } catch (IOException e1) {
            System.out.println("Image not found");
        }
         */
        /*
        // TESTS FOR DE-SERIALISATION
        System.out.println(outlets.get(0));
        System.out.println(outlets.get(0).username);
        System.out.println(outlets.get(0).password);
        //System.out.println(outlets.get(0).surname);
        System.out.println(customers.get(0).age);
        System.out.println(customers.get(0).cusinePreference);
        System.out.println(customers.get(0).suburb);
        System.out.println(customers.size());
        */
        //outlets.remove(0);
        //System.out.println(outlets.size());
        //System.out.println(outlets.get(0).username);
        //System.out.println(outlets.get(0).password);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		final JButton btnLogin = new JButton("Login");
		panel.add(btnLogin);
		btnLogin.setBounds(288, 207, 91, 23);
		final JButton btnRegister = new JButton("Register");
		panel.add(btnRegister);
		btnRegister.setBounds(57, 207, 91, 23);


        JButton btnNewButton_2 = new JButton("Need Help?");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                TutPage tp = new TutPage();
                tp.setVisible(true);
                tp.setLocationRelativeTo(null);
            }
        });
        btnNewButton_2.setBounds(150, 250, 159, 23);
        panel.add(btnNewButton_2);

		JLabel lblWelcomeToFine = new JLabel("Welcome To Fine Food Finder");
		lblWelcomeToFine.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWelcomeToFine.setBounds(101, 10, 307, 32);
		panel.add(lblWelcomeToFine);
		
		JLabel lblPleaseSelectRegister = new JLabel("Please select Register or Login:");
		lblPleaseSelectRegister.setFont(new Font("Arial", Font.ITALIC, 16));
		lblPleaseSelectRegister.setBounds(27, 71, 275, 32);
		panel.add(lblPleaseSelectRegister);
		
		 
        ImageIcon icon = new ImageIcon("1.jpg"); 
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setBounds(0,0,500,450);
        panel.add(thumb);
			
			//Register button action
			btnRegister.addActionListener(new ActionListener(){
			
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					path = 2;
					Welcome WelcomeDlg = new Welcome();
    				WelcomeDlg.setVisible(true);
    				WelcomeDlg.setLocationRelativeTo(null);
				}
			
				});
			
			btnLogin.addActionListener(new ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        				frame.dispose();
        				path = 1;
        				Welcome WelcomeDlg = new Welcome();
        				WelcomeDlg.setVisible(true);
        				WelcomeDlg.setLocationRelativeTo(null);
        				// if logon successfully
                        if(Welcome.choice == true){
                        	Login LoginDlg = new Login(frame);
                        	LoginDlg.setVisible(true);
                        	frame.dispose();
                        }
                    }
			});
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setSize(500,400);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        	frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	
		
	}
	
	public static void playMusic()
	{
		try
		{
			InputStream in = new FileInputStream("music/Lounge_short_jazz_.wav");
		    Clip clip = AudioSystem.getClip();
		    InputStream bufferedIn = new BufferedInputStream(in);
	        AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
	        clip.open(ais);
	        clip.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}