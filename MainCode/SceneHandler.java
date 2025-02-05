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

    private int intNumPiece;

    JLabel JLphonePiece1;
    JLabel JLphonePiece2;
    JLabel JLphonePiece3;

    private boolean blnPhonePiece1Alive = true;
    private boolean blnPhonePiece2Alive = true;
    private boolean blnPhonePiece3Alive = true;

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
    public void checkTile(JLabel et, JLabel energyUI, JLabel arrows){
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
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
        setTile(ET, energyUI, arrows);
            }
            default -> {
            }
        }
    }
    public void setTile(JLabel ET, JLabel energyUI1, JLabel arrows){
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
        game.add(arrows);
        game.update(game.getGraphics());
    }

    public void arrowHandler(JLabel arrows, ImageIcon arrowLeft, ImageIcon arrowRight, ImageIcon arrowUp, ImageIcon arrowDown, int location){
        if(location == 3 || location == 4 || location == 5 || location == 6 || location == 7){
            if(blnPhonePiece1Alive){}
                if(PhonePieceSpawns.phonePiece1Map > location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowRight);
                    System.out.println("Right Arrow");
                }
                else if(PhonePieceSpawns.phonePiece1Map < location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowLeft);
                    System.out.println("Left Arrow");
                }
                else if(PhonePieceSpawns.phonePiece1Map == location){
                    arrows.setVisible(false);
                }


                if(location == 4 || location == 8){
                    if(PhonePieceSpawns.phonePiece1Map == 1){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if(PhonePieceSpawns.phonePiece1Map == 8 && location == 4){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }
                else if(location == 6 || location == 9){
                    if(PhonePieceSpawns.phonePiece1Map == 2){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if (PhonePieceSpawns.phonePiece1Map == 9 && location == 6){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }

            }
            if(!blnPhonePiece1Alive && blnPhonePiece2Alive){
                if(PhonePieceSpawns.phonePiece2Map > location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowRight);
                    System.out.println("Right Arrow");
                }
                else if(PhonePieceSpawns.phonePiece2Map < location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowLeft);
                    System.out.println("Left Arrow");
                }
                else if(PhonePieceSpawns.phonePiece2Map == location){
                    arrows.setVisible(false);
                }

                if(location == 4 || location == 8){
                    if(PhonePieceSpawns.phonePiece2Map == 1){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if(PhonePieceSpawns.phonePiece2Map == 8 && location == 4){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }
                else if(location == 6 || location == 9){
                    if(PhonePieceSpawns.phonePiece2Map == 2){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if (PhonePieceSpawns.phonePiece2Map == 9 && location == 6){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }
            }
            if(!blnPhonePiece1Alive && !blnPhonePiece2Alive && blnPhonePiece3Alive){
                if(PhonePieceSpawns.phonePiece3Map > location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowRight);
                    System.out.println("Right Arrow");
                }
                else if(PhonePieceSpawns.phonePiece3Map < location){
                    arrows.setVisible(true);
                    arrows.setIcon(arrowLeft);
                    System.out.println("Left Arrow");
                }
                else if(PhonePieceSpawns.phonePiece1Map == location){
                    arrows.setVisible(false);
                }

                if(location == 4 || location == 8){
                    if(PhonePieceSpawns.phonePiece1Map == 1){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if(PhonePieceSpawns.phonePiece1Map == 8 && location == 4){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }
                else if(location == 6 || location == 9){
                    if(PhonePieceSpawns.phonePiece3Map == 2){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowUp);
                        System.out.println("Up Arrow");
                    }
                    else if (PhonePieceSpawns.phonePiece3Map == 9 && location == 6){
                        arrows.setVisible(true);
                        arrows.setIcon(arrowDown);
                        System.out.println("Down Arrow");
                    }
                }
            }

        else{
            arrows.setVisible(false);
        }
    }

    // detects Left and right edges of the screen
    public void detectLREdge(JLabel ET, JLabel energyUI, JLabel arrows){
        // Left edge
        if (ET.getX() <= 30 ){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(270,ET.getY());
            direction = "L";
            checkTile(ET, energyUI, arrows);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() + 230, GreatComputer.detective.getY());
        }
        // Right edge
        else if (ET.getX() >= 275){
            System.out.println("Edge Detected");
            //System.out.println(ET.getX());
            ET.setLocation(36,ET.getY());
            ET.setLocation(32,ET.getY());
            direction = "R";
            checkTile(ET, energyUI, arrows);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX() - 230, GreatComputer.detective.getY());
        }
    }

    public void detectUDEdge(JLabel ET, JLabel energyUI, JLabel arrows){
        // Top edge
        if (ET.getY() <= 20){
            System.out.println("Edge Detected");
            System.out.println(ET.getY());
            // screenChange(intScreenNum + 1);
            ET.setLocation(ET.getX(),140);
            direction = "U";
            checkTile(ET, energyUI, arrows);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() + 100);
        }
        // bottom edge
        else if (ET.getY() >= 150){
            System.out.println("Edge Detected");
            // screenChange(intScreenNum - 1);
            System.out.println(ET.getY());
            ET.setLocation(ET.getX(),30);
            direction = "D";
            checkTile(ET, energyUI, arrows);
            GreatComputer.detective.setLocation(GreatComputer.detective.getX(), GreatComputer.detective.getY() - 100);
        }
    }

    public int detectpit(JLabel ET,  JLabel energyUI){

        previousLocation = Movement.location;

        if (Movement.location == 3 || Movement.location == 7){
            //bottem right
            if (ET.getX() >= 182 && ET.getX() <= 239 && ET.getY() >= 100 && ET.getY() <= 116){
                System.out.println("Pit Detected");
                Movement.isInPit = true;

                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile( ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom left
            if (ET.getX() >= 64 && ET.getX() <= 110 && ET.getY() >= 100 && ET.getY() <= 116){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI,arrows);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top left
            if (ET.getX() >= 64 && ET.getX() <= 110 && ET.getY() >= 34 && ET.getY() <= 52){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 182 && ET.getX() <= 239 && ET.getY() >= 34 && ET.getY() <= 52){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                Movement.location = 10;
                game.remove(GreatComputer.detective);
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 3 || PhonePieceSpawns.phonePiece1Map == 7){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 3 || PhonePieceSpawns.phonePiece2Map == 7){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece3Map == 3 || PhonePieceSpawns.phonePiece3Map == 7){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
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
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom right
            if (ET.getX() >= 148 && ET.getX() <= 160 && ET.getY() >= 96 && ET.getY() <= 104){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top left
            if (ET.getX() >= 148 && ET.getX() <= 160 && ET.getY() >= 48 && ET.getY() <= 56){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 224 && ET.getX() <= 238 && ET.getY() >= 56 && ET.getY() <= 104){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 1 || PhonePieceSpawns.phonePiece1Map == 2){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 1 || PhonePieceSpawns.phonePiece2Map == 2){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
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
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //top right
            if (ET.getX() >= 188 && ET.getX() <= 232 && ET.getY() >= 44 && ET.getY() <= 64){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom left
            if (ET.getX() >= 74 && ET.getX() <= 114 && ET.getY() >= 100 && ET.getY() <= 108){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            //bottom right
            if (ET.getX() >= 188 && ET.getX() <= 232 && ET.getY() >= 100 && ET.getY() <= 108){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 8 || PhonePieceSpawns.phonePiece1Map == 9){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 8 || PhonePieceSpawns.phonePiece2Map == 9){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
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
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 4){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 4){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 4){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // middle right pit
            else if(ET.getX() >=214 && ET.getX() <= 228 && ET.getY() >= 71 && ET.getY() <=83){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 5){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 5){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 5){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top center pit
            else if(ET.getX() >= 134 && ET.getX() <= 174 && ET.getY() >= 33 && ET.getY() <=39){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                Movement.location = 10;
                setTile( ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 2){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 2){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 2){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom middle pit
            else if(ET.getX() >= 134 && ET.getX() <= 174 && ET.getY() >= 115 && ET.getY() <= 121){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 7){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 7){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 7){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom right pit
            else if(ET.getX() >= 32 && ET.getX() <= 54 && ET.getY() >= 113 && ET.getY() <= 123){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 8){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 8){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 8){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top right pit
            else if(ET.getX() >= 32 && ET.getX() <= 54 && ET.getY() >= 29 && ET.getY() <= 41){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 3){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 3){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 3){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // top left pit
            else if(ET.getX() >= 264 && ET.getX() <= 274 && ET.getY() >= 29 && ET.getY() <= 41){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 1){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 1){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 1){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
                    }
                }else{
                    System.err.println("ERROR: piece thought it was in the wrong spot");
                }
                return previousLocation;
            }
            // bottom left pit
            else if(ET.getX() >= 266 && ET.getX() <= 274 && ET.getY() >= 113 && ET.getY() <= 123){
                System.out.println("Pit Detected");
                Movement.isInPit = true;
                ET.setLocation(150, 128);
                game.remove(GreatComputer.detective);
                Movement.location = 10;
                setTile(ET, energyUI, arrows);
                if(PhonePieceSpawns.phonePiece1Map == 5){
                    if(PhonePieceSpawns.phonePiece1Hole == 6){
                        JLphonePiece1 = new JLabel(phonePiece1);
                        JLphonePiece1.setSize(16,10);
                        JLphonePiece1.setLocation(140,128);
                        JLphonePiece1.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece1);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece1Alive = pieceCollection(JLphonePiece1);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece2Hole == 6){
                        JLphonePiece2 = new JLabel(phonePiece2);
                        JLphonePiece2.setSize(16,10);
                        JLphonePiece2.setLocation(140,128);
                        JLphonePiece2.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece2);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece2Alive = pieceCollection(JLphonePiece2);
                    }
                }else if(PhonePieceSpawns.phonePiece2Map == 5){
                    if(PhonePieceSpawns.phonePiece3Hole == 6){
                        JLphonePiece3 = new JLabel(phonePiece3);
                        JLphonePiece3.setSize(16,10);
                        JLphonePiece3.setLocation(140,128);
                        JLphonePiece3.setVisible(true);
                        game.remove(background);
                        game.remove(ET);
                        game.remove(energyUI);
                        game.add(JLphonePiece3);
                        game.add(energyUI);
                        game.add(ET);
                        game.add(background);
                        game.update(game.getGraphics());
                        blnPhonePiece3Alive = pieceCollection(JLphonePiece3);
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
        if (Movement.location == 10 && ET.getY() <= 20){
            System.out.println("left pit");
            ET.setLocation(ET.getX(),140);
            //game.add(GreatComputer.detective);
            Movement.location = previousLocation;
            setTile(ET, energyUI, arrows);
            Movement.isInPit = false;
        }
    }

    // deletes piece if it got collected
    private boolean pieceCollection(JLabel phonePiece){
        if(previousLocation == PhonePieceSpawns.phonePiece1Map || previousLocation == PhonePieceSpawns.phonePiece2Map || previousLocation == PhonePieceSpawns.phonePiece3Map){
            if(phonePiece == JLphonePiece1 && blnPhonePiece1Alive){
                if(Movement.location == 10 && ET.getX() >= 140 && ET.getX() <= 156 && ET.getY() >= 128 && ET.getY() <= 138){
                    JLphonePiece1.remove(JLphonePiece1);
                    JLphonePiece1.setVisible(false);

                    intNumPiece++;

                    System.out.println("Piece 1 get!");

                    return false;
                }
                else{
                    return true;
                }
            }
            else if(phonePiece == JLphonePiece2 && blnPhonePiece2Alive){
                if(Movement.location == 10 && ET.getX() >= 140 && ET.getX() <= 156 && ET.getY() >= 128 && ET.getY() <= 138){
                    JLphonePiece2.remove(JLphonePiece2);
                    JLphonePiece2.setVisible(false);

                    intNumPiece++;

                    System.out.println("Piece 2 get!");

                    return false;
                }
                else{
                    return true;
                }
            }
            else if(phonePiece == JLphonePiece3 && blnPhonePiece3Alive){
                if(Movement.location == 10 && ET.getX() >= 140 && ET.getX() <= 156 && ET.getY() >= 128 && ET.getY() <= 138){
                    JLphonePiece3.remove(JLphonePiece3);
                    JLphonePiece3.setVisible(false);

                    intNumPiece++;

                    System.out.println("Piece 3 get!");

                    return false;
                }
                else{
                    return true;
                }
            }

        return true;
    }
        return true;
    }
}
