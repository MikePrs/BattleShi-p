package battleshipmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameSetUp {

    JFrame f = new JFrame();
    JPanel jPanel1 = new JPanel(new BorderLayout());
    JPanel jPanelN = new JPanel(new BorderLayout()); //jPanelNORTH
    JPanel jPanelC = new JPanel(new BorderLayout()); //PanelCENTER
    JPanel jPanelCW = new JPanel(new BorderLayout()); //PanelCENTER WEST
    JPanel jPanelCE = new JPanel(new BorderLayout()); //PanelCENTER EAST
    JPanel jPanelCWS = new JPanel(new BorderLayout()); //jPanelCENTER WEST SOUTH
    JPanel jPanelS = new JPanel(new BorderLayout()); //jPanelSOUTH
    JPanel pw, pw5;

    JButton jButton_turn, jButton_start;

    public JButton[] t = new JButton[25];
    public JButton[] b = new JButton[100];
    JButton temp = new JButton();
    Color oldcolor;

    boolean flag = false;

    boolean flagP = false;
    public boolean flagC = false;
    public boolean turnFlag = false;
    public int size = 0;
    public boolean flagShip = false;
    JButton[] tmp = new JButton[size];

    public int pos;
    public int tempSize;
    public ArrayList<Integer> List = new ArrayList<>();
    public ArrayList<Integer> List2 = new ArrayList<>();
    public ArrayList<Integer> shipCountPlaced = new ArrayList<>();
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public String name;
    boolean PlaceFlag = true;
    public int shipCount = 5;
    public int turnCount = 0;
    public int countShipSize3 = 0;
    public boolean flagStart = false;
    public int ShipCounter = 0;
    
    public boolean flagWhite3a = false;
    public boolean flagWhite3b = false;


    public void GameSetUp() {
        Battle battle = new Battle();
        Init in = new Init();
        List = in.IntList();
        //100 koumpia topothetisis ploion
        pw = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            b[i] = new JButton(i + "");
            b[i].setPreferredSize(new Dimension(60, 60));
            
            b[i].setBackground(Color.cyan);
            b[i].setForeground(new Color(0,0,0,0));
            pw.add(b[i]);
        }

        for (int i = 0; i < 100; i++) {
            b[i].addMouseListener(new MouseAdapter() {
                String x;

                public void mouseEntered(MouseEvent me) {
                    if (flag) {
                        JButton t = (JButton) me.getSource();
                        x = t.getText();
                        if (List.contains(Integer.valueOf(x))) {  // if list contain the block mouse entered
                            flagP = false;
                            pos = Integer.valueOf(t.getText());
                            Hover(x, size);
                        }
                    }
                }

                public void mouseExited(MouseEvent me) {
                    if (flag) {
                        JButton t = (JButton) me.getSource();
                        x = t.getText();
                        if (List.contains(Integer.valueOf(x))) { // if its clicked don t 
                            if (flagP == false) {     // if we choose ship do not hover out 
                                HoverOut(x, size);
                            }
                        }
                    }
                }
            });
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (PlaceFlag) { // if you go to click on placed ship
                        flag = false;
                        String x;
                        x = e.getActionCommand();
                        System.out.println("Block clicked/firstblock of ship placed " + x);
                        Placed(x, size);
                    }
                }
            });
        }
        //25 koumpia ploion
        pw5 = new JPanel(new GridLayout(5, 5));
        
        for (int j = 0; j < 25; j++) {
            t[j] = new JButton("" + j);
            t[j].setPreferredSize(new Dimension(50, 50));
            t[j].setBackground(Color.white);
            t[j].setForeground(new Color(0,0,0,0));
            if (j>=0 && j<5) {                             // ship size 5
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0,0,0,0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = 5;
                        if (shipCountPlaced.contains(size)) {
                        } else {  // prevents from double click
                            flag = true;        // aprove hovering 
                            flagShip = true;    // preventing from placing 2 times
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor); // change the cursor 
                        }
                    }
                });
            }
            if (j>=5 && j<9) {                         // ship size 4
                    t[j].setBackground(Color.DARK_GRAY);
                    t[j].setForeground(new Color(0,0,0,0));
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            size = 4;
                            if (shipCountPlaced.contains(size)) {
                            } else {
                                flag = true;
                                flagShip = true;
                                tempSize = size;
                                shipCount--;
                                pw.setCursor(cursor);
                            }
                        }
                    });            
            }
            if (j>=10 && j<13) {                    // ship size 3
                    t[j].setBackground(Color.DARK_GRAY);
                    t[j].setForeground(new Color(0,0,0,0));
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            size = 3;
                            if (shipCountPlaced.contains(size)) {
                            } else {
                                flag = true;
                                flagShip = true;
                                tempSize = size;
                                shipCount--;
                                pw.setCursor(cursor);
                                flagWhite3a = true;
                            }
                        }
                    });
            }
            if (j>=15 && j<18) {                   // ship size 3
                    t[j].setBackground(Color.DARK_GRAY);
                    t[j].setForeground(new Color(0,0,0,0));
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            size = 3;
                            if (shipCountPlaced.contains(size)) {
                            } else {
                                flag = true;
                                flagShip = true;
                                tempSize = size;
                                shipCount--;
                                pw.setCursor(cursor);
                                flagWhite3b = true;
                            }
                        }
                    });
            }
            if (j>=20 && j<22) {                        // ship size 2
                    t[j].setBackground(Color.DARK_GRAY);
                    t[j].setForeground(new Color(0,0,0,0));
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            size = 2;
                            if (shipCountPlaced.contains(size)) {
                            } else {
                                flag = true;
                                flagShip = true;
                                tempSize = size;
                                shipCount--;
                                pw.setCursor(cursor);
                            }
                        }
                    });
            }
            pw5.add(t[j]);
        }
        
        //2 koumpia katw aristera kai deksia
        jButton_turn = new JButton("Rotate Ship");
        jButton_turn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnCount == 0) {
                    turnFlag = true;
                    turnCount = 1; // turn vertical 
                } else {
                    turnFlag = false;
                    turnCount = 0; // turn horizontal
                }
            }
        });
        jButton_start = new JButton("Start");
        
