package battleshipmain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Battle implements ActionListener {

    JPanel panelL = new JPanel(); // left  panel
    JPanel panelLC = new JPanel(); // left center panel 100 btn

    JPanel panelR = new JPanel(); // right panel
    JPanel panelRC = new JPanel(); // right center panel 100 btn
    
    
    GiveName name = new GiveName();
    String onoma = name.SetName();

    JLabel NameLab = new JLabel("                                                             "+ onoma + "'s Board");
    JLabel ComputerLab = new JLabel("                                                            Computer's Board");

    public JButton[] b1 = new JButton[101];
    public JButton[] b2 = new JButton[101];

    int board[][];

    boolean flagg = false;
    boolean flag2 = false;

    ArrayList<Integer> rndList = new ArrayList<>();
    ArrayList<Integer> clickList = new ArrayList<>();

    public int[] finalPin2 = new int[17];
    int count1 = 0, count2 = 0;
    int winCount = 0;
    int countComp = 0;

    public JPanel Battle(ArrayList<Integer> finalList) {
        JPanel mainPanel = new JPanel();
        Init in = new Init();
        Random rnd = new Random();

        board = in.InitMatrix();
        rndList = in.IntList();
        clickList = in.IntList();
        System.out.println("Computer s random ship positions " + Arrays.deepToString(board));
        System.out.println("Player battle ship positions " + finalList);

        panelLC.setLayout(new GridLayout(10, 10));
        panelRC.setLayout(new GridLayout(10, 10));

        for (int i = 0; i < 100; i++) {
            b1[i] = new JButton("" + i);
            if (finalList.contains(i)) {
                b1[i].setBackground(Color.DARK_GRAY);
            }
            else{
                b1[i].setBackground(Color.cyan);
            }
            b1[i].setForeground(new Color(0,0,0,0));
            b2[i] = new JButton("" + i);
            b2[i].setBackground(Color.cyan);
            b2[i].setForeground(new Color(0,0,0,0));
            b2[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton t = (JButton) e.getSource();
                    if (clickList.contains(Integer.valueOf(t.getText()))) { // prevent double clicking 
                        clickList.remove(Integer.valueOf(t.getText()));
                        count2++;
                        flag2 = true;
                        flagg = false;
                        int pos = Integer.parseInt(t.getText());
                        for (int j = 0; j < 5; j++) {
                            for (int i = 0; i < board[j].length; i++) {
                                if (pos == board[j][i]) {
                                    winCount++;
                                    flagg = true;
                                    t.setBackground(Color.red);
                                    t.setForeground(new Color(0,0,0,0));
                                    System.out.println("Player hit " + t.getText() + "Player clicks " + count2);
                                    if (winCount == 17) {
                                        JOptionPane.showOptionDialog(null, onoma + " is the winner!", "Results", JOptionPane.DEFAULT_OPTION,
                                                JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                                    }
                                    break;
                                }
                                if ((flagg == false)) {
                                    t.setBackground(Color.white);
                                    t.setForeground(new Color(0,0,0,0));
                                    System.out.println("Player not hit " + t.getText() + "Player clicks " + count2);
                                }
                            }
                        }
                        if (flag2 == true) {
                            int x = rnd.RandomHit(rndList);
                            if (finalList.contains(x)) {
                                b1[x].setBackground(Color.red);
                                b1[x].setForeground(new Color(0,0,0,0));
                                System.out.println("Computer hit " + x);
                                countComp++;
                            } else {
                                b1[x].setBackground(Color.white);
                                b1[x].setForeground(new Color(0,0,0,0));
                                System.out.println("Computer not hit " + x);
                            }
                            if (countComp == 17) {
                                JOptionPane.showOptionDialog(null, "Computer Wins !", "Results", JOptionPane.DEFAULT_OPTION,
                                        JOptionPane.INFORMATION_MESSAGE, null, new Object[]{}, null);
                            }
                            count1++;
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
