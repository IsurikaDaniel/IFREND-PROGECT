import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class ViewCustomerForm extends JFrame {
    private JButton btnReload;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;
    private JTextField searchField;
    private JButton searchButton;
    private JButton home;

    ViewCustomerForm() {
        initComponents();
        reloadCustomerDetails();
    }

    ViewCustomerForm(ArrayList<Contact> searchResults) {
        initComponents();
        loadSearchResults(searchResults);
    }

    private void initComponents() {
        setSize(700, 600);
        setTitle("View Customer Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("View Customer Form");
        titleLabel.setFont(new Font("", Font.BOLD, 30));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(9, 105, 230));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchField = new JTextField(20);
        searchField.setFont(new Font("", Font.PLAIN, 20));
        searchButton = new JButton("SEARCH");
        searchButton.setFont(new Font("", Font.BOLD, 20));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.SOUTH);


        String[] columnNames = {"Customer ID", "Name", "Company", "Salary", "BirthDay"};
        dtm = new DefaultTableModel(columnNames, 0);
        tblCustomerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(tblCustomerDetails);
        add(tablePane, BorderLayout.CENTER);


        JPanel homePanel = new JPanel();
        homePanel.setSize(150, 50);


        btnReload = new JButton("Reload");
        btnReload.setFont(new Font("", Font.BOLD, 20));
        btnReload.setPreferredSize(new Dimension(100, 50));
        btnReload.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                reloadCustomerDetails();
            }
        });
        homePanel.add(btnReload);

        home = new JButton("HOME");
        home.setFont(new Font("", Font.BOLD, 20));
        home.setPreferredSize(new Dimension(100, 50));
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
            }
        });
        homePanel.add(home);
        add(homePanel, BorderLayout.SOUTH);
    }

    private void reloadCustomerDetails() {
        dtm.setRowCount(0);

        for (Contact contact : DBConnection.getInstance().getContactList()) {
            Object[] rowData = {contact.getId(), contact.getName(), contact.getCompanyName(), contact.getSalary(), contact.getBirthday()};
            dtm.addRow(rowData);
        }
    }

    private void loadSearchResults(ArrayList<Contact> searchResults) {
        dtm.setRowCount(0);

        for (Contact contact : searchResults) {
            Object[] rowData = {contact.getId(), contact.getName(), contact.getCompanyName(), contact.getSalary(), contact.getBirthday()};
            dtm.addRow(rowData);
        }
    }

   
}
