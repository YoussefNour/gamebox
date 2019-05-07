package Sudoku;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JButton;

public class PuzzleCreator {

    private int[][] randomPuzzle = new int[9][9];
    private int[][] PlayablePuzzle = new int[9][9];
    private JFrame main;
    private String Diff;

    //Creates a Puzzle with the required difficulty
    public PuzzleCreator(String Difficulty, JFrame main) {
        Diff = Difficulty;
        this.main = main;
        int[][] basePuzzle = {{1, 2, 3, 6, 7, 8, 9, 4, 5},
        {5, 8, 4, 2, 3, 9, 7, 6, 1},
        {9, 6, 7, 1, 4, 5, 3, 2, 8},
        {3, 7, 2, 4, 6, 1, 5, 8, 9},
        {6, 9, 1, 5, 8, 3, 2, 7, 4},
        {4, 5, 8, 7, 9, 2, 6, 1, 3},
        {8, 3, 6, 9, 2, 4, 1, 5, 7},
        {2, 1, 9, 8, 5, 7, 4, 3, 6},
        {7, 4, 5, 3, 1, 6, 8, 9, 2}};

        //copy from base
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                randomPuzzle[i][j] = basePuzzle[i][j];
            }

        }
        PuzzleGenerator(randomPuzzle);

        Random Rand = new Random();
        int x, y;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 0; j++) {
                PlayablePuzzle[i][j] = 0;
            }
        }
        switch (Difficulty) {
            case "EASY":
                for (int k = 0; k < 65; k++) {
                    x = Rand.nextInt(9);
                    y = Rand.nextInt(9);
                    while (PlayablePuzzle[x][y] != 0) {
                        x = Rand.nextInt(9);
                        y = Rand.nextInt(9);
                    }
                    PlayablePuzzle[x][y] = randomPuzzle[x][y];
                }
                break;
            case "MEDIUM":
                for (int k = 0; k < 35; k++) {
                    x = Rand.nextInt(9);
                    y = Rand.nextInt(9);
                    while (PlayablePuzzle[x][y] != 0) {
                        x = Rand.nextInt(9);
                        y = Rand.nextInt(9);
                    }
                    PlayablePuzzle[x][y] = randomPuzzle[x][y];
                }
                break;
            case "HARD":
                for (int k = 0; k < 25; k++) {
                    x = Rand.nextInt(9);
                    y = Rand.nextInt(9);
                    while (PlayablePuzzle[x][y] != 0) {
                        x = Rand.nextInt(9);
                        y = Rand.nextInt(9);
                    }
                    PlayablePuzzle[x][y] = randomPuzzle[x][y];
                }
                break;
        }
    }

    //Generates a random Puzzle
    private static void PuzzleGenerator(int[][] randomPuzzle) {
        int tempArr[][] = new int[9][9];
        //copy to a temp array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tempArr[i][j] = randomPuzzle[i][j];
            }

        }

        Random rnd = new Random();

        for (int k = 0; k < 211; k++) {             //random number between 0 and 1, '0' is to switch rows and '1' is for columns
            int row_column = rnd.nextInt(2);
            //first and second row/column to switch

            int first = rnd.nextInt(3);
            int second = rnd.nextInt(3);
            while (second == first) {
                second = rnd.nextInt(3);//to make sure second never equals first
            }

            int box = rnd.nextInt(3);
            first += 3 * box;
            second += 3 * box;
            if (row_column == 0) // switching rows
            {

                for (int i = 0; i < 9; i++) {
                    randomPuzzle[first][i] = tempArr[second][i];
                    randomPuzzle[second][i] = tempArr[first][i];
                }

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        tempArr[i][j] = randomPuzzle[i][j];
                    }

                }

            }
            if (row_column == 1) // switching columns
            {
                for (int x = 0; x < 9; x++) {
                    randomPuzzle[x][first] = tempArr[x][second];
                    randomPuzzle[x][second] = tempArr[x][first];
                }

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        tempArr[i][j] = randomPuzzle[i][j];
                    }

                }

            }
        }
    }

    //Returns the number inside the cell of the solution
    public int getSolvedPuzzleIndex(int x, int y) {
        return randomPuzzle[x][y];
    }

    //Returns the generated puzzle with the specified difficulty
    public String getUnsolvedPuzzleIndex(int x, int y) {
        return Integer.toString(PlayablePuzzle[x][y]);
    }

    //Returns true incase if setting a number in the specified place (x,y) matches the game's rule. False if not possible
    public boolean IsPossible(int x, int y, int index) {
        int x1 = x / 3;
        int y1 = y / 3;

        if (index == 0) {
            return true;
        }

        for (int i = x1 * 3; i < (x1 * 3) + 3; i++) {
            for (int j = y1 * 3; j < (y1 * 3) + 3; j++) {
                if (PlayablePuzzle[i][j] == index) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (PlayablePuzzle[x][i] == index) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (PlayablePuzzle[i][y] == index) {
                return false;
            }
        }
        return true;
    }

    //Checks if the play is possible then sets the number to the cell
    public void SetNumber(int x, int y, int index) {
        if (IsPossible(x, y, index) == true) {
            PlayablePuzzle[x][y] = index;
        }
    }

    //Returns true if the Puzzle is solved, False if not
    public boolean IsSolved(Youwonwindow won) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (PlayablePuzzle[i][j] != randomPuzzle[i][j]) {
                    return false;
                }
            }
        }
        gameGUI.StopScore();
        won.jTextField1.setEditable(false);
        won.setVisible(true);
        main.dispose();
        return true;
    }

    public void IncreaseNumber(int x, int y) {
        int counter = 0;
        int i = 1 + PlayablePuzzle[x][y];
        while (IsPossible(x, y, i) == false) {
            counter++;
            i++;
            if (i == 10) {
                i = 0;
            }
            if (counter == 11) {
                return;
            }
        }
        if (i == 10) {
            i = 0;
        }
        PlayablePuzzle[x][y] = i;
    }

    public void IncreaseNumberHard(int x, int y) {
        int i = 1 + PlayablePuzzle[x][y];
        if (i == 10) {
            i = 0;
        }
        PlayablePuzzle[x][y] = i;
    }

    public void SaveGame(JButton btns[][]) {

        java.io.FileOutputStream FOS = null;
        java.io.ObjectOutputStream OOS = null;

        try {

            FOS = new java.io.FileOutputStream("SaveFile.H", false);
            OOS = new java.io.ObjectOutputStream(FOS);

            OOS.writeUTF(Diff);
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    OOS.writeInt(randomPuzzle[i][j]);
                }
            }
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    OOS.writeInt(PlayablePuzzle[i][j]);
                }
            }
            
            OOS.writeInt(gameGUI.getScore());
            
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                   OOS.writeObject(btns[i][j]);;
                }
            }
            
            OOS.flush();
            
        } catch (Exception e) {
            ErrorWindow x = new ErrorWindow();
            x.errormsg.setText(e.toString());
            x.setVisible(true);
        }
    }
    
    public void SetRandomPuzzle(int index,int i, int j){
        randomPuzzle[i][j]=index;
    }
    
    public void SetPlayablePuzzle(int index,int i, int j){
        PlayablePuzzle[i][j]=index;
    }

}
