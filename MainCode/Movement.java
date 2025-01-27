package MainCode;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Movement implements KeyListener{
    JFrame game;
    JLabel ET;
    int nextScreen;
    int moveAnimationSpot = 0;
    ImageIcon ETIdle = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
    ImageIcon ETMoveOne = new ImageIcon("seperated sprites\\E.T\\ETWalk01.png");
    ImageIcon ETMoveTwo = new ImageIcon("seperated sprites\\E.T\\ETWalk02.png");
    ImageIcon backgroundTestIcon = new ImageIcon("seperated sprites\\Screens\\Pits01.png");
    ImageIcon ETFlyOne = new ImageIcon("seperated sprites\\E.T\\ETStretch01.png");
    ImageIcon ETFlyTwo = new ImageIcon("seperated sprites\\E.T\\ETStretch02.png");
    ImageIcon ETFlyThree = new ImageIcon("seperated sprites\\E.T\\ETStretch03.png");
    
    public Movement(JFrame g, int nS){
        game = g;
        nextScreen = nS;
        System.out.println("Next Tile is : " + nextScreen);
    }
    public void ETMoveFirstRun(){
        game.addKeyListener(this);
        ET = new JLabel(ETIdle);
        ET.setVisible(true);
        ET.setSize(16,17);
        ET.setLocation(0,100);
        game.add(ET);
        JLabel backgroundTest = new JLabel();
        backgroundTest.setSize(320,210);
        backgroundTest.setVisible(true);
        backgroundTest.setIcon(backgroundTestIcon);
        game.add(backgroundTest);
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
            ET.setLocation(ET.getX(), ET.getY() - 5);
        }else if(key == KeyEvent.VK_A){
            ET.setLocation(ET.getX() - 5, ET.getY());
            ETMoveAnimation(ET);
        }else if(key == KeyEvent.VK_S){
            ET.setLocation(ET.getX(), ET.getY() + 5);
            ETMoveAnimation(ET);
        }else if(key == KeyEvent.VK_D){
            ET.setLocation(ET.getX() + 5, ET.getY());
            ETMoveAnimation(ET);
        }else if(key == KeyEvent.VK_SPACE){
            ET.setLocation(ET.getX(), ET.getY() - 5);
            ETFlyAnimation(ET);
        }
        moveAnimationSpot = 0;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("KEY RELEACED: " + key);
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
    
