import java.util.*;

public class Sudoku{

  public static void main(String[] args) {

    ArrayList<int[]> grid = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    int n = 0;

    //initialize grid
    while(n < 9)
    {
      String str_row = input.nextLine();
      int[] row = new int[9];

      for(int i = 0; i < 9; i++)
      {
        row[i] = Integer.parseInt(str_row.split(" ")[i]);
      }

      grid.add(row);

      printGrid(grid);
      n++;
    }
  }

  private static void printGrid(ArrayList<int[]> grid)
  {
    for(int i = 0; i<9 ; i++)
    {
      int[] row = grid.get(i);
      for(int j = 0; j<9 ; j++)
      {
        System.out.print(row[j] + " ");
      }
      System.out.println();
    }
  }
}
