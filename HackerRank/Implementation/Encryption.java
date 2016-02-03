/*

An English text needs to be encrypted using the following encryption scheme. 
First, the spaces are removed from the text. Let L be the length of this text. 
Then, characters are written into a grid, whose rows and columns have the following constraints:

⌊L‾‾√⌋≤rows≤column≤⌈L‾‾√⌉, where ⌊x⌋ is floor function and ⌈x⌉ is ceil function
For example, the sentence if man was meant to stay on the ground god would have given us roots after removing spaces is 54 characters long, so it is written in the form of a grid with 7 rows and 8 columns.

ifmanwas  
meanttos          
tayonthe  
groundgo  
dwouldha  
vegivenu  
sroots
Ensure that rows×columns≥L
If multiple grids satisfy the above conditions, choose the one with the minimum area, i.e. rows×columns.
The encoded message is obtained by displaying the characters in a column, inserting a space, and then displaying the next column and inserting a space, and so on. For example, the encoded message for the above rectangle is:

imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau

You will be given a message in English with no spaces between the words. The maximum message length can be 81 characters. Print the encoded message.

Here are some more examples:

Sample Input:

haveaniceday
Sample Output:

hae and via ecy
Sample Input:

feedthedog    
Sample Output:

fto ehg ee dd
Sample Input:

chillout
Sample Output:

clu hlt io

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        int row = 1;
        int col = 1;
        for (int i = 0; i < s.length() ; i++) {
            if (row * col >= s.length()) {
                break;
            } else {
                if (row == col) {
                    col ++;
                } else {
                    row ++;
                }
            }
        }
        
        String[] ss = new String[row];
        
        int cnt = 0;
        while (s.length() > col) {
            ss[cnt] = s.substring(0, col);
            cnt ++;
            s = s.substring(col);
        }
        ss[row - 1] = s;
        
        for (int i = 0; i < col; i++) {
            String temp = "";
            for (int j = 0; j < row-1; j++) {
                temp += ss[j].charAt(i);
            }
            if (i < ss[row - 1].length()) {
                temp += ss[row - 1].charAt(i);
            }
            System.out.print(temp + " ");
        }
    }
}
