/*

You are given two strings, A and B. Find if there is a substring that appears in both A and B.

Input Format

Several test cases will be given to you in a single file. The first line of the input will contain a single integer T, the number of test cases.

Then there will be T descriptions of the test cases. Each description contains two lines. The first line contains the string A and the second line contains the string B.

Output Format

For each test case, display YES (in a newline), if there is a common substring. Otherwise, display NO.

Constraints

All the strings contain only lowercase Latin letters.
1<=T<=10
1<=|A|,|B|<=105
Sample Input

2
hello
world
hi
world
Sample Output

YES
NO
Explanation

For the 1st test case, the letter o is common between both strings, hence the answer YES. (Furthermore, the letter l is also common, but you only need to find one common substring.) 
For the 2nd test case, hi and world do not have a common substring, hence the answer NO.

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
        int t = sc.nextInt();
        for (int index = 0; index < t; index ++) {
            String s1 = sc.next();
            String s2 = sc.next();
            
            int[] a = new int[26];
            for (int i = 0; i < s1.length(); i ++) {
                a[(int)(s1.charAt(i) - 'a')] ++;
            }
            
            boolean find = false;
            for (int i = 0; i < s2.length(); i ++) {
                if (a[(int)(s2.charAt(i) - 'a')] != 0) {
                    find = true;
                    break;
                }
            }
            
            if (find) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}