package MainCode;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Movement{
    JFrame game;
    JLabel ET;
    int nextScreen;
    int moveAnimationSpot = 0;
    ImageIcon ETIdle = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
    ImageIcon ETMoveOne = new ImageIcon("seperated sprites\\E.T\\ETWalk01.png");
    ImageIcon ETMoveTwo = new ImageIcon("seperated sprites\\E.T\\ETWalk02.png");
    public Movement(JFrame g, int nS){
        game = g;
        nextScreen = nS;
        System.out.println("Next Tile is : " + nextScreen);

    }
    public void ETMoveFirstRun(){
        ET = new JLabel(ETIdle);
        ET.setVisible(true);
        ET.setSize(16,17);
        ET.setLocation(0,100);
        game.add(ET);
    }
    public ImageIcon ETMove(ImageIcon ET){
        switch (moveAnimationSpot) {
            case 0 -> {
                ET.setImage(ETMoveOne.getImage());
                moveAnimationSpot = 1;
            }
            case 1 -> {
                ET.setImage(ETMoveTwo.getImage());
                moveAnimationSpot = 2;
            }
            case 2 ->{
                ET.setImage(ETMoveOne.getImage());
                moveAnimationSpot = 1;
            }
            default -> {
                ET.setImage(ETIdle.getImage());
                moveAnimationSpot = 0;
            }
        }

        return ET;
    }
}
    
