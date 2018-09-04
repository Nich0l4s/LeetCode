package com.xxp.leetcode.Hard;
import java.util.HashSet;
import java.util.Stack;

public class SudokuSolver {
	// test case
	// char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
	// char[][] board2 = new char[][]{{'.','.','9','7','4','8','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}};
	// char[][] board3 = new char[][]{{'5','1','9','7','4','8','6','3','2'},{'7','8','3','6','5','2','4','1','9'},{'4','2','6','1','3','9','8','7','5'},{'3','5','7','9','8','6','2','4','1'},{'2','6','4','3','1','7','5','9','8'},{'1','9','8','5','2','4','3','6','7'},{'9','7','5','8','6','3','1','2','4'},{'8','3','2','4','9','1','7','5','6'},{'6','4','1','2','7','5','9','8','3'}};
	
	private void back(char[][] board, Stack<int[]> s, boolean[][] rows, boolean[][] cols, boolean[][] cubs) {
		while(!s.isEmpty()) {
			int[] i = s.pop();
			int digit = board[i[0]][i[1]] - '0';
			int r = i[0], c = i[1];
			board[r][c] = '.';
			rows[r][digit-1] = false;
			cols[c][digit-1] = false;
			cubs[r/3*3+c/3][digit-1] = false;
			for(int j=digit; j<9; j++) {
				if(!rows[r][j] && !cols[c][j] && !cubs[r/3*3+c/3][j]) {
					board[r][c] = Character.forDigit(j+1, 10);
					rows[r][j] = true;
					cols[c][j] = true;
					cubs[r/3*3+c/3][j] = true;
					s.push(new int[] {r, c, j});
					return;
				}
			}
		}
	}
	public void solveSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] cubs = new boolean[9][9];

		Stack<int[]> back = new Stack<int[]>();

		boolean hasEmpty = true;
		boolean changed = false;
		int num = 0;

		while (hasEmpty) {
			changed = false;
			hasEmpty = false;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						hasEmpty = true;
						if (num != 0) {// 可填数字的数量是否小于num要求
							int count = 0;
							for (int k = 0; k < 9; k++) {
								if (!rows[i][k] && !cols[j][k] && !cubs[i / 3 * 3 + j / 3][k])
									count++;
							}
							if (count == 0) {
								back(board, back, rows, cols, cubs);
								num = 1;
								changed = true;
							} else if (count == num) {
								int k = 0;
								while (rows[i][k] || cols[j][k] || cubs[i / 3 * 3 + j / 3][k])
									k++;
								board[i][j] = Character.forDigit(k+1, 10);
								rows[i][k] = true;
								cols[j][k] = true;
								cubs[i / 3 * 3 + j / 3][k] = true;
								back.add(new int[] { i, j, k });
								num = 1;
								changed = true;
							}
						}
					} else {
						int digit = board[i][j] - '0';
						rows[i][digit - 1] = true;
						cols[j][digit - 1] = true;
						cubs[i / 3 * 3 + j / 3][digit - 1] = true;
					}
				}
			}
			num += changed == true ? 0 : 1;
		}
	}
	public void solveSudoku2(char[][] board) {
		solve(board, 0, 0);
	}
	public void solveSudoku3(char[][] board) {
		solve2(board, 0, 0);
	}
	private boolean solve(char[][] board, int r, int c){
		if(board[r][c] != '.'){
			if(r == 8 && c ==8){
				return true;
			}
			return solve(board, r+c/8, (c+1)%9);
		} 
		for(int k=1; k<=9; k++){
			board[r][c] = (char)(k+'0');
			if(isValid(board) && ((r == 8 && c ==8) || solve(board, r+c/8, (c+1)%9))){
				return true;
			}
		}
		board[r][c] = '.';
		return false;	
	}
	private boolean isValid(char[][] board){
		for(int i=0; i<9; i++){
			HashSet<Character> rows = new HashSet<Character>();
			HashSet<Character> cols = new HashSet<Character>();
			HashSet<Character> cubs = new HashSet<Character>();
			for(int j=0; j<9; j++){
				if(board[i][j] != '.' && !rows.add(board[i][j])){
					return false;
				}
				if(board[j][i] != '.' && !cols.add(board[j][i])){
					return false;
				}
				if(board[i/3*3+j/3][i%3*3+j%3] != '.' && !cubs.add(board[i/3*3+j/3][i%3*3+j%3] )){
					return false;
				}
			}
		}
		return true;
	}
	private boolean isValid2(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false;
            if(board[row][i] != '.' && board[row][i] == c) return false;
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
            board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }
	private boolean solve2(char[][] board, int r, int c){
		if(board[r][c] != '.'){
			if(r == 8 && c ==8){
				return true;
			}
			return solve2(board, r+c/8, (c+1)%9);
		} 
		for(char k='1'; k<='9'; k++){
			if(isValid2(board, r, c, k)){
				board[r][c] = k;
				if((r == 8 && c ==8) || solve2(board, r+c/8, (c+1)%9)){
					return true;
				}
			}
		}
		board[r][c] = '.';
		return false;	
	}
}
