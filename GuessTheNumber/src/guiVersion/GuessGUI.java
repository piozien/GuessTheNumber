package guiVersion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



    public class GuessGUI extends JFrame {
        private JTextField guessTextField;
        private JTextArea resultArea;
        private JButton guessButton;
        private GuessLogicGUI guessLogic;

        public GuessGUI() {
            super("Game - Guess The Number");

            // closing gui terminates the program
            setDefaultCloseOperation(EXIT_ON_CLOSE);

            // Increase the size of the window
            setSize(600, 450);


            getContentPane().setBackground(new Color(157, 245, 239));

            // load GUI in the middle of the screen
            setLocationRelativeTo(null);

            // make layout manager null to manually position  components within the gui
            setLayout(null);

            // prevent any resize of our gui
            setResizable(false);

            addComponents();

            guessLogic = new GuessLogicGUI();
        }

        private void addComponents() {
            JLabel introLabel = new JLabel("<html>Hi, it's a guess the number game! You have 4 attempts to correctly predict a number between 1 and 100. Good luck!</html>");
            // Adjusted bounds to fit the wider window
            introLabel.setBounds(15, 20, 560, 60);
            // set font
            introLabel.setFont(new Font("Fibra", Font.PLAIN, 14));
            // set horizontal center for introLabel
            introLabel.setHorizontalAlignment(SwingConstants.CENTER);
            add(introLabel);

            guessTextField = new JTextField();
            // Adjusted bounds to fit the wider window
            guessTextField.setBounds(15, 96, 560, 36);
            // set border
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
            guessTextField.setBorder(border);
            // set font
            guessTextField.setFont(new Font("Fibra", Font.PLAIN, 20));
            // set background color
            guessTextField.setBackground(new Color(178, 234, 118, 249));

            guessTextField.setHorizontalAlignment(SwingConstants.CENTER);
            add(guessTextField);

            guessButton = new JButton("Guess");
            // Adjusted bounds to center the button
            guessButton.setBounds(220, 146, 150, 50);
            guessButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guessAction();
                }
            });
            add(guessButton);

            resultArea = new JTextArea();
            resultArea.setEditable(false);
            // line wrap for result text
            resultArea.setLineWrap(true);
            // Adjusted bounds to fit the wider window
            resultArea.setBounds(15, 206, 560, 280);

            resultArea.setFont(new Font("Fibra", Font.PLAIN, 14));
            resultArea.setBackground(new Color(157, 245, 239));
            JScrollPane scrollPane = new JScrollPane(resultArea);
            // Adjusted bounds to fit the wider window
            scrollPane.setBounds(15, 206, 560, 280);
            add(scrollPane);
        }

        private void guessAction() {
            String input = guessTextField.getText();
            try {
                int guess = Integer.parseInt(input);
                String result = guessLogic.checkGuess(guess);
                resultArea.append(result + "\n");
                if (!result.contains("Attempts left")) {
                    guessButton.setEnabled(false);
                    guessTextField.setEnabled(false);
                }
            } catch (NumberFormatException ex) {
                resultArea.append("Please enter a valid number!\n");
            }
        }
    }

