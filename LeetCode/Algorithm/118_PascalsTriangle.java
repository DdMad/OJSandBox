/*

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0) {
            return result;
        }
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> tempList = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tempList.add(1);
                } else {
                    List<Integer> last = result.get(i - 1);
                    tempList.add(last.get(j - 1) + last.get(j));
                }
            }
            result.add(tempList);
        }
        
        return result;
    }
}