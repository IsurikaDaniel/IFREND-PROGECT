import javax.swing.*;
import java.awt.*;
import java.util.List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Search extends JFrame {
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

    private List<Contact> searchResults;

    public Search() {
        setSize(700, 600);
        setTitle("Ifriend Contact Organizer - Search Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel searchPanel = new JPanel(new GridLayout(2, 1));
        
        searchLabel = new JLabel("SEARCH", JLabel.CENTER);
        searchLabel.setOpaque(true);
        searchLabel.setPreferredSize(new Dimension(getWidth(), 70));
        
        
        searchLabel.setBackground(new Color(52, 107, 235));
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("", Font.BOLD, 35));
        searchPanel.add(searchLabel);

        JPanel searchInputPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(25);
        searchField.setFont(new Font("", 1, 20));
        searchButton = new JButton("SEARCH");
        searchButton.setBackground(new Color(52, 107, 235));
        searchButton.setForeground(Color.BLACK);
        searchInputPanel.add(searchField);
        searchInputPanel.add(searchButton);

        searchPanel.add(searchInputPanel);

        mainPanel.add(searchPanel, BorderLayout.NORTH);;

        JPanel resultPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        Font labelFont = new Font("", 1, 20);
      
        txtId = new JLabel();
        txtId.setFont(labelFont);
        txtName = new JLabel();
        txtName.setFont(labelFont);
        txtNumber = new JLabel();
        txtNumber.setFont(labelFont);
        txtCompany = new JLabel();
        txtCompany.setFont(labelFont);
        txtSalary = new JLabel();
        txtSalary.setFont(labelFont);
        txtBirthDay = new JLabel();
        txtBirthDay.setFont(labelFont);

        
        JLabel id = new JLabel("ID      :");
        id.setFont(labelFont);
        resultPanel.add(id);
        resultPanel.add(txtId);
        JLabel name = new JLabel("Name      :");
        name.setFont(labelFont);
        resultPanel.add(name);
        resultPanel.add(txtName);
        JLabel number = new JLabel("Number   :");
        number.setFont(labelFont);
        resultPanel.add(number);
        resultPanel.add(txtNumber);
        JLabel company = new JLabel("Company        :");
        company.setFont(labelFont);
        resultPanel.add(company);
        resultPanel.add(txtCompany);
        JLabel salary = new JLabel("Salary      :");
        salary.setFont(labelFont);  
        resultPanel.add(salary);
        resultPanel.add(txtSalary);
        JLabel date = new JLabel("BirthDay      :");
        date.setFont(labelFont);
        resultPanel.add(date);
        resultPanel.add(txtBirthDay);

        mainPanel.add(resultPanel, BorderLayout.CENTER);

        searchButton.addActionListener(e -> {
            String searchText = searchField.getText().trim();
            searchResults = Controller.searchContacts(searchText);
            displaySearchResults();
        });

        JPanel home1 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        

        home = new JButton("HOME");
        home.setBackground(new Color(52, 107, 235));
        home.setFont(new Font("", Font.BOLD, 30));
        home.setForeground(Color.BLACK);
        home.setPreferredSize(new Dimension(150, 40));
        home1.add(home);
        mainPanel.add(home1, BorderLayout.SOUTH);


        home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                Search.this.setVisible(false);
            }

        });
    }

    private void displaySearchResults() {
        if (searchResults == null || searchResults.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No contacts found matching the search criteria.", "Search Results", JOptionPane.INFORMATION_MESSAGE);
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
