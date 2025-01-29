//this class controls ETs movement and super classes GreatComputer and ScreenHandler
package MainCode;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Movement implements KeyListener{
    protected JFrame game;
    protected JLabel ET;
    private int moveAnimationSpot = 0;
    private int location; // this is where ET starts the game
    private final ImageIcon ETIdle = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
    private final ImageIcon ETMoveOne = new ImageIcon("seperated sprites\\E.T\\ETWalk01.png");
    private final ImageIcon ETMoveTwo = new ImageIcon("seperated sprites\\E.T\\ETWalk02.png");
    private final ImageIcon ETFlyOne = new ImageIcon("seperated sprites\\E.T\\ETStretch01.png");
    private final ImageIcon ETFlyTwo = new ImageIcon("seperated sprites\\E.T\\ETStretch02.png");
    private final ImageIcon ETFlyThree = new ImageIcon("seperated sprites\\E.T\\ETStretch03.png");
    protected SceneHandler handler;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    protected int energy = 9999;
    public Movement(JFrame g){
        game = g;
        handler = new SceneHandler(g);
    }
    public Movement(){
    }
    //Makes ET and starts the detectives movement
    public void ETMoveFirstRun(){    
        location = 4;    
        game.addKeyListener(this);
        ET = new JLabel(ETIdle);
        ET.setVisible(true);
        ET.setSize(16,17);
        ET.setLocation(100,100);
        game.add(ET);
        handler.setTile(location, ET);
        GreatComputer detective = new GreatComputer(game);
        Runnable computerMovment = () -> {
            detective.move(ET);
        };
        scheduler.scheduleAtFixedRate(computerMovment, 5, 500, TimeUnit.MILLISECONDS);
        Thread aiMoving = new Thread(computerMovment);
        aiMoving.start();
    }
    //Plays ETs animaton for when hes walking
    public JLabel ETMoveAnimation(JLabel ET){
        switch (moveAnimationSpot) {
            case 0 -> {
                ET.setIcon(ETMoveOne);
                moveAnimationSpot = 1;
            }
            case 1 -> {
                ET.setIcon(ETMoveTwo);
                moveAnimationSpot = 2;
            }
            case 2 ->{
                ET.setIcon(ETMoveOne);
                moveAnimationSpot = 1;
            }
            default -> {
                ET.setIcon(ETIdle);
                moveAnimationSpot = 0;
            }
        }
        return ET;
    }
    //Plays ETs second animation for when he flys
    public JLabel ETFlyAnimation(JLabel ET){
        switch (moveAnimationSpot) {
            case 0 -> {
                ET.setIcon(ETFlyOne);
                moveAnimationSpot = 1;
            }
            case 1 -> {
                ET.setIcon(ETFlyTwo);
                moveAnimationSpot = 2;
            }
            case 2 ->{
                ET.setIcon(ETFlyThree);
                moveAnimationSpot = 3;
            }
            default -> {
                ET.setIcon(ETFlyThree);
            }
        }
        return ET;
    }
    //these methods are for detecting keypresses then moving ET to those spots
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(energy > 0){
            switch (key) {
                case KeyEvent.VK_W -> {
                    ETMoveAnimation(ET);
                    ET.setLocation(ET.getX(), ET.getY() - 2);
                }
                case KeyEvent.VK_A -> {
                    ET.setLocation(ET.getX() - 2, ET.getY());
                    ETMoveAnimation(ET);
                }
                case KeyEvent.VK_S -> {
                    ET.setLocation(ET.getX(), ET.getY() + 2);
                    ETMoveAnimation(ET);
                }
                case KeyEvent.VK_D -> {
                    ET.setLocation(ET.getX() + 2, ET.getY());
                    ETMoveAnimation(ET);
                }
                //once var is made we need to add && etInHole into the if statment for the space bar
                case KeyEvent.VK_SPACE -> {
                    ET.setLocation(ET.getX(), ET.getY() - 2);
                    ETFlyAnimation(ET);
                    energy = energy - 18;
                }
                default -> {
                }
            }
            energy--;
        }

        location = handler.detectLREdge(ET, location);
        location = handler.detectUDEdge(ET, location);
    }
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_SPACE) {
            ET.setIcon(ETIdle);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W -> ET.setLocation(ET.getX(), ET.getY() - 5);
            case KeyEvent.VK_A -> ET.setLocation(ET.getX() - 5, ET.getY());
            case KeyEvent.VK_S -> ET.setLocation(ET.getX(), ET.getY() + 5);
            case KeyEvent.VK_D -> ET.setLocation(ET.getX() + 5, ET.getY());
        }
    }
}