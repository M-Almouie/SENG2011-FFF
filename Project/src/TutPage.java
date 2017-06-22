import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TutPage extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JPanel contentPane;
    /**
     * Create the dialog.
     */
    @SuppressWarnings("deprecation")
    public TutPage() {
        setTitle("FFF user's guide");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 725, 950);
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
        list.add("Change Credentials");
        list.add("Search food outlet by name");
        list.add("Search food outlet by reference");

        contentPane.add(list);
        JTextPane textpane = new JTextPane();
        textpane.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
        textpane.setEditable(false);
        textpane.setText("FineFoodFinder User's Guide");
        textpane.setBounds(170, 10, 518, 743);
        contentPane.add(textpane);

        JButton btnBackToOptions = new JButton("Back To Options");
        btnBackToOptions.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Options OP = new Options();
                OP.setLocationRelativeTo(null);
                OP.setVisible(true);
            }
        });

        JButton btnBackToMain = new JButton("Back To the Main Page");
        btnBackToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Main m = new Main();
                m.main(null);
            }
        });
        btnBackToOptions.setBounds(41, 323, 89, 23);
        btnBackToMain.setBounds(41, 323, 89, 23);
        if(Main.currentOutletUser != null || Main.currentUser != null){
            contentPane.add(btnBackToOptions);
        } else{
            contentPane.add(btnBackToMain);
        }

        list.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e){
                if(list.getSelectedItem() == ("Search food outlet by name") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/sofn.PNG"));
                };
                if(list.getSelectedItem() == ("Search food outlet by reference") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/sofr.PNG"));
                };
                if(list.getSelectedItem() == ("Change Credentials") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/cc.PNG"));
                };
                if(list.getSelectedItem() == ("Create an account") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/cac.PNG"));
                };
                if(list.getSelectedItem() == ("Logout") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/lo.PNG"));
                };
                if(list.getSelectedItem() == ("Delete account") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/da.PNG"));
                };
                if(list.getSelectedItem() == ("Edit profile") && list.isIndexSelected(list.getSelectedIndex())){
                    textpane.setText("");
                    textpane.insertIcon(new ImageIcon("files/edit.PNG"));
                };
            }

            //@Override
            //public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub

            //}
        });
    }

}