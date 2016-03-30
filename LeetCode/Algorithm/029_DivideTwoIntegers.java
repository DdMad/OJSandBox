/*

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

*/

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (dividend == 0) {
            return 0;
        }
        
        if (divisor == 1) {
            return dividend;
        }
        
        long result = 0;
        int sign = dividend > 0 ? (divisor > 0 ? 1 : -1) : ( divisor > 0 ? -1 : 1);
        
        // Must convert to long first, then abs
        // Since abs(Integer.MIN_VALUE) will overflow
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        
        while (newDividend >= newDivisor) {
            long count = 1;
            long temp = newDivisor;
            
            while (newDividend >= temp) {
                count = count << 1;
                temp = temp << 1;
            }
            
            temp = temp >> 1;
            count = count >> 1;
            result += count;
            newDividend -= temp;
        }
        
        result = result * sign;
        
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = Integer.MAX_VALUE;
        }
        
        return (int)result;
    }
}