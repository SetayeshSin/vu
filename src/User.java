import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User {
    public SignUp signUpInfo;
    public JFrame frame=new JFrame();
    public JPanel classPanel=new JPanel();
    public JPanel taskPanel=new JPanel();
    public JPanel notifPanel=new JPanel();
    public JPanel profPanel=new JPanel();
    public Home home;
    public User(SignUp signUpInfo,Home home){
        this.signUpInfo=signUpInfo;
        this.home=home;
    }
    public void menu(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        profPanel.setBounds(100,100,100,100);
        profPanel.setLayout(new GridLayout(2,1));
       // profPanel.add(new JLabel(signUpInfo.firstName +" " + signUpInfo.lastName));
        profPanel.add(new JLabel(signUpInfo.educationalID));
       // classPanel.setBounds(900,100,600,450);
      //  classPanel.setLayout(new GridLayout(3,4));
        JButton homeButton=new JButton("Home");
        homeButton.setBounds(100,250,100,70);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home.homePage();
                frame.dispose();
            }
        });
        frame.add(homeButton);
        frame.add(profPanel);
        frame.setVisible(true);
    }
}
