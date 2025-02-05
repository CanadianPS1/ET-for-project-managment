//This program creates and moves the detective to make him move in ETs derection
package MainCode;
import javax.swing.*;
public class GreatComputer extends SceneHandler{
    private final ImageIcon detectiveMove1 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA1.png");
    private final ImageIcon detectiveMove2 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA2.png");
    private final ImageIcon detectiveMove3 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA3.png");
    private final ImageIcon detectiveMove4 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA4.png");
    private int moveAnimationSpot = 0;
    protected static JLabel detective;
    //private JLabel ET;
    private Thread forcingRight;
    private int count = 1;
    private boolean running = true;
    private int energy;
    public GreatComputer(JFrame g, SceneHandler handler, int e) {
        super(g, e);
        detective = new JLabel(detectiveMove1);
        detective.setSize(12,28);
        detective.setLocation(250,30);
        detective.setVisible(true);
        game.add(detective);
    }

    public GreatComputer(JFrame g, int e) {
        super(g, e);
    }
    //this checks and compares ets location with the detective then moves the det ective tword him
    public int move(JLabel ET, SceneHandler handler, JLabel energyUI, int e){
        energy = e;
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
            
            detectiveGrab(ET, handler, energyUI);
            energy = energy - 50;
        }
        detectiveMoveAnimation(detective);
        return energy;
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
    public void detectiveGrab(JLabel ET, SceneHandler handler, JLabel energyUI){
        if(detective.getX() == ET.getX() && detective.getY() == ET.getY()){
            Movement.setCanMove(false);
            running = true;
            switch (Movement.location) {
                case 4 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 3 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 5 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 6 -> {
                    Movement.setCanMove(true);
                    running = false;
                    Movement.location = 6;
                }
                case 7 -> {
                    forceRight(ET, handler, 26, ET.getX() - 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 1 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() + 5, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 2 -> {
                    forceRight(ET, handler, 26, ET.getX(), ET.getY() + 10, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 8 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() - 5, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                case 9 -> {
                    forceRight(ET, handler, 26, ET.getX(), ET.getY() - 10, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.setCanMove(true);
                    }   if(!running){
                        count = 0;
                    }
                }
                default -> System.err.println("Error: invalid tile");

            }
        }
    }
    public void forceRight(JLabel ET, SceneHandler handler, int amountMoved, int ETX, int ETY, JLabel energyUI){
        Runnable forceRight = () -> {
            if(count < amountMoved && running){
                System.out.println(count);
                ET.setLocation(ETX, ETY);
                detective.setLocation(ET.getX() - 10, ET.getY());
                count += 1;
                handler.detectLREdge(ET, energyUI);
                handler.detectUDEdge(ET, energyUI);
                System.out.println("location: " + Movement.location);
                if(Movement.location == 6){
                    running = false;
                    count = amountMoved;
                    Movement.setCanMove(true);
                    energy = energy - 900;
                }
            }
        };
        forcingRight = new Thread(forceRight);
    }

    
}