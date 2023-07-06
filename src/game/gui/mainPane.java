package game.gui;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

import game.gui.jswing.Panel;
import game.gui.jswing.Text;
import game.gui.jswing.Warning;

import java.awt.event.*;
import java.awt.Dimension;
import java.awt.GridLayout;

public class mainPane extends Panel {

    private JTextField nameBox;
    private JButton playButton;
	private mainFrame mainFrame;

    public mainPane(mainFrame mainFrame) {

		this.mainFrame = mainFrame;
        this.setPreferredSize(new Dimension(800, 100));
		this.setLayout(new GridLayout(1, 3, 10,10));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 50));
		
		this.add(new Text("Nome do Jogador:"));
		nameBox = new JTextField();
		nameBox.setHorizontalAlignment(JTextField.CENTER);
		
		this.nameBox.setPreferredSize(new Dimension(300, 50));
		this.add(nameBox);
		
		playButton = new JButton("Jogar");
		playButton.addActionListener(new gameStart());
		this.add(playButton);
    }

	/*public void setPlayButton(boolean state) {
		playButton.setEnabled(state);
	}

	public void setNameBox(boolean state) {
		nameBox.setEnabled(state);
	}*/

	private boolean verifyNameBox() {
		return nameBox.getText().isBlank();
	}

	public String getPlayerName() {
		return nameBox.getText();
	}

	private class gameStart implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (verifyNameBox()) {
				new Warning("Nome do Jogador não pode ser vazio!");
				return;
			}

			mainFrame.getGame().startGame();
		}
	}
}
