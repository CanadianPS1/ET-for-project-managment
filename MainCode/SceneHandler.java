package MainCode;

import java.util.ArrayList;
import javax.swing.*;


public class SceneHandler extends Movement {

    ArrayList<String> strScenePaths = new ArrayList<>();

    private int intScreenNum = 0;


        
    public SceneHandler(JFrame g, int nS){
        game = g;
        nextScreen = nS;
        System.out.println("Next Tile is : " + nextScreen);
        
        strScenePaths.add("seperated sprites\\Screens\\Forest.png");
        strScenePaths.add("seperated sprites\\Screens\\Pits01.png");
        strScenePaths.add("seperated sprites\\Screens\\Pits02.png");
        strScenePaths.add("seperated sprites\\Screens\\Pits03.png");
        strScenePaths.add("seperated sprites\\Screens\\Pits04.png");
        strScenePaths.add("seperated sprites\\Screens\\PitInside.png");
        strScenePaths.add("seperated sprites\\Screens\\DC.png");
        strScenePaths.add("seperated sprites\\Screens\\EndingHouse.png");
        
    }

    public void screenChange(int intScreen){
        JLabel background = new JLabel();

        background.setSize(320,210);

        background.setVisible(true);

        game.add(background);

        if (intScreen == 0){
            background.setIcon(new ImageIcon(strScenePaths.get(0)));
            intScreenNum = 0;
        }
        else if (intScreen == 1){
            background.setIcon(new ImageIcon(strScenePaths.get(1)));
            intScreenNum = 1;
        }
        else if (intScreen == 2){
            background.setIcon(new ImageIcon(strScenePaths.get(2)));
            intScreenNum = 2;
        }
        else if (intScreen == 3){
            background.setIcon(new ImageIcon(strScenePaths.get(3)));
            intScreenNum = 3;

        }
        else if (intScreen == 4){
            background.setIcon(new ImageIcon(strScenePaths.get(4)));
            intScreenNum = 4;

        }
        else if (intScreen == 5){
            background.setIcon(new ImageIcon(strScenePaths.get(5)));
            intScreenNum = 5;

        }
        else if (intScreen == 6){
            background.setIcon(new ImageIcon(strScenePaths.get(6)));
            intScreenNum = 6;

        }
        else if (intScreen == 7){
            background.setIcon(new ImageIcon(strScenePaths.get(7)));
            intScreenNum = 7;

        }
        else{
            System.err.println("Error: Screen not found");
            intScreenNum = 0;

        }


    }

    public void detectEdge(){
        if (ET.getX() == 0 || ET.getX() == 320){
            System.out.println("Edge Detected");
            screenChange(intScreenNum);

        }
    }





}
