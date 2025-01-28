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
    protected int nextScreen = 0;
    int moveAnimationSpot = 0;
    ImageIcon ETIdle = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
    ImageIcon ETMoveOne = new ImageIcon("seperated sprites\\E.T\\ETWalk01.png");
    ImageIcon ETMoveTwo = new ImageIcon("seperated sprites\\E.T\\ETWalk02.png");
    ImageIcon ETFlyOne = new ImageIcon("seperated sprites\\E.T\\ETStretch01.png");
    ImageIcon ETFlyTwo = new ImageIcon("seperated sprites\\E.T\\ETStretch02.png");
    ImageIcon ETFlyThree = new ImageIcon("seperated sprites\\E.T\\ETStretch03.png");
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public Movement(JFrame g){
        game = g;
        System.out.println("Next Screen is : " + nextScreen);
    }

    public Movement() {
    }
    public void ETMoveFirstRun(){
        game.addKeyListener(this);
        ET = new JLabel(ETIdle);
        ET.setVisible(true);
        ET.setSize(16,17);
        ET.setLocation(100,100);
        game.add(ET);
        GreatComputer detective = new GreatComputer(game, moveAnimationSpot);
        Runnable computerMovment = () -> {
            detective.move(ET);
        };
        scheduler.scheduleAtFixedRate(computerMovment, 5, 500, TimeUnit.MILLISECONDS);
        Thread aiMoving = new Thread(computerMovment);
        aiMoving.start();
    }
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

 
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W){
            ETMoveAnimation(ET);
            ET.setLocation(ET.getX(), ET.getY() - 2);
        }else if(key == KeyEvent.VK_A){
            ET.setLocation(ET.getX() - 2, ET.getY());
            ETMoveAnimation(ET);
        }else if(key == KeyEvent.VK_S){
            ET.setLocation(ET.getX(), ET.getY() + 2);
            ETMoveAnimation(ET);
        }else if(key == KeyEvent.VK_D){
            ET.setLocation(ET.getX() + 2, ET.getY());
            ETMoveAnimation(ET);
        //once var is made we need to add && etInHole into the if statment for the space bar
        }else if(key == KeyEvent.VK_SPACE){
            ET.setLocation(ET.getX(), ET.getY() - 2);
            ETFlyAnimation(ET);
        }
        moveAnimationSpot = 0;

        SceneHandler handler = new SceneHandler(game, nextScreen);

        
        handler.screenChange(handler.detectLREdge(ET), handler.detectUDEdge(ET));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        // System.out.println("KEY RELEACED: " + key);
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
    
