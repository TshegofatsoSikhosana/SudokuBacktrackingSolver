import java.util.*;

public class Program {
	
	public static boolean isSafe(ArrayList<ArrayList<Integer>> grid, int row, int col, int val) {
		
		//check if column is safe
		for(int i=0; i<9; i++) {
			if(i == col) {
				continue;
			}
			else {
				if(grid.get(row).get(i) == val) {
					return false;
				}

			}
		}
		
		//check if row is safe
		for(int i=0; i<9; i++) {
			if(i == row) {
				continue;
			}
			else {
				if(grid.get(i).get(col) == val) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static Pair solveGrid(ArrayList<ArrayList<Integer>> grid){
		boolean isSolved = false;
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(grid.get(i).get(j) != 0) {
					continue;
				}
				else {
					for(int k=1; k<=9; k++) {
					
						if(isSafe(grid, i, j, k)) {
							grid.get(i).set(j, k);
							Pair thing = solveGrid(grid);
							if(thing.getIsSolved()==false) {
							printGrid(grid);
								continue;
							}
							else {
								isSolved = true;
								printGrid(grid);
								break;
							}
							
						}
						if(k==9 && isSolved == false) {
							grid.get(i).set(j, 0);
							Pair thing2 = new Pair(grid, false);
							return thing2;
						}
					}
				}
			}
		}
		
		Pair fin = new Pair(grid, true);
		return fin;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			String string = in.nextLine();
			String[] ins = string.split(" ");
			ArrayList<Integer> gridRow = new ArrayList<>();
			for(int j=0; j<9; j++) {
				gridRow.add(Integer.parseInt(ins[j]));
			}
			grid.add(gridRow);
		}
		
		in.close();
		
		grid = solveGrid(grid).getGrid();
		
		printGrid(grid);
		

	}
	
	public static void printGrid(ArrayList<ArrayList<Integer>> grid){
	
		System.out.println(" \n");
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(grid.get(i).get(j));
				System.out.print(" ");
				
			}
			System.out.println();
		}
	}

}
