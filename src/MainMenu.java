import javax.swing.*;
import java.awt.*;

public class MainMenu {
    public JFrame frame=new JFrame();
    public JPanel classPanel=new JPanel();
    public JPanel taskPanel=new JPanel();
    public JPanel notifPanel=new JPanel();
    public JPanel profPanel=new JPanel();
    public void menu(){
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1600,900);
        frame.setLayout(null);
        classPanel.setBounds(900,100,600,450);
        classPanel.setLayout(new GridLayout(3,4));

    }
}
