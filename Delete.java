import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JLabel searchLabel;
    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtNumber;
    private JLabel txtCompany;
    private JLabel txtSalary;
    private JLabel txtBirthDay;

    private JButton home;
    private JButton delete;

    private List<Contact> searchResults;

    public Delete() {
        setSize(700, 600);
        setTitle("Ifriend Contact Organizer - Delete Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel searchPanel = new JPanel(new GridLayout(2, 1));

        searchLabel = new JLabel("DELETE", JLabel.CENTER);
        searchLabel.setOpaque(true);
        searchLabel.setBackground(new Color(9, 105, 230));
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setPreferredSize(new Dimension(getWidth(), 70));
        searchLabel.setFont(new Font("", Font.BOLD,  35));
        searchPanel.add(searchLabel);

        JPanel searchInputPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("Search");
        searchInputPanel.add(searchField);
        searchInputPanel.add(searchButton);

        searchPanel.add(searchInputPanel);

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        

        JPanel resultPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        txtId = new JLabel();
        txtName = new JLabel();
        txtNumber = new JLabel();
        txtCompany = new JLabel();
        txtSalary = new JLabel();
        txtBirthDay = new JLabel();

        resultPanel.add(new JLabel("ID:"));
        resultPanel.add(txtId);

        resultPanel.add(new JLabel("Name:"));
        resultPanel.add(txtName);

        resultPanel.add(new JLabel("Phone Number:"));
        resultPanel.add(txtNumber);

        resultPanel.add(new JLabel("Company:"));
        resultPanel.add(txtCompany);

        resultPanel.add(new JLabel("Salary:"));
        resultPanel.add(txtSalary);

        resultPanel.add(new JLabel("Birthday:"));
        resultPanel.add(txtBirthDay);

        mainPanel.add(resultPanel, BorderLayout.CENTER);

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim();
            searchResults = Controller.searchContacts(searchText);
            displaySearchResults();
        });

        JPanel home1 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
       

        home = new JButton("HOME");
        home.setBackground(new Color(9, 105, 230));
        home.setFont(new Font("", Font.BOLD, 30));
        home.setForeground(Color.BLACK);
        home.setPreferredSize(new Dimension(200, 40));
        home1.add(home);

        delete = new JButton("DELETE");
        delete.setBackground(new Color(9, 105, 230));
        delete.setFont(new Font("", Font.BOLD, 30));
        delete.setForeground(Color.RED);
        delete.setPreferredSize(new Dimension(200, 40));
        home1.add(delete);

        mainPanel.add(home1, BorderLayout.SOUTH);

        // Action listner to the home buttom
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                Delete.this.setVisible(false);
            }

        });

        //ACTION LISAYNER FOR DELETE BUTTON
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if (searchResults == null || searchResults.isEmpty()) {
                    JOptionPane.showMessageDialog(Delete.this, "No contacts found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Contact contact = searchResults.get(0);
                Controller.removeContact(contact);
                JOptionPane.showMessageDialog(Delete.this, "Contacts removed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearLabels();
                searchResults.clear();
            }
        });

    }

    private void displaySearchResults() {
        if (searchResults == null || searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No contacts found matching the search criteria.", "Search Results",
                    JOptionPane.INFORMATION_MESSAGE);
            clearLabels();
        } else {
            Contact contact = searchResults.get(0);
            txtId.setText(contact.getId());
            txtName.setText(contact.getName());
            txtNumber.setText(contact.getPhoneNumber());
            txtCompany.setText(contact.getCompanyName());
            txtSalary.setText(String.valueOf(contact.getSalary()));
            txtBirthDay.setText(contact.getBirthday());
        }
    }

    private void clearLabels() {
        txtId.setText("");
        txtName.setText("");
        txtNumber.setText("");
        txtCompany.setText("");
        txtSalary.setText("");
        txtBirthDay.setText("");
    }

}
