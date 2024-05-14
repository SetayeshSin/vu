import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SignUp {
    public JFrame frame=new JFrame();
    public JPanel panel=new JPanel();
    public String firstName;
    public String lastName;
    private String userName;
    private String fieldOfStudy;
    public String educationalID;
    private String email;
    private String phoneNumber;
    private String userRole;
    public String password;
    private String repeatPassword;
    public Home home;
    public SignUp(Home home){
        this.home=home;
    }
    public void checkSignUp(String firstName,String lastName,String fieldOfStudy,String userName,String educationalID,String email,String phoneNumber,String userRole,String password,String repeatPassword) {
        int sw = 1;
        if (isUsernameValid(userName)) this.userName = userName;
        else {
            JOptionPane.showMessageDialog(null, "          username " + userName + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (isValidInput1(firstName)) {
                this.firstName = firstName;
            } else {
                JOptionPane.showMessageDialog(null, "          firstname " + firstName + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
                sw = 0;
        }
        if (isValidInput1(lastName)) {
            this.lastName = lastName;
        } else {
            JOptionPane.showMessageDialog(null, "          lastname " + lastName + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (isValidInput1(fieldOfStudy)) {
            this.fieldOfStudy = fieldOfStudy;
        } else {
            JOptionPane.showMessageDialog(null, "          fieldOfStudy " + fieldOfStudy + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (isEmailValid(email)) {
            this.email = email;
        } else {
            JOptionPane.showMessageDialog(null, "          email " + email + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (isPhoneNumberValid(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            JOptionPane.showMessageDialog(null, "          phoneNumber " + phoneNumber + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (!setUserRole(userRole)) {
            JOptionPane.showMessageDialog(null, "          userrole " + userRole + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        else {
            if (isEducationalIDValid(educationalID, getUserRole())) {
                this.educationalID = educationalID;
            } else {
                JOptionPane.showMessageDialog(null, "          educationalID " + educationalID + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
                sw = 0;
            }
        }
        if (isPasswordValid(password)) {
            this.password = password;
        } else {
            JOptionPane.showMessageDialog(null, "          password " + password + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
        }
        if (repeatPassword.equals(password)) {
            this.repeatPassword = repeatPassword;
        } else {
            JOptionPane.showMessageDialog(null, "          repeatPassword " + repeatPassword + " is not valid!!", "SignUp Failed!!", JOptionPane.PLAIN_MESSAGE);
            sw = 0;
           }
        if (sw == 1) {
            home.userList[home.userCount]=new User(this,home);
            home.userCount++;
            home.userList[home.userCount-1].menu();
            frame.dispose();
        }
    }
    public static boolean isValidInput1(String input){
        return input.matches("^[a-zA-Z ]{1,18}$");
    }
    public static boolean isUsernameValid(String input){
        return input.matches("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9]{5,12}$");
    }
    public static boolean isEducationalIDValid(String educationalID, String string){
        if (string.equals("student")) return educationalID.matches("\\d{10}");
        else if (string.equals("professor")) return educationalID.matches("\\d{6}");
        else if (string.equals("official")) return educationalID.matches("\\d{4}");
        return false;
    }
    public static boolean isEmailValid(String input){
        return input.matches("^[a-zA-Z0-9.]{1,18}@[a-z.-]{1,8}\\.[a-z]{1,4}");
    }
    public static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.matches("09\\d{9}");
    }
    public boolean setUserRole(String userRole) {
        if (userRole.equals("student") || userRole.equals("professor") || userRole.equals("official")){this.userRole = userRole;return true;}
        else return false;
    }
    public String getUserRole() {
        return this.userRole;
    }
    public static boolean isPasswordValid(String input){
        return input.matches("^(?=.*[a-zA-Z0-9])[a-zA-Z0-9]{8,12}$");
    }
    public void signUpPanel(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        panel.setBounds(600,100,350,500);
        panel.setLayout(new GridLayout(10,2));
        panel.add(new JLabel("firstname:"));
        JTextField first=new JTextField(0);
        panel.add(first);
        panel.add(new JLabel("lastname:"));
        JTextField last=new JTextField(0);
        panel.add(last);
        panel.add(new JLabel("username:"));
        JTextField user=new JTextField(0);
        panel.add(user);
        panel.add(new JLabel("filedOfStudy:"));
        JTextField field=new JTextField(0);
        panel.add(field);
        panel.add(new JLabel("email:"));
        JTextField em=new JTextField(0);
        panel.add(em);
        panel.add(new JLabel("phoneNumber:"));
        JTextField phone=new JTextField(0);
        panel.add(phone);
        panel.add(new JLabel("userrole:"));
        JTextField role=new JTextField(0);
        panel.add(role);
        panel.add(new JLabel("educationalID:"));
        JTextField id=new JTextField(0);
        panel.add(id);
        panel.add(new JLabel("password:"));
        JPasswordField pass=new JPasswordField(0);
        panel.add(pass);
        panel.add(new JLabel("repeatPassword:"));
        JPasswordField repeat=new JPasswordField(0);
        panel.add(repeat);
        JButton signUpButton=new JButton("SignUp");
        signUpButton.setBounds(625,610,300,50);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strpass=new String(pass.getPassword());
                String strrepeat=new String(repeat.getPassword());
                checkSignUp(first.getText(),last.getText(),field.getText(),user.getText(),id.getText(),em.getText(),phone.getText(),role.getText(),strpass,strrepeat);
            }
        });
        frame.add(signUpButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}
