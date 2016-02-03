/*

Given an array of integers, calculate which fraction of the elements are positive, negative, and zeroes, respectively. Print the decimal value of each fraction.

Input Format

The first line, , is the size of the array. 
The second line contains space-separated integers describing the array of numbers ().

Output Format

Print each value on its own line with the fraction of positive numbers first, negative numbers second, and zeroes third.

Sample Input

6
-4 3 -9 0 4 1         
Sample Output

0.500000
0.333333
0.166667
Explanation

There are 3 positive numbers, 2 negative numbers, and 1 zero in the array. 
The fraction of the positive numbers, negative numbers and zeroes are , and , respectively.

Note: This challenge introduces precision problems. The test cases are scaled to six decimal places, though answers with absolute error of up to are acceptable.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        DecimalFormat df = new DecimalFormat("#.000000"); 
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            if (arr[arr_i] > 0) {
                positive ++;
            } else if (arr[arr_i] == 0) {
                zero ++;
            } else {
                negative ++;
            }
        }
        
        System.out.println(df.format((double)positive/(double)n));
        System.out.println(df.format((double)negative/(double)n));
        System.out.println(df.format((double)zero/(double)n));
    }
}
