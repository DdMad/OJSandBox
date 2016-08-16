/*

Given an integer, write a function to determine if it is a power of two.

*/

public class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag = false;
        
        while (n != 0) {
            if (flag) {
                return false;
            }
            
            if ((n & 1) >= 1) {
                flag = true;
            }
            n >>= 1;
        }
        
        return flag;
    }
}