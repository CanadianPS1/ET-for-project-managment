package MainCode;
import javax.swing.*;
public class GreatComputer extends SceneHandler{
    ImageIcon detectiveMove1 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA1.png");
    ImageIcon detectiveMove2 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA2.png");
    ImageIcon detectiveMove3 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA3.png");
    ImageIcon detectiveMove4 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA4.png");
    protected JLabel detective;
    private int locationScreenDelay;
    public GreatComputer(JFrame g, int nS) {
        super(g, nS);
        detective = new JLabel(detectiveMove1);
        detective.setSize(12,28);
        detective.setLocation(250,30);
        detective.setVisible(true);
        game.add(detective);
    }
    public void move(JLabel ET){
        System.out.println("detective is moving");

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
    }
        

    
}