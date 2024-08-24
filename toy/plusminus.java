package toy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class plusminus {
    JFrame frame;
    int num = 0;
    JTextField textField;

    plusminus() {
        frame = new JFrame("더하기빼기");
        frame.setSize(400, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        textField = new JTextField();
        textField.setText(String.valueOf(num));
        frame.add(textField, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        frame.add(panel, BorderLayout.SOUTH);
        String[] names = new String[] {"1","2","3"};
        for (String text : names) {
            JButton buttons = new JButton(text);
            buttons.addActionListener(new buttonAction());
            panel.add(buttons);
        }
    }

    class buttonAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.charAt(0) == '1') {
                num += 1;
                textField.setText(String.valueOf(num));
            } else if (command.charAt(0) == '2') {
                num += 2;
                textField.setText(String.valueOf(num));
            } else {
                num += 3;
                textField.setText(String.valueOf(num));
            }
        }
    }

    public static void main(String[] args) {
        new plusminus();
    }
}
