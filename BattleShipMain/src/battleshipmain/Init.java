package battleshipmain;

import java.util.ArrayList;

public class Init {

    public int[] Ship5 = new int[5];
    public int[] Ship4 = new int[4];
    public int[] Ship3 = new int[3];
    public int[] Ship2 = new int[3];
    public int[] Ship1 = new int[2];
    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<Integer> shipPos = new ArrayList<>();
    int Ships[][] = {Ship1, Ship2, Ship3, Ship4, Ship5};

    public int[][] InitMatrix() {

        Random rnd = new Random();

        for (int j = 0; j < 5; j++) {

            int rn = rnd.Random1();  // random direction
            System.out.println(rn);
            switch (rn) {
                case 1:
                    for (int i = 0; i < Ships[j].length; i++) { // check boundries
                        if (i == 0) {
                            Ships[j][0] = rnd.Random(); // random ship start
                        }
                        if (i > 0) {
                            Ships[j][i] = Ships[j][i - 1] + 10;
                        }
                        if (Ships[j][i] > 99) {
                            i = 0; 
                        }
                        if (temp.contains(Ships[j][i])) {// in case ships step in another
                            System.out.println("---same block---" + Ships[j][i]);
                           j--;
                            break;   
                        }
                        temp.add(Ships[j][i]);
                    }
                    break;
                case 0:
                    for (int i = 0; i < Ships[j].length; i++) { // check boundries
                        if (i == 0) {
                            Ships[j][0] = rnd.Random(); // random ship start
                        }
                        if ((Ships[j][i]%10+5 > 9)) { // prevent ship to placed half 
                            System.out.println("---split line---" + Ships[j][i]+i);
                             j--;
                            break;  
                        }
                        if (i > 0) {
                            Ships[j][i] = Ships[j][i - 1] + 1;
                        }
                        if (temp.contains(Ships[j][i])) { // in case ships falls on another one 
                            System.out.println("---same block----" + Ships[j][i]);
                             j--;
                            break;
                        }
                        temp.add(Ships[j][i]);
                    }
                    break;
                default:
                    break;
            }
        }
        return Ships;
    }

    public ArrayList<Integer> IntList() {
        ArrayList<Integer> List = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            List.add(i);
        }
        return List;
    }

    public int[][] InitShips() {
        Random rnd = new Random();
        shipPos = IntList();
        for (int j = 0; j < 5; j++) {
            Ships[j][0] = rnd.Random(); // random ship start
            int rn = rnd.Random1();  // random direction
            System.out.println("Direction "+rn);
            switch (rn) {
                case 1:
                    for (int i = 0; i < Ships[j].length; i++) { // check boundries
                        if (i == 0) {
                            Ships[j][i] = rnd.RandomHit(shipPos);
                        }
                        if (i > 0) {
                            Ships[j][i] = Ships[j][i - 1] + 10;
                            shipPos.remove(shipPos.indexOf(Ships[j][i])); 
                        }
                    }
                    break;
                case 0:
                    for (int i = 0; i < Ships[j].length; i++) { // check boundries
                        if (i == 0) {
                            Ships[j][i] = rnd.RandomHit(shipPos);
                        }
                        if (i > 0) {
                            Ships[j][i] = Ships[j][i - 1] + 1;
                            shipPos.remove(shipPos.indexOf(Ships[j][i]));
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return Ships;
    }
}
