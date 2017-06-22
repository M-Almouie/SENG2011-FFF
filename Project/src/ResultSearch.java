import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.util.Collections;
import java.awt.SystemColor;
import java.awt.Color;
public class ResultSearch extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel c9;
	//private ArrayList<DataRow> DR;
	/**
	 * Create the dialog.
	 */
	public ResultSearch(ArrayList<DataRow> DR, String passedPostcode) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        int postcode;
	    if(passedPostcode.equals("")){
	        postcode = 0;
        } else{
            postcode = Integer.parseInt(passedPostcode);
        }
	    setBounds(100, 100, 500, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		DefaultListModel<String> listModel;
		listModel = new DefaultListModel<String>();
		for(DataRow data : DR)
		{
            listModel.addElement("ID: " + data.getId() + " | Name: " + data.getName() + " | Postcode: " + data.getPostcode()
                    + " | Average Price: " + data.getAp() + " | Average Rating: " + data.getAr());
		}
        JScrollPane jsp = new JScrollPane();
		JList list = new JList(listModel);
		list.setBackground(SystemColor.inactiveCaption);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jsp.setViewportView(list);
        jsp.setBounds(23, 77, 289, 143);
		contentPanel.add(jsp);
		
		Label title = new Label("Search Result");
		title.setBackground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 20));
		title.setBounds(167, 10, 145, 22);
		contentPanel.add(title);
		
		Label infoLB = new Label("Select the Outlet of your preference then press \"Go To Outlet Profile\" :");
		infoLB.setBackground(Color.WHITE);
		infoLB.setFont(new Font("Dialog", Font.ITALIC, 12));
		infoLB.setBounds(10, 38, 414, 22);
		contentPanel.add(infoLB);
		
		JComboBox<String> filters = new JComboBox<String>();
		filters.setMaximumRowCount(4);
		filters.setToolTipText("Filters");
		filters.setBounds(344, 75, 130, 20);
		contentPanel.add(filters);
		GridBagConstraints gbc_filtersOption = new GridBagConstraints();
		gbc_filtersOption.insets = new Insets(0, 0, 5, 0);
		gbc_filtersOption.anchor = GridBagConstraints.WEST;
		gbc_filtersOption.gridx = 1;
		gbc_filtersOption.gridy = 3;
		contentPanel.add(filters, gbc_filtersOption);
		
		JButton goButton = new JButton("Go To Outlet Profile");
		goButton.setBounds(63, 303, 175, 23);
		contentPanel.add(goButton);
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = (String)list.getSelectedValue();
                String[] sl = str.split(" ");
                int id = Integer.parseInt(sl[1]);
				for(OutletAccount i : Main.outlets){
				    if(i.getID() == id){
				        Main.accessedOutlet = i;
				        break;
                    }
                }
				dispose();
				OutletProfilePage OPP = new OutletProfilePage();
				OPP.setVisible(true);
				OPP.setLocationRelativeTo(null);
			}
		});
		goButton.setActionCommand("OK");
		getRootPane().setDefaultButton(goButton);
		
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(283, 303, 114, 23);
			contentPanel.add(cancelButton);
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
			cancelButton.setActionCommand("Cancel");
			
			c9 = new JLabel();
			c9.setBackground(SystemColor.text);
			ImageIcon icon = new ImageIcon("9.jpg"); 
			c9.setIcon(icon);
			c9.setBackground(Color.WHITE);
			c9.setBounds(322, 117, 152, 178);
			contentPanel.add(c9);
		filters.addItem("Lowest Price");
		filters.addItem("Nearest Outlet");
		filters.addItem("Highest Rating");
        filters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                Object selected = comboBox.getSelectedItem();
                if(selected.toString().equals("Lowest Price")){
                    sortBookings(DR, "averagePrice");
                } else if(selected.toString().equals("Highest Rating")){
                    sortBookings(DR, "averageRating");
                } else{
                    sortPostcode(DR, postcode);
                }
                listModel.clear();
                for(DataRow data : DR)
                {
                    listModel.addElement("ID: " + data.getId() + " | Name: " + data.getName() + " | Postcode: " + data.getPostcode()
                            + " | Average Price: " + data.getAp() + " | Average Rating: " + data.getAr());
                }
            }
        });
	
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				 if (list.getSelectedIndex() == -1) {
				            goButton.setEnabled(false);
				 }
				 goButton.setEnabled(true);
			}
		});
		
	}
    public void sortPostcode(ArrayList<DataRow> l, int postcode)
    {
        for(int i = 0; i < l.size()-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < l.size(); j++)
            {
                if(Math.abs(l.get(j).getPostcode() - postcode) < Math.abs(l.get(min).getPostcode() - postcode))
                {
                    min = j;
                }
            }
            if(min != i)
            {
                Collections.swap(l, i, min);
            }
        }
    }
    public void sortBookings(ArrayList<DataRow> l, String sortCat)
    {
        for(int i = 0; i < l.size()-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < l.size(); j++)
            {
                switch(sortCat){
                    case "averagePrice": if(l.get(j).getAp() < l.get(min).getAp())
                    {
                        min = j;
                    } break;
                    case "averageRating": if(l.get(j).getAr() > l.get(min).getAr())
                    {
                        min = j;
                    } break;
                }
            }
            if(min != i)
            {
                Collections.swap(l, i, min);
            }
        }
    }
}