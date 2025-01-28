package MainCode;

import javax.swing.*;


public class SceneHandler extends Movement {

    String[][] strScenePaths = new String[][]{
        {null, "seperated sprites\\Screens\\Pits03.png", null,  "seperated sprites\\Screens\\Pits03.png", null},
        {"seperated sprites\\Screens\\Pits02.png", "seperated sprites\\Screens\\Forest.png", "seperated sprites\\Screens\\Pits04.png",  "seperated sprites\\Screens\\DC.png", "seperated sprites\\Screens\\Pits02.png"},
        {null, "seperated sprites\\Screens\\Pits01.png", null, "seperated sprites\\Screens\\Pits01.png",null}
    };

    private int intCurrentX = 1;
    private int intCurrentY = 1;

    public SceneHandler(JFrame g, int nS){
        game = g;
        nextScreen = nS;   
    }

    public void screenChange(boolean leftRightDirection, boolean upDownDirection){
        JLabel background = new JLabel();

        background.setSize(320,210);

        background.setVisible(true);

        game.add(background);

        // direcction = left
        if (leftRightDirection){
            if (strScenePaths[intCurrentX][intCurrentY + 1] == null){
                return;
            }
            else{
                background.setIcon(new ImageIcon(strScenePaths[intCurrentX][intCurrentY + 1]));
                intCurrentY++;
            }
            
        }
        else if (nextScreen == 1){
            background.setIcon(new ImageIcon(strScenePaths[1][0]));
            nextScreen = 1;
        }
        else if (nextScreen == 2){
            background.setIcon(new ImageIcon(strScenePaths[1][0]));
            nextScreen = 2;
        }
        else{
            System.err.println("Error: Screen not found");
            nextScreen = 0;

        }

        System.out.println("Next Screen is : " + nextScreen);


    }

    // detects Left and right edges of the screen
    public boolean detectLREdge(JLabel ET){
        // Left edge
        if (ET.getX() == 0){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            // screenChange(intScreenNum + 1);
            ET.setLocation(300,ET.getY());
            return true;
        }
        // Right edge
        else if (ET.getX() == 300){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getX());
            ET.setLocation(1,ET.getY());
            return false;
        }
        else{
            return true;
        }
    }

    public boolean detectUDEdge(JLabel ET){
        // Top edge
        if (ET.getY() == 0){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),190);
            return true;
        }
        // bottom edge
        else if (ET.getY() == 200){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),2);
            return false;
        }
        else{
            return true;
        }
    }





}
