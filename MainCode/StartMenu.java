package MainCode;

import java.awt.event.*;
import javax.swing.*;

public class StartMenu implements ActionListener{
    JFrame game;
    ImageIcon startScreenIcon;
    JButton startButton;
    public StartMenu(){
        startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");



        game = new JFrame();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(335,249);
        game.setVisible(true);
        startButton = new JButton();
        startButton.setSize(320,210);
        startButton.setVisible(true);
        startButton.setIcon(startScreenIcon);

        //game.add(startScreenLabel);
        game.add(startButton);


        game.getGraphics();
        startButton.addActionListener((ActionListener) this);
    
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        startButton.setVisible(false);
        game.getGraphics();
        System.out.println("Start Button Pressed");
    }
    
}
