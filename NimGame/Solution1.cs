/*You can always win the game if n is not divisible by 4.
40ms solution.
*/
public class Solution {
    public bool CanWinNim(int n) {
        return n%4 != 0;
    }
}
