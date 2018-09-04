package com.xxp.leetcode.Medium;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        if(target < matrix[0][0] || target > matrix[row-1][col-1]) return false;
        int l = 0;
        int r = row * col - 1;
        while(l<=r){
            int mid = l + (r - l) / 2;
            int next = matrix[mid/col][mid%col];
            if(next == target) return true;
            else if(next > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
