import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Options extends JDialog implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();

    /**
     * Create the dialog.
     */
    public Options() {
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblOptions = new JLabel("Options");
            lblOptions.setHorizontalAlignment(SwingConstants.CENTER);
            lblOptions.setBounds(177, 5, 123, 22);
            lblOptions.setFont(new Font("Tahoma", Font.BOLD, 20));
            contentPanel.add(lblOptions);
        }
        {
            JButton okButton = new JButton("Edit Profile");
            okButton.setBounds(168, 38, 159, 23);
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(Welcome.choice == true)
                    {
                        dispose();
                        EditCustProfile EUP = new EditCustProfile(Main.frame);
                        EUP.setVisible(true);
                        EUP.setLocationRelativeTo(null);
                    }else{
                        dispose();
                        EditOutletProfile EOP = new EditOutletProfile(Main.frame);
                        EOP.setVisible(true);
                        EOP.setLocationRelativeTo(null);
                    }
                }
            });
            contentPanel.add(okButton);
            okButton.setActionCommand("OK");
            getRootPane().setDefaultButton(okButton);
        }
        {
            JButton cancelButton = new JButton("Change Credentials");
            cancelButton.setBounds(168, 82, 159, 23);
            contentPanel.add(cancelButton);
            cancelButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    ChangeAccountDetails CCAD = new ChangeAccountDetails();
                    CCAD.setVisible(true);
                    CCAD.setLocationRelativeTo(null);
                    dispose();
                }
            });
            cancelButton.setActionCommand("Cancel");
        }
        {
            JButton btnNewButton = new JButton("LogOut");
            btnNewButton.setBounds(168, 187, 159, 23);
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dispose();
                    Logout lo = new Logout();
                    lo.setLocationRelativeTo(null);
                    lo.setVisible(true);
                }
            });
            contentPanel.add(btnNewButton);
        }
        {
            JButton btnNewButton_1 = new JButton("Delete Account");
            btnNewButton_1.setBounds(168, 130, 159, 23);
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if(Welcome.choice == true){
                        deleteAccount();
                    }else{
                        deleteAccountOutlet();
                    }
                    dispose();
                    Main main = new Main();
                    Main.main(null);
                }
            });
            contentPanel.add(btnNewButton_1);
        }
        {
            JButton btnBackToProfile = new JButton("Back To Profile");
            btnBackToProfile.setBounds(168, 279, 159, 23);
            btnBackToProfile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    dispose();
                    if(Welcome.choice == true){
                        CustomerProfilePage ccp = new CustomerProfilePage();
                        ccp.setVisible(true);
                        ccp.setLocationRelativeTo(null);
                    }
                    else{
                        OutletProfilePage OPP = new OutletProfilePage();
                        OPP.setVisible(true);
                        OPP.setLocationRelativeTo(null);
                    }
                }
            });
            contentPanel.add(btnBackToProfile);
        }

        ImageIcon icon = new ImageIcon("1.jpg");
        {
            JButton btnNewButton_2 = new JButton("Need Help?");
            btnNewButton_2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    TutPage tp = new TutPage();
                    tp.setVisible(true);
                    tp.setLocationRelativeTo(null);
                }
            });
            btnNewButton_2.setBounds(168, 235, 159, 23);
            contentPanel.add(btnNewButton_2);
        }

        JButton btnQuit = new JButton("Quit");
        btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
        btnQuit.setBounds(168, 327, 159, 23);
        contentPanel.add(btnQuit);
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setBounds(0,0,500,500);
        contentPanel.add(thumb);
    }

    public void deleteAccount()
    {
        for(int i = 0; i < Main.customers.size(); i++)
        {
            if(Main.currentUser.username.compareTo(Main.customers.get(i).username) == 0
                    && (Main.currentUser.password.compareTo(Main.customers.get(i).password) == 0))
            {
                Main.customers.remove(i);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("CustomerUser.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.customers); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAccountOutlet()
    {
        for(int i = 0; i < Main.outlets.size(); i++)
        {
            if(Main.currentOutletUser.username.compareTo(Main.outlets.get(i).username) == 0
                    && (Main.currentOutletUser.password.compareTo(Main.outlets.get(i).password) == 0))
            {
                Main.outlets.remove(i);
            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("OutletUser.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Main.outlets); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}