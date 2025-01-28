//This program creates and moves the detective to make him move in ETs derection
package MainCode;
import javax.swing.*;
public class GreatComputer extends SceneHandler{
    private final ImageIcon detectiveMove1 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA1.png");
    private final ImageIcon detectiveMove2 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA2.png");
    private final ImageIcon detectiveMove3 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA3.png");
    private final ImageIcon detectiveMove4 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA4.png");
    private int moveAnimationSpot = 0;
    protected JLabel detective;
    public GreatComputer(JFrame g, int nS) {
        super(g, nS);
        detective = new JLabel(detectiveMove1);
        detective.setSize(12,28);
        detective.setLocation(250,30);
        detective.setVisible(true);
        game.add(detective);
    }
    //this checks and compares ets location with the detective then moves the detective tword him
    public void move(JLabel ET){
        if(ET.getX() > detective.getX()){
            detective.setLocation(detective.getX() + 8, detective.getY());
        }
        if(ET.getY() > detective.getY()){
            detective.setLocation(detective.getX(), detective.getY() + 8);
        }
        if(ET.getX() < detective.getX()){
            detective.setLocation(detective.getX() - 8, detective.getY());
        }
        if(ET.getY() < detective.getY()){
            detective.setLocation(detective.getX(), detective.getY() - 8);
        }
        if(ET.getX() == detective.getX() && ET.getY() == detective.getY()){
            energy = energy - 999;
        }
        detectiveMoveAnimation(detective);
    }
    //sets the animation loop for the detective
    public JLabel detectiveMoveAnimation(JLabel detective){
        switch (moveAnimationSpot) {
            case 0 -> {
                detective.setIcon(detectiveMove1);
                moveAnimationSpot = 1;
            }
            case 1 -> {
                detective.setIcon(detectiveMove2);
                moveAnimationSpot = 2;
            }
            case 2 ->{
                detective.setIcon(detectiveMove3);
                moveAnimationSpot = 3;
            }
            case 3 ->{
                detective.setIcon(detectiveMove4);
                moveAnimationSpot = 1;
            }
            default -> {
                detective.setIcon(detectiveMove1);
                moveAnimationSpot = 0;
            }
        }
        return ET;
    }
    
}