package com.xxp.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length;
        if(m == 0) return list;
        int n = matrix[0].length;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        boolean[][] visited = new boolean[m][n];
        int r = 0, c = 0;
        int dir = 0;
        for(int i=0; i<m*n; i++){
            list.add(matrix[r][c]);
            visited[r][c] = true;
            int nextR = r + dr[dir];
            int nextC = c + dc[dir];
            if(nextR>=0 && nextR<m && nextC>=0 && nextC<n && !visited[nextR][nextC]){
                r = nextR;
                c = nextC;
            }
            else{
                dir = (dir+1) % 4;
                r += dr[dir];
                c += dc[dir];
            }
        }
        return list;
    }
}
