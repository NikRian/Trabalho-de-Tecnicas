package game.gui;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;

public class BoardView extends JPanel {

    private Color cellWhite = new Color(240, 217, 181);
    private Color cellBlack = new Color(181, 136, 99);

    public BoardView(int maxX, int maxY) {

        this.setBorder(new LineBorder(Color.BLACK));

        setLayout(new GridLayout(maxX, maxY));

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                JPanel cell = createCell(x, y);
                add(cell);
            }
        }
    }

    private JPanel createCell(int x, int y) {
        
        JPanel cell = new JPanel();
        cell.setBackground((x + y) % 2 == 0 ? cellWhite : cellBlack);
        
        return cell;
    }
}
