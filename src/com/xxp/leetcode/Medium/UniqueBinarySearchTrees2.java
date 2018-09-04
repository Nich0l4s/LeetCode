package com.xxp.leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

import com.xxp.leetcode.Common.TreeNode;

public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
		List<TreeNode>[] res = new List[n+1];
		ArrayList<TreeNode> zero = new ArrayList<>();
		ArrayList<TreeNode> one = new ArrayList<>();
		res[0] = zero;
		res[1] = one;
		zero.add(null);
		one.add(new TreeNode(1));
		for (int i = 2; i <= n; i++) {
			ArrayList<TreeNode> trees = new ArrayList<>();
			for (int j = 1; j <= i; j++) {
				for (TreeNode left : res[j - 1]) {
					for (TreeNode right : res[i - j]) {
					    TreeNode root = new TreeNode(j);
						root.left = left;
						root.right = clone(right, j);
						trees.add(root);
					}
				}
			}
			res[i] = trees;
		}
		return res[n];
	}
	private TreeNode clone(TreeNode root, int off) {
		if (root == null)
			return null;
		TreeNode newRoot = new TreeNode(root.val+off);
        newRoot.left = clone(root.left, off);
        newRoot.right = clone(root.right, off);
		return newRoot;
	}
}
