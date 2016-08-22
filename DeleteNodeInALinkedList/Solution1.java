/**Copy value and link of the next node.
*1ms solution.
*/
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
