package MainCode;

import javax.sound.sampled.Clip;
import javax.swing.*;


public class SceneHandler extends Movement {
    ImageIcon pit3 = new ImageIcon("seperated sprites\\Screens\\Pits03.png");
    ImageIcon pit2 = new ImageIcon("seperated sprites\\Screens\\Pits02.png");
    ImageIcon forest = new ImageIcon("seperated sprites\\Screens\\Forest.png");
    ImageIcon pit4 = new ImageIcon("seperated sprites\\Screens\\Pits04.png");
    ImageIcon pit1 = new ImageIcon("seperated sprites\\Screens\\Pits01.png");
    ImageIcon DC = new ImageIcon("seperated sprites\\Screens\\DC.png");



    private final JLabel background;
    private String direction;
    private int location;
    public SceneHandler(JFrame g){
        game = g;     
        background = new JLabel();

        background.setSize(320,210);


        background.setVisible(true);

        game.add(background);           
    }
    public int checkTile(int l, JLabel et){
        ET = et;
        location = l;
        switch (location) {
            case 1 -> {
            switch (direction) {
                case "L" -> location = 2;
                case "R" -> location = 2;
                case "U" -> location = 8;
                case "D" -> location = 4;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 2 -> {
            switch (direction) {
                case "L" -> location = 1;
                case "R" -> location = 1;
                case "U" -> location = 9;
                case "D" -> location = 6;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 3 -> {
            switch (direction) {
                case "L" -> location = 7;
                case "R" -> location = 4;
                case "U" -> location = 3;
                case "D" -> location = 3;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 4 -> {
            switch (direction) {
                case "L" -> location = 3;
                case "R" -> location = 5;
                case "U" -> location = 1;
                case "D" -> location = 8;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 5 -> {
            switch (direction) {
                case "L" -> location = 4;
                case "R" -> location = 6;
                case "U" -> location = 5;
                case "D" -> location = 5;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 6 -> {
            switch (direction) {
                case "L" -> location = 5;
                case "R" -> location = 7;
                case "U" -> location = 2;
                case "D" -> location = 9;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 7 -> {
            switch (direction) {
                case "L" -> location = 6;
                case "R" -> location = 3;
                case "U" -> location = 7;
                case "D" -> location = 7;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 8 -> {
            switch (direction) {
                case "L" -> location = 9;
                case "R" -> location = 9;
                case "U" -> location = 4;
                case "D" -> location = 1;
                default -> {
                }
            }
setTile(location, ET);
            }
            case 9 -> {
            switch (direction) {
                case "L" -> location = 8;
                case "R" -> location = 8;
                case "U" -> location = 6;
                case "D" -> location = 2;
                default -> {
                }
            }
setTile(location, ET);
            }
            default -> {
            }
        }
        return location;
    }
    public void setTile(int l, JLabel ET){
        location = l;
        switch (location) {
            case 1 -> background.setIcon(pit3);
            case 2 -> background.setIcon(pit3);
            case 3 -> background.setIcon(pit2);
            case 4 -> background.setIcon(forest);
            case 5 -> background.setIcon(pit4);
            case 6 -> background.setIcon(DC);
            case 7 -> background.setIcon(pit2);
            case 8 -> background.setIcon(pit1);
            case 9 -> background.setIcon(pit1);
            default -> {
            }
        }
        game.remove(background);
        game.remove(ET);
        game.add(ET);
        game.add(background);
    }

    // detects Left and right edges of the screen
    public int detectLREdge(JLabel ET, int l){
        location = l;
        // Left edge
        if (ET.getX() <= 20 ){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(270,ET.getY());
            direction = "L";
            checkTile(location, ET);
        }
        // Right edge
        else if (ET.getX() >= 275){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(22,ET.getY());
            direction = "R";
            checkTile(location, ET);
        }
        return location;
    }

    public int detectUDEdge(JLabel ET, int l){
        location = l;
        // Top edge
        if (ET.getY() <= 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),140);
            direction = "U";
            checkTile(location, ET);
        }
        // bottom edge
        else if (ET.getY() >= 150){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),30);
            direction = "D";
            checkTile(location, ET);
        }
        return location;
    }

    Clip soundHandler(String strSoundPath, boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }





}
