package battleshipmain;

import java.util.ArrayList;
import javax.swing.*;

public class GiveName {
    GameSetUp g = new GameSetUp();
    public String GiveName() {
        JFrame f;  
        f=new JFrame();   
        String name=JOptionPane.showInputDialog(f,"Enter Your Name:");
        return name;   
    }
}