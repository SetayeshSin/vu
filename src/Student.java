import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student {
    public SignUp signUpInfo;
    public JFrame frame=new JFrame();
    public Lesson[] lessonsList=new Lesson[12];
    public int lessonCount;
    public JPanel lessonPanel;
    public JPanel taskPanel=new JPanel();
    public JPanel notifPanel=new JPanel();
    public JPanel stuPanel;
    public Home home;
    public Student(SignUp signUpInfo,Home home){
        this.signUpInfo=signUpInfo;
        this.home=home;
    }
    public void menu(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        stuPanel=new JPanel();
        stuPanel.setBounds(100,100,200,100);
        stuPanel.setLayout(new GridLayout(2,1));
        stuPanel.add(new JLabel(signUpInfo.firstName + " " + signUpInfo.lastName));
        stuPanel.add(new JLabel(signUpInfo.educationalID));
        lessonPanel=new JPanel();
        lessonPanel.setBounds(900,100,600,450);
        lessonPanel.setLayout(new GridLayout(3,4));
        for(int i=0;i<12;i++){
            final int j=i;
            JButton lessonButton=new JButton();
            if(lessonsList[i]==null)lessonButton.setVisible(false);
            else{
            lessonButton.setText(lessonsList[i].name);
            lessonButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lessonsList[j].stuLessonMenu();
                }
            });
            }
            lessonPanel.add(lessonButton);
        }
        JButton homeButton=new JButton("Home");
        homeButton.setBounds(100,600,100,70);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(stuPanel);
                frame.dispose();
                home.homePage();
            }
        });
        frame.add(homeButton);
        frame.add(stuPanel);
        frame.add(lessonPanel);
        frame.setVisible(true);
    }
}