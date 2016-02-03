/*

Given the time in numerals we may convert it into words, as shown below:

5:005:015:105:305:405:455:475:28→ five o' clock→ one minute past five→ ten minutes past five→ half past five→ twenty minutes to six→ quarter to six→ thirteen minutes to six→ twenty eight minutes past five
Write a program which prints the time in words for the input given in the format mentioned above.

Input Format

There will be two lines of input:
H, representing the hours
M, representing the minutes

Constraints
1≤H<12
0≤M<60
Output Format

Display the time in words.

Sample Input

5  
47  
Sample Output

thirteen minutes to six

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        
        if (m == 0) {
            System.out.println(convertNumberToString(h) + " o' clock");
        } else if (m > 0 && m < 15) {
            System.out.println(convertNumberToString(m) + " minutes past " + convertNumberToString(h));
        } else if (m == 15) {
            System.out.println("quarter past " + convertNumberToString(h));
        } else if (m > 15 && m < 30) {
            System.out.println(convertNumberToString(m) + " minutes past " + convertNumberToString(h));
        } else if (m == 30) {
            System.out.println("half past " + convertNumberToString(h));
        } else if (m > 30 && m < 45) {
            System.out.println(convertNumberToString(60 - m) + " minutes to " + convertNumberToString(h + 1));
        } else if (m == 45) {
            System.out.println("quarter to " + convertNumberToString(h + 1));
        } else if (m > 45 && m < 60){
            System.out.println(convertNumberToString(60 - m) + " minutes to " + convertNumberToString(h + 1));
        }
    }
    
    public static String convertNumberToString(int n) {
        switch(n) {
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "quarter";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            case 20: return "twenty";
            case 21: return "twenty one";
            case 22: return "twenty two";
            case 23: return "twenty three";
            case 24: return "twenty four";
            case 25: return "twenty five";
            case 26: return "twenty six";
            case 27: return "twenty seven";
            case 28: return "twenty eight";
            case 29: return "twenty nine";
            case 30: return "half";
            default: return "zero";
        }
    }
}
