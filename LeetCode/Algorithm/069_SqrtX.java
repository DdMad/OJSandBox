/*

Implement int sqrt(int x).

Compute and return the square root of x.

*/

public class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        
        if (x == 1) {
            return 1;
        }
        
        int start = 0;
        int end = x;
        while(start <= end) {
            int mid = (end + start) / 2;
            // For not overflow purpose, use x/mid and mid to check
            if (x / mid > mid) {
                start = mid + 1;
            } else if (x / mid < mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return end;
    }
}