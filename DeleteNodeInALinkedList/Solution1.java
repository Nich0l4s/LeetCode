/**Copy value and link of the next node.
*1ms solution.
*May you find it is so easy.
*/
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
