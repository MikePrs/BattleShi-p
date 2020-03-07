/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mikep
 */
public class Battle extends GameSetUp implements ActionListener {

    JPanel panelL = new JPanel(); // left  panel
    JPanel panelLC = new JPanel(); // left center panel 100 btn

    JPanel panelR = new JPanel(); // right panel
    JPanel panelRC = new JPanel(); // right center panel 100 btn

    JLabel NameLab = new JLabel("Name Board");
    JLabel ComputerLab = new JLabel("Computer's Board");

    public JButton[] b1 = new JButton[101];
    public JButton[] b2 = new JButton[101];

    int board[][];

    boolean flag = false;
    boolean flag2 = false;

    ArrayList<Integer> rndList = new ArrayList<>();
    ArrayList<Integer> clickList = new ArrayList<>();

    int count1 = 0, count2 = 0;
    int winCount = 0;

    public JPanel Battle() {
        JPanel mainPanel = new JPanel();
        Init in = new Init();
        Random rnd = new Random();

        board = in.InitMatrix();
        rndList = in.IntList();
        clickList = in.IntList();

        panelLC.setLayout(new GridLayout(10, 10));
        panelRC.setLayout(new GridLayout(10, 10));

        for (i = 0; i < 100; i++) {
            b1[i] = new JButton("" + i);
            b1[i].setBackground(Color.cyan);

            b2[i] = new JButton("" + i);
            b2[i].setBackground(Color.cyan);
            b2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton t = (JButton) e.getSource();
                    if (clickList.contains(Integer.valueOf(t.getText()))) { // prevent double clicking 
                        clickList.remove(Integer.valueOf(t.getText()));
                        count2++;
                        flag2 = true;
                        flag = false;
                        
                        int pos = Integer.parseInt(t.getText());
                        for (int j = 0; j < 5; j++) {

                            for (int i = 0; i < board[j].length; i++) { // -1 eixe 
                                if (pos == board[j][i]) {
                                    winCount++;
                                    flag = true;
                                    t.setBackground(Color.red);
                                    System.out.println("hit " + t.getText() + " " + count2);
                                    if (winCount == 18) {
                                        JOptionPane.showOptionDialog(null, "You Win !", "Results", JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                                    }
                                    break;
                                }
                                if ((flag == false)) {
                                    t.setBackground(Color.blue);
                                    System.out.println("no " + t.getText() + " " + count2);
                                }
                            }
                        }

                        if (flag2 == true) {
                            int x = rnd.RandomHit(rndList);

                            b1[x].setBackground(Color.blue);

                            count1++;
                            System.out.println("random computer hit " + b1[x].getText() + " " + count1);
                        }
                    }
                }
            });
            panelRC.add(b2[i]);
            panelLC.add(b1[i]);

        }

        panelL.setLayout(new BorderLayout());
        panelL.add(NameLab, BorderLayout.NORTH);
        panelL.add(panelLC, BorderLayout.CENTER);

        panelR.setLayout(new BorderLayout());
        panelR.add(ComputerLab, BorderLayout.NORTH);
        panelR.add(panelRC, BorderLayout.CENTER);

        mainPanel.add(panelL, BorderLayout.WEST);
        mainPanel.add(panelR, BorderLayout.EAST);

        return mainPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
