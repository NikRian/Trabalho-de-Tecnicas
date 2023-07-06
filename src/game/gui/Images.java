package game.gui;

import javax.swing.ImageIcon;

public enum Images {

	STUDENT("images/student.png"),
	BUG("images/bug.png"),
	ROBOT1("images/robo1.png"),
	ROBOT2("images/robo2.png"),
	ROBOT3("images/robo3.png");

    private ImageIcon image;

    private Images(String name) {
        image = new ImageIcon(name);
    }

    public ImageIcon getImage() {
		return image;
	}
}
