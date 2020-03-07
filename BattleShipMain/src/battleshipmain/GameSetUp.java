/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmain;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import static java.awt.Color.cyan;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.BoxLayout;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
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

    JButton[] t = new JButton[25];
    JButton[] b = new JButton[100];

    JButton temp = new JButton();
    Color oldcolor;

    boolean flag = false;
    boolean flagP = false;
    int size = 0;
    JButton[] tmp = new JButton[size];
    int i;

    int pos;

    public void GameSetUp() {
        
        Battle battle = new Battle();
        //100 koumpia topothetisis ploion
        pw = new JPanel(new GridLayout(10, 10));
        for (i = 0; i < 100; i++) {
            b[i] = new JButton(i + "");
            b[i].setPreferredSize(new Dimension(60, 60));
            b[i].setBackground(Color.CYAN);

            pw.add(b[i]);
        }

        for (i = 0; i < 100; i++) {
            b[i].addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent me) {
                    if (flag) {
                        flagP=false;
                        JButton t = (JButton) me.getSource();

                        temp = t;
                        t.setBackground(Color.GRAY);
                        pos = Integer.valueOf(t.getText());

                    }
                }

                public void mouseExited(MouseEvent me) {
                    if (flagP==false ) {
                        temp.setBackground(Color.cyan);
                    }
                }
            });

            b[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton t = (JButton) e.getSource();
                    flagP = true;
                    t.setBackground(Color.BLACK);
                }
            });

        }

        //25 koumpia ploion
        pw5 = new JPanel(new GridLayout(5, 5));
        int check = 2;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                t[j] = new JButton(i + "" + j);
                t[j].setPreferredSize(new Dimension(50, 50));
                t[j].setBackground(Color.white);
                if ((i == 3) || (i == 2)) {
                    if ((j < 3)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                flag = true;
                                size = 3;
                            }
                        });
                    }
                }
                if (i == 0) {
                    t[j].setBackground(Color.black);
                    t[j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            flag = true;
                            size = 5;
                        }
                    });
                }
                if (i == 1) {
                    if ((j < 4)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                flag = true;
                                size = 4;
                            }
                        });
                    }
                }
                if (i == 4) {
                    if ((j < 2)) {
                        t[j].setBackground(Color.black);
                        t[j].addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                flag = true;
                                size = 2;
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

        jButton_start.addActionListener(
                new ActionListener() {
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

        //epikefalida
        JLabel epikef = new JLabel("               Please select ships from the left and place them in your board. Press 'Start' when you are ready!");

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

        //frame.pack();
        f.setTitle(
                "BattleShips");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setBounds(
                100, 50, 1050, 600);
        f.setVisible(
                true);
    }

    public void change(JButton b) {

    }
}
