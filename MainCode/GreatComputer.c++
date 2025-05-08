//This program creates and moves the detective to make him move in ETs derection
//import javax.swing.*;
#include <iostream>
using namespace std;
class GreatComputer extends SceneHandler{
    private:
    const ImageIcon detectiveMove1 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA1.png");
    const ImageIcon detectiveMove2 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA2.png");
    const ImageIcon detectiveMove3 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA3.png");
    const ImageIcon detectiveMove4 = new ImageIcon("seperated sprites\\AI\\CIA\\CIA4.png");
    int moveAnimationSpot = 0;
    //private JLabel ET;
    Thread forcingRight;
    int count = 1;
    bool running = true;
    int energy;
    protected:
    static JLabel detective;

    public:
    void GreatComputer(JFrame g, SceneHandler handler, int e) {
        super(g, e);
        detective = new JLabel(detectiveMove1);
        detective.setSize(12,28);
        detective.setLocation(250,30);
        detective.setVisible(true);
        game.add(detective);
    }
    void GreatComputer(JFrame g, int e) {
        super(g, e);
    }
    //this checks and compares ets location with the detective then moves the det ective tword him
    int move(JLabel ET, SceneHandler handler, JLabel energyUI, int e){
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
        if(ET.getX() == detective.getX() && ET.getY() == detective.getY() && game.getContentPane().isAncestorOf(detective)){
            detectiveGrab(ET, handler, energyUI);
            energy = energy - 50;
        }
        detectiveMoveAnimation(detective);
        return energy;
    }
    //sets the animation loop for the detective
    JLabel detectiveMoveAnimation(JLabel detective){

        string strSoundPath;
        
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
    void detectiveGrab(JLabel ET, SceneHandler handler, JLabel energyUI){
        if(detective.getX() == ET.getX() && detective.getY() == ET.getY()){
            Movement.canMove = false;
            running = true;
            switch (Movement.location) {
                case 4 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 3 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 5 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 6 -> {
                    Movement.canMove = true;
                    running = false;
                    Movement.location = 6;
                }
                case 7 -> {
                    forceRight(ET, handler, 26, ET.getX() - 10, ET.getY(), energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 1 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() + 5, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 2 -> {
                    forceRight(ET, handler, 26, ET.getX(), ET.getY() + 10, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 8 -> {
                    forceRight(ET, handler, 26, ET.getX() + 10, ET.getY() - 5, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                case 9 -> {
                    forceRight(ET, handler, 26, ET.getX(), ET.getY() - 10, energyUI);
                    forcingRight.start();
                    if(count == 26){
                        running = false;
                        Movement.canMove = true;
                    }   if(!running){
                        count = 0;
                    }
                }
                default -> System.err.println("Error: invalid tile");

            }
        }
    }
    void forceRight(JLabel ET, SceneHandler handler, int amountMoved, int ETX, int ETY, JLabel energyUI){
        Runnable forceRight = () -> {
            if(count < amountMoved && running){
                System.out.println(count);
                ET.setLocation(ETX, ETY);
                detective.setLocation(ET.getX() - 10, ET.getY());
                count += 1;
                handler.detectLREdge(ET, energyUI, arrows);
                handler.detectUDEdge(ET, energyUI, arrows);
                System.out.println("location: " + Movement.location);
                if(Movement.location == 6){
                    running = false;
                    count = amountMoved;
                    Movement.canMove = true;
                    energy = energy - 900;
                }
            }
        };
        forcingRight = new Thread(forceRight);
    }

    
}