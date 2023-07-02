package game.gui.jswing;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

public class Frame extends JFrame{

    private Color background = new Color(22, 21, 18);

    public Frame(int sizeX, int sizeY) {
        this.setTitle("Resgate na ilha de java");

        this.setSize(sizeX, sizeY);

        this.getContentPane().setBackground(background);
        
        centerFrame();

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void centerFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth())/2;
        int y = (screenSize.height - getHeight())/2;
        setBounds(x, y, getWidth(), getHeight());
    }
}
