import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator {
    public static void main(String[] args) {

        //Calculator Window
        JFrame frame = new JFrame("Calculator"); // Creates a window with the title Calculator
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Instructs program to close window when exited by user
        frame.setSize(300,400); // Sets the dimensions of the application

        //Displays Text
        JTextField display = new JTextField(20); // Creates a text display of the calculator that can take 20 numbers showing at once
        display.setEditable(false); // Makes it so that you cant edit the text display
        display.setHorizontalAlignment(SwingConstants.RIGHT); // Makes it so that all numbers start from right side at all times
        frame.getContentPane().add(display); // Adds the display to the contentPane , the contentPane is the container of all UI components

        JPanel panel = new JPanel(); // Creates a new panel section
        panel.setLayout(new GridLayout(4,4)); // This panel section will be the layout of the calculator where it will be 4 by 4 which
        // has the numbers 0-9 and all the operator signs

        //ContentPane is the big box containing all the smaller boxes in it which are the panels

        //Buttons
        
        //Instead of manually having to create a button for every single number and operator 
        //we will put it into a 2D array and then use nested for loops
        // to create  button functions for each one in the array
        //this is a better and faster approach
        
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
                        display.setText(command);
                    }
                });
                panel.add(button);
            }
        }

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);



    }
}
