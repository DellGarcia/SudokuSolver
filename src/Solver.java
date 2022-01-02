
public class Solver {
	private final int GRID_SIZE = 9;
	private int[][] board;
	
	public Solver(int[][] board) {
		this.board = board;
	}
	
	private boolean isNumberInRow(int number, int row) {
		for(int column = 0; column < 9; column++) 
			if(board[row][column] == number) 
				return true;
		
		return false;
	}
	
	private boolean isNumberInColumn(int number, int column) {
		for(int row = 0; row < 9; row++)
			if(board[row][column] == number)
				return true;
		
		return false;
	}
	
	private boolean isNumberInLocalGroup(int number, int row, int column) {
		int localRow = row - row % 3;
		int localColumn = column - column % 3;
		
		for(int i = localRow; i < localRow+3; i++)
			for(int j = localColumn; j < localColumn+3; j++)
				if(board[i][j] == number)
					return true;
				
		return false;
	}
	
	private boolean isValidPlacement(int row, int column, int number) {	
		return !isNumberInLocalGroup(number, row, column) && 
				!isNumberInRow(number, row) &&
				!isNumberInColumn(number, column);
	}
	
	public boolean solve() {
		for(int row = 0; row < GRID_SIZE; row++) {
			for(int column = 0; column < GRID_SIZE; column++) {
				if(board[row][column] == 0) {
					for(int number = 1; number <= GRID_SIZE; number++) {
						if(isValidPlacement(row, column, number)) {
							board[row][column] = number;
							
							if(solve()) {
								return true;
							} else {
								board[row][column] = 0;
							}
						}
 					}
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < GRID_SIZE; i++) {
			if(i % 3 == 0 && i != 0) 
				sb.append("- - - - - - - - - - -\n");
			
			for(int j = 0; j < GRID_SIZE; j++) {
				if(j % 3 == 0 && j != 0) 
					sb.append("| ");
				
				sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	
}
