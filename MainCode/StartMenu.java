package MainCode;

import java.awt.event.ActionListener;

import javax.swing.*;

public class StartMenu {
    public StartMenu(){
        ImageIcon startScreenIcon = new ImageIcon("");
        JFrame game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(320,210);
        game.setVisible(true);
        JButton startButton = new JButton();
        startButton.setVisible(true);
        startButton.setOpaque(true);
        game.add(startButton);

        game.getGraphics();
        startButton.addActionListener((ActionListener) this);
    }
}
