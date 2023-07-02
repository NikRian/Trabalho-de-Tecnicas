package game.gui.jswing;

import javax.swing.JLabel;

import java.awt.Color;

public class Text extends JLabel{

    private Color textColor = new Color(171, 171, 171);

    public Text(String text) {

        super(text);

        setForeground(textColor);
    }   
}