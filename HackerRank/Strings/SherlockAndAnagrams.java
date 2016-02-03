/*

Given a string S, find the number of "unordered anagrammatic pairs" of substrings.

Input Format 
First line contains T, the number of testcases. Each testcase consists of string S in one line.

Constraints 
1≤T≤10 
2≤length(S)≤100 
String S contains only the lowercase letters of the English alphabet.

Output Format 
For each testcase, print the required answer in one line.

Sample Input#00

2
abba
abcd
Sample Output#00

4
0
Sample Input#01

5
ifailuhkqq
hucpoltgty
ovarjsnrbf
pvmupwjjjf
iwwhrlkpek
Sample Output#01

3
2
2
6
3
Explanation

Sample00 
Let's say S[i,j] denotes the substring Si,Si+1,⋯,Sj.

testcase 1: 
For S=abba, anagrammatic pairs are: {S[1,1],S[4,4]}, {S[1,2],S[3,4]}, {S[2,2],S[3,3]} and {S[1,3],S[2,4]}.

testcase 2: 
No anagrammatic pairs.

Sample01 
Left as an exercise to you.

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
            String s = sc.next();
            
            int count = 0;
            
            for (int i = 1; i <= s.length(); i ++) {
                ArrayList<String> list = new ArrayList<String>();
                
                for (int j = 0; j <= s.length() - i; j ++) {
                    String temp = "";
                    
                    for (int k = j; k < j + i; k ++) {
                        temp += s.charAt(k);
                    }
                    
                    list.add(temp);
                }
                
                count += countAnagram(list);
            }
            
            System.out.println(count);
        }
    }
    
    public static int countAnagram(ArrayList<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i ++) {
            for (int j = i + 1; j < list.size(); j ++) {
                if (isAnagram(list.get(i), list.get(j))) {
                    count ++;
                }
            }
        }
        
        return count;
    }
    
    public static boolean isAnagram(String s1, String s2) {
        int[] a = new int[26];
        
        for (int i = 0; i < s1.length(); i ++) {
            a[(int)(s1.charAt(i) - 'a')] ++;
        }
        
        for (int i = 0; i < s2.length(); i ++) {
            a[(int)(s2.charAt(i) - 'a')] --;
        }
        
        boolean flag = true;
        for (int i = 0; i < 26; i ++) {
            if (a[i] != 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}