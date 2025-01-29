//makes the starting screen and lets you click it
package MainCode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
public class StartMenu implements ActionListener{
    protected JFrame game;
    private final ImageIcon startScreenIcon;
    private final JButton startButton;
    //makes the JFrame and puts a button in it so you can start the game
    public StartMenu(){
        startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
        game = new JFrame("Extra Terrestrial");
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
    //the method for when you click the button
    //it disables its self then makes ET and all that jazz
    @Override
    public void actionPerformed(ActionEvent e){
        startButton.setVisible(false);
        game.remove(startButton);
        game.update(game.getGraphics());
        System.out.println("Start Button Pressed");
        new Movement(game).ETMoveFirstRun();


        new SceneHandler(game).setTile(4);;

    }  
}
