#include <QApplication>
#include <QPushButton>
class StartMenu{
    protected:
    Clip strSound;
    JFrame game;
    private:
    const ImageIcon startScreenIcon;
    const JButton startButton;
    //makes the JFrame and puts a button in it so you can start the game
    public:
    StartMenu(){
        startScreenIcon = new ImageIcon("seperated sprites\\Screens\\MainMenue.png");
        ImageIcon gameIcon = new ImageIcon("seperated sprites\\E.T\\ETIdle.png");
        game = new JFrame("Extra Terrestrial");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setBounds(700,300,325,240);
        game.setVisible(true);
        game.setIconImage(gameIcon.getImage());
        game.setFocusable(true);
        startButton = new JButton();
        startButton.setSize(320,210);
        startButton.setVisible(true);
        startButton.setIcon(startScreenIcon);
        game.add(startButton);
        game.update(game.getGraphics());
        startButton.addActionListener((ActionListener) this);

        String strSoundPath = "Sounds\\MainMenu.wav";

        SoundHandler soundHandler = new SoundHandler();
        strSound = soundHandler.soundControl(strSoundPath, true);

    }
    //the method for when you click the button
    //it disables its self then makes ET and all that jazz
    override
    void actionPerformed(ActionEvent e){
        int energy = 9999;
        startButton.setVisible(false);
        game.remove(startButton);
        game.update(game.getGraphics());
        System.out.println("Start Button Pressed");
        new Movement(game, energy).ETMoveFirstRun(energy);

        SoundHandler soundHandler = new SoundHandler();
        soundHandler.sounndOff(strSound);


        SceneHandler handler = new SceneHandler(game, energy);

    }  
}
