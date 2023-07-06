package game.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.*;

import game.core.pieces.robots.Robot;

import java.awt.Image;
import java.awt.Color;

public class controllButton extends JButton{

    public static final Color unlocked = Color.BLUE;
	
    public static final Color locked = Color.RED;

    private controlPanel controlPanel;

    private boolean selected;

    private int id;

    private ImageIcon icon;


    public controllButton(controlPanel controlPanel, int id) {
    
        this.id = id;
        createIcon(Images.values()[id - 1]);
        on();
        addActionListener(new selectRobot());
    }

    private void createIcon(Images image) {
		icon = new ImageIcon(image.getImage().getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
	}

    public void on() {
		this.setIcon(icon);
		setDisabledIcon(null);
		
		setBackground(unlocked);
		setEnabled(true);
		selected = false;
	}

    public boolean isSelected() {
        return selected;
    }

    public int getId() {
        return id;
    }

    public Robot getSelectedRobot() {
		return controlPanel.getMainFrame().getGame().getBoard().getRobo(id);
	}

    public void unlock() {
		setIcon(icon);
		setDisabledIcon(null);
		
		setBackground(unlocked);
		setEnabled(true);
		selected = false;
	}

	public void lock() {
		
		if (getSelectedRobot().isOk()) {
			setIcon(null);
			setDisabledIcon(null);
		} else {
			setIcon(icon);
			setDisabledIcon(icon);
		}
		
		setBackground(locked);
		setEnabled(false);
		selected = false;
	}

    public void select() {
		setIcon(icon);
		setDisabledIcon(null);
		
		setBackground(unlocked);
		setEnabled(false);
		selected = true;
		
		for (controllButton button : controlPanel.getRobotButton()) {
			if (!button.equals(controllButton.this))
				button.lock();
		}
	}

    private class selectRobot implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			select();
			controlPanel.getMainFrame().getGridPanel();
		}
	}
    
}
