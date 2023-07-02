package game.gui;

import javax.swing.JPanel;

import game.gui.jswing.Frame;

public class GameFrame extends Frame{

    public GameFrame(int boardX, int boardY) {

        super(800, 800);

        this.setLayout(null);

        JPanel panel = createBoard(boardX, boardY);
        this.add(panel);

    }

    private Board createBoard(int maxX, int maxY) {
        Board panel = new Board(maxX, maxY,true);
        panel.setSize(450, 450);
        panel.setLocation(10,105);
        
        return panel;
    }    
}
