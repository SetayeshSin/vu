import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
public class Home {
    public JFrame frame;
    public JPanel panel;
    public Home home=this;
    public Student[] studentList=new Student[1000];
    public int studentCount=0;
    public Professor[] professorList=new Professor[1000];
    public int professorCount=0;
    public Official[] officialList=new Official[1000];
    public int officialCount=0;
    public void homePage(){
        frame=new JFrame();
        panel=new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        JLabel time=new JLabel();
        time.setBounds(700,100,200,50);
        LocalDateTime current=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formatterTime=current.format(formatter);
        time.setText(formatterTime);
        frame.add(time);
        panel.setBounds(600,300,350,200);
        panel.setLayout(new GridLayout(2,1));
        JButton loginButton=new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login log=new Login(home);
                log.loginPanel();
                frame.dispose();
            }
        });
        JButton signUpButton=new JButton("SignUp");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUp signUp=new SignUp(home);
                signUp.signUpPanel();
                frame.dispose();
            }
        });
        panel.add(loginButton);
        panel.add(signUpButton);
        frame.add(panel);
        frame.setVisible(true);
    }
}
