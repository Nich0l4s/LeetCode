package com.xxp.leetcode.Medium;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (word.isEmpty())
			return true;
		int m, n;
		if ((m = board.length) == 0 || (n = board[0].length) == 0)
			return false;
		boolean[][] used = new boolean[m][n];
        char[] target = word.toCharArray();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (search(i, j, board, target, 0, used))
					return true;
			}
		}
		return false;
	}

	private boolean search(int r, int c, char[][] board, char[] target, int p, boolean [][] used) {
		if(p == target.length) return true;
		if(r<0 || r==board.length || c<0 || c==board[0].length || used[r][c] == true) return false;
		if(board[r][c] == target[p]) {
			used[r][c] = true;
			if(search(r, c+1, board, target, p+1, used) ||
              search(r+1, c, board, target, p+1, used) ||
              search(r, c-1, board, target, p+1, used) ||
              search(r-1, c, board, target, p+1, used))
				return true;
			used[r][c] = false;
		}
		return false;
	}
}
