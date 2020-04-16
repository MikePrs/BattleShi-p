package battleshipmain;

import javax.swing.*;

public class GiveName {
    
    public String SetName() {
        String name=JOptionPane.showInputDialog("Enter Your Name:");
        return name;   
    }
}