package MainCode;

import javax.swing.*;


public class SceneHandler extends Movement {

    String[][] strScenePaths = new String[][]{
        {null,                                     "seperated sprites\\Screens\\Pits03.png", null,                                     "seperated sprites\\Screens\\Pits03.png",null},
        {"seperated sprites\\Screens\\Pits02.png", "seperated sprites\\Screens\\Forest.png", "seperated sprites\\Screens\\Pits04.png", "seperated sprites\\Screens\\DC.png","seperated sprites\\Screens\\Pits02.png"},
        {null,                                     "seperated sprites\\Screens\\Pits01.png", null,                                     "seperated sprites\\Screens\\Pits01.png",null}
    };

    private int intCurrentX = 1;
    private int intCurrentY = 1;

    private Directions direction = Directions.N;

    public SceneHandler(JFrame g){
        game = g;                
    }

    public void screenChange(){
        JLabel background = new JLabel();

        background.setSize(320,210);

        background.setIcon(new ImageIcon(strScenePaths[intCurrentX][intCurrentY]));

        background.setVisible(true);

        game.add(background);

        // direction = left
        if (direction.equals(this.direction.L)){
            try {
                if (strScenePaths[intCurrentX][intCurrentY + 1].equals(null)){
                    return;
                }
                else{
                    background.setIcon(new ImageIcon(strScenePaths[intCurrentX][intCurrentY + 1]));
                    intCurrentY++;

                    background.setVisible(true);
                    background.setLocation(0, 0);
    
                    System.out.println(strScenePaths[intCurrentX][intCurrentY]);
                }
            } catch (Exception e) {
                return;
            }

            
        }
        else if (direction.equals(this.direction.R)){
            if (strScenePaths[intCurrentX][intCurrentY - 1] == null){
                return;
            }
            else{
                background.setIcon(new ImageIcon(strScenePaths[intCurrentX][intCurrentY - 1]));
                intCurrentY--;
            }

        }
        else if (direction.equals(this.direction.U)){
            if (strScenePaths[intCurrentX + 1][intCurrentY] == null){
                return;
            }
            else{
                background.setIcon(new ImageIcon(strScenePaths[intCurrentX + 1][intCurrentY]));
                intCurrentX++;
            }
        }
        else if (direction.equals(this.direction.D)){
            if (strScenePaths[intCurrentX - 1][intCurrentY] == null){
                return;
            }
            else{
                background.setIcon(new ImageIcon(strScenePaths[intCurrentX - 1][intCurrentY]));
                intCurrentX--;

                System.out.println(intCurrentX);
            }
        }
        else if (direction.equals(this.direction.N)){
            return;
        }

        else{
            System.err.println("Error: Screen not found");
        }



    }

    // detects Left and right edges of the screen
    public void detectLREdge(JLabel ET){
        // Left edge
        if (ET.getX() == -2 || ET.getX() == -1){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            ET.setLocation(300,ET.getY());
            direction = Directions.L;
        }
        // Right edge
        else if (ET.getX() == 300 || ET.getX() == 301){
            System.out.println("Edge Detected");
            System.out.println(ET.getX());
            ET.setLocation(1,ET.getY());
            direction = Directions.R;
        }
    }

    public void detectUDEdge(JLabel ET){
        // Top edge
        if (ET.getY() == 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),150);
            direction = Directions.U;
        }
        // bottom edge
        else if (ET.getY() == 160){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),22);
            direction = Directions.D;
        }
    }





}
