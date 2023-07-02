package game.gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;

public class Board extends JPanel {

    private Color cellWhite = new Color(240, 217, 181);
    private Color cellBlack = new Color(181, 136, 99);
    //private JPanel selectedCell = null;

    public Board(int maxX, int maxY, boolean interactable) {

        this.setBorder(new LineBorder(Color.BLACK));

        setLayout(new GridLayout(maxX, maxY));

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                JPanel cell = createCell(x, y, interactable);
                add(cell);
            }
        }
    }

    private JPanel createCell(int x, int y, boolean interactable) {
        
        JPanel cell = new JPanel();
        cell.setBackground((x + y) % 2 == 0 ? cellWhite : cellBlack);

        if(interactable) {
            cell.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        return cell;
    }
}
