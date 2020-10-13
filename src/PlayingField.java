
/**
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * @author Selin Ustaoglu (1533754)
 * @author Damla Savas (1533746)
 * assignment group 44
 * 
 * assignment copyright Kees Huizing
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

class PlayingField extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Patch[][] grid;
	
	private boolean[][] isCooperating;

	private double alpha; // defection award factor

	private Timer timer;

	// random number genrator
	private static final long SEED = 37L; // seed for random number generator; any number goes
	public static final Random random = new Random(SEED);

	// ...
	
	private int[][] neighboursLocations = {
			{0, -1},
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, 1},
			{1, 1},
			{1, 0},
			{1, -1},
	};

	public PlayingField() {
		int N = 10;

		GridLayout gridLayout = new GridLayout(N, N);
		setLayout(gridLayout);
		setSize(400, 400);

		grid = new Patch[N][N];

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col] = new Patch(random.nextBoolean());
				add(grid[row][col]);
			}
		}
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				// add Neighbours to patch
				List<Patch> neighbours = new ArrayList<Patch>();
				
				for (int i = 0; i < neighboursLocations.length; i++) {
					int[] neigLocation = neighboursLocations[i];
					int neigRow = (row + neigLocation[0] + N) % N;
					int neigCol = (col + neigLocation[1] + N) % N;
					neighbours.add(grid[neigRow][neigCol]);
				}
				
				grid[row][col].setNeighbours(neighbours);
			}
		}
	}

	/**
	 * calculate and execute one step in the simulation
	 */
	public void step() {
		// ...
		// for all patchs cell calculate 
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col].calculatedNewScore();
			}
		}
		
		// for all patchs cell setCalculatedScore
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid.length; col++) {
				grid[row][col].setCalculatedScore();
			}
		}
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}

	public double getAlpha() {
		return alpha; 
	}

	// return grid as 2D array of booleans
	// true for cooperators, false for defectors
	// precondition: grid is rectangular, has non-zero size and elements are
	// non-null
	public boolean[][] getGrid() {
		boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				resultGrid[x][y] = grid[x][y].isCooperating();
			}
		}

		return resultGrid;
	}

	// sets grid according to parameter inGrid
	// a patch should become cooperating if the corresponding
	// item in inGrid is true
	public void setGrid(boolean[][] isCooperating) {
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[0].length; y++) {
				grid[x][y].setCooperating(isCooperating[x][y]);
			}
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
