package com.xxp.leetcode.Medium;
import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			HashSet<Character> row = new HashSet<Character>();
			HashSet<Character> col = new HashSet<Character>();
			HashSet<Character> cub = new HashSet<Character>();
			int firstRow = i / 3 * 3;
			int firstCol = i % 3 * 3;
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j]))
					return false;
				if (board[j][i] != '.' && !col.add(board[j][i]))
					return false;
				int r = j / 3;
				int c = j % 3;
				if (board[firstRow + r][firstCol + c] != '.' && !cub.add(board[firstRow + r][firstCol + c]))
					return false;
			}
		}
		return true;
	}
	public boolean isValidSudoku2(char[][] board) {
	    int [] vset = new int [9];
	    int [] hset = new int [9];
	    int [] bckt = new int [9];
	    int idx = 0;
	    for (int i = 0; i < 9; i++) {
	        for (int j = 0; j < 9; j++) {
	            if (board[i][j] != '.') {
	                idx = 1 << (board[i][j] - '0') ;
	                if ((hset[i] & idx) > 0 ||
	                    (vset[j] & idx) > 0 ||
	                    (bckt[(i / 3) * 3 + j / 3] & idx) > 0) return false;
	                hset[i] |= idx;
	                vset[j] |= idx;
	                bckt[(i / 3) * 3 + j / 3] |= idx;
	            }
	        }
	    }
	    return true;
	}
}
