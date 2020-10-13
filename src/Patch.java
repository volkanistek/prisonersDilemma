import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.List;

/**
 * INCOMPLETE 
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * 
 * @author Selin Ustaoglu (1533754)
 * @author Damla Savas (1533746)
 * assignment group 44
 * assignment copyright Kees Huizing
 */

class Patch extends Panel {
    private double score = 0;
    private double newScore = 0;
    
	private static final long serialVersionUID = 1L;
	
	private boolean cooperating;
	
	private List<Patch> neighbours;
	
	public Patch(boolean cooperating) {
		this.cooperating = cooperating;
	}

	// returns true if and only if patch is cooperating
    boolean isCooperating() {
        return cooperating; // CHANGE THIS
    }
    
    // set strategy to C if isC is true and to D if false
    void setCooperating(boolean isC) {
    	this.cooperating = isC;
    }
    
    // change strategy from C to D and vice versa
    void toggleStrategy() {
    	this.cooperating = !this.cooperating;
    }
    
    // return score of this patch in current round
    double getScore() {
        return score; // CHANGE THIS
    }

	public void setNeighbours(List<Patch> neighbours) {
		this.neighbours = neighbours;
	}

	public void calculatedNewScore() {
		// Check Neighbours and calculate newScore
		int numberOfCooperatingNeighbours = 0;
		for (Patch neighbour : neighbours) {
			if (neighbour.isCooperating())
				numberOfCooperatingNeighbours++;
		}
		// Maybe we need to change cooperating field or newScore ?????
	}
	
	public void setCalculatedScore() {
		this.score = this.newScore;
	}
	
	@Override
	public void paint(Graphics g) {
		setBackground(cooperating ? Color.RED : Color.BLUE);
		super.paint(g);
	}
    
    
}
