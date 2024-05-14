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
        ifelse: if(home.userCount==0) {
            JOptionPane.showMessageDialog(null, "                     user not founded!!", "Login Failed!!", JOptionPane.PLAIN_MESSAGE);
        }
       else{
            for (int i = 0; i < home.userCount; i++) {
               //if (educationalID.equals(home.userList[i].signUpInfo.educationalID) && password.equals(home.userList[i].signUpInfo.password)) {
                if(home.userList[i].signUpInfo.educationalID.equals(id)&&home.userList[i].signUpInfo.password.equals(pass)){
                    home.userList[i].menu();
                    frame.dispose();
                    break ifelse;
                }
            }
           JOptionPane.showMessageDialog(null, "                     user not founded!!", "Login Failed!!", JOptionPane.PLAIN_MESSAGE);
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
