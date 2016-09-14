/**A iterative solution.DFS
*6 ms
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if(root != null){
            Stack<TreeNode> node = new Stack<TreeNode>();
            Stack<Integer> height = new Stack<Integer>();
            node.push(root);
            height.push(1);
            while(!node.isEmpty()){
                TreeNode tempNode = node.pop();
                int tempHeight = height.pop();
                max = Math.max(max, tempHeight);
                if(tempNode.left != null){
                    node.push(tempNode.left);
                    height.push(tempHeight + 1);
                }
                if(tempNode.right != null){
                    node.push(tempNode.right);
                    height.push(tempHeight + 1);
                }
            }
        }
        return max;
    }
}
