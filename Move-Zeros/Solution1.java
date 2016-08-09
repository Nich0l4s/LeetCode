/*If the nth non-zero element doesn't have a index of n-1, move it to position n.
*1ms solution.
*/
public class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, count = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != count){
                //Swap two elements.One of them is a zero.
                nums[count] = nums[i];
                nums[i] = 0;
                }
                count++;
            }
        }
    }
}
