/*

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.

*/

public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        
        int[] resultInt = new int[len1 + len2];
        int start = len1 + len2 - 1;
        
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        if (num1.equals("1")) {
            return num2;
        }
        if (num2.equals("1")) {
            return num1;
        }
        
        for (int i = len2 - 1; i >= 0; i--) {
            int count = 0;
            int[] temp = new int[len1 + 1];
            if (num2.charAt(i) > '0' && num2.charAt(i) <= '9') {
                for (int j = len1 - 1; j >= 0; j--) {
                    int result = ((int)(num1.charAt(j) - '0')) * ((int)(num2.charAt(i) - '0')) + count;
                    count = result / 10;
                    temp[j + 1] = result % 10;
                }
            }
            temp[0] = count;
            
            int index = len1;
            int k = start;
            count = 0;
            while(k > start - len1 - 1 || count > 0) {
                if (index >= 0) {
                    resultInt[k] = temp[index] + resultInt[k] + count;
                    index--;
                } else {
                    resultInt[k] = resultInt[k] + count;
                }
                count = resultInt[k] / 10;
                resultInt[k] %= 10;
                k--;
            }
            start--;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < resultInt.length; i++) {
            char temp = (char)(resultInt[i] + '0');
            if (temp == '0' && i == 0) {
                continue;
            } else {
                result.append(temp);
            }
        }
        
        return result.toString();
    }
}