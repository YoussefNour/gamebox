package connect4;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

public class gamepnl extends JPanel 
{
    
    public grid maingrid ;
    protected static usedby turn = usedby.player1;
    private gamepnl main = this;
     
    
    protected enum usedby
    {
        player1,
        player2,
        empty
    }
    
    public void setturn(usedby t)
    {
        turn = t;
    }
    
    public gamepnl()
    {
        this.setBackground(Color.BLUE);
        maingrid = new grid();
    }
    
    public static void switchturn()
    {
        if(turn==usedby.player1)
        {
            turn = usedby.player2;
        }
        else{
            turn = usedby.player1;
        }
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        maingrid.drawgrid(g);
            
    }
    
    public void play(int c)
        {
            if(main.maingrid.crcls[c][0].isempty())
            {
                main.maingrid.crcls[c][0].t=turn;
                Graphics g = main.getGraphics();
                main.maingrid.drawgrid(g);
                main.paint(g);
                main.drop(c,0,g);
            }
            
        }
    
    public void drop(int c,int r,Graphics g)
    {
        do
        {
            if(main.maingrid.crcls[c][r+1].isempty())
            {
                ++r;
                main.maingrid.crcls[c][r-1].t = usedby.empty;
                main.maingrid.crcls[c][r].t = turn;
                main.maingrid.drawgrid(g);
                main.paint(g);
                try{
                Thread.sleep(60);
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(main,"drop interrupted");
                }
                //System.out.println("["+c+"] ["+r+"]");//for testing drop location
            }
            else
            {
                break;
            }
            }while(r<5);
        if(main.checkwin(c,r))
        {
            showwinmessage();
            main.maingrid.restart();
        }
        switchturn();
    }
    
    
    public void showwinmessage()
    {
        JOptionPane.showMessageDialog(main,turn+" "+"won !!");
    }
    
    
    public boolean checkwin(int c,int r)
    {
        boolean playerwon=false;
        circle checkcircle = main.maingrid.crcls[c][r];
        
        //horizontal check right------------------------------------------------
        
        int counthl=0,counthr=0;
        
        for(int i=1;i<4;i++)
        {
            if((c+i)>6)
            {
                break;
            }
            if(main.maingrid.crcls[c+i][r].t==checkcircle.t)
            {
                
                counthr++;
            }
        }
        if((counthr+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        //horizontal check left-------------------------------------------------
        
        for(int i=1;i<4;i++)
        {
            if((c-i)<0)
            {
                break;
            }
            if(main.maingrid.crcls[c-i][r].t == checkcircle.t)
            {
                counthl++;
            }
        }
        if((counthl+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        //check-horizontal-row--------------------------------------------------
        //for when disk is dropped in middle of 3 disks of same color
        int counth = 0;
        for (int i=0;i<=6;i++)
            {
                if (main.maingrid.crcls[i][r].t == checkcircle.t)
                {
                    counth++; 
                }
                else
                {
                    counth=0;
                }
                if (counth>=4){
                        playerwon = true;
                        return playerwon;}
            }
        //vertical check--------------------------------------------------------
        int  countv =0;
        for(int i=1;i<4;i++)
        {
            if((r+i)> 5)
            {  
                break;
            }
            if(main.maingrid.crcls[c][r+i].t==checkcircle.t)
            {
                countv++;
            }
        }
        if((countv+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        //diagonal-check--------------------------------------------------------
        
        //diagonal-check-r-&-u--------------------------------------------------
        int countru = 0 ;
        for(int i =1;i<4;i++)
        {
            if((c+i)>6 ||(r+i)>5){
                break;}
            if(main.maingrid.crcls[c+i][r+i].t==checkcircle.t){
                countru++;}
        }
        if((countru+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        //diagonal-check-l-&-u--------------------------------------------------
        int countlu = 0 ;
        for(int i =1;i<4;i++)
        {
            if((c-i)<0 ||(r+i)>5){
                break;}
            if(main.maingrid.crcls[c-i][r+i].t==checkcircle.t){
                countlu++;}
        }
        if((countlu+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }

        //diagonal-check-r-&-d--------------------------------------------------
        int countrd = 0 ;
        for(int i =1;i<4;i++)
        {
            if((c+i)>6 ||(r-i)<0){
                break;}
            if(main.maingrid.crcls[c+i][r-i].t==checkcircle.t){
                countrd++;}
        }
        
        if((countrd+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        if((countlu+countrd+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        //diagonal-check-l-&-d--------------------------------------------------
        int countld = 0 ;
        for(int i =1;i<4;i++)
        {
            if((c-i)<0 ||(r-i)<0){
                break;}
            if(main.maingrid.crcls[c-i][r-i].t==checkcircle.t){
                countld++;}
        }
        
        if((countld+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        if((countru+countld+1)>=4)
        {
            playerwon = true;
            return playerwon;
        }
        
        return playerwon;
    }

        
                    
    
    
    
    
    public class grid
    {
        private circle[][] crcls= new circle[7][6];
        
        public grid()
        {
            for(int i=0;i<7;i++)
            {
                for(int j=0;j<6;j++)
                {
                    crcls[i][j]= new circle(10+i*85,10+j*85,usedby.empty);
                }
            }
        }
        
        
        public void drawgrid(Graphics g)
        {
            for(int i=0;i<7;i++)
               {
                 for(int j=0;j<6;j++)
                    {
                        crcls[i][j].drawcircle(g);
                    }
               }
        
        }
       
        public grid(circle[][] crcls) {
            this.crcls = crcls;
        }

        public circle[][] getCrcls() {
            return crcls;
        }
        public void restart()
        {
            for(int i=0;i<7;i++)
            {
                for(int j=0;j<6;j++)
                {
                    (main.maingrid.getCrcls())[i][j].setT(gamepnl.usedby.empty);
                    main.setturn(gamepnl.usedby.player1);
                    Graphics g = main.getGraphics();
                    main.paint(g);    
                }    
            }    
        }
    }
    
    
    
    
    
    
    public class circle 
    {
        private int x,y;
        private usedby t;
        
        public circle(int x,int y,usedby t) 
        {
            this.x=x;
            this.y=y;
            this.t=t;
        }
        
        public void drawcircle(Graphics g)
        {
            switch(this.t)
            {
                case player1:
                {
                    g.setColor(Color.red);
                }
                break;
                case player2:
                {
                    g.setColor(Color.yellow);
                }
                break;
                case empty:
                {
                    g.setColor(Color.white);
                }
                break;
            }
            g.fillOval(this.x,this.y,80,80);
        }

        public usedby getT() {
            return t;
        }
        
        public boolean isempty()
        {
            boolean res=false;
            switch(this.t)
            {
                case player1:
                {
                    res=false;
                }
                break;
                case player2:
                {
                    res=false;
                }
                break;
                case empty:
                {
                    res=true;
                }
                break;
            }
            return res;
        }

        public void setT(usedby t) 
        {
            this.t = t;
        }
    }
}
