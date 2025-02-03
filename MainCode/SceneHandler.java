package MainCode;

import javax.swing.*;


public class SceneHandler extends Movement {
    ImageIcon pit3 = new ImageIcon("seperated sprites\\Screens\\Pits03.png");
    ImageIcon pit2 = new ImageIcon("seperated sprites\\Screens\\Pits02.png");
    ImageIcon forest = new ImageIcon("seperated sprites\\Screens\\Forest.png");
    ImageIcon pit4 = new ImageIcon("seperated sprites\\Screens\\Pits04.png");
    ImageIcon pit1 = new ImageIcon("seperated sprites\\Screens\\Pits01.png");
    ImageIcon DC = new ImageIcon("seperated sprites\\Screens\\DC.png");

    ImageIcon insidePit = new ImageIcon("seperated sprites\\Screens\\InsidePit.png");



    private final JLabel background;
    private String direction;
    private int location;
    public SceneHandler(JFrame g, int e){
        game = g;     
        background = new JLabel();

        background.setSize(320,210);


        background.setVisible(true);

        game.add(background);           
    }
    public int checkTile(int l, JLabel et, JLabel energyUI){
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
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
        setTile(location, ET, energyUI);
            }
            default -> {
            }
        }
        return location;
    }
    public void setTile(int l, JLabel ET, JLabel energyUI1){
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
            case 10 -> background.setIcon(insidePit);
            default -> {
            }
        }
        //game.remove(energyUI);
        game.remove(background);
        game.remove(ET);
        game.remove(energyUI);


        game.add(energyUI);
        game.add(ET);
        game.add(background);
        game.update(game.getGraphics());
    }

    // detects Left and right edges of the screen
    public int detectLREdge(JLabel ET, int l, JLabel energyUI){
        location = l;
        // Left edge
        if (ET.getX() <= 30 ){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(270,ET.getY());
            direction = "L";
            checkTile(location, ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() + 230, GreatComputer.detective.getY());
        }
        // Right edge
        else if (ET.getX() >= 275){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(36,ET.getY());
            ET.setLocation(32,ET.getY());
            direction = "R";
            checkTile(location, ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() - 230, GreatComputer.detective.getY());
        }
        return location;
    }

    public int detectUDEdge(JLabel ET, int l, JLabel energyUI){
        location = l;
        // Top edge
        if (ET.getY() <= 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),140);
            direction = "U";
            checkTile(location, ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() + 150);
        }
        // bottom edge
        else if (ET.getY() >= 150){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),30);
            direction = "D";
            checkTile(location, ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() - 150);
        }
        return location;
    }

    public void detectpit(JLabel ET, int l, JLabel energyUI){
        location = l;

        if (location == 3 || location == 7){
            if (ET.getX() >= 208 && ET.getX() <= 239 && ET.getY() >= 105 && ET.getY() <= 135){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                location = 10;
                setTile(location, ET, energyUI);
            }
        }

    }

    public int getLocation(){
        return location;
    }



}
