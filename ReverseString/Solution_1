```Java
/**Swap elements in a char array.
*3ms solution(sometimens 2ms)
*/
public class Solution
{
    public String reverseString(String s)
    {
        char [] array = s.toCharArray();
        int mid = array.length/2;
        for(int i = 0; i < mid; i++)
        {
            char temp;
            temp = array[i];
            array[i] = array[array.length - i -1];
            array[array.length -i -1] = temp;
        }
        return new String(array);
    }
}
```
