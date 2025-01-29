package MainCode;

import javax.swing.*;


public class SceneHandler extends Movement {
    ImageIcon pit3 = new ImageIcon("seperated sprites\\Screens\\Pits03.png");
    ImageIcon pit2 = new ImageIcon("seperated sprites\\Screens\\Pits02.png");
    ImageIcon forest = new ImageIcon("seperated sprites\\Screens\\Forest.png");
    ImageIcon pit4 = new ImageIcon("seperated sprites\\Screens\\Pits04.png");
    ImageIcon pit1 = new ImageIcon("seperated sprites\\Screens\\Pits01.png");
    ImageIcon DC = new ImageIcon("seperated sprites\\Screens\\DC.png");



    

    private int intCurrentX = 1;
    private int intCurrentY = 1;
    private JLabel background;
    private String direction;

    public SceneHandler(JFrame g){
        game = g;     
        background = new JLabel();

        background.setSize(320,210);


        background.setVisible(true);

        game.add(background);           
    }
    public void checkTile(int location, JLabel et){
        ET = et;
        if(location == 1){
            if(direction.equals("L")){
                location = 2;
            }else if(direction.equals("R")){
                location = 2;
            }else if(direction.equals("U")){
                location = 8;
            }else if(direction.equals("D")){
                location = 4;
            }
            setTile(location, ET);

        }else if(location == 2){
            if(direction.equals("L")){
                location = 1;
            }else if(direction.equals("R")){
                location = 1;
            }else if(direction.equals("U")){
                location = 9;
            }else if(direction.equals("D")){
                location = 6;
            }
            setTile(location, ET);

        }else if(location == 3){
            if(direction.equals("L")){
                location = 7;
            }else if(direction.equals("R")){
                location = 4;
            }else if(direction.equals("U")){
                location = 3;
            }else if(direction.equals("D")){
                location = 3;
            }
            setTile(location, ET);

        }else if(location == 4){
            if(direction.equals("L")){
                location = 3;
            }else if(direction.equals("R")){
                location = 5;
            }else if(direction.equals("U")){
                location = 1;
            }else if(direction.equals("D")){
                location = 8;
            }
            setTile(location, ET);

        }else if(location == 5){
            if(direction.equals("L")){
                location = 4;
            }else if(direction.equals("R")){
                location = 6;
            }else if(direction.equals("U")){
                location = 5;
            }else if(direction.equals("D")){
                location = 5;
            }
            setTile(location, ET);

        }else if(location == 6){
            if(direction.equals("L")){
                location = 5;
            }else if(direction.equals("R")){
                location = 7;
            }else if(direction.equals("U")){
                location = 2;
            }else if(direction.equals("D")){
                location = 9;
            }
            setTile(location, ET);

        }else if(location == 7){
            if(direction.equals("L")){
                location = 7;
            }else if(direction.equals("R")){
                location = 3;
            }else if(direction.equals("U")){
                location = 7;
            }else if(direction.equals("D")){
                location = 7;
            }
            setTile(location, ET);

        }else if(location == 8){
            if(direction.equals("L")){
                location = 9;
            }else if(direction.equals("R")){
                location = 9;
            }else if(direction.equals("U")){
                location = 4;
            }else if(direction.equals("D")){
                location = 1;
            }
            setTile(location, ET);

        }else if(location == 9){
            if(direction.equals("L")){
                location = 8;
            }else if(direction.equals("R")){
                location = 8;
            }else if(direction.equals("U")){
                location = 6;
            }else if(direction.equals("D")){
                location = 2;
            }
            setTile(location, ET);

        }
    }
    public void setTile(int location, JLabel ET){
        if(location == 1){
            background.setIcon(pit3);
        }else if(location == 2){
            background.setIcon(pit3);
        }else if(location == 3){
            background.setIcon(pit2);
        }else if(location == 4){
            background.setIcon(forest);
        }else if(location == 5){
            background.setIcon(pit4);
        }else if(location == 6){
            background.setIcon(DC);
        }else if(location == 8){
            background.setIcon(pit1);
        }else if(location == 9){
            background.setIcon(pit1);
        }
        game.remove(background);
        game.remove(ET);
        game.add(ET);
        game.add(background);
    }

    // detects Left and right edges of the screen
    public void detectLREdge(JLabel ET, int location){
        // Left edge
        if (ET.getX() == -2 || ET.getX() == -1){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            ET.setLocation(300,ET.getY());
            direction = "L";
            checkTile(location, ET);
        }
        // Right edge
        else if (ET.getX() == 300 || ET.getX() == 301){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            ET.setLocation(1,ET.getY());
            direction = "R";
            checkTile(location, ET);
        }
    }

    public void detectUDEdge(JLabel ET, int location){
        // Top edge
        if (ET.getY() == 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),150);
            direction = "U";
            checkTile(location, ET);
        }
        // bottom edge
        else if (ET.getY() == 160){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),22);
            direction = "D";
            checkTile(location, ET);
        }
    }





}
