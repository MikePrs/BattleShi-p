package battleshipmain;

import javax.swing.UIManager;

public class BattleShipMain {

    public static void main(String[] args) {
        
         try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        GameSetUp game = new GameSetUp();
        game.GameSetUp();
    }
    
}
