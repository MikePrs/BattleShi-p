package battleshipmain;

import javax.swing.*;

public class GiveName {
    public String GiveName() {
        JFrame f;  
        f=new JFrame();   
        String name=JOptionPane.showInputDialog(f,"Enter Your Name:");
        return name;   
    }  
}