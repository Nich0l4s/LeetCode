/**Another iterative solution. BFS
*3ms solution.
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
            Queue<TreeNode> node = new LinkedList<TreeNode>();
            node.offer(root);
            max = 0;
            while(!node.isEmpty()){
                int levelSize = node.size();
                while(levelSize -- > 0){
                    TreeNode tempNode = node.poll();
                    if(tempNode.left != null){
                        node.offer(tempNode.left);
                    }
                    if(tempNode.right != null){
                        node.offer(tempNode.right);
                    }
                }
                max++;
            }
        }
        return max;
    }
}
