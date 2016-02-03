/*

Given a string, S, we define some operations on the string as follows:

a. reverse(S) denotes the string obtained by reversing string S. E.g.: reverse("abc") = "cba"

b. shuffle(S) denotes any string that's a permutation of string S. E.g.: shuffle("god") ∈ ['god', 'gdo', 'ogd', 'odg', 'dgo', 'dog']

c. merge(S1,S2) denotes any string that's obtained by interspersing the two strings S1 & S2, maintaining the order of characters in both. 
E.g.: S1 = "abc" & S2 = "def", one possible result of merge(S1,S2) could be "abcdef", another could be "abdecf", another could be "adbecf" and so on.

Given a string S such that S∈ merge(reverse(A), shuffle(A)), for some string A, can you find the lexicographically smallest A?

Input Format

A single line containing the string S.

Constraints: 
S contains only lower-case English letters.
The length of string S is less than or equal to 10000.

Output Format

A string which is the lexicographically smallest valid A.

Sample Input

eggegg
Sample Output

egg
Explanation

reverse("egg") = "gge" 
shuffle("egg") can be "egg" 
"eggegg" belongs to merge of ("gge", "egg")

The split is: e(gge)gg.

egg is the lexicographically smallest.

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
        String s = sc.next();
        
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i ++) {
            a[(int)(s.charAt(i) - 'a')] ++;
        }
        
        int[] b = new int[26];
        int[] c = new int[26];
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i = 0; i < 26; i ++) {
            b[i] = a[i] / 2;
            c[i] = b[i];
            if (a[i] != 0) {
                for (int j = 0; j < b[i]; j ++) {
                    list.add((char)(i + 'a'));
                }
            }
        }
        /*
        for (int i = 0; i < 26; i ++) {
            System.out.println((char)(i + 'a') + " = " + a[i]);
        }
        */
        
        Collections.sort(list);
        
        String ans = "";
        ArrayList<Character> skipChar = new ArrayList<Character>();
        ArrayList<Character> sameChar = new ArrayList<Character>();
        //System.out.println("==================");
        for (int i = s.length() - 1; i >= 0; i --) {
            /*
            for (int j = 0; j < skipChar.size(); j ++) {
                System.out.print(skipChar.get(j));
            }
            System.out.print("|");
            */
            
            if (ans.length() >= s.length() / 2) {
                break;
            }
            
            char temp = s.charAt(i);
            //System.out.print("temp = " + temp + "|");
            //System.out.print("list top = " + list.get(0) + "|");
            
            
            if (c[(int)(temp - 'a')] != 0) {
                if (temp == list.get(0)) {
                    ans += temp;
                    c[(int)(temp - 'a')] --;
                    list.remove(0);
                    skipChar.clear();
                    sameChar.clear();
                } else {
                    if (b[(int)(temp - 'a')] == 0) {
                        char min = ' ';
                        int minIndex = -1;
                        
                        if (sameChar.size() != 0 && (char)sameChar.get(0) < temp) {
                            //System.out.println("\nhere we have: " + sameChar.get(0));
                            ans += sameChar.get(0);
                            b[(int)(sameChar.get(0) - 'a')] ++;
                            c[(int)(sameChar.get(0) - 'a')] --;
                            list.remove(sameChar.get(0));
                            sameChar.clear();
                        } else {
                            sameChar.clear();
                        }
                        
                        for (int j = skipChar.size() - 1; j >= 0; j --) {
                            if (skipChar.get(j) < temp) {
                                min = skipChar.get(j);
                                minIndex = j;
                                b[(int)(skipChar.get(j) - 'a')] ++;
                                c[(int)(skipChar.get(j) - 'a')] --;
                                list.remove(skipChar.get(j));
                                break;
                            } else if (skipChar.get(j) == temp && sameChar.size() == 0) {
                                min = skipChar.get(j);
                                minIndex = j;
                                
                                sameChar.add(temp);
                                
                                break;
                            }
                        }
                        String pick = "";
                        if (minIndex != -1) {
                            if (min != temp) {
                                pick = "" + min;
                            } else {
                                pick = "";
                            }
                            //System.out.print("min = ");
                            for (int j = minIndex - 1; j >= 0; j --) {
                                //System.out.print(min);
                                if (skipChar.get(j) == temp && min == temp && sameChar.size() == 0){
                                    sameChar.add(temp);
                                }
                                if ((skipChar.get(j) < min) || (skipChar.get(j) == min && min < temp)) {
                                    pick = skipChar.get(j) + pick;
                                    min = skipChar.get(j);
                                    b[(int)(skipChar.get(j) - 'a')] ++;
                                    c[(int)(skipChar.get(j) - 'a')] --;
                                    list.remove(skipChar.get(j));
                                }
                            }
                            //System.out.print("|");
                            if (sameChar.size() != 0) {
                                //System.out.print("same = " + sameChar.get(0) + "|");
                            }
                        }
                        skipChar.clear();
                        
                        ans += pick + temp;
                        
                        c[(int)(temp - 'a')] --;
                        list.remove((Character)temp);
                    } else {
                        b[(int)(temp - 'a')] --;
                        skipChar.add(temp);
                    }
                }
            } else {
                continue;
            }
            
            
            //System.out.print("ans = " + ans + "|");
            /*
            for (int j = 0; j < skipChar.size(); j ++) {
                System.out.print(skipChar.get(j));
            }
            */
            //System.out.println();
            
        }
        
        System.out.println(ans);
    }
}