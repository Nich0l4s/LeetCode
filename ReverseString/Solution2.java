/**Concat chars in the String from the last to the first.
*6ms solution.It's ordinary.
*/
public class Solution
{
  public String reverseString(String s)
  {
    StringBuilder sb = new StringBuilder();
    int length = s.length();
    for(int i = length - 1; i >= 0 ; i--)
    {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }
}
