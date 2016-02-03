/*

The Head Librarian at a library wants you to create a program that calculates the fine for returning a book after the return date. You are given the actual and the expected return dates. Calculate the fine as follows:

If the book is returned on or before the expected return date, no fine will be charged. In other words, the fine is 0.
If the book is returned in the same calendar month as the expected return date, the fine = 15 Hackos × the number of late days.
If the book is not returned in the same calendar month but in the same calendar year as the expected return date, the fine = 500 Hackos × the number of late months.
If the book is not returned in the same calendar year, the fine is fixed at 10000 Hackos.
Input 
You are given the actual and the expected return dates in D M Y format on two separate lines. The first line contains the D M Y values for the actual return date and the next line contains the D M Y values for the expected return date. Here's a sample:

9 6 2015
6 6 2015
Constraints: 
1≤D≤31 
1≤M≤12 
1≤Y≤3000 
The given date is a valid date on a Gregorian calendar.

Output 
Print a single value representing the fine. 
The sample output for the above input would be 45. 
Since the actual return date is 3 days later than expected, the fine is calculated as 15×3=45 Hackos.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        
        if (y2 > y1) {
            System.out.println(0);
        } else if (y2 < y1) {
            System.out.println(10000);
        } else {
            if (m2 > m1) {
                System.out.println(0);
            } else if (m2 < m1) {
                System.out.println(500 * (m1 - m2));
            } else {
                if (d2 > d1) {
                    System.out.println(0);
                } else if (d2 < d1) {
                    System.out.println(15 * (d1 - d2));
                } else {
                    System.out.println(0);
                }
            }
        }
        
    }
}
