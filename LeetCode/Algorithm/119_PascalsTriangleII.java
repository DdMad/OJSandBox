/*

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?

*/

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Using array not arraylist may be faster
        List<Integer> result = new ArrayList<Integer>();
        if (rowIndex < 0) {
            return result;
        }
        
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = result.size() - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        
        return result;
    }
}