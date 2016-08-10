/**According to the first formula in Explanation.md
*2ms solution
*/
public class Solution {
    public int addDigits(int num) {
        if(num == 0){
            return 0;
        }
        int res = num % 9;
        return res == 0 ? 9 : res;
    }
}
