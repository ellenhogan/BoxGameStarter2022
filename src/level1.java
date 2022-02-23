import javax.swing.*;

public class level1 extends GridDemoPanel
{
//    private Cell[][] theGrid;
    public final static int NUM_ROWS = 5;
    public final static int NUM_COLS = 5;

    public level1(GridDemoFrame parent)
    {
        super(parent);
    }

    public void resetCells()
    {
        System.out.println("hello");
        theGrid = new Cell[NUM_ROWS][NUM_COLS];
        theGrid[0][0] = new Cell(4, 0, 0, "*", true);
        theGrid[0][1] = new Cell(3, 0, 1, "*", true);
        theGrid[0][2] = new Cell(5, 0, 2, "", false);
        theGrid[0][3] = new Cell(2, 0, 3, "*", true);
        theGrid[0][4] = new Cell(5, 0, 4, "", false);
        theGrid[1][0] = new Cell(5, 1, 0, "", false);
        theGrid[1][1] = new Cell(2, 1, 1, "*", true);
        theGrid[1][2] = new Cell(5, 1, 2, "", false);
        theGrid[1][3] = new Cell(4, 1, 3, "*", true);
        theGrid[1][4] = new Cell(3, 1, 4, "*", true);
        theGrid[2][0] = new Cell(3, 2, 0, "*", true);
        theGrid[2][1] = new Cell(5, 2, 1, "", false);
        theGrid[2][2] = new Cell(4, 2, 2, "*", true);
        theGrid[2][3] = new Cell(5, 2, 3, "", false);
        theGrid[2][4] = new Cell(2, 2, 4, "*", true);
        theGrid[3][0] = new Cell(2, 3, 0, "*", true);
        theGrid[3][1] = new Cell(1, 3, 1, "*", true);
        theGrid[3][2] = new Cell(3, 3, 2, "*", true);
        theGrid[3][3] = new Cell(5, 3, 3, "", false);
        theGrid[3][4] = new Cell(5, 3, 4, "", false);
        theGrid[4][0] = new Cell(5, 4, 0, "", false);
        theGrid[4][1] = new Cell(5, 4, 1, "", false);
        theGrid[4][2] = new Cell(2, 4, 2, "*", true);
        theGrid[4][3] = new Cell(3, 4, 3, "*", true);
        theGrid[4][4] = new Cell(0, 4, 4, "*", true);
    }

    public void makeGameOverDialog()
    {
        if (theGrid[0][2].getColorID() == 0 & theGrid[0][4].getColorID() == 1 & theGrid[1][0].getColorID() == 0
                & theGrid[1][2].getColorID() == 1 & theGrid[2][1].getColorID() == 0 & theGrid[2][3].getColorID() == 1
                & theGrid[3][3].getColorID() == 0 & theGrid[3][4].getColorID() == 4 & theGrid[4][0].getColorID() == 1
                & theGrid[4][1].getColorID() == 4) {
            JOptionPane.showMessageDialog(this, "You win! Congrats :)");
        }
    }
}
