package guiVersion;

import javax.swing.*;

public class GuessTheNumberGuiApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessGUI().setVisible(true);
            }
        });
    }
}
