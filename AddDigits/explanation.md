**Explanation:**

If list input sequence from 0~30, we get output sequence:
>0~9:0,1,2,3,4,5,6,7,8,9
>10~18:1,2,3,4,5,6,7,8,9
>19~27:1,2,3,4,5,6,7,8,9
>28~30:1,2,3

The result periodically occur.This problem is widely known as digit root problem.
For base b(decimal case b = 10), the digit root of an integer is:

* dr(n) = 0, if n == 0;
* dr(n) = n % (b - 1), if n % (b - 1) != 0;
* dr(n) = b - 1, if n % (b - 1) = 0;
**OR:**
* dr(n) = 1 + (n - 1) % (b - 1);

***
**Reference:**

<https://en.wikipedia.org/wiki/Digital_root#Congruence_formula>
