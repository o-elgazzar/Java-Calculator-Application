import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    static double firstNumber = 0;
    static double secondNumber = 0;
    static String operation = null;
    static boolean startNew = true;

    public static double performOperation(double firstNum, double secondNum, String op) {
        switch (op) {
            case "+": return firstNum + secondNum;
            case "-": return firstNum - secondNum;
            case "*": return firstNum * secondNum;
            case "/": return secondNum != 0 ? firstNum / secondNum : 0;
            default: return 0;
        }
    }

    public static void main(String[] args) {

            JFrame frame = new JFrame("Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,400);

            JTextField display =  new JTextField(20);
            display.setEditable(false);
            display.setHorizontalAlignment(SwingConstants.RIGHT);
            frame.getContentPane().add(display);
        
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4,4));

            display.setFont(new Font("SansSerif", Font.BOLD, 24));
            display.setPreferredSize(new Dimension(280, 50));

            frame.setLayout(new BorderLayout());
            frame.add(display, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

        String[][] buttonLabels = {
                {"7", "8", "9", "+"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "*"},
                {"0", "C", "=", "/"}
            };

        for(int i = 0; i < buttonLabels.length; i++) {
            for(int j = 0; j < buttonLabels[i].length;j++) {
                String label = buttonLabels[i][j];
                JButton button = new JButton(label);
                button.setActionCommand(label);
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String command = e.getActionCommand();
                        if (command.matches("[0-9]")) {
                            if (startNew) {
                                display.setText(command);
                                startNew = false;
                            } else {
                                display.setText(display.getText() + command);
                            }
                        } else if (command.matches("[+\\-*/]")) {
                            firstNumber = Double.parseDouble(display.getText());
                            operation = command;
                            startNew = true;
                        } else if (command.equals("=")) {
                            secondNumber = Double.parseDouble(display.getText());
                            double result = performOperation(firstNumber, secondNumber, operation);
                            display.setText(String.valueOf(result));
                            startNew = true;
                        } else if (command.equals("C")) {
                            display.setText("");
                            startNew = true;
                        }
                    }
                });
                panel.add(button);
            }
        }

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
