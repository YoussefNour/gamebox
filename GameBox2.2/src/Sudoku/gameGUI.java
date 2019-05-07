package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class gameGUI extends JFrame {

    private Youwonwindow won = new Youwonwindow();
    private static Timer Refresher;
    private JTextArea Scorelbl;
    private sudokugridpnl sgp;
    private JPanel btmpnl;
    private JButton btn_ext, btn_restart,SaveBtn;
    private static int Score = 0;
    private JFrame main = this;

    public gameGUI(String Difficulty) {
        main.setTitle("Sudoku");
        main.setBounds(200, 200, 600, 700);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
        main.setResizable(false);

        sgp = new sudokugridpnl(Difficulty, main, won);

        btmpnl = new JPanel();
        btmpnl.setBackground(Color.darkGray);

        btn_ext = new JButton("Exit");
        btn_ext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamebox.Selector x = new gamebox.Selector();
                x.setVisible(true);
                main.dispose();
            }
        });
//        SaveBtn= new JButton("Save game");
//        SaveBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sgp.SaveGame();
//            }
//        });
        btn_restart = new JButton("Restart");
        btn_restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diffchooser dc = new diffchooser();
                dc.setVisible(true);
                main.dispose();
                gameGUI.StopScore();
            }
        });

        Scorelbl = new JTextArea(Integer.toString(Score));
        //btmpnl.add(SaveBtn);
        btmpnl.add(btn_ext);
        btmpnl.add(btn_restart);
        btmpnl.add(Scorelbl);

        main.add(btmpnl, BorderLayout.SOUTH);

        Refresher = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Refresh();
                Scorelbl.setText(" Time: " + Integer.toString(++Score) + " seconds");
                Scorelbl.repaint();
                won.jTextField1.setText(Integer.toString(getScore()) + " Seconds");
            }
        });
        Scorelbl.setEditable(false);
        Refresher.start();
    }

    public void Refresh() {
        btmpnl.repaint();
        main.repaint();
        this.repaint();
    }

    public static int getScore() {
        return Score;
    }

    public static void StopScore() {
        Refresher.stop();
        Score = 0;
    }
    
    public static void SetScore(int x) {
        Score = x;
    }

    public void setButtons(JButton btns[][]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sgp.SetButton(btns[i][j], i, j);
            }
        }
    }

    public void load(int x, int y, int i, int j) {

        sgp.SetRandomPuzzle(x, i, j);
        sgp.SetPlayablePuzzle(y, i, j);

    }

}
