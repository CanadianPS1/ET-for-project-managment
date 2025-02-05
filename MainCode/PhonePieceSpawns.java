package MainCode;
import java.util.Random;

import javax.swing.JFrame;
public class PhonePieceSpawns extends SceneHandler{
    private Random rand = new Random();
    protected static int phonePiece1Map, phonePiece1Hole;
    protected static int phonePiece2Map, phonePiece2Hole;
    protected static int phonePiece3Map, phonePiece3Hole;

    public PhonePieceSpawns(JFrame g, int e){
        super(g,e);
        phonePiece1Map = rand.nextInt(1,5);
        phonePiece2Map = rand.nextInt(1,5);
        phonePiece3Map = rand.nextInt(1,5);
        //generates the locations for the first phone piece
        switch (phonePiece1Map) {
            case 1 -> {
                phonePiece1Hole = rand.nextInt(1,5);
                phonePiece1Map =  rand.nextInt(1,3);
                if(phonePiece1Map == 1){
                    phonePiece1Map = 8;
                }else{
                    phonePiece1Map = 9;
                }
            }
            case 2 -> {
                phonePiece1Hole = rand.nextInt(1,5);
                phonePiece1Map =  rand.nextInt(1,3);
                if(phonePiece1Map == 1){
                    phonePiece1Map = 3;
                }else{
                    phonePiece1Map = 7;
                }
            }
            case 3 -> {
                phonePiece1Hole = rand.nextInt(1,5);
                phonePiece1Map =  rand.nextInt(1,3);
                if(phonePiece1Map != 1){
                    phonePiece1Map = 2;
                }
            }
            case 4 -> {
                phonePiece1Hole = rand.nextInt(1,9);
                phonePiece1Map = 5;
            }
            default -> System.err.println("ERROR: invalid map id at phone piece 1 Map spawns");
        }


        //generates the locations for the second phone piece
        switch (phonePiece2Map) {
            case 1 -> {
                phonePiece2Hole = rand.nextInt(1,5);
                phonePiece2Map =  rand.nextInt(1,3);
                if(phonePiece2Map == 1){
                    phonePiece2Map = 8;
                }else{
                    phonePiece2Map = 9;
                }
            }
            case 2 -> {
                phonePiece2Hole = rand.nextInt(1,5);
                phonePiece2Map =  rand.nextInt(1,3);
                if(phonePiece2Map == 1){
                    phonePiece2Map = 3;
                }else{
                    phonePiece2Map = 7;
                }
            }
            case 3 -> {
                phonePiece2Hole = rand.nextInt(1,5);
                phonePiece2Map =  rand.nextInt(1,3);
                if(phonePiece2Map != 1){
                    phonePiece2Map = 2;
                }
            }
            case 4 -> {
                phonePiece2Hole = rand.nextInt(1,9);
                phonePiece2Map = 5;
            }
            default -> System.err.println("ERROR: invalid map id at phone piece 2 Map spawns");
        }

        //generates the locations for the third phone piece
        switch (phonePiece3Map) {
            case 1 -> {
                phonePiece3Hole = rand.nextInt(1,5);
                phonePiece3Map =  rand.nextInt(1,3);
                if(phonePiece3Map == 1){
                    phonePiece3Map = 8;
                }else{
                    phonePiece3Map = 9;
                }
            }
            case 2 -> {
                phonePiece3Hole = rand.nextInt(1,5);
                phonePiece3Map =  rand.nextInt(1,3);
                if(phonePiece3Map == 1){
                    phonePiece3Map = 3;
                }else{
                    phonePiece3Map = 7;
                }
            }
            case 3 -> {
                phonePiece3Hole = rand.nextInt(1,5);
                phonePiece3Map =  rand.nextInt(1,3);
                if(phonePiece3Map != 1){
                    phonePiece3Map = 2;
                }
            }
            case 4 -> {
                phonePiece3Hole = rand.nextInt(1,9);
                phonePiece3Map = 5;
            }
            default -> System.err.println("ERROR: invalid map id at phone piece 3 Map spawns");
        }
        

    }
}
