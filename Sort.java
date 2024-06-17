import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


 public class Sort extends JFrame{
    private JButton Name;
    private JButton Salary;
    private JButton birthDay;

    private ArrayList<Contact> sortByName = new ArrayList<>();
    private ArrayList<Contact> sortBySalary = new ArrayList<>();
    private ArrayList<Contact> sortByBirthDay = new ArrayList<>();
    private ViewCustomerForm  viewCustomerForm;
    private ViewCustomerForm  viewCustomerForm2;
    private ViewCustomerForm  viewCustomerForm3;

    Sort(){
        setSize(700, 600);
        setTitle("Ifriend Contact organizer - List contact");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel title = new JLabel("LIST CONTACT");
        title.setBackground(new Color(64, 168, 237));
        title.setFont(new Font("", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(new Color(64, 168, 237));
        titlePanel.setPreferredSize(new Dimension(getWidth(), 70));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);


        Name = new JButton("SORT BY NAME");
        Name.setForeground(Color.WHITE);
        Name.setBackground(new Color(64, 168, 237));
        Name.setFont(new Font("", Font.BOLD, 15));
        Name.setPreferredSize(new Dimension(150, 40));
        Name.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortByName = Controller.sortByName();
                if (viewCustomerForm == null) {
                    viewCustomerForm = new ViewCustomerForm(sortByName);
                }
                viewCustomerForm.setVisible(true);
            }
        });

        Salary = new JButton("SORT BY SALARY");
        Salary.setForeground(Color.WHITE);
        Salary.setBackground(new Color(64, 168, 237));
        Salary.setFont(new Font("", Font.BOLD, 15));
        Salary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortBySalary = Controller.sortBySalary();
                if (viewCustomerForm2 == null) {
                    viewCustomerForm2 = new ViewCustomerForm(sortBySalary);
                }
                viewCustomerForm2.setVisible(true);
            }
        });

        birthDay = new JButton("SORT BY BIRTHDAY");
        birthDay.setForeground(Color.WHITE);
        birthDay.setBackground(new Color(64, 168, 237));
        birthDay.setFont(new Font("", Font.BOLD, 15));
        birthDay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortByBirthDay = Controller.sortByBirthDay();
                if (viewCustomerForm3 == null) {
                    viewCustomerForm3 = new ViewCustomerForm(sortByBirthDay);
                }
                viewCustomerForm3.setVisible(true);
            }
        });

        JPanel middle = new JPanel();
        middle.setLayout(new GridLayout(3,1,20,20));
        middle.add(Name);
        middle.add(Salary);
        middle.add(birthDay);

        add(middle, BorderLayout.CENTER);
        

    }
}
