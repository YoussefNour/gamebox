package connect4;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import connect4.gamepnl;

public class gameGUI extends JFrame {

    private JPanel toppnl;
    protected JPanel btmpnl;
    private gamepnl centerpnl;
    private JButton pause, restart;
    private JButton[] topbtns;
    protected JTextField trntxt;
    private JFrame main = this;

    public gameGUI() {
        this.setTitle("Connect 4");
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width / 5, Toolkit.getDefaultToolkit().getScreenSize().height / 5, 625, 625);

        Container c = getContentPane();

//---------------------------------------------------------------------------------------
        // top panel
        toppnl = new JPanel();
        toppnl.setLayout(new GridLayout(1, 7, 5, 5));
        toppnl.setBackground(Color.DARK_GRAY);

        topbtns = new JButton[7];
        for (int i = 0; i < 7; i++) {
            topbtns[i] = new JButton("" + (i + 1));
            topbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int x = Integer.parseInt(((JButton) (e.getSource())).getText().trim()) - 1;
                    centerpnl.play(x);
                    switchtrnlbl();
                }
            });
            toppnl.add(topbtns[i]);
        }
        c.add(toppnl, BorderLayout.NORTH);
//-------------------------------------------------------------------------------------------
        // center panel

        centerpnl = new gamepnl();
        c.add(centerpnl);

//-------------------------------------------------------------------------------------------
        //bottom panel
        pause = new JButton("Exit");
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extbtnfn();
            }
        });

        restart = new JButton("restart");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerpnl.maingrid.restart();
            }
        });

        trntxt = new JTextField("it's " + centerpnl.turn.toString() + " turn");
        trntxt.setBackground(Color.darkGray);
        trntxt.setForeground(Color.red);
        trntxt.setEditable(false);

        btmpnl = new JPanel();
        btmpnl.setBackground(Color.DARK_GRAY);
        btmpnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        btmpnl.add(pause);
        btmpnl.add(restart);
        btmpnl.add(trntxt);
        c.add(btmpnl, BorderLayout.SOUTH);
    }

    public void extbtnfn() {
        int dialogbtn = JOptionPane.YES_NO_OPTION;
        int dialogrslt = JOptionPane.showConfirmDialog(main, "are you sure you want to exit", "Warning", dialogbtn);
        if (dialogrslt == JOptionPane.YES_OPTION) {
            gamebox.Selector x = new gamebox.Selector();
            x.setVisible(true);
            main.dispose();
            this.dispose();
        }
    }

    public void switchtrnlbl() {
        trntxt.setText("it's " + gamepnl.turn + " turn");
        if (gamepnl.turn == gamepnl.usedby.player1) {
            trntxt.setForeground(Color.red);
        } else {
            trntxt.setForeground(Color.yellow);
        }
        this.btmpnl.repaint();
    }

}
