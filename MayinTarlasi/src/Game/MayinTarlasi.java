package Game;

import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {

	int rowNumber = 4, colNumber = 4, size;
	int[][] map;
	int[][] board;
	boolean game = true;

	Random rnd = new Random();
	Scanner scan = new Scanner(System.in);

	MayinTarlasi(int rowNumber, int colNumber) {
		this.rowNumber = rowNumber;
		this.colNumber = colNumber;
		this.map = new int[rowNumber][colNumber];
		this.board = new int[rowNumber][colNumber];
		this.size = rowNumber * colNumber;
	}

	public void run() {
		int row, col;
		prepareGame();
		// print(map);
		System.out.println("Oyun Başladı !");
		while (game) {
			print(map);
			print(board);
			System.out.print("Satır->");
			row = scan.nextInt();
			System.out.print("Sütün->");
			col = scan.nextInt();
			if (row >= map.length || col >= map[0].length) {
				System.out.println("Buyuk satır veya sutun girdiniz..");
				break;

			}
			if (map[row][col] != -1) {
				if (col == 0 && row == 0) {

					if (map[row + 1][col] == -1) {
						map[row][col]++;
						board[row][col]++;
					}
					if (map[row][col + 1] == -1) {
						map[row][col]++;
						board[row][col]++;
					}

					if (map[row][col] == 0) {
						map[row][col] = -2;
						board[row][col] = -2;
					}

				} else {
					checkMayin(row, col);
				}

			}
			if (map[row][col] == -1) {
				game = false;
				System.out.println("Maalesef yandınız:(");
				break;
			}
		}

	}

	public void prepareGame() {
		int randRow, randCol, count = 0;

		while (count != size / 4) {
			randRow = rnd.nextInt(rowNumber);
			randCol = rnd.nextInt(colNumber);
			if (map[randRow][randCol] != -1) {
				map[randRow][randCol] = -1;
				count++;
			}
		}

	}

	public void print(int[][] array) {
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] <= -1) {
					System.out.print(array[i][j] + " ");
					continue;
				}
				System.out.print(" " + array[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void checkMayin(int row, int col) {

		if ((row == 0) && (col <= map[0].length)) {

			if (map[row + 1][col] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col + 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}

			if (map[row + 1][col - 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col - 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col] == 0) {
				map[row][col] = -2;
				board[row][col] = -2;
			}
		} else if ((col == 0) && (row <= map.length)) {
			if (map[row - 1][col] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row + 1][col] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col + 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}

			if (map[row][col] == 0) {
				map[row][col] = -2;
				board[row][col] = -2;
			}

		}

		else if (row <= map.length && col <= map[0].length) {
			if (map[row - 1][col] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row + 1][col] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col + 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}

			if (map[row][col - 1] == -1) {
				map[row][col]++;
				board[row][col]++;
			}
			if (map[row][col] == 0) {
				map[row][col] = -2;
				board[row][col] = -2;
			}
		}

	}

}
