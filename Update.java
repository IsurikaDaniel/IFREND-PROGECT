import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Update extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JLabel searchLabel;
    private JLabel txtId;
    private JTextField txtName;
    private JTextField txtNumber;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthDay;

    private JButton home;
    private JButton update;

    private List<Contact> searchResults;

    public Update() {
        setSize(700, 600);
        setTitle("Ifriend Contact Organizer - Upadate Contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);

        JPanel searchPanel = new JPanel(new GridLayout(2, 1));

        searchLabel = new JLabel("UPDATE", JLabel.CENTER);
        searchLabel.setOpaque(true);
        searchLabel.setBackground(new Color(9, 105, 230));
        searchLabel.setForeground(Color.WHITE);
        searchLabel.setFont(new Font("Serif", Font.BOLD, 24));
        searchPanel.add(searchLabel);

        JPanel searchInputPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchButton = new JButton("SEARCH");
        searchInputPanel.add(searchField);
        searchInputPanel.add(searchButton);

        searchPanel.add(searchInputPanel);

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        

        JPanel resultPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        txtId = new JLabel();
        txtName = new JTextField();
        txtName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "Name Entered entered");

            }
        });
        txtNumber = new JTextField();
        txtNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean validPhoneNumber = Controller.isValidPhoneNumber(txtNumber.getText());
                if (!validPhoneNumber) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "INVALID PHONE NUMBER. Do you want to fill it again?", "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtNumber.setText("");
                        txtNumber.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Enter the currect Number for go head! ");
                        txtNumber.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Phone number entered");

                }

            }
        });
        txtCompany = new JTextField();
        txtCompany.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null, "Company Entered entered");
            }
        });
        txtSalary = new JTextField();
        txtSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean isValidSalary = Controller.isValidSalary(Double.parseDouble(txtSalary.getText()));
                if (!isValidSalary) {
                    int option = JOptionPane.showConfirmDialog(null, "INVALID SALARY. Do you want to fill it again?",
                            "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtSalary.setText("");
                        txtSalary.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "you must enter positive salary");
                        txtSalary.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Salary entered");
                }
            }
        });
        txtBirthDay = new JTextField();
        txtBirthDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                boolean validBirthday = Controller.isValidBirthday(txtBirthDay.getText());
                if (!validBirthday) {
                    int option = JOptionPane.showConfirmDialog(null, "INVALID DATE. Do you want to fill it again?",
                            "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtBirthDay.setText("");
                        txtBirthDay.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "you must enter valid date");
                        txtBirthDay.setText("");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "BirthDay entered");
                }
            }
        });

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

        JPanel home1 = new JPanel();
        home1.setSize(150, 50);

        home = new JButton("HOME");
        home.setPreferredSize(new Dimension(100, 50));
        home1.add(home);

        update = new JButton("Update");
        update.setPreferredSize(new Dimension(100, 50));
        home1.add(update);

        mainPanel.add(home1, BorderLayout.SOUTH);

        // Action listner to the home buttom
        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                Update.this.setVisible(false);
            }

        });

        //ADD ACTION  LISNER TO UPDATE BUTTON
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (searchResults == null || searchResults.isEmpty()) {
                    JOptionPane.showMessageDialog(Update.this, "No contacts found.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Contact contact = searchResults.get(0);

                // Check if each field has been modified, and update the contact accordingly
                if (!txtName.getText().isEmpty()) {
                    contact.setName(txtName.getText());
                }
                if (!txtNumber.getText().isEmpty()) {
                    contact.setPhoneNumber(txtNumber.getText());
                }
                if (!txtCompany.getText().isEmpty()) {
                    contact.setCompanyName(txtCompany.getText());
                }
                if (!txtSalary.getText().isEmpty()) {
                    contact.setSalary(Double.parseDouble(txtSalary.getText()));
                }
                if (!txtBirthDay.getText().isEmpty()) {
                    contact.setBirthday(txtBirthDay.getText());
                }

                JOptionPane.showMessageDialog(Update.this, "Contact updated successfully.", "Success",
                JOptionPane.INFORMATION_MESSAGE);
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
