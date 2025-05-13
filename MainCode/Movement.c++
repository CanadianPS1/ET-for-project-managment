//this class controls ETs movement and super classes GreatComputer and ScreenHandler
package MainCode;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
class Movement implements KeyListener{
    
    private:
    const ImageIcon ETMoveOne = new ImageIcon("seperated sprites\\E.T\\ETWalk01.png");
    const ImageIcon ETMoveTwo = new ImageIcon("seperated sprites\\E.T\\ETWalk02.png");
    const ImageIcon ETFlyOne = new ImageIcon("seperated sprites\\E.T\\ETStretch01.png");
    const ImageIcon ETFlyTwo = new ImageIcon("seperated sprites\\E.T\\ETStretch02.png");
    const ImageIcon ETFlyThree = new ImageIcon("seperated sprites\\E.T\\ETStretch03.png");
    const ImageIcon ETDead = new ImageIcon("seperated sprites\\E.T\\ETDeath06.png");
    const ImageIcon shipIco = new ImageIcon("seperated sprites\\E.T\\Ship\\ETShip01.png");
    const ImageIcon arrowUp = new ImageIcon("seperated sprites\\UI\\Arrows\\ArrowUp.png");
    const ImageIcon arrowDown = new ImageIcon("seperated sprites\\UI\\Arrows\\ArrowDown.png");
    const ImageIcon arrowLeft = new ImageIcon("seperated sprites\\UI\\Arrows\\ArrowLeft.png");
    const ImageIcon arrowRight = new ImageIcon("seperated sprites\\UI\\Arrows\\ArrowRight.png");
    const JLabel ship = new JLabel(shipIco);
    Thread shipAnimationThread;
    boolean inAnimation;
    SceneHandler handler;
    const ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    int moveAnimationSpot = 0;

    protected:
    int energy;
    int intPrevLocal;
    static bool canMove = true;
    static bool isInPit = false;
    static JLabel energyUI;
    const JLabel arrows = new JLabel();
    JLabel ET;
    JFrame game;

    static int location; // this is where ET starts the game

    public:
    void Movement(JFrame g, int e){
        game = g;
        handler = new SceneHandler(g, e);
        energy = e;
    }
    Movement(){
    }
    //Makes ET and starts the detectives movement
    void ETMoveFirstRun(int e){
        inAnimation = true;
        canMove = false;
        energy = e;
        energyUI = new JLabel(energy + ""); 
        energyUI.setLocation(140,160);
        energyUI.setSize(100,30);
        energyUI.setVisible(true);
        arrows.setLocation(152,4);
        arrows.setSize(16,16);
        arrows.setVisible(true);
        game.add(arrows);
        GreatComputer detective = new GreatComputer(game, handler, energy);
        Runnable computerMovment = () -> {
            energy = detective.move(ET, handler, energyUI, energy);
            if(energy <= 0){
                ET.setIcon(ETDead);
            }
        };
        scheduler.scheduleAtFixedRate(computerMovment, 5, 100, TimeUnit.MILLISECONDS);
        Thread aiMoving = new Thread(computerMovment);
        aiMoving.start();
        location = 4;
        ship.setSize(32,32);
        ship.setLocation(148,28);
        ship.setVisible(true);
        game.add(ship);
        game.addKeyListener(this);
        ET = new JLabel(ETIdle);
        ET.setVisible(true);
        ET.setSize(16,17);
        ET.setLocation(156,36);
        game.add(energyUI);

        game.add(ET);

        handler.setTile(ET, energyUI, arrows);
        Runnable shipAnimationRunnable = shipAnimetion();
        scheduler.scheduleAtFixedRate(shipAnimationRunnable, 5, 200, TimeUnit.MILLISECONDS);
        shipAnimationThread.start();
        new PhonePieceSpawns(game, energy);
    }
    //Plays ETs animaton for when hes walking
    JLabel ETMoveAnimation(JLabel ET){

        String strSoundPath;
        
        SoundHandler soundHandler = new SoundHandler();


        switch (moveAnimationSpot) {
            case 0 -> {
                ET.setIcon(ETMoveOne);
                moveAnimationSpot = 1;
                strSoundPath = "Sounds\\ETWalkies.wav";
                soundHandler.soundControl(strSoundPath, true);
            }
            case 1 -> {
                ET.setIcon(ETMoveTwo);
                moveAnimationSpot = 2;
                strSoundPath = "Sounds\\ETWalkies2.wav";
                soundHandler.soundControl(strSoundPath, true);
            }
            case 2 ->{
                ET.setIcon(ETMoveOne);
                moveAnimationSpot = 1;
                strSoundPath = "Sounds\\ETWalkies.wav";
                soundHandler.soundControl(strSoundPath, true);
            }
            default -> {
                ET.setIcon(ETIdle);
                moveAnimationSpot = 0;
            }
        }
        if(energy <= 0){
            ET.setIcon(ETDead);
        }

        return ET;
    }
  
