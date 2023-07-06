package game.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import java.util.ArrayList;

import game.gui.jswing.Panel;
import game.gui.jswing.Text;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class controlPanel extends Panel{

    private mainFrame mainFrame;
	
	private Text points;
	
	private Text labelAlunos;
	

	private Text labelBugs;
	
	private ArrayList<Text> robotLabel;
	

	private ArrayList<controllButton> robotButton;
	

	private JButton botaoResetar;
	

	private JButton botaoProsseguir;
	

	private JButton botaoSair;

    public controlPanel(mainFrame mainFrame) {

        this.mainFrame = mainFrame;

        points = new Text("PONTUAÇÃO: 0");
        points.setHorizontalAlignment(Text.CENTER);
        this.add(points);

        labelAlunos = new Text("ALUNOS: 0");
        labelAlunos.setHorizontalAlignment(Text.CENTER);
        labelAlunos.setIcon(Images.STUDENT.getImage());
        this.add(labelAlunos);

        labelBugs = new Text("BUGS: 0");
        labelBugs.setHorizontalAlignment(Text.CENTER);
        labelBugs.setIcon(Images.BUG.getImage());
        this.add(labelBugs);

        Panel robotPanel = new Panel();

        robotPanel.setLayout(new GridLayout(1, 3));
        robotLabel = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            Text points = new Text("ROBO " + i + ": 0");
            points.setHorizontalAlignment(Text.CENTER);

            ImageIcon icon = Images.values()[i - 1].getImage();
            points.setIcon(icon);

            robotLabel.add(points);
            robotPanel.add(points);
        }

        this.add(robotPanel);

        setLayout(new GridLayout(4, 1));

        robotButton = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            controllButton botao = new controllButton(this, i);
            robotButton.add(botao);
            add(botao);
        }

        botaoResetar = new JButton("Resetar");
        //botaoResetar.addActionListener(new AcaoResetar());
        //botaoResetar.setBackground(new Color(0xb6b6b6));
        add(botaoResetar);

        botaoProsseguir = new JButton("Prosseguir");
        //botaoProsseguir.addActionListener(new AcaoProsseguir());
        //botaoProsseguir.setBackground(new Color(0xb6b6b6));
        add(botaoProsseguir);

        botaoSair = new JButton("Terminar Jogo");
        //botaoSair.addActionListener(new AcaoSair());
        //botaoSair.setBackground(new Color(0xb6b6b6));
        add(botaoSair);

    }

    public mainFrame getMainFrame() {
        return mainFrame;
    }

    public ArrayList<controllButton> getRobotButton() {
		return robotButton;
	}
}
