/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmain;

import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author mikep
 */
public class Random {


    public int Random() { // random number from 0 to 99 for first block of the ship
        int min = 0;
        int max = 99;
        int num = (int) (Math.random() * (max - min + 1)) + min;

        return num;
    }

    public int Random1() { // random 0 or 1 ... 0 horizontal.. 1 vertical random positions 
        int min = 0;
        int max = 1;
        int num = (int) (Math.random() * (max - min + 1)) + min;

        return num;
    }

    public int RandomHit(ArrayList list) {  // random hit ... with every hit the number goes off the list 
        int index = (int) (Math.random() * list.size());
        System.out.println("\nIndex :" + index);
        int x = (int) list.get(index);
        list.remove(index);
        return x ;
    }
}
