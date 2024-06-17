import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class HomePage extends JFrame {

    public static final ArrayList<Contact>contactList=new ArrayList<>();

    private JButton addContact;
    private JButton deleteContact;
    private JButton updateContact;
    private JButton listContact;
    private JButton searchContact;
    private JButton exit;

    private AddContact addContactnew;
    private Sort view;

    HomePage() {
        setSize(700, 600);
        setTitle("Ifriend Contact Organizer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //----------------ADD IMAGE----------------------------------
        ImageIcon imageIcon = new ImageIcon("img.jpg");
        Image scaledImage = imageIcon.getImage().getScaledInstance(350, 420, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(52, 107, 235));
        panel1.setPreferredSize(new Dimension(400, getHeight()));

        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headingPanel.setBackground(new Color(52, 107, 235));
        
        JLabel heading = new JLabel("<html><div style='text-align: center;'>IFriend<br>Contact Organizer</div></html>");
        heading.setFont(new Font("", Font.BOLD, 35));
        heading.setForeground(Color.WHITE);
        headingPanel.add(heading);
        panel1.add(Box.createRigidArea(new Dimension(0, 10))); 
        panel1.add(headingPanel);
        panel1.add(Box.createRigidArea(new Dimension(0, 20)));
        panel1.add(imageLabel);

        add(panel1, BorderLayout.WEST);

        JPanel panel2 = new JPanel(new GridBagLayout()); 
        panel2.setBackground(new Color(52, 107, 235));
        //GRIDBAGCONTAINER-------------------------------
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 

        JLabel titleName = new JLabel("HOME PAGE");
        titleName.setFont(new Font("", Font.BOLD, 25));
        titleName.setForeground(Color.WHITE);
        titleName.setOpaque(true); 
        titleName.setBackground(new Color(52, 107, 235));
        titleName.setHorizontalAlignment(SwingConstants.CENTER);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        titleName.setBorder(border);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel2.add(titleName, gbc);

        // -----------------------------ADD CONTACT ACTION LISTNER TO THE BUTTON---------------------------------
        addContact = new JButton("Add Contact");
        addContact.setForeground(Color.BLACK);
        addContact.setBackground(Color.WHITE);
        addContact.setPreferredSize(new Dimension(200, 40));
        addContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (addContactnew == null) {
                    addContactnew = new AddContact();
                }
                addContactnew.setVisible(true);
                HomePage.this.setVisible(false);
            }
        });
        addContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                addContact.setBackground(new Color(52, 107, 235)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addContact.setBackground(Color.WHITE); 
            }
        });

        //----------------------ADD ACTIONLISTNER TO DELETE BUTTON-----------------------------------
        deleteContact = new JButton("Delete Contact");
        deleteContact.setForeground(Color.BLACK);
        deleteContact.setBackground(Color.WHITE);
        deleteContact.setPreferredSize(new Dimension(200, 40));
        deleteContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Delete().setVisible(true);
                    }
                });
            }
        });
        deleteContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                deleteContact.setBackground(new Color(52, 107, 235)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                deleteContact.setBackground(Color.WHITE); 
            }
        });

        //-------------------------------ADD ACTION LISNER TO UPDATE BUTTON--------------------------
        updateContact = new JButton("Update Contact");
        updateContact.setForeground(Color.BLACK);
        updateContact.setBackground(Color.WHITE);
        updateContact.setPreferredSize(new Dimension(200, 40));
        updateContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Update().setVisible(true);
                    }
                });
            }
        });
        updateContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                updateContact.setBackground(new Color(52, 107, 235));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                updateContact.setBackground(Color.WHITE); 
            }
        });

        //---------------------ADD ACTION LISNER TO LIST CONTACT BUTTON--------------
        listContact = new JButton("List Contact");
        listContact.setForeground(Color.BLACK);
        listContact.setBackground(Color.WHITE);
        listContact.setPreferredSize(new Dimension(200, 40));
        listContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if(view==null){
					view=new Sort();
				}
				view.setVisible(true);
			

                HomePage.this.setVisible(false);
            }
        });
        listContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                listContact.setBackground(new Color(52, 107, 235)); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                listContact.setBackground(Color.WHITE); 
            }
        });
        
        //----------------ADD ACTION LISTNER TO SERACH BUTTON--------------------------
        searchContact = new JButton("Search Contact");
        searchContact.setForeground(Color.BLACK);
        searchContact.setBackground(Color.WHITE);
        searchContact.setPreferredSize(new Dimension(200, 40));
        searchContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new Search().setVisible(true);
                    }
                });
            }
        });
        searchContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                searchContact.setBackground(new Color(52, 107, 235));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                searchContact.setBackground(Color.WHITE);
            }
        });
        //----------------------EXIT BUTTON ACTION LISNER--------------------------
        exit = new JButton("Exit");
        exit.setForeground(Color.BLACK);
        exit.setBackground(Color.WHITE);
        exit.setPreferredSize(new Dimension(200, 40));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                System.exit(0);

            }
        });
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exit.setBackground(new Color(52, 107, 235));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exit.setBackground(Color.WHITE); 
            }
        });
        

        //---------------Add buttons to panel using GridBagLayout constraints-----------------
        JButton[] buttons = {addContact, deleteContact, updateContact, listContact, searchContact, exit};
        for (int i = 0; i < buttons.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i + 1;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            panel2.add(buttons[i], gbc);
        }

        add(panel2, BorderLayout.CENTER);
    }

    
}
