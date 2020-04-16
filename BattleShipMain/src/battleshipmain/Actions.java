package battleshipmain;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;

public class Actions extends GameSetUp {

    public boolean turnFlag = false;
    boolean PlaceFlag = true;
    public boolean flagShip = false;
    public boolean flagWhite3a = false;
    public boolean flagWhite3b = false;
    public boolean flagStart = false;

    public void Placed(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2, ArrayList<Integer> List, Ships ships[]) { // method for placing the ships
        int poss = Integer.valueOf(pos); // the value for the first block
        ShipCounter++;
        if (ShipCounter == 5) {
            flagStart = true;
        }
        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) { // size is the size of the ship that will be placed
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j); // adding to list so we know the coordinates of the ships
                        // battle.finalList.add(j);
                        flagP = true;
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
        } else {
            for (int j = poss; j < poss + size; j++) { // size is the size of the ship that will be placed
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j); // adding to list so we know the coordinates of the ships
                        // battle.finalList.add(j);
                        flagP = true;
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
        }
        turnFlag = false;// turning flag
        flagShip = false; // preventing from placing 2 times
        System.out.println("GameSetUp List2 ships placed " + List2);
        System.out.println("Ship count that placed Placed " + shipCountPlaced);

        if (size == 5) {
            for (int k = 0; k < size; k++) {
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 4) {
            for (int k = 5; k < 9; k++) {
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 3 && flagWhite3a) {
            for (int k = 10; k < 13; k++) {
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0, 0, 0, 0));
                flagWhite3a = false;
            }
        }
        if (size == 3 && flagWhite3b) {
            for (int k = 15; k < 18; k++) {
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0, 0, 0, 0));
                flagWhite3b = false;
            }
        }
        if (size == 2) {
            for (int k = 20; k < 22; k++) {
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }

    }

    public void Hover(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2) { // hovering over buttons
        int poss = Integer.valueOf(pos); // hovering the first block
        PlaceFlag = true;
        if (turnFlag) { // turning flag kafter click
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (j <= 99) {
                    if (List2.contains(j) || (poss + (size * 10)) > 110) { // check if the hover is on boundries or on
                        b[j].setBackground(Color.red);
                        b[j].setForeground(new Color(0, 0, 0, 0)); // other ship
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j); // if it is then RED
                    } else {
                        b[j].setBackground(Color.green);
                        b[j].setForeground(new Color(0, 0, 0, 0)); // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) {
                if (j <= 99) {
                    if (List2.contains(j) || ((poss + size - 1) % 10 < (size - 1)) && ((poss) % 10 != 0)) { // check if the hover is on boundries or on
                        b[j].setBackground(Color.red);
                        b[j].setForeground(new Color(0, 0, 0, 0)); // other ship
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j); // if it is then RED
                    } else {
                        b[j].setBackground(Color.green);
                        b[j].setForeground(new Color(0, 0, 0, 0)); // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        }
        if (size == 5) {
            for (int k = 0; k < size; k++) {
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 4) {
            for (int k = 5; k < 9; k++) {
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 3 && flagWhite3a) {
            for (int k = 10; k < 13; k++) {
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 3 && flagWhite3b) {
            for (int k = 15; k < 18; k++) {
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
        if (size == 2) {
            for (int k = 20; k < 22; k++) {
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0, 0, 0, 0));
            }
        }
    }
    
    public void HoverOut(String pos, int size, JButton[] b, JButton t[], ArrayList<Integer> List2) { // hovering out
        int poss = Integer.valueOf(pos); // hovering out the first block
        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (List2.contains(j)) {
                    if (j <= 99) {
                        b[j].setBackground(Color.DARK_GRAY);
                        b[j].setForeground(new Color(0, 0, 0, 0));
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99) {
                        b[j].setBackground(Color.cyan); // hovering out of empty block back to cyan OLO MOY TO GANG
                        // ANIMAL
                        b[j].setForeground(new Color(0, 0, 0, 0));
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) {
                if (List2.contains(j)) {
                    if (j <= 99) {
                        b[j].setBackground(Color.DARK_GRAY);
                        b[j].setForeground(new Color(0, 0, 0, 0));
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99) {
                        b[j].setBackground(Color.cyan); // hovering out of empty block back to cyan OLO MOY TO GANG
                        // ANIMAL
                        b[j].setForeground(new Color(0, 0, 0, 0));
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        }
    }

}
