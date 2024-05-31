import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class User {
    public SignUp signUpInfo;
    public JFrame frame=new JFrame();
    public Lesson[] lessonsList=new Lesson[12];
    public JPanel lessonPanel;
    public JPanel taskPanel=new JPanel();
    public JPanel notifPanel=new JPanel();
    public JPanel profPanel;
    public Home home;
    public User(SignUp signUpInfo,Home home){
        this.signUpInfo=signUpInfo;
        this.home=home;
    }
    public void menu(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        profPanel=new JPanel();
        profPanel.setBounds(100,100,200,100);
        profPanel.setLayout(new GridLayout(2,1));
        profPanel.add(new JLabel(signUpInfo.firstName + " " + signUpInfo.lastName));
        profPanel.add(new JLabel(signUpInfo.educationalID));
        lessonPanel=new JPanel();
        lessonPanel.setBounds(900,100,600,450);
        lessonPanel.setLayout(new GridLayout(3,4));
        /*for(int i=0;i<12;i++){
            final int j=i;
            JButton lessonButton=new JButton();
            //   if(lessonsList[i]==null)lessonButton.setVisible(false);
            //    else{
            lessonButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lessonsList[j].lessonMenu();
                }
            });
            //   }
            lessonPanel.add(lessonButton);
        }*/
        JButton homeButton=new JButton("Home");
        homeButton.setBounds(100,600,100,70);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profPanel);
                frame.dispose();
                home.homePage();
            }
        });
        frame.add(homeButton);
        frame.add(profPanel);
        frame.add(lessonPanel);
        frame.setVisible(true);
    }
}
