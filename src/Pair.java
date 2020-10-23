import java.util.*;

public class Pair {
	private ArrayList<ArrayList<Integer>> grid;
	private boolean isSolved;
	
	public Pair(ArrayList<ArrayList<Integer>> grid, boolean isSolved) {
		this.grid = grid;
		this.isSolved = isSolved;
	}
	
	public ArrayList<ArrayList<Integer>> getGrid(){
		return grid;
	}
	
	public void setIsSolved(boolean solved)
	{
		this.isSolved = solved;
	}
	
	public boolean getIsSolved() {
		return isSolved;
	}
	
}
