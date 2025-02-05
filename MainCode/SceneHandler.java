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


    ImageIcon phonePiece1 = new ImageIcon("seperated sprites\\E.T\\PhonePieces\\PhonePiece01.png");
    ImageIcon phonePiece2 = new ImageIcon("seperated sprites\\E.T\\PhonePieces\\PhonePiece02.png");
    ImageIcon phonePiece3 = new ImageIcon("seperated sprites\\E.T\\PhonePieces\\PhonePiece03.png");

    JLabel phonePiece;

    private final JLabel background;
    private String direction;
    protected static int previousLocation;
    public SceneHandler(JFrame g, int e){
        game = g;     
        background = new JLabel();

        background.setSize(320,210);


        background.setVisible(true);

        game.add(background);           
    }
    public void checkTile(JLabel et, JLabel energyUI){
        ET = et;
        switch (Movement.location) {
            case 1 -> {
            switch (direction) {
                case "L" -> Movement.location = 2;
                case "R" -> Movement.location = 2;
                case "U" -> Movement.location = 8;
                case "D" -> Movement.location = 4;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 2 -> {
            switch (direction) {
                case "L" -> Movement.location = 1;
                case "R" -> Movement.location = 1;
                case "U" -> Movement.location = 9;
                case "D" -> Movement.location = 6;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 3 -> {
            switch (direction) {
                case "L" -> Movement.location = 7;
                case "R" -> Movement.location = 4;
                case "U" -> Movement.location = 3;
                case "D" -> Movement.location = 3;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 4 -> {
            switch (direction) {
                case "L" -> Movement.location = 3;
                case "R" -> Movement.location = 5;
                case "U" -> Movement.location = 1;
                case "D" -> Movement.location = 8;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 5 -> {
            switch (direction) {
                case "L" -> Movement.location = 4;
                case "R" -> Movement.location = 6;
                case "U" -> Movement.location = 5;
                case "D" -> Movement.location = 5;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 6 -> {
            switch (direction) {
                case "L" -> Movement.location = 5;
                case "R" -> Movement.location = 7;
                case "U" -> Movement.location = 2;
                case "D" -> Movement.location = 9;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 7 -> {
            switch (direction) {
                case "L" -> Movement.location = 6;
                case "R" -> Movement.location = 3;
                case "U" -> Movement.location = 7;
                case "D" -> Movement.location = 7;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 8 -> {
            switch (direction) {
                case "L" -> Movement.location = 9;
                case "R" -> Movement.location = 9;
                case "U" -> Movement.location = 4;
                case "D" -> Movement.location = 1;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            case 9 -> {
            switch (direction) {
                case "L" -> Movement.location = 8;
                case "R" -> Movement.location = 8;
                case "U" -> Movement.location = 6;
                case "D" -> Movement.location = 2;
                default -> {
                }
            }
        setTile(ET, energyUI);
        }
            default -> {
            }
        }
    }
    public void setTile(JLabel ET, JLabel energyUI1){
        switch (Movement.location) {
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
    public void detectLREdge(JLabel ET, JLabel energyUI){
        // Left edge
        if (ET.getX() <= 30 ){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(270,ET.getY());
            direction = "L";
            checkTile(ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() + 230, GreatComputer.detective.getY());
        }
        // Right edge
        else if (ET.getX() >= 275){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(36,ET.getY());
            ET.setLocation(32,ET.getY());
            direction = "R";
            checkTile(ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() - 230, GreatComputer.detective.getY());
        }
    }

    public void detectUDEdge(JLabel ET,  JLabel energyUI){
        // Top edge
        if (ET.getY() <= 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),140);
            direction = "U";
            checkTile(ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() + 100);
        }
        // bottom edge
        else if (ET.getY() >= 150){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),30);
            direction = "D";
            checkTile(ET, energyUI);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() - 100);
        }
    }

    public int detectpit(JLabel ET,  JLabel energyUI){

        previousLocation = Movement.location;

        if (Movement.location == 3 || Movement.location == 7){
            //bottem right
            if (ET.getX() >= 182 && ET.getX() <= 239 && ET.getY() >= 100 && ET.getY() <= 116){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom left
            if (ET.getX() >= 64 && ET.getX() <= 110 && ET.getY() >= 100 && ET.getY() <= 116){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
                
            }
            //top left
            if (ET.getX() >= 64 && ET.getX() <= 110 && ET.getY() >= 34 && ET.getY() <= 52){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 182 && ET.getX() <= 239 && ET.getY() >= 34 && ET.getY() <= 52){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }

            return previousLocation;
        }
        else if (Movement.location == 1 || Movement.location == 2){
            //bottom left
            if (ET.getX() >= 71 && ET.getX() <= 84 && ET.getY() >= 62 && ET.getY() <= 102){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom right
            if (ET.getX() >= 148 && ET.getX() <= 160 && ET.getY() >= 96 && ET.getY() <= 104){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top left
            if (ET.getX() >= 148 && ET.getX() <= 160 && ET.getY() >= 48 && ET.getY() <= 56){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 224 && ET.getX() <= 238 && ET.getY() >= 56 && ET.getY() <= 104){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }

            return previousLocation;
        }else if (Movement.location == 8 || Movement.location == 9){
            //top left
            if (ET.getX() >= 74 && ET.getX() <= 114 && ET.getY() >= 44 && ET.getY() <= 64){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 188 && ET.getX() <= 232 && ET.getY() >= 44 && ET.getY() <= 64){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom left
            if (ET.getX() >= 74 && ET.getX() <= 114 && ET.getY() >= 100 && ET.getY() <= 108){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom right
            if (ET.getX() >= 188 && ET.getX() <= 232 && ET.getY() >= 100 && ET.getY() <= 108){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }

            return previousLocation;
        }
        else if(Movement.location == 5){
            // middle left pit
            if(ET.getX() >= 82 && ET.getX() <= 100 && ET.getY() >= 71 && ET.getY() <= 83){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // middle right pit
            else if(ET.getX() >=214 && ET.getX() <= 228 && ET.getY() >= 71 && ET.getY() <=83){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 5){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 5){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 5){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top center pit
            else if(ET.getX() >= 134 && ET.getX() <= 174 && ET.getY() >= 33 && ET.getY() <=39){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom middle pit
            else if(ET.getX() >= 134 && ET.getX() <= 174 && ET.getY() >= 115 && ET.getY() <= 121){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 7){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 7){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 7){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom right pit
            else if(ET.getX() >= 32 && ET.getX() <= 54 && ET.getY() >= 113 && ET.getY() <= 123){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 8){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 8){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 8){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top right pit
            else if(ET.getX() >= 32 && ET.getX() <= 54 && ET.getY() >= 29 && ET.getY() <= 41){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top left pit
            else if(ET.getX() >= 264 && ET.getX() <= 274 && ET.getY() >= 29 && ET.getY() <= 41){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom left pit
            else if(ET.getX() >= 266 && ET.getX() <= 274 && ET.getY() >= 113 && ET.getY() <= 123){
                System.out.println("Pit Detected");
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 6){
                        phonePiece = new JLabel(phonePiece1);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 6){
                        phonePiece = new JLabel(phonePiece2);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 6){
                        phonePiece = new JLabel(phonePiece3);
                        phonePiece.setSize(16,10);
                        phonePiece.setLocation(140,128);
                        phonePiece.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);

                        game.add(phonePiece);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
        }
        return previousLocation;
    }

    
    
    public void checkPitLeave(JLabel ET, JLabel energyUI){

        if (Movement.location == 10 && ET.getX() >= 173){
                setTile(ET, energyUI);
                Movement.location = previousLocation;
                game.add(GreatComputer.detective);
                game.remove(phonePiece);
                ET.setLocation(ET.getX(),140);
        }
        
    }



}