    //Plays ETs second animation for when he flys
    JLabel ETFlyAnimation(JLabel ET, int mas){
        switch (mas) {
            case 0 -> {
                ET.setIcon(ETFlyOne);
                mas = 1;
            }
            case 1 -> {
                ET.setIcon(ETFlyTwo);
                mas = 2;
            }
            case 2 ->{
                ET.setIcon(ETFlyThree);
                mas = 3;
            }
            default -> {
                ET.setIcon(ETFlyThree);
            }
        }
        return ET;
    }
    Runnable shipAnimetion(){

        Runnable shipAnimationRunnable = () -> {
            if(inAnimation){
                if(ET.getY() <= 100){
                    ET.setLocation(ET.getX(), ET.getY() + 6);
                    ship.setLocation(ship.getX(), ship.getY() + 6);

                }else{
                    inAnimation = false;
                    ship.setVisible(false);
                    ship.setLocation(148,28);
                    canMove = true;
                }
            }
        };
        shipAnimationThread = new Thread(shipAnimationRunnable);
        return shipAnimationRunnable;
    }
    //these methods are for detecting keypresses then moving ET to those spots
    override
    void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(energy > 0 && canMove){
            if(key == KeyEvent.VK_W && !isInPit){
                ETMoveAnimation(ET);
                ET.setLocation(ET.getX(), ET.getY() - 2);
            }else if(key == KeyEvent.VK_A){
                ET.setLocation(ET.getX() - 2, ET.getY());
                ETMoveAnimation(ET);
            }else if(key == KeyEvent.VK_S && !isInPit){
                ET.setLocation(ET.getX(), ET.getY() + 2);
                ETMoveAnimation(ET);
            }else if(key == KeyEvent.VK_D){
                ET.setLocation(ET.getX() + 2, ET.getY());
                ETMoveAnimation(ET);
            }else if(key == KeyEvent.VK_SPACE){
                //once var is made we need to add && etInHole into the if statment for the space bar
                if(isInPit){
                    ET.setLocation(ET.getX(), ET.getY() - 2);
                    ETFlyAnimation(ET, 0);
                    energy = energy - 18;
                }else{
                    ETFlyAnimation(ET, 0);

                    handler.arrowHandler(arrows, arrowLeft, arrowRight, arrowUp, arrowDown, location);
                }

            }
            energy--;
            energyUI.setText(energy + "");
        }else if(energy <= 0){
            ET.setIcon(ETDead);
            energyUI.setText("0");
        }
        
        if(location != 10){
            handler.detectLREdge(ET, energyUI, arrows);
            handler.detectUDEdge(ET, energyUI, arrows);
        
            SceneHandler.previousLocation = handler.detectpit(ET, energyUI);

        }
        if(location == 10){
            handler.checkPitLeave(ET, energyUI);
        }
    }
    override
    void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W || key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D || key == KeyEvent.VK_SPACE) {
            ET.setIcon(ETIdle);
        }
    }
    override
    void keyTyped(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_W -> ET.setLocation(ET.getX(), ET.getY() - 5);
            case KeyEvent.VK_A -> ET.setLocation(ET.getX() - 5, ET.getY());
            case KeyEvent.VK_S -> ET.setLocation(ET.getX(), ET.getY() + 5);
            case KeyEvent.VK_D -> ET.setLocation(ET.getX() + 5, ET.getY());
        }
    }
    static void setCanMove(bool cm){
        canMove = cm;
    }
}