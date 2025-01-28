package MainCode;

import java.util.ArrayList;
import javax.swing.*;


public class SceneHandler extends Movement {

    ArrayList<String> strScenePaths = new ArrayList<>();


        
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

    public void screenChange(){
        JLabel background = new JLabel();

        background.setSize(320,210);

        background.setVisible(true);

        game.add(background);

        if (nextScreen == 0){
            background.setIcon(new ImageIcon(strScenePaths.get(0)));
        }
        else if (nextScreen == 1){
            background.setIcon(new ImageIcon(strScenePaths.get(1)));
        }
        else if (nextScreen == 2){
            background.setIcon(new ImageIcon(strScenePaths.get(2)));
        }
        else if (nextScreen == 3){
            background.setIcon(new ImageIcon(strScenePaths.get(3)));
        }
        else if (nextScreen == 4){
            background.setIcon(new ImageIcon(strScenePaths.get(4)));
        }
        else if (nextScreen == 5){
            background.setIcon(new ImageIcon(strScenePaths.get(5)));
        }
        else if (nextScreen == 6){
            background.setIcon(new ImageIcon(strScenePaths.get(6)));
        }
        else if (nextScreen == 7){
            background.setIcon(new ImageIcon(strScenePaths.get(7)));
        }
        else{
            System.err.println("Error: Screen not found");
        }


    }

    public void detectEdge(){
        if (nextScreen == 0){
            if (ET.getX() >= 320){
                nextScreen = 1;
                screenChange();
                ET.setLocation(0,100);
            }
        }
        else if (nextScreen == 1){
            if (ET.getX() >= 320){
                nextScreen = 2;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 0;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 2){
            if (ET.getX() >= 320){
                nextScreen = 3;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 1;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 3){
            if (ET.getX() >= 320){
                nextScreen = 4;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 2;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 4){
            if (ET.getX() >= 320){
                nextScreen = 5;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 3;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 5){
            if (ET.getX() >= 320){
                nextScreen = 6;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 4;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 6){
            if (ET.getX() >= 320){
                nextScreen = 7;
                screenChange();
                ET.setLocation(0,100);
            }
            else if (ET.getX() <= -16){
                nextScreen = 5;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else if (nextScreen == 7){
            if (ET.getX() <= -16){
                nextScreen = 6;
                screenChange();
                ET.setLocation(304,100);
            }
        }
        else{
            System.err.println("Error: Screen not found");
        }
    }





}
