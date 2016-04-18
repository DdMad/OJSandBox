/*

The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

*/

public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0 || k <= 0) {
            return null;
        }
        
        List<Character> numbers = new ArrayList<Character>();
        for (int i = 1; i <= n; i++) {
            numbers.add((char)(i + '0'));
        }
        
        int[] factorial = new int[n];
        getFactorial(factorial, n);
        
        StringBuilder sb = new StringBuilder();
        int count = n;
        k--;
        while (count > 0) {
            count--;
            int temp = k / factorial[count];
            sb.append(numbers.get(temp));
            numbers.remove(temp);
            k = k % factorial[count];
        }
        
        return sb.toString();
    }
    
    public void getFactorial(int[] factorial, int n) {
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
    }
}