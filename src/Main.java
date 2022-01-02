public class Main {
	public static void main(String[] args) {
		int board[][] = {
				{4, 2, 0, 0, 3, 6, 0, 9, 0},
				{0, 5, 0, 9, 0, 0, 6, 3, 0},
				{0, 0, 9, 0, 7, 0, 1, 5, 0},
				{7, 0, 3, 1, 5, 0, 0, 0, 9},
				{0, 9, 0, 8, 6, 0, 4, 0, 1},
				{1, 4, 0, 7, 0, 2, 0, 8, 0},
				{0, 0, 5, 2, 8, 7, 9, 0, 0},
				{9, 3, 4, 6, 0, 0, 0, 0, 7},
				{0, 0, 0, 3, 4, 9, 0, 0, 0}
		};
		
		Solver solver = new Solver(board);
		
		if(solver.solve())
			System.out.println("Solve successfully!");
		else 
			System.out.println("Unsolvable board :(");
		
		
		System.out.println(solver);
	}
}
