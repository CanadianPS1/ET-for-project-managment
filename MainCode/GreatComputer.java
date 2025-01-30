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
    //private JLabel ET;
    private int location;
    private Thread forcingRight;
    private int count = 1;
    private boolean running = true;
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
            
            detectiveGrab(ET, handler);
        }
        detectiveMoveAnimation(detective);
    }
    //sets the animation loop for the detective
    public JLabel detectiveMoveAnimation(JLabel detective){

        String strSoundPath;
        
        SoundHandler soundHandler = new SoundHandler();

        switch (moveAnimationSpot) {
            case 0 -> {
                detective.setIcon(detectiveMove1);
                moveAnimationSpot = 1;
                strSoundPath = "Sounds\\EnemyWalk1.wav";
                soundHandler.soundControl(strSoundPath, true);
            }
            case 1 -> {
                detective.setIcon(detectiveMove2);
                moveAnimationSpot = 2;
                strSoundPath = "Sounds\\EnemyWalk2.wav";
                soundHandler.soundControl(strSoundPath, true);
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
                strSoundPath = "Sounds\\EnemyWalk1.wav";
                soundHandler.soundControl(strSoundPath, true);
            }
        }
        return detective;
    }
    public void detectiveGrab(JLabel ET, SceneHandler handler){
        if(detective.getX() == ET.getX() && detective.getY() == ET.getY()){
            Movement.setCanMove(false);
            running = true;
            if(location == 4){
                forceRight(ET, handler, 26, ET.getX() + 10, ET.getY());
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 3){
                forceRight(ET, handler, 26, ET.getX() + 10, ET.getY());
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 5){
                forceRight(ET, handler, 26, ET.getX() + 10, ET.getY());
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 6){
                Movement.setCanMove(true);
                running = false;
                location = 6;
            }else if(location == 7){
                forceRight(ET, handler, 26, ET.getX() - 10, ET.getY());
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 1){
                forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() + 5); 
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 2){
                forceRight(ET, handler, 26, ET.getX(), ET.getY() + 10);
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 8){
                forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() - 5);
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else if(location == 9){
                forceRight(ET, handler, 26, ET.getX(), ET.getY() - 10);
                forcingRight.start();
                if(count == 26){
                    running = false;
                    Movement.setCanMove(true);
                }
                if(!running){
                    count = 0;
                }
            }else{
                System.err.println("Error: invalid tile");
            }
        }
    }
    public void forceRight(JLabel ET, SceneHandler handler, int amountMoved, int ETX, int ETY){
        Runnable forceRight = () -> {
            if(count < amountMoved && running){
                System.out.println(count);
                ET.setLocation(ETX, ETY);
                detective.setLocation(ET.getX() - 10, ET.getY());
                count += 1;
                location = handler.detectLREdge(ET, location);
                location = handler.detectUDEdge(ET, location);
                System.out.println("location: " + location);
                if(location == 6){
                    running = false;
                    count = amountMoved;
                    Movement.setCanMove(true);
                }
            }
        };
        forcingRight = new Thread(forceRight);
    }
}