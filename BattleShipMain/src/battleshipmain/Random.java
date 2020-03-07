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


    public int Random() {
        int min = 0;
        int max = 99;

        // Generate five random number between 10 and 50
        int num = (int) (Math.random() * (max - min + 1)) + min;

        return num;
    }

    public int Random1() {
        int min = 0;
        int max = 1;

        // Generate five random number between 10 and 50
        int num = (int) (Math.random() * (max - min + 1)) + min;

        return num;
    }

    public int RandomHit(ArrayList list) {
        int index = (int) (Math.random() * list.size());
        System.out.println("\nIndex :" + index);
        int x = (int) list.get(index);
        list.remove(index);
        return x ;
    }
}
