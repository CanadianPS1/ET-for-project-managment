package MainCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartMenu implements ActionListener{
    JFrame game;
    ImageIcon startScreenIcon;
    JButton startButton;
    public StartMenu(){
        startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");

        game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setBounds(700,300,325,240);
        game.setVisible(true);
        game.setIconImage(gameIcon.getImage());
        game.setFocusable(true);
        startButton = new JButton();
        startButton.setSize(320,210);
        startButton.setVisible(true);
        startButton.setIcon(startScreenIcon);
        
        game.add(startButton);

        game.update(game.getGraphics());
        startButton.addActionListener((ActionListener) this);       
    }
    @Override
    public void actionPerformed(ActionEvent e){
        startButton.setVisible(false);
        game.remove(startButton);
        game.update(game.getGraphics());
        System.out.println("Start Button Pressed");
        new Movement(game, 2).ETMoveFirstRun();

        SceneHandler handler = new SceneHandler(game, 2);

        handler.screenChange(0);
    }  
}
