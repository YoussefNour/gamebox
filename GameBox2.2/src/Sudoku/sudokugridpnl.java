package Sudoku;

/**
 *
 * @author youssef
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sudokugridpnl extends JPanel {

    protected JButton[][] btns;
    private JPanel[][] pnls3x3;
    private PuzzleCreator pc;

    public sudokugridpnl(String difficulty, JFrame main, Youwonwindow won) {
        main.add(this, BorderLayout.CENTER);
        this.setBackground(Color.black);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        this.setLayout(new GridLayout(3, 3));
        pnls3x3 = new JPanel[3][3];
        btns = new JButton[9][9];
        pc = new PuzzleCreator(difficulty, main);

        //--------------------panels-creations-and-addition-----------------------
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pnls3x3[i][j] = new JPanel();
                pnls3x3[i][j].setLayout(new GridLayout(3, 3));
                pnls3x3[i][j].setBackground(Color.white);
                pnls3x3[i][j].setForeground(Color.white);
                pnls3x3[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                this.add(pnls3x3[i][j]);

            }
        }
        //--------------------panels-creations-and-addition-----------------------

        //--------------------buttons-creation------------------------------------
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                btns[i][j] = new JButton(pc.getUnsolvedPuzzleIndex(i, j));
                if (!"0".equals(pc.getUnsolvedPuzzleIndex(i, j))) {
                    btns[i][j].setEnabled(false);
                }
                btns[i][j].setBackground(Color.white);
                btns[i][j].setPreferredSize(new Dimension(30, 30));
                btns[i][j].setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                if (difficulty.equals("HARD")) {
                    btns[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton x = (JButton) e.getSource();
                            incrementbtnHard(x);
                            pc.IsSolved(won);
                        }
                    });
                } else {
                    btns[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton x = (JButton) e.getSource();
                            incrementbtn(x);
                            pc.IsSolved(won);
                        }
                    });
                }
                if (btns[i][j].getText().equals("0")) {
                    btns[i][j].setText(" ");
                }
            }
        }
        //--------------------buttons-creation------------------------------------

        //-------------------adding-buttons-in-sub-panels-------------------------
        int jumperi = 0, jumperj = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int a = jumperi; a < 3 + jumperi && a < 9; a++) {
                    for (int b = jumperj; b < 3 + jumperj && b < 9; b++) {
                        pnls3x3[i][j].add(btns[a][b]);
                    }
                }
                jumperj += 3;
                if (jumperj > 6) {
                    jumperj = 0;
                }
            }
            jumperi += 3;
            if (jumperi > 6) {
                jumperi = 0;
            }
        }

        //-------------------adding-buttons-in-sub-panels-------------------------
    }

    public int findbtni(JButton y) {
        int z = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.btns[i][j] == y) {
                    z = i;
                    break;
                }
            }
        }

        return z;
    }

    public int findbtnj(JButton y) {
        int z = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.btns[i][j] == y) {
                    z = j;
                    break;
                }
            }
        }

        return z;
    }

    public void incrementbtn(JButton x) {
        int i = findbtni(x);
        int j = findbtnj(x);
        //etsh's code
        pc.IncreaseNumber(i, j);
        x.setText(pc.getUnsolvedPuzzleIndex(i, j));
        if (x.getText().equals("0")) {
            x.setText(" ");
        }
        /*int num = Integer.parseInt(x.getText().trim());
                        if(num == 0)
                        {
                            num=1;
                            x.setText("1");
                            pc.SetNumber2(i,j,num);
                            if(pc.IsSolved())
                                {
                                    showwinmessage();
                                }
                        }
                        else
                        {
                            if(num == 9)
                            {
                                num=1;
                                x.setText("1");
                                pc.SetNumber2(i,j,num);
                                if(pc.IsSolved())
                                {
                                    showwinmessage();
                                }
                            }
                            else{
                                num++;
                                String s = Integer.toString(num);
                                x.setText(s);
                                pc.SetNumber2(i,j,num);
                                if(pc.IsSolved())
                                {
                                    showwinmessage();
                                }
                            }
                        }*/

//        for (int a = 0; a < 9; a++) {
//            for (int b = 0; b < 9; b++) {
//                System.out.print(" {" + pc.getUnsolvedPuzzleIndex(a, b) + "} ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        this.repaint();
    }

    public void incrementbtnHard(JButton x) {
        int i = findbtni(x);
        int j = findbtnj(x);
        //etsh's code
        pc.IncreaseNumberHard(i, j);
        x.setText(pc.getUnsolvedPuzzleIndex(i, j));
        if (x.getText().equals("0")) {
            x.setText(" ");
        }
        this.repaint();
    }
    
    public void SetButton(JButton loadedbtn,int i,int j){
        btns[i][j]=loadedbtn;
    }
    
    public void SetRandomPuzzle(int index,int i, int j){
        pc.SetRandomPuzzle(index, i, j);
    }
    
    public void SetPlayablePuzzle(int index,int i, int j){
        pc.SetPlayablePuzzle(index, i, j);
    }
    
    public void SaveGame(){
        pc.SaveGame(btns);
    }
    
}
