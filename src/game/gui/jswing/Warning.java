package game.gui.jswing;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Color;

public class Warning {

    private Color background = new Color(22, 21, 18);
    private Color textColor = new Color(171, 171, 171);

    public Warning(String text) {

        UIManager.put("OptionPane.background", background);
        UIManager.put("Panel.background", background);
        UIManager.put("OptionPane.messageForeground", textColor);

        JOptionPane.showMessageDialog(null, text, "ERROR", JOptionPane.INFORMATION_MESSAGE);
    }
}
