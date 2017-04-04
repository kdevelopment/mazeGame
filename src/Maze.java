import java.util.Scanner;

public class Maze {
	char MyMaze[][] = { { '*', '*', '*', '*', '*', '-', '*', '*', '*', '*', '*', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '*' },
			{ '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

	public Maze() {
		KeyBoard = new Scanner(System.in);
		YPos = 13;
		XPos = 7;
		ReplacedChar = MyMaze[YPos][XPos];
		MyMaze[YPos][XPos] = 'X';
	}

	void print() {
		int rows = MyMaze.length;
		int columns = MyMaze[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(MyMaze[i][j]);
			}
			System.out.println();
		}
	}

	Scanner KeyBoard;
	int XPos, YPos;
	char ReplacedChar;
	static public final char WINNING_CHAR = '-';

	void run() {
		boolean bWon = false;
		print();
		while (!bWon) {
			String s = KeyBoard.nextLine();
			if (s.equals("w")) {
				if (YPos == 0 || MyMaze[YPos - 1][XPos] == '*') {
					System.out.println("you hit a wall!");
				} else {
					MyMaze[YPos][XPos] = ReplacedChar;
					YPos--;
					ReplacedChar = MyMaze[YPos][XPos];
					MyMaze[YPos][XPos] = 'X';
				}
				print();
			} else if (s.equals("a")) {
				if (XPos == 0 || MyMaze[YPos][XPos - 1] == '*') {
					System.out.println("you hit a wall!");
				} else {
					MyMaze[YPos][XPos] = ReplacedChar;
					XPos--;
					ReplacedChar = MyMaze[YPos][XPos];
					MyMaze[YPos][XPos] = 'X';
					print();
				}
			} else if (s.equals("d")) {
				if (XPos == MyMaze[0].length-1 || MyMaze[YPos][XPos + 1] == '*') {
					System.out.println("you hit a wall!");
				} else {
					MyMaze[YPos][XPos] = ReplacedChar;
					XPos++;
					ReplacedChar = MyMaze[YPos][XPos];
					MyMaze[YPos][XPos] = 'X';
				}
				print();
			} else if (s.equals("s")) {
				if (YPos == MyMaze.length-1 || MyMaze[YPos+1][XPos] == '*') {
					System.out.println("you hit a wall!");
				} else {
					MyMaze[YPos][XPos] = ReplacedChar;
					YPos++;
					ReplacedChar = MyMaze[YPos][XPos];
					MyMaze[YPos][XPos] = 'X';
				}
				print();
			}
			if (ReplacedChar == WINNING_CHAR) {
				bWon = true;
				System.out.println("you won");
			}
		}
	}


	public static void main(String[] args) {
		Maze m = new Maze();
		m.run();

	}

}
