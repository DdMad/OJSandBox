/*

Implement pow(x, n).

*/

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long newN = n;
        return n > 0 ? pow(x, newN) : 1 / pow(x, - newN);
    }
    
    public double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        
        double temp = pow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * pow(x, n % 2);
        }
    }
}