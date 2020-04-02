package battleshipmain;

import java.util.ArrayList;
import javax.swing.*;

public class GiveName {
    public String GiveName() {
        JFrame f;  
        f=new JFrame();   
        String name=JOptionPane.showInputDialog("Enter Your Name:");
        return name;   
    }
}