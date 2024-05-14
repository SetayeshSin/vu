import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lesson {
      JFrame frame=new JFrame();
      public Exam[] examList=new Exam[5];
      public Notif[] notifList=new Notif[10];
      public Content[] contentList=new Content[20];
      public Practice[] practiceList=new Practice[5];
      public void lessonMenu(){
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
          frame.setSize(1600,900);
          frame.setLayout(null);
          JPanel examPanel=new JPanel();
          examPanel.setBounds(900,100,200,300);
          examPanel.setLayout(new GridLayout(6,1));
          JLabel exam=new JLabel("the List of Exams");
          examPanel.add(exam);
          for(int i=0;i<5;i++) {
              final int j=i;
              JButton examButton=new JButton(examList[i].name);
              if(examList[i]==null)examButton.setVisible(false);
              else{
                  examButton.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          examList[j].page();
                      }
                  });
              }
              examPanel.add(examButton);
          }
          JPanel practicePanel=new JPanel();
          practicePanel.setBounds(600,100,200,300);
          practicePanel.setLayout(new GridLayout(6,1));
          JLabel practice=new JLabel("the List of Practices");
          practicePanel.add(practice);
          for(int i=0;i<5;i++) {
              final int j=i;
              JButton practiceButton=new JButton(practiceList[i].name);
              if(practiceList[i]==null)practiceButton.setVisible(false);
              else{
                  practiceButton.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          practiceList[j].practicePage(frame);
                      }
                  });
              }
              practicePanel.add(practiceButton);
          }
          frame.add(examPanel);
          frame.add(practicePanel);
          frame.setVisible(true);
      }

}
