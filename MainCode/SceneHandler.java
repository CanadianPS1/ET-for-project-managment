package MainCode;

import javax.swing.JFrame;

public class SceneHandler extends Movement {

        
    public SceneHandler(JFrame g, int nS){
        game = g;
        nextScreen = nS;
        System.out.println("Next Tile is : " + nextScreen);
    }




}
