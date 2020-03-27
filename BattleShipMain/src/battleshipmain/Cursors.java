/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmain;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author mikep
 */
class Cursors {

    public Cursor Cursors() {
        Image x = Toolkit.getDefaultToolkit().getImage("src\\5.png");
       

        Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(x, new Point(0, 0), "cursor1");
        return c;
    }
}
