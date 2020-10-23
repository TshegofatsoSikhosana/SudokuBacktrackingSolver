
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

		//check if number doesn't repeat in sub block 3x3
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				 if (grid.get(i + (row/3)*3).get(j +(col/3)*3)== val) 
				 {
					 return false; 
				 }
			}
		}
			
		return true;
	}
	
	public static boolean solveGrid(ArrayList<ArrayList<Integer>> grid, int i, int j){
		
		boolean isSolved = false;
		Pair thing = new Pair(grid,false);
		
		if(i == 8 && j == 9)
		{
			return true;
		}
		
		if(j == 9)
		{
			i++;
			j = 0;
		}
		
		if(grid.get(i).get(j) != 0) 
		{
			//backtracking
			return solveGrid(grid,i,j+1);
		}

		for(int k=1; k<=9; k++) {
		
			if(isSafe(grid, i, j, k)) 
			{
				grid.get(i).set(j, k);
				printGrid(grid);
				
				if (solveGrid(grid, i, j+1) == true) 
				{
					return true;
				}
			}
			grid.get(i).set(j,0);
		}
		
		
		return false;
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
		
		ArrayList<ArrayList<Integer>> originalGrid = grid;
	
		if( solveGrid(grid,0,0))
		{	
			printGrid(grid);
		}
		
		if(problemGrid(originalGrid, grid) == true)
		{
			System.out.println("\n \n  think its a bad joke");
		}

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

	public static boolean problemGrid(ArrayList<ArrayList<Integer>> originalGrid, ArrayList<ArrayList<Integer>> grid)
	{
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9;j++)
			{
				if(grid.get(i).get(j) != originalGrid.get(i).get(j) && originalGrid.get(i).get(j) != 0)
				{
					return false;
				}
			}
		}

		return true;
	}

}
