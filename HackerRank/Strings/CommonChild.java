/*

Given two strings a and b of equal length, what's the longest string (S) that can be constructed such that it is a child of both? 

A string x is said to be a child of a string y if x can be formed by deleting 0 or more characters from y. 

For example, ABCD and ABDC has two children with maximum length 3, ABC and ABD. Note that we will not consider ABCD as a common child because C doesn't occur before D in the second string.

Input format

Two strings, a and b, with a newline separating them.

Constraints

All characters are upper cased and lie between ASCII values 65-90. The maximum length of the strings is 5000.

Output format

Length of string S.

Sample Input #0

HARRY
SALLY
Sample Output #0

2
The longest possible subset of characters that is possible by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2.

Sample Input #1

AA
BB
Sample Output #1

0
AA and BB has no characters in common and hence the output is 0.

Sample Input #2

SHINCHAN
NOHARAAA
Sample Output #2

3
The largest set of characters, in order, between SHINCHAN and NOHARAAA is NHA.

Sample Input #3

ABCDEF
FBDAMN
Sample Output #3

2
BD is the longest child of these strings.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        
        int[][] f = new int[s1.length()][s2.length()];
        
        for (int i = 0; i < s1.length(); i ++) {
            for (int j = 0; j < s2.length(); j ++) {
                f[i][j] = 0;
            }
        }
        
        for (int i = 0; i < s1.length(); i ++) {
            for (int j = 0; j < s2.length(); j ++) {
            	// important!
                if (i == 0 || j == 0) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        f[i][j] = 1;
                    } else {
                        if (i > 0) {
                           f[i][j] = f[i - 1][j];
                        }
                        if (j > 0) {
                            f[i][j] = f[i][j - 1];
                        }
                    }
                } else {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        f[i][j] = getMax(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1] + 1);
                    } else {
                        f[i][j] = getMax(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]);
                    }
                }
            }
        }
        
        System.out.println(f[s1.length() - 1][s2.length() - 1]);
    }
    
    public static int getMax(int a, int b, int c) {
        if (a > b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b > c) {
                return b;
            } else {
                return c;
            }
        }
    }
}