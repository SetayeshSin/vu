import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login {
    public JFrame frame=new JFrame();
    public JPanel panel=new JPanel();
    public Home home;
    public Login(Home home){
        this.home=home;
    }
    public void checkInfo(String id,String pass){
        int sw=0;
        System.out.println(home.studentCount);
        if(home.studentCount==0&&home.professorCount==0&&home.officialCount==0) {
            JOptionPane.showMessageDialog(null, "                     user not founded!!", "Login Failed!!", JOptionPane.PLAIN_MESSAGE);
        }
        else{
            System.out.println(home.studentCount);
            for (int i = 0; i < home.studentCount&&sw==0; i++) {
                //if (educationalID.equals(home.userList[i].signUpInfo.educationalID) && password.equals(home.userList[i].signUpInfo.password)) {
                if (home.studentList[i].signUpInfo.educationalID.equals(id) && home.studentList[i].signUpInfo.password.equals(pass)) {
                    sw=1;
                    home.studentList[i].menu();
                    frame.dispose();
                }
            }
            for (int i = 0; i < home.officialCount&&sw==0; i++) {
                //if (educationalID.equals(home.userList[i].signUpInfo.educationalID) && password.equals(home.userList[i].signUpInfo.password)) {
                if (home.officialList[i].signUpInfo.educationalID.equals(id) && home.officialList[i].signUpInfo.password.equals(pass)) {
                    home.officialList[i].menu();
                    frame.dispose();
                    sw=1;
                }
            }
            for (int i = 0; i < home.professorCount&&sw==0; i++) {
                //if (educationalID.equals(home.userList[i].signUpInfo.educationalID) && password.equals(home.userList[i].signUpInfo.password)) {
                if (home.professorList[i].signUpInfo.educationalID.equals(id) && home.professorList[i].signUpInfo.password.equals(pass)) {
                    home.professorList[i].menu();
                    frame.dispose();
                    sw=1;
                }
            }
           if(sw==0)JOptionPane.showMessageDialog(null, "                     user not founded!!", "Login Failed!!", JOptionPane.PLAIN_MESSAGE);
       }
    }
    public void loginPanel(){
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.setSize(1600,900);
         frame.setLayout(null);
         panel.setBounds(600,300,350,100);
         panel.setLayout(new GridLayout(2,2));
         panel.add(new JLabel("educationalID:"));
         JTextField text=new JTextField(0);
         panel.add(text);
         panel.add(new JLabel("password:"));
         JPasswordField pass=new JPasswordField(0);
         panel.add(pass);
         JButton loginButton=new JButton("Login");
         loginButton.setBounds(625,410,300,50);
         loginButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String educationalId=text.getText();
                 String password=new String(pass.getPassword());
                 checkInfo(educationalId,password);
             }
         });
       frame.add(loginButton);
       frame.add(panel);
       frame.setVisible(true);
    }
}
