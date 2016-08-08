/**Swap two char with bitwise operation
*4ms solution
*/
public class Solution
{
    public String reverseString(String s)
    {
        char [] array = s.toCharArray();
        int mid = array.length/2;
        for(int i = 0; i < mid; i++)
        {
            array[i] = (char)(array[i] ^ array[array.length - i -1]);
            array[array.length -i -1] = (char)(array[i] ^ array[array.length - i -1]);
            array[i] = (char)(array[i] ^ array[array.length - i -1]);
        }
        return new String(array);
    }
}
