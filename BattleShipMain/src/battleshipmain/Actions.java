package battleshipmain;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Actions extends GameSetUp {

    public boolean turnFlag = false;
    boolean PlaceFlag = false;
    public boolean flagShip = false;
    public boolean flagWhite3a = false;
    public boolean flagWhite3b = false;
    public boolean flagStart = false;
    public boolean flagReplace = false;
    public ArrayList<Integer> exceptionList = new ArrayList<>();
    
    public String SetName() {
        String name=JOptionPane.showInputDialog("Enter Your Name:");
        return name;
    }

    public void Placed(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2, ArrayList<Integer> List, Ships ships[],ArrayList<Integer> shipCountPlaced) { // method for placing the ships
        int poss = Integer.valueOf(pos); // the value for the first block
        
        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) { // size is the size of the ship that will be placed
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j); // adding to list so we know the coordinates of the ships
                        // battle.finalList.add(j);
                        flagP = true;
                        ShipCounter++;
                        if (size == 3) {
                            countShipSize3++;
                            if (countShipSize3 > 3) {
                                shipCountPlaced.add(size);
                                ships[1].setPos(j);// adding pos to ships entity info

                            } else {
                                shipCountPlaced.add(size);
                                ships[size].setPos(j);// adding pos to ships entity info
                            }
                        } else {
                            shipCountPlaced.add(size);
                            ships[size].setPos(j);// adding pos to ships entity info
                        }
                    }
                }
            }
            flagShip = false;
        } 
        else {
            for (int j = poss; j < poss + size; j++) { // size is the size of the ship that will be placed
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j); // adding to list so we know the coordinates of the ships
                        // battle.finalList.add(j);
                        flagP = true;
                        ShipCounter++;
                        if (size == 3) {
                            countShipSize3++;
                            if (countShipSize3 > 3) {
                                shipCountPlaced.add(size);
                                ships[1].setPos(j);// adding pos to ships entity info

                            } else {
                                shipCountPlaced.add(size);
                                ships[size].setPos(j);// adding pos to ships entity info
                            }
                        } else {
                            shipCountPlaced.add(size);
                            ships[size].setPos(j);// adding pos to ships entity info
                        }
                    }
                }
            }
            flagShip = false;
        }
        turnFlag = false;// turning flag
        System.out.println("GameSetUp List2 ships placed " + List2);
        System.out.println("Ship count that placed " + shipCountPlaced);

        if (size == 5) {
            for (int k = 0; k < size; k++) {
                t[k].setBackground(Color.white);
            }
        }
        if (size == 4) {
            for (int k = 5; k < 9; k++) {
                t[k].setBackground(Color.white);
            }
        }
        if (size == 3 && flagWhite3a) {
            for (int k = 10; k < 13; k++) {
                t[k].setBackground(Color.white);
                flagWhite3a = false;
            }
        }
        if (size == 3 && flagWhite3b) {
            for (int k = 15; k < 18; k++) {
                t[k].setBackground(Color.white);
                flagWhite3b = false;
            }
        }
        if (size == 2) {
            for (int k = 20; k < 22; k++) {
                t[k].setBackground(Color.white);
            }
        }
       
        if (ShipCounter == 17) {
            flagStart = true;
        }
        
        for (int j = 0; j < 100; j++) {
            if(exceptionList.contains(j)){
                b[j].setBackground(Color.cyan);
            }
        }
        exceptionList.clear(); 
    }

    public void Hover(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2) { // hovering over buttons
        int poss = Integer.valueOf(pos); // hovering the first block
        PlaceFlag = true;
        if (turnFlag) { // turning flag kafter click
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (j <= 99 && !(exceptionList.contains(j))) {
                    if (List2.contains(j) || (poss + (size * 10)) > 110) { // check if the hover is on boundries or on
                        b[j].setBackground(Color.red); // other ship
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j); // if it is then RED
                    }
                    else {
                        b[j].setBackground(Color.green); // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) {
                if (j <= 99 && !(exceptionList.contains(j))) {
                    if (List2.contains(j) || ((poss + size - 1) % 10 < (size - 1)) && ((poss) % 10 != 0)) { // check if the hover is on boundries or on
                        b[j].setBackground(Color.red); // other ship
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j); // if it is then RED
                    }
                    else{
                        b[j].setBackground(Color.green); // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        }
        if(!flagReplace){
            if (size == 5) {
                for (int k = 0; k < size; k++) {
                    t[k].setBackground(Color.yellow);
                }
            }
            if (size == 4) {
                for (int k = 5; k < 9; k++) {
                    t[k].setBackground(Color.yellow);
                }
            }
            if (size == 3 && flagWhite3a) {
                for (int k = 10; k < 13; k++) {
                    t[k].setBackground(Color.yellow);
                }
            }
            if (size == 3 && flagWhite3b) {
                for (int k = 15; k < 18; k++) {
                    t[k].setBackground(Color.yellow);
                }
            }
            if (size == 2) {
                for (int k = 20; k < 22; k++) {
                    t[k].setBackground(Color.yellow);
                }
            }
        }
    }
    
    public void HoverOut(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2) { // hovering out
        int poss = Integer.valueOf(pos); // hovering out the first block
        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (List2.contains(j)) {
                    if (j <= 99 && !(exceptionList.contains(j))) {
                        b[j].setBackground(Color.DARK_GRAY);
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99 && !(exceptionList.contains(j))) {
                        b[j].setBackground(Color.cyan);
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) {
                if (List2.contains(j)) {
                    if (j <= 99 && !(exceptionList.contains(j))) {
                        b[j].setBackground(Color.DARK_GRAY);
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99 && !(exceptionList.contains(j))) {
                        b[j].setBackground(Color.cyan); 
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        }
    }
    
    public int Replace(String pos, JButton[] b, ArrayList<Integer> List2, Ships ships[]){
        int shipNumber;
        int position = Integer.parseInt(pos);
        
        for (shipNumber = 1; shipNumber<= 5; shipNumber++) {
            if(ships[shipNumber].getPos().contains(position)){
                break;
            }
        }
        int in = ships[shipNumber].getPos().get(0);
        int num = ships[shipNumber].getSize() + in;
        
        for(int j = in; j < num; j++){
                b[j].setBackground(Color.yellow);
                exceptionList.add(j);
        }
             
        ships[shipNumber].getPos().clear();
        return shipNumber;
    }
}