//        if (flagStart) {
//            jButton_start.setEnabled(true);
//        }
//        
//        else{
//            jButton_start.setEnabled(false);
//        }
        
        jButton_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flagStart) {
                    jPanel1.removeAll();
                    jPanel1.repaint();
                    jPanel1.add(battle.Battle(List2), BorderLayout.CENTER);
                    BoxLayout boxlayout = new BoxLayout(jPanel1, BoxLayout.X_AXIS);
                    jPanel1.setLayout(boxlayout);
                    jPanel1.setBorder(new EmptyBorder(new Insets(150, 30, 10, 100)));
                    f.add(jPanel1, BorderLayout.CENTER);
                    jPanel1.repaint();
                    f.setVisible(true);
                }
            }
        }
        );
        //diachorismos arxikou panel sta 3, panw katw kentro
        jPanel1.add(jPanelN, BorderLayout.NORTH);
        jPanel1.add(jPanelC, BorderLayout.CENTER);
        jPanel1.add(jPanelS, BorderLayout.SOUTH);
        JLabel epikef = new JLabel("               "
                + "Please select ships from the left and place them in your board. Press 'Start' when you are ready!");
        jPanelN.add(epikef, BorderLayout.WEST);
        //vazw ta koumpia start kai turn katw aristera kai katw deksia
        jPanelS.add(jButton_turn, BorderLayout.WEST);
        jPanelS.add(jButton_start, BorderLayout.EAST);
        JLabel yb = new JLabel("Your Board:");
        jPanelC.add(jPanelCE, BorderLayout.EAST);
        jPanelCE.add(yb, BorderLayout.NORTH);
        jPanelCE.add(pw, BorderLayout.CENTER);//100 koumpia sto kentro tou kentrikou panel pou vriskete sto kentro tou arxikou panel (panel1)
        jPanelC.add(jPanelCE, BorderLayout.EAST);
        jPanelC.add(jPanelCW, BorderLayout.WEST);//25 koumpia sta aristera tou kentrikou panel pou vriskete sto kentro tou arxikou panel (panel1)
        jPanelCW.add(jPanelCWS, BorderLayout.CENTER);
        jPanelCWS.add(pw5, BorderLayout.SOUTH);
        JLabel stbp = new JLabel("Ships to be placed:");//epikefalida ploion
        jPanelCWS.add(stbp, BorderLayout.CENTER);
        //diachorismos arxikou panel sta 3
        jPanel1.add(jPanelN, BorderLayout.NORTH);
        jPanel1.add(jPanelC, BorderLayout.CENTER);
        jPanel1.add(jPanelS, BorderLayout.SOUTH);
        f.add(jPanel1);
        f.setTitle("BattleShips");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 50, 1050, 600);
        f.setVisible(true);
    }

    public void Placed(String pos, int size) { // method for placing the ships
        int poss = Integer.valueOf(pos);  // the value for the first block 
        ShipCounter++;
        if (ShipCounter == 5) {
            flagStart = true;
        }
        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) { // size is the size of the ship that will be placed 
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j);  // adding to list so we know the coordinates of the ships 
                        //                    battle.finalList.add(j);
                        flagP = true;
                        if (size == 3) {
                            countShipSize3++;
                            if (countShipSize3 > 3) {
                                shipCountPlaced.add(size);
                            }
                        } else {
                            shipCountPlaced.add(size);
                        }
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) { // size is the size of the ship that will be placed 
                if (flagShip) {
                    if (List.contains(j)) {
                        b[j].setBackground(Color.DARK_GRAY);
                        List2.add(j);  // adding to list so we know the coordinates of the ships 
                        //                    battle.finalList.add(j);
                        flagP = true;
                        if (size == 3) {
                            countShipSize3++;
                            if (countShipSize3 > 3) {
                                shipCountPlaced.add(size);
                            }
                        } else {
                            shipCountPlaced.add(size);
                        }
                    }
                }
            }
        }
        turnFlag = false;// turning flag 
        flagShip = false; // preventing from placing 2 times
        System.out.println("GameSetUp List2 ships placed " + List2);
        System.out.println("Ship count that placed Placed " + shipCountPlaced);
        
        if(size==5){
            for(int k=0;k<size;k++){
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
        if(size==4){
            for(int k=5;k<9;k++){
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
        if(size==3 && flagWhite3a){
            for(int k=10;k<13;k++){
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0,0,0,0));
                flagWhite3a = false;
            }
        }
        if(size==3 && flagWhite3b){
            for(int k=15;k<18;k++){
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0,0,0,0)); 
                flagWhite3b = false;
            }
        }
        if(size==2){
            for(int k=20;k<22;k++){
                t[k].setBackground(Color.white);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
    }

    public void Hover(String pos, int size) { // hovering over buttons 
        int poss = Integer.valueOf(pos); // hovering the first block 
        PlaceFlag = true;
        if (turnFlag) {  // turning flag kafter click 
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (j <= 99) {
                    if (List2.contains(j) || (poss + (size * 10)) > 110) { // check if the hover is on boundries or on 
                        b[j].setBackground(Color.red);
                        b[j].setForeground(new Color(0,0,0,0));                                                     // other ship 
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j);                               // if it is then RED
                    } else {
                        b[j].setBackground(Color.green);
                        b[j].setForeground(new Color(0,0,0,0));                                                // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        }
        else {
            for (int j = poss; j < poss + size; j++) {
                if (j <= 99) {
                    if (List2.contains(j) || ((poss + size - 1) % 10 < (size - 1)) && ((poss) % 10 != 0)) { // check if the hover is on boundries or on 
                        b[j].setBackground(Color.red);
                        b[j].setForeground(new Color(0,0,0,0));                                                      // other ship 
                        PlaceFlag = false;
                        System.out.println("hover red ----" + PlaceFlag + j);                               // if it is then RED
                    } else {
                        b[j].setBackground(Color.green);
                        b[j].setForeground(new Color(0,0,0,0));                                                  // if its not... green
                        System.out.println("hover green----" + PlaceFlag + j);
                    }
                }
            }
        }
        
        if(size==5){
            for(int k=0;k<size;k++){
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
        if(size==4){
            for(int k=5;k<9;k++){
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
        if(size==3 && flagWhite3a){
            for(int k=10;k<13;k++){
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
        if(size==3 && flagWhite3b){
            for(int k=15;k<18;k++){
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0,0,0,0));
            }
        }
        if(size==2){
            for(int k=20;k<22;k++){
                t[k].setBackground(Color.yellow);
                t[k].setForeground(new Color(0,0,0,0)); 
            }
        }
    }

    public void HoverOut(String pos, int size) {       // hovering out 
        int poss = Integer.valueOf(pos);               // hovering out the first block 

        if (turnFlag) {
            for (int j = poss; j < poss + (size * 10); j += 10) {
                if (List2.contains(j)) {
                    if (j <= 99) {
                        b[j].setBackground(Color.DARK_GRAY);
                        b[j].setForeground(new Color(0,0,0,0));
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99) {
                        b[j].setBackground(Color.cyan);      // hovering out of empty block back to cyan OLO MOY TO GANG ANIMAL
                        b[j].setForeground(new Color(0,0,0,0));
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        } else {
            for (int j = poss; j < poss + size; j++) {
                if (List2.contains(j)) {
                    if (j <= 99) {
                        b[j].setBackground(Color.DARK_GRAY);
                        b[j].setForeground(new Color(0,0,0,0));
                        System.out.println("hover out green----" + PlaceFlag + j);
                    }
                } else {
                    if (j <= 99) {
                        b[j].setBackground(Color.cyan);      // hovering out of empty block back to cyan OLO MOY TO GANG ANIMAL
                        b[j].setForeground(new Color(0,0,0,0));
                        System.out.println("hover out cyan----" + PlaceFlag + j);
                    }
                }
            }
        }
    }
}
