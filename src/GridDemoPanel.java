import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GridDemoPanel extends JPanel implements MouseListener, KeyListener
{
	private Cell[][] theGrid;
	public final static int NUM_ROWS = 5;
	public final static int NUM_COLS = 5;
	public GridDemoFrame myParent;
	public int score;
	
	public GridDemoPanel(GridDemoFrame parent)
	{
		super();
		resetCells();

		//theGrid[2][2].setMarker("A");
		//theGrid[2][2].setDisplayMarker(true);
	//	theGrid[3][3].setIsLive(false);
		//setBackground(Color.BLACK);
		addMouseListener(this);
		//parent.addKeyListener(this); // activate this if you wish to listen to the keyboard. 
		myParent = parent;
	}	
	
	/**
	 * makes a new board with random colors, completely filled in, and resets the score to zero.
	 */
	public void resetCells()
	{
		theGrid = new Cell[NUM_ROWS][NUM_COLS];
		//for (int r =0; r<NUM_ROWS; r++)
		//for (int c=0; c<NUM_COLS; c++)
		theGrid[0][0] = new Cell(4,0,0,"*",true);
		theGrid[0][1] = new Cell(3,0,1,"*",true);
		theGrid[0][2] = new Cell(5,0,2,"",false);
		theGrid[0][3] = new Cell(2,0,3,"*",true);
		theGrid[0][4] = new Cell(5,0,4,"",false);
		theGrid[1][0] = new Cell(5,1,0,"",false);
		theGrid[1][1] = new Cell(2,1,1,"*",true);
		theGrid[1][2] = new Cell(5,1,2,"",false);
		theGrid[1][3] = new Cell(4,1,3,"*",true);
		theGrid[1][4] = new Cell(3,1,4,"*",true);
		theGrid[2][0] = new Cell(3,2,0,"*",true);
		theGrid[2][1] = new Cell(5,2,1,"",false);
		theGrid[2][2] = new Cell(4,2,2,"*",true);
		theGrid[2][3] = new Cell(5,2,3,"",false);
		theGrid[2][4] = new Cell(2,2,4,"*",true);
		theGrid[3][0] = new Cell(2,3,0,"*",true);
		theGrid[3][1] = new Cell(1,3,1,"*",true);
		theGrid[3][2] = new Cell(3,3,2,"*",true);
		theGrid[3][3] = new Cell(5,3,3,"",false);
		theGrid[3][4] = new Cell(5,3,4,"",false);
		theGrid[4][0] = new Cell(5,4,0,"",false);
		theGrid[4][1] = new Cell(5,4,1,"",false);
		theGrid[4][2] = new Cell(2,4,2,"*",true);
		theGrid[4][3] = new Cell(3,4,3,"*",true);
		theGrid[4][4] = new Cell(0,4,4,"*",true);


	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (int r =0; r<NUM_ROWS; r++)
			for (int c=0; c<NUM_COLS; c++)
				theGrid[r][c].drawSelf(g);
	}
	
	/**
	 * the mouse listener has detected a click, and it has happened on the cell in theGrid at row, col
	 * @param row
	 * @param col
	 */
	public void userClickedCell(int row, int col)
	{
		System.out.println("("+row+", "+col+")");
		if (!theGrid[row][col].isLive())
			return;
		if(theGrid[row][col].shouldDisplayMarker() == false)
		{
			theGrid[row][col].cycleColorIDForward();
		}
		repaint();
		makeGameOverDialog();
	}
	
	
	
	
	/**
	 * Here's an example of a simple dialog box with a message.
	 */
	public void makeGameOverDialog()
	{
		if (theGrid[0][2].getColorID() == 0 & theGrid[0][4].getColorID() == 1 & theGrid[1][0].getColorID() == 0
				& theGrid[1][2].getColorID() == 1 & theGrid[2][1].getColorID() == 0 & theGrid[2][3].getColorID() == 1
				& theGrid[3][3].getColorID() == 0 & theGrid[3][4].getColorID() == 4 & theGrid[4][0].getColorID() == 1
				& theGrid[4][1].getColorID() == 4)
		{
			JOptionPane.showMessageDialog(this, "Congrats! You won!");
		}
		
	}
	
	//============================ Mouse Listener Overrides ==========================

	@Override
	// mouse was just released within about 1 pixel of where it was pressed.
	// NOTE: this is actually kind of obnoxious because if the mouse moved much at all between press
	// and release, it won't register as a click. You may be happier with mouseReleased, instead.
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		// mouse location is at e.getX() , e.getY().
		// if you wish to convert to the rows and columns, you can integer-divide by the cell size.
		int col = e.getX()/Cell.CELL_SIZE;
		int row = e.getY()/Cell.CELL_SIZE;
		userClickedCell(row,col);
		
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		// mouse location is at e.getX() , e.getY().
		// if you wish to convert to the rows and columns, you can integer-divide by the cell size.
				
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		// mouse location is at e.getX() , e.getY().
		// if you wish to convert to the rows and columns, you can integer-divide by the cell size.
		
	}

	@Override
	// mouse just entered this window
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	// mouse just left this window
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	//============================ Key Listener Overrides ==========================

	@Override
	/**
	 * user just pressed and released a key. (May also be triggered by autorepeat, if key is held down?
	 * @param e
	 */
	public void keyTyped(KeyEvent e)
	{
		char whichKey = e.getKeyChar();
		myParent.updateMessage("User just typed \""+whichKey+"\"" );
		System.out.println(whichKey);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}
	// ============================= animation stuff ======================================
	/**
	 * if you wish to have animation, you need to call this method from the GridDemoFrame AFTER you set the window visibility.
	 */
	public void initiateAnimationLoop()
	{
		Thread aniThread = new Thread( new AnimationThread(500)); // the number here is the number of milliseconds between steps.
		aniThread.start();
	}
	
	/**
	 * Modify this method to do what you want to have happen periodically.
	 * This method will be called on a regular basis, determined by the delay set in the thread.
	 * Note: By default, this will NOT get called unless you uncomment the code in the GridDemoFrame's constructor
	 * that creates a thread.
	 *
	 */
	public void animationStep(long millisecondsSinceLastStep)
	{
		theGrid[0][0].cycleColorIDBackward();
		repaint();
	}
	// ------------------------------- animation thread - internal class -------------------
	public class AnimationThread implements Runnable
	{
		long start;
		long timestep;
		public AnimationThread(long t)
		{
			timestep = t;
			start = System.currentTimeMillis();
		}
		@Override
		public void run()
		{
			long difference;
			while (true)
			{
				difference = System.currentTimeMillis() - start;
				if (difference >= timestep)
				{
					animationStep(difference);
					start = System.currentTimeMillis();
				}
				try
				{	Thread.sleep(1);
				}
				catch (InterruptedException iExp)
				{
					System.out.println(iExp.getMessage());
					break;
				}
			}
			
		}
		
	}
}
