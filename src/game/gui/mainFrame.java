package game.gui;

import game.gui.jswing.Panel;

import game.Game;
import game.gui.jswing.Frame;

import java.awt.BorderLayout;

public class mainFrame extends Frame{

    private boolean gameMode;
    private mainPane mainPane;
    private Panel controlPanel, gridPanel;
    private Game game;

    public mainFrame(Game game) {
      super(800, 100);

      this.game = game;

      gameMode = false;
      mainPane = new mainPane(this);
      controlPanel = new controlPanel(this);
      gridPanel = new Panel();

      this.setLayout(new BorderLayout());
      this.add(mainPane, BorderLayout.CENTER);

      this.setVisible(true);
    }

    public void changeGameMode() {

      if(gameMode) {
        return;
      }

        gameMode = true;

        //gridPanel.update();
        //controlPanel.updateInformacoes();

        this.remove(mainPane);
        
        this.setSize(800, 600);
        this.add(controlPanel, BorderLayout.EAST);
        this.add(gridPanel, BorderLayout.WEST);
        
        updateUI();
	  }

    public Panel getGridPanel() {
        return gridPanel;
    }

    public mainPane getMainPane() {
        return mainPane;
    }

    public Game getGame() {
		  return game;
	  }
}
