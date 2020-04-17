package battleshipmain;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GameSetUp {

    JFrame f = new JFrame();
    JPanel jPanel1 = new JPanel(new BorderLayout());
    JPanel jPanelN = new JPanel(new BorderLayout()); // jPanelNORTH
    JPanel jPanelC = new JPanel(new BorderLayout()); // PanelCENTER
    JPanel jPanelCW = new JPanel(new BorderLayout()); // PanelCENTER WEST
    JPanel jPanelCE = new JPanel(new BorderLayout()); // PanelCENTER EAST
    JPanel jPanelCWS = new JPanel(new BorderLayout()); // jPanelCENTER WEST SOUTH
    JPanel jPanelS = new JPanel(new BorderLayout()); // jPanelSOUTH
    JPanel pw, pw5;

    public int size = 0;
    public int pos , tempSize;
    
    JButton jButton_turn, jButton_start;
    public JButton[] t = new JButton[25];
    public JButton[] b = new JButton[100];
    JButton[] tmp = new JButton[size];
    JButton temp = new JButton();

    Color oldcolor;

    boolean flag = false;
    boolean flagP = false;
    public boolean flagC = false;

    public ArrayList<Integer> List = new ArrayList<>();
    public ArrayList<Integer> List2 = new ArrayList<>();
    public ArrayList<Integer> shipCountPlaced = new ArrayList<>();
    
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public String name;

    public int shipCount = 5;
    public int turnCount = 0;
    public int countShipSize3 = 0;
    public int ShipCounter = 0;

    Ships ships[] = new Ships[6];
    Boolean flagShip3 = true ;
    public void GameSetUp() {
        Actions ac = new Actions();
        ships[5] = new Ships("5", 5);
        ships[4] = new Ships("4", 4);
        ships[3] = new Ships("3a", 3);
        ships[2] = new Ships("2", 2);
        ships[1] = new Ships("3b", 3);

        Battle battle = new Battle();
        Init in = new Init();
        List = in.IntList();
        // 100 koumpia topothetisis ploion
        pw = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            b[i] = new JButton(i + "");
            b[i].setPreferredSize(new Dimension(60, 60));
            b[i].setBackground(Color.cyan);
            b[i].setForeground(new Color(0, 0, 0, 0));
            pw.add(b[i]);
        }
        for (int i = 0; i < 100; i++) {
            b[i].addMouseListener(new MouseAdapter() {
                String x;
                public void mouseEntered(MouseEvent me) {
                    if (flag) {
                        JButton butt = (JButton) me.getSource();
                        x = butt.getText();
                        if (List.contains(Integer.valueOf(x))) { // if list contain the block mouse entered
                            flagP = false;
                            pos = Integer.valueOf(butt.getText());
                            ac.Hover(x, size, b, t, List2);
                        }
                    }
                }
                public void mouseExited(MouseEvent me) {
                    if (flag) {
                        JButton butt = (JButton) me.getSource();
                        x = butt.getText();
                        if (List.contains(Integer.valueOf(x))) { // if its clicked don t
                            if (flagP == false) { // if we choose ship do not hover out
                                ac.HoverOut(x, size, b, t, List2);
                            }
                        }
                    }
                }
            });
            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (ac.PlaceFlag) { // if you go to click on placed ship
                        flag = false;
                        String x;
                        x = e.getActionCommand();
                        System.out.println("Block clicked/firstblock of ship placed " + x);
                        ac.Placed(x, size, b, t, List2, List, ships,shipCountPlaced);
                        for (int i = 1; i <= 5; i++) {
                            System.out.println("----------------");
                            System.out.println("Ship with ID : " + ships[i].getId() + "  in positions : " + ships[i].getPos());
                        }
                    }
                }
            });
        }
        // 25 koumpia ploion
        pw5 = new JPanel(new GridLayout(5, 5));
        for (int j = 0; j < 25; j++) {
            t[j] = new JButton("" + j);
            t[j].setPreferredSize(new Dimension(50, 50));
            t[j].setBackground(Color.white);
            t[j].setForeground(new Color(0, 0, 0, 0));
            if (j >= 0 && j < 5) {                      // ship size 5
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0, 0, 0, 0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = ships[5].getSize(); // takings from ships the size
                        if (shipCountPlaced.contains(size)) {
                        } else { // prevents from double click
                            flag = true; // aprove hovering
                            ac.flagShip = true; // preventing from placing 2 times
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor); // change the cursor
                        }
                    }
                });
            }
            if (j >= 5 && j < 9) {                   // ship size 4
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0, 0, 0, 0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = ships[4].getSize();
                        if (shipCountPlaced.contains(size)) {
                        } else {
                            flag = true;
                            ac.flagShip = true;
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor);
                        }
                    }
                });
            }
            if (j >= 10 && j < 13) {                // ship size 3
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0, 0, 0, 0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = ships[3].getSize();
                        if (shipCountPlaced.contains(size)) {
                        } else {
                            flag = true;
                            ac.flagShip = true;
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor);
                            ac.flagWhite3a = true;
                        }
                    }
                });
            }
            if (j >= 15 && j < 18) {                // ship size 3
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0, 0, 0, 0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = ships[1].getSize();
                        if (shipCountPlaced.contains(size) && flagShip3 ) {
                            flag = true;
                            ac.flagShip = true;
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor);
                            ac.flagWhite3b = true;
                            flagShip3 = false ;
                        }
                    }
                });
            }
            if (j >= 20 && j < 22) {             // ship size 2
                t[j].setBackground(Color.DARK_GRAY);
                t[j].setForeground(new Color(0, 0, 0, 0));
                t[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        size = ships[2].getSize();
                        if (shipCountPlaced.contains(size)) {
                        } else {
                            flag = true;
                            ac.flagShip = true;
                            tempSize = size;
                            shipCount--;
                            pw.setCursor(cursor);
                        }
                    }
                });
            }
            pw5.add(t[j]);
        }

        // 2 koumpia katw aristera kai deksia
        jButton_turn = new JButton("Rotate Ship");
        jButton_turn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnCount == 0) {
                    ac.turnFlag = true;
                    turnCount = 1; // turn vertical
                } else {
                    ac.turnFlag = false;
                    turnCount = 0; // turn horizontal
                }
            }
        });
        jButton_start = new JButton("Start");
        jButton_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ac.flagStart) {
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
        });
        // diachorismos arxikou panel sta 3, panw katw kentro
        jPanel1.add(jPanelN, BorderLayout.NORTH);
        jPanel1.add(jPanelC, BorderLayout.CENTER);
        jPanel1.add(jPanelS, BorderLayout.SOUTH);
        JLabel epikef = new JLabel("               "
                + "Please select ships from the left and place them in your board. Press 'Start' when you are ready!");
        jPanelN.add(epikef, BorderLayout.WEST);
        // vazw ta koumpia start kai turn katw aristera kai katw deksia
        jPanelS.add(jButton_turn, BorderLayout.WEST);
        jPanelS.add(jButton_start, BorderLayout.EAST);
        JLabel yb = new JLabel("Your Board:");
        jPanelC.add(jPanelCE, BorderLayout.EAST);
        jPanelCE.add(yb, BorderLayout.NORTH);
        jPanelCE.add(pw, BorderLayout.CENTER);// 100 koumpia sto kentro tou kentrikou panel pou vriskete sto kentro tou
        // arxikou panel (panel1)
        jPanelC.add(jPanelCE, BorderLayout.EAST);
        jPanelC.add(jPanelCW, BorderLayout.WEST);// 25 koumpia sta aristera tou kentrikou panel pou vriskete sto kentro
        // tou arxikou panel (panel1)
        jPanelCW.add(jPanelCWS, BorderLayout.CENTER);
        jPanelCWS.add(pw5, BorderLayout.SOUTH);
        JLabel stbp = new JLabel("Ships to be placed:");// epikefalida ploion
        jPanelCWS.add(stbp, BorderLayout.CENTER);
        // diachorismos arxikou panel sta 3
        jPanel1.add(jPanelN, BorderLayout.NORTH);
        jPanel1.add(jPanelC, BorderLayout.CENTER);
        jPanel1.add(jPanelS, BorderLayout.SOUTH);
        f.add(jPanel1);
        f.setTitle("BattleShips");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(100, 50, 1050, 600);
        f.setVisible(true);
    }
}
