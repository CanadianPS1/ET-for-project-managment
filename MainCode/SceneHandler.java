package MainCode;

import java.util.ArrayList;
import javax.swing.*;


public class SceneHandler extends Movement {

    String[][] strScenePaths = new String[][]{
        {null, "seperated sprites\\Screens\\Pits03.png", null,  "seperated sprites\\Screens\\Pits03.png", null},
        {"seperated sprites\\Screens\\Pits02.png", "seperated sprites\\Screens\\Forest.png", "seperated sprites\\Screens\\Pits04.png",  "seperated sprites\\Screens\\DC.png", "seperated sprites\\Screens\\Pits02.png"},
        {null, "seperated sprites\\Screens\\Pits01.png", null, "seperated sprites\\Screens\\Pits01.png",null}
    };

    public SceneHandler(JFrame g, int nS){
        game = g;
        nextScreen = nS;
                
    }

    public void screenChange(boolean direction){
        JLabel background = new JLabel();

        background.setSize(320,210);

        background.setVisible(true);

        game.add(background);

        // direcction = left
        if (direction){
            background.setIcon(new ImageIcon(strScenePaths.get(0)));
        }
        else if (nextScreen == 1){
            background.setIcon(new ImageIcon(strScenePaths.get(1)));
            nextScreen = 1;
        }
        else if (nextScreen == 2){
            background.setIcon(new ImageIcon(strScenePaths.get(2)));
            nextScreen = 2;
        }
        else if (nextScreen == 3){
            background.setIcon(new ImageIcon(strScenePaths.get(3)));
            nextScreen = 3;

        }
        else if (nextScreen == 4){
            background.setIcon(new ImageIcon(strScenePaths.get(4)));
            nextScreen = 4;

        }
        else if (nextScreen == 5){
            background.setIcon(new ImageIcon(strScenePaths.get(5)));
            nextScreen = 5;

        }
        else if (nextScreen == 6){
            background.setIcon(new ImageIcon(strScenePaths.get(6)));
            nextScreen = 6;

        }
        else if (nextScreen == 7){
            background.setIcon(new ImageIcon(strScenePaths.get(7)));
            nextScreen = 7;

        }
        else{
            System.err.println("Error: Screen not found");
            nextScreen = 0;

        }

        System.out.println("Next Screen is : " + nextScreen);


    }

    public boolean detectEdge(JLabel ET){
        if (ET.getX() == 0){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            // screenChange(intScreenNum + 1);
            ET.setLocation(300,ET.getY());
            return true;
        }
        else if (ET.getX() == 300){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getX());
            ET.setLocation(0,ET.getY());
            return false;
        }
        else{
            return true;
        }
    }





}
