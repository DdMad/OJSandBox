/*

Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int len = digits.length;
        int carry = (digits[len - 1] + 1) / 10;
        digits[len - 1] = (digits[len - 1] + 1) % 10;
        for (int i = len - 2; i >= 0; i--) {
            if (carry == 0) {
                return digits;
            } else {
                digits[i] += carry;
                carry = digits[i] / 10;
                digits[i] %= 10;
            }
        }
        if (carry > 0) {
            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            for (int i = 0; i < len; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}