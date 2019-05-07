/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TicTacToegame;

import java.awt.Color;
import javax.swing.JOptionPane;
import gamebox.GameBox;
import gamebox.Selector;

public class TicTacToeFrame extends javax.swing.JFrame {

    /**
     *
     */
    public String turn="X";
    public String playerX="Player x";
    public String playerO="Player O";
    private int scoreX =0;
    private int scoreO =0;
    
    public TicTacToeFrame() {
        initComponents();
        setSize(600,600);
        setLocationRelativeTo(null);
        getplayername();
        setscore();
        tiegame();
    }
    private void tiegame(){
    String no1 = jButton1.getText();
    String no2 = jButton2.getText();
    String no3 = jButton3.getText();
    String no6 = jButton4.getText();
    String no5 = jButton5.getText();
    String no4 = jButton6.getText();
    String no9 = jButton7.getText();
    String no8 = jButton8.getText();
    String no7  = jButton9.getText();
    if(no1 != "" && no2 !="" && no3 !="" && no4 !="" && no5 !="" && no6 !=""&&no7!=""&&no8!=""){
        JOptionPane.showMessageDialog(this,"Game is tie !", "Tie Game", JOptionPane.INFORMATION_MESSAGE);
        resetgame();
    }
    }
    private void getplayername(){
        playerX= JOptionPane.showInputDialog(this, "Player one name","player name",JOptionPane.INFORMATION_MESSAGE);
        playerO= JOptionPane.showInputDialog(this, "Player two name","player name",JOptionPane.INFORMATION_MESSAGE);
        
    }
    private void setscore(){
      jLabel1.setText(playerX +"   score is :\t" + scoreX +"   \t" +playerO +" score is :    \t" +scoreO);
    }
private void whoseturn()
{
    if(turn=="X")
          {turn="O";}
    else
          {turn="X";}
}
private void printWhowin(String winer)
{ if (winer=="X")
    {
        JOptionPane.showMessageDialog(this, "player X wins"," winner !",JOptionPane.INFORMATION_MESSAGE);
 
        resetgame();
       
    }



else if (winer=="O")JOptionPane.showMessageDialog(this, "player O wins"," winner !",JOptionPane.INFORMATION_MESSAGE);   
   
resetgame();
   
}
private void resetgame(){
    jButton1.setText("");
    jButton2.setText("");
    jButton3.setText("");
    jButton4.setText("");
    jButton5.setText("");
    jButton6.setText("");
    jButton7.setText("");
    jButton8.setText("");
    jButton9.setText("");
    setscore();
}
private void determinewhowin(){
    String no1 = jButton1.getText();
    String no2 = jButton2.getText();
    String no3 = jButton3.getText();
    String no6 = jButton4.getText();
    String no5 = jButton5.getText();
    String no4 = jButton6.getText();
    String no9 = jButton7.getText();
    String no8 = jButton8.getText();
    String no7  = jButton9.getText();
    //xwins
    if(no1=="X"&&no2=="X"&&no3=="X")
    {       scoreX++;
        printWhowin("X");
    }
    if(no4=="X"&&no5=="X"&&no6=="X")
    {      scoreX++;
        printWhowin("X");
    }
    if(no7=="X"&&no8=="X"&&no9=="X")
    {      scoreX++;
        printWhowin("X");
    }
    if(no1=="X"&&no4=="X"&&no7=="X"){
              scoreX++;
        printWhowin("X");
    }
    if(no2=="X"&&no5=="X"&&no8=="X"){
              scoreX++;
        printWhowin("X");
    }
    if(no3=="X"&&no6=="X"&&no9=="X"){
              scoreX++;
              printWhowin("X");
    }
    if(no1=="X"&&no5=="X"&&no9=="X"){
              scoreX++;
              printWhowin("X");
    }
    if(no3=="X"&&no5=="X"&&no7=="X"){
              scoreX++;
              printWhowin("X");
    }
    //o wins
    if(no1=="O"&&no2=="O"&&no3=="O")
    { scoreO++;
    printWhowin("O");
    }
    if(no4=="O"&&no5=="O"&&no6=="O")
    {
     scoreO++;
     printWhowin("O");
    }
    if(no7=="O"&&no8=="O"&&no9=="O")
    {
      scoreO++;
      printWhowin("O");
    }
    if(no1=="O"&&no4=="O"&&no7=="O"){
       scoreO++;
       printWhowin("O");
    }
    if(no2=="O"&&no5=="O"&&no8=="O"){
        scoreO++;
        printWhowin("O");
    }
    if(no3=="O"&&no6=="O"&&no9=="O"){
         scoreO++;
         printWhowin("O");
    }
    if(no1=="O"&&no5=="O"&&no9=="O"){
         scoreO++;
         printWhowin("O");
    }
    if(no3=="O"&&no5=="O"&&no7=="O"){
         scoreO++;
         printWhowin("O");
    }
//tie
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Btn1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        Btn2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Btn3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        Btn4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        Btn5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        Btn6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        Btn7 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        Btn8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        Btn9 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        btn_ext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TicTacToe");

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        Btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Btn1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn1);

        Btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Btn2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn2);

        Btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        Btn3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn3);

        Btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn4.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Btn4.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn4);

        Btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        Btn5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn5);

        Btn6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn6.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        Btn6.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn6);

        Btn7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn7.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        Btn7.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn7);

        Btn8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        Btn8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn8);

        Btn9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn9.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 100)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        Btn9.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanel3.add(Btn9);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        btn_ext.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        btn_ext.setText("Exit");
        btn_ext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_extActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ext, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        
        jButton8.setText(turn);
        if(turn=="X")
        { 
           jButton8.setForeground(Color.BLACK);
         
        }else{
            jButton8.setForeground(Color.red);
        }
        this.disable();
        whoseturn();
        tiegame();
        determinewhowin();
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setText(turn);
        if(turn=="X")
        {
            jButton1.setForeground(Color.BLACK);
         
        }else{
            jButton1.setForeground(Color.red);
        }
        this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         jButton2.setText(turn);
         if(turn=="X")
        {
            jButton2.setForeground(Color.BLACK);
         
        }else{
            jButton2.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         jButton3.setText(turn);
         if(turn=="X")
        {
            jButton3.setForeground(Color.BLACK);
         
        }else{
            jButton3.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         jButton6.setText(turn);
         if(turn=="X")
        {
            jButton6.setForeground(Color.BLACK);
         
        }else{
            jButton6.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         jButton5.setText(turn);
         if(turn=="X")
        {
            jButton5.setForeground(Color.BLACK);
         
        }else{
            jButton5.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         jButton4.setText(turn);
         if(turn=="X")
        {
            jButton4.setForeground(Color.BLACK);
         
        }else{
            jButton4.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
       tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
         jButton9.setText(turn);
         if(turn=="X")
        {
            jButton9.setForeground(Color.BLACK);
         
        }else{
            jButton9.setForeground(Color.red);
        }
        this.disable();
         whoseturn();
       tiegame();
         determinewhowin();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         jButton7.setText(turn);
         if(turn=="X")
        {
            jButton7.setForeground(Color.BLACK);
         
        }else{
            jButton7.setForeground(Color.red);
        }
         this.disable();
        whoseturn();
      tiegame();
        determinewhowin();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_extActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_extActionPerformed
      gamebox.Selector s = new Selector();
      s.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_btn_extActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicTacToeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicTacToeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Btn1;
    private javax.swing.JPanel Btn2;
    private javax.swing.JPanel Btn3;
    private javax.swing.JPanel Btn4;
    private javax.swing.JPanel Btn5;
    private javax.swing.JPanel Btn6;
    private javax.swing.JPanel Btn7;
    private javax.swing.JPanel Btn8;
    private javax.swing.JPanel Btn9;
    private javax.swing.JButton btn_ext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
