package toy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class rockpaper {
    Random random = new Random();
    JFrame frame;
    JTextField text1;
    JTextField text2;
    int num1 =0;

    public rockpaper() {
        frame = new JFrame("가위바위보");
        frame.setSize(400,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        text1 = new JTextField();
        text2 = new JTextField();

        String[] buttonnames = new String[] {
                "가위" , "바위", "보"
        };

        for (String text : buttonnames) {
            JButton buttons = new JButton(text);
            buttons.addActionListener(new rockbuttonlisten());
            panel.add(buttons);
        }
        text1.setText(text1.getText()+"아래 버튼 중 하나 클릭");
        frame.add(panel,BorderLayout.CENTER);
        frame.add(text1,BorderLayout.NORTH);
        frame.add(text2,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    class rockbuttonlisten implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int rock = random.nextInt(3) + 1;
            //1은 가위 2는 바위 3은 보
            String command = e.getActionCommand();
            if (command.charAt(0) == '가') {
                switch (rock) {
                    case 1 :
                        text2.setText("비겼습니다.");
                        break;
                    case 2 :
                        text2.setText("졌습니다.");
                        break;
                    case 3 :
                        text2.setText("이겼습니다.");
                        break;
                }
            } else if (command.charAt(0) == '바') {
                switch (rock) {
                    case 1 :
                        text2.setText("이겼습니다.");
                        break;
                    case 2 :
                        text2.setText("비겼습니다.");
                        break;
                    case 3 :
                        text2.setText("졌습니다.");
                        break;
                }
            } else if(command.charAt(0) == '보') {
                switch (rock) {
                    case 1 :
                        text2.setText("졌습니다.");
                        break;
                    case 2 :
                        text2.setText("이겼습니다.");
                        break;
                    case 3 :
                        text2.setText("비겼습니다.");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        new rockpaper();
    }
}
