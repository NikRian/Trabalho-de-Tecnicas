package game.gui;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.*;

import game.gui.jswing.*;

import java.awt.Color;
import java.awt.GridLayout;

public class TopMenu extends Frame {

    private JComboBox<Integer> comboBoxX, comboBoxY;
    private Panel exemplo;
    private Board board;

    public TopMenu() {
        super(400, 400);

        Panel panel = new Panel();

        this.setLayout(new GridLayout(3,1));
        this.add(panel);

        panel.add(new Text("Tamanho do tabuleiro: "));

        Integer[] numeros = new Integer[26];

        for (int i = 5; i <= 30; i++) {
            numeros[i - 5] = i;
        }

        comboBoxX = new JComboBox<>(numeros);
        comboBoxY = new JComboBox<>(numeros);

        ActionListener updateBoard = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updatePanel();
            }
        };

        comboBoxX.addActionListener(updateBoard);
        comboBoxY.addActionListener(updateBoard);

        panel.add(comboBoxX);

        panel.add(new Text(" X "));

        panel.add(comboBoxY);

        JButton continueButton = new JButton("Continuar");
        panel.add(continueButton);

        

        exemplo = new Panel();

        this.add(new Text("Prévia do Tabuleiro: "));

        int x = (Integer) (comboBoxX.getSelectedItem());
        int y = (Integer) (comboBoxY.getSelectedItem());

        board = drawBoard(x, y);
        exemplo.add(board);

        this.add(exemplo);

        this.setVisible(true);
    }

    private void updatePanel() {
      exemplo.remove(board);
        int x = (Integer) comboBoxX.getSelectedItem();
        int y = (Integer) comboBoxY.getSelectedItem();
        board = drawBoard(x, y);
        exemplo.add(board);
        exemplo.revalidate();
        exemplo.repaint();
    }

    private Board drawBoard(int maxX, int maxY) {
        Board panel = new Board(maxX, maxY, false);
        panel.setSize(450, 450);
        panel.setLocation(10, 105);
        panel.setBorder(new LineBorder(Color.BLACK));
        // panel.setBackground(background);
        return panel;
    }

    public static void main(String[] args) {
        new TopMenu();
    }
}
