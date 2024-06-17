import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AddContact extends JFrame {
    private JLabel txtId;
    private JTextField txtName;
    private JTextField txtNumber;
    private JTextField txtCompany;
    private JTextField txtSalary;
    private JTextField txtBirthDay;

    private JButton addContact;
    private JButton cancel;
    private JButton homeButton;

    public AddContact() {
        setSize(700, 600);
        setTitle("Ifriend Contact organizer - Add contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("ADD CONTACT");
        title.setBackground(new Color(52, 107, 235));
        title.setFont(new Font("", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(52, 107, 235));
        titlePanel.setPreferredSize(new Dimension(getWidth(), 70));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 15, 20));

        //---------------GENERATE ID----------------
        String generatedId = Controller.generateId();
        String prefixedId = "ID: " + generatedId; 
        txtId = new JLabel(prefixedId);
        txtId.setFont(new Font("", 1, 20));

        txtName = new JTextField();
        txtName.setFont(new Font("", 1, 20));
        txtNumber = new JTextField();
        txtNumber.setFont(new Font("", 1, 20));
        txtNumber.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                String number = txtNumber.getText();
                boolean validPhoneNumber = Controller.isValidPhoneNumber(number);
                if (!validPhoneNumber) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "INVALID PHONE NUMBER. Do you want to fill it again?", "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtNumber.setText("");
                        txtNumber.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtId.setText(Controller.generateId());
                        txtName.setText("");
                        txtNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                }
            }

        });
        txtNumber.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String number = txtNumber.getText();
                boolean validPhoneNumber = Controller.isValidPhoneNumber(number);
                if (!validPhoneNumber) {
                    int option = JOptionPane.showConfirmDialog(null,
                            "INVALID PHONE NUMBER. Do you want to fill it again?", "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtNumber.setText("");
                        txtNumber.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtId.setText(Controller.generateId());
                        txtName.setText("");
                        txtNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                }
            }
        });

        txtCompany = new JTextField();
        txtCompany.setFont(new Font("", 1, 20));
        txtSalary = new JTextField();
        txtSalary.setFont(new Font("", 1, 20));
        txtSalary.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent e) {
                double salary = Double.parseDouble(txtSalary.getText());
                boolean isValidSalary = Controller.isValidSalary(salary);
                if (!isValidSalary) {
                    int option = JOptionPane.showConfirmDialog(null, "INVALID SALARY. Do you want to fill it again?",
                            "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtSalary.setText("");
                        txtSalary.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtId.setText(Controller.generateId());
                        txtName.setText("");
                        txtNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                }
            }

        });
        txtSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                double salary = Double.parseDouble(txtSalary.getText());
                boolean isValidSalary = Controller.isValidSalary(salary);
                if (!isValidSalary) {
                    int option = JOptionPane.showConfirmDialog(null, "INVALID SALARY. Do you want to fill it again?",
                            "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtSalary.setText("");
                        txtSalary.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtId.setText(Controller.generateId());
                        txtName.setText("");
                        txtNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                }
            }
        });
        txtBirthDay = new JTextField();
        txtBirthDay.setFont(new Font("", 1, 20));
        Font labelFont = new Font("", 1, 20);
        JLabel id = new JLabel("ID      :");
        id.setFont(labelFont);
        formPanel.add(id);
        formPanel.add(txtId);
        JLabel name = new JLabel("Name      :");
        name.setFont(labelFont);
        formPanel.add(name);
        formPanel.add(txtName);
        JLabel number = new JLabel("Number   :");
        number.setFont(labelFont);
        formPanel.add(number);
        formPanel.add(txtNumber);
        JLabel company = new JLabel("Company        :");
        company.setFont(labelFont);
        formPanel.add(company);
        formPanel.add(txtCompany);
        JLabel salary = new JLabel("Salary      :");
        salary.setFont(labelFont);  
        formPanel.add(salary);
        formPanel.add(txtSalary);
        JLabel date = new JLabel("BirthDay      :");
        date.setFont(labelFont);
        formPanel.add(date);
        formPanel.add(txtBirthDay);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

        addContact = new JButton("ADD CONTACT");
        addContact.setForeground(Color.WHITE);
        addContact.setBackground(new Color(52, 107, 235));
        addContact.setFont(new Font("", Font.BOLD, 15));

        cancel = new JButton("CANCEL");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(52, 107, 235));
        cancel.setFont(new Font("", Font.BOLD, 15));
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                clear();
            }
        });

        homeButton = new JButton("HOME");
        homeButton.setForeground(Color.WHITE);
        homeButton.setBackground(new Color(52, 107, 235));
        homeButton.setFont(new Font("", Font.BOLD, 15));

        buttonPanel.add(addContact);
        buttonPanel.add(cancel);
        buttonPanel.add(homeButton);

        add(buttonPanel, BorderLayout.SOUTH);
        addContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (areFieldsEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill the all colums", "INVALID ERROR", JOptionPane.INFORMATION_MESSAGE);
                    clear(); 
                } else {
                    String date = txtBirthDay.getText();
                    boolean isValidBirthday = Controller.isValidBirthday(date);
                if (!isValidBirthday) {
                    int option = JOptionPane.showConfirmDialog(null, "INVALID BIRTHDAY. Do you want to fill it again?",
                            "Error", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        txtBirthDay.setText("");
                        txtBirthDay.requestFocus();
                    } else if (option == JOptionPane.NO_OPTION) {
                        txtId.setText(Controller.generateId());
                        txtName.setText("");
                        txtNumber.setText("");
                        txtCompany.setText("");
                        txtSalary.setText("");
                        txtBirthDay.setText("");
                    }
                } else {
                    String id = txtId.getText();
                    String name = txtName.getText();
                    String number = txtNumber.getText();
                    String company = txtCompany.getText();
                    double salary = Double.parseDouble(txtSalary.getText());
                    String birthDay = txtBirthDay.getText();
                    Contact contact = new Contact(id, name, number, company, salary, birthDay);
                    Controller.addContact(contact);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "CONTACT ADDED SUCCESSFULLY! Do you want to add another contact?", "Success",
                            JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        //----------OPEN NEW ADD CONTACT WINDOW-------------
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new AddContact().setVisible(true);
                            }
                        });
                    } else if (choice == JOptionPane.NO_OPTION) {
                        setVisible(false);

                        HomePage homePage = new HomePage();
                        homePage.setVisible(true);

                    }

                }
                }
                
            }
        });

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HomePage homePage = new HomePage();
                homePage.setVisible(true);
                AddContact.this.setVisible(false);
            }
        });
    }
    private void clear() {
        txtName.setText("");
        txtNumber.setText("");
        txtCompany.setText("");
        txtSalary.setText("");
        txtBirthDay.setText("");
    }
    private boolean areFieldsEmpty() {
        return txtName.getText().isEmpty() || 
               txtNumber.getText().isEmpty() || 
               txtCompany.getText().isEmpty() || 
               txtSalary.getText().isEmpty() || 
               txtBirthDay.getText().isEmpty();
    }
}
