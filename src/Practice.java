import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practice {
    public String name;
    public String status;
    public double time;
    public void practicePage(JFrame frame){
        JDialog info = new JDialog(frame,name+" practice",true);
        info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        info.setBounds(550, 300, 400, 250);
        info.setLayout(null);
        JPanel infoPanel = new JPanel();
        infoPanel.setSize(400, 250);
        infoPanel.setLayout(null);
        JLabel label=new JLabel("practice: "+name+"\n"+"remaining time: "+time+"\n"+"delivery status: "+status);
        label.setBounds(10,10,100,100);
        infoPanel.add(label);
        JLabel questionlabel=new JLabel("do you want to deliver the practice?");
        questionlabel.setBounds(10,10,100,100);
        infoPanel.add(questionlabel);
        JButton button=new JButton("yes");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
