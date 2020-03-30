/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author mikep
 */
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
    public int size = 0;
    JButton[] tmp = new JButton[size];

    public int pos;
    public int tempSize;
    public ArrayList<Integer> List = new ArrayList<>();
    public ArrayList<Integer> List2 = new ArrayList<>();
    public ArrayList<Integer> finalList = new ArrayList<>();
    public Cursor cursor = new Cursor(Cursor.HAND_CURSOR);

    public String name;
    boolean PlaceFlag = true;
    public int shipCount = 5;
    public int[] finalPin = new int[17];

    public void GameSetUp() {
        Battle battle = new Battle();
        Init in = new Init();
        List = in.IntList();
        //100 koumpia topothetisis ploion
        pw = new JPanel(new GridLayout(10, 10));
        for (int i = 0; i < 100; i++) {
            b[i] = new JButton(i + "");
            b[i].setPreferredSize(new Dimension(60, 60));
            b[i].setBackground(Color.CYAN);

            pw.add(b[i]);
        }

        for (int i = 0; i < 100; i++) {
            b[i].addMouseListener(new MouseAdapter() {
                String x;

                public void mouseEntered(MouseEvent me) {
                    if (flag) {
                        JButton t = (JButton) me.getSource();
                        x = t.getText();
                        System.out.println(x);
                        if (List.contains(Integer.valueOf(x))) {  // if list contain the block mouse entered
                            flagP = false;
                            pos = Integer.valueOf(t.getText());
                            Hover(x, tempSize);
                        }
                    }
                }

                public void mouseExited(MouseEvent me) {
                    if (flag) {
                        JButton t = (JButton) me.getSource();
                        x = t.getText();
                        System.out.println(x);
                        if (List.contains(Integer.valueOf(x))) { // if its clicked don t 
                            if (flagP == false) {     // if we choose ship do not hover out 
                                HoverOut(x, tempSize);
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
                        System.out.println(x);
                        Placed(x, tempSize);
                    }
                }
            });
        }
        //25 koumpia ploion
        pw5 = new JPanel(new GridLayout(5, 5));

        for (int k = 0; k < 5; k++) {
            for (int j = 0; j < 5; j++) {
                t[j] = new JButton(k + "" + j);
                t[j].setPreferredSize(new Dimension(50, 50));
                t[j].setBackground(Color.white);
                if (k == 0) {                             // ship size 5
                    t[j].setBackground(Color.black);
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (shipCount == 5) {   // prevents from double click
                                flag = true;
                                size = 5;
                                tempSize = size;
                                shipCount--;
                                pw.setCursor(cursor); // change the cursor 
                            }
                        }
                    });
                }
                if (k == 1) {                         // ship size 4
                    if ((j < 4)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (shipCount == 4) {
                                    flag = true;
                                    size = 4;
                                    tempSize = size;
                                    shipCount--;
                                    pw.setCursor(cursor);
                                }
                            }
                        });
                    }
                }
                if ((k == 2)) {                  // ship size 3
                    if ((j < 3)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (shipCount == 3) {
                                    flag = true;
                                    size = 3;
                                    tempSize = size;
                                    shipCount--;
                                    pw.setCursor(cursor);
                                }
                            }
                        });
                    }
                }
                if ((k == 3)) {                  // ship size 3
                    if ((j < 3)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (shipCount == 2) {
                                    flag = true;
                                    size = 3;
                                    tempSize = size;
                                    shipCount--;
                                    pw.setCursor(cursor);
                                }
                            }
                        });
                    }
                }
                if (k == 4) {                        // ship size 2
                    if ((j < 2)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (shipCount == 1) {
                                    flag = true;
                                    size = 2;
                                    tempSize = size;
                                    shipCount--;
                                    f.setCursor(cursor);
                                }
                            }
                        });
                    }
                }

                pw5.add(t[j]);

            }
        }

        //2 koumpia katw aristera kai deksia
        jButton_turn = new JButton("Turn");
        jButton_start = new JButton("Start");
        jButton_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                jPanel1.removeAll();
                jPanel1.repaint();

                jPanel1.add(battle.Battle(), BorderLayout.CENTER);
                BoxLayout boxlayout = new BoxLayout(jPanel1, BoxLayout.X_AXIS);
                jPanel1.setLayout(boxlayout);
                jPanel1.setBorder(new EmptyBorder(new Insets(150, 30, 10, 100)));
                f.add(jPanel1, BorderLayout.CENTER);

                jPanel1.repaint();
                f.setVisible(true);

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
        name = JOptionPane.showInputDialog("Enter Name");
    }

    public void Placed(String pos, int size) { // method for placing the ships
        int poss = Integer.valueOf(pos);  // the value for the first block 
        for (int j = poss; j < poss + size; j++) { // size is the size of the ship that will be placed 
            if (List.contains(j)) {
                b[j].setBackground(Color.yellow);
                List2.add(j);  // adding to list so we know the coordinates of the ships 
                flagP = true;
            }
        }
        System.out.println(List2);
    }

    public void Hover(String pos, int size) { // hovering over buttons 
        int poss = Integer.valueOf(pos); // hovering the first block 
        PlaceFlag = true; 
        for (int j = poss; j < poss + size; j++) {
            if (j <= 99) {
                if (List2.contains(j) || ((poss + size - 1) % 10 < (size - 1)) && ((poss) % 10 != 0)) { // check if the hover is on boundries or on 
                    b[j].setBackground(Color.red);                                                      // other ship 
                    PlaceFlag = false;
                    System.out.println("red----" + PlaceFlag + j);                                      // if it is then RED
                } else {
                    b[j].setBackground(Color.yellow);                                                   // if its not yellow
                    System.out.println("yellow----" + PlaceFlag + j);
                }
            }
        }
    }

    public void HoverOut(String pos, int size) {       // hovering out 
        int poss = Integer.valueOf(pos); // hovering out the first block 
        for (int j = poss; j < poss + size; j++) {
            if (List2.contains(j)) { 
                if (j <= 99) {
                    b[j].setBackground(Color.yellow);
                    System.out.println("yellow----" + PlaceFlag + j);
                }
                System.out.println(j);
            } else {
                if (j <= 99) {
                    b[j].setBackground(Color.cyan);  // hovering out of empty block back to cyan OLO MOY TO GANG ANIMAL
                    System.out.println("cyan----" + PlaceFlag + j);
                }
                System.out.println(j);
            }
        }
    }

    public ArrayList<Integer> getFinalList() {    // still in progress method 
        finalList = List2;
        System.out.println("-----------" + finalList);
        return finalList;

    }
}
