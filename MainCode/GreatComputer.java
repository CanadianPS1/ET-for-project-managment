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
    private int location;
    public GreatComputer(JFrame g, SceneHandler handler) {
        super(g);
        detective = new JLabel(detectiveMove1);
        detective.setSize(12,28);
        detective.setLocation(250,30);
        detective.setVisible(true);
        game.add(detective);
        location = handler.getLocation();
    }
    //this checks and compares ets location with the detective then moves the detective tword him
    public void move(JLabel ET, SceneHandler handler){
        location = handler.getLocation();
        if(ET.getX() > detective.getX()){
            detective.setLocation(detective.getX() + 2, detective.getY());
        }
        if(ET.getY() > detective.getY()){
            detective.setLocation(detective.getX(), detective.getY() + 2);
        }
        if(ET.getX() < detective.getX()){
            detective.setLocation(detective.getX() - 2, detective.getY());
        }
        if(ET.getY() < detective.getY()){
            detective.setLocation(detective.getX(), detective.getY() - 2);
        }
        if(ET.getX() == detective.getX() && ET.getY() == detective.getY()){
            energy = energy - 999;
            detectiveGrab(ET);
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
        return detective;
    }
    public void detectiveGrab(JLabel ET){
        if(detective.getX() == ET.getX() && detective.getY() == ET.getY()){
            Movement.setCanMove(false);
            if(location == 4){
                //he will have to go right for 30s
            }else if(location == 3){
                //he will have to go right for 30s
            }else if(location == 5){
                //he will have to go right for 15s
            }else if(location == 7){
                //he will have to go left for 15s
            }else if(location == 1){
                //he will have to go down for 15s then right for 30s
            }else if(location == 2){
                //he will have to go down for 15s
            }else if(location == 8){
                //he will have to go up for 15s then right for 30s
            }else if(location == 9){
                //he will have to up for 15s
            }else{
                System.err.println("Error: invalid tile");
            }
        }
    }
}