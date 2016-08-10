/**According to the second fomula in explanation.md
*It's clean
*2ms solution
*/
public class Solution {
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
