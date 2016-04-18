/*

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Stack<Interval> result = new Stack<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return (List<Interval>)result;
        }
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        Interval last = null;
        for (int i = 0; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (last == null) {
                last = current;
            } else {
                if (last.end < current.start) {
                    result.push(last);
                    last = current;
                } else {
                    last.end = current.end > last.end ? current.end : last.end;
                }
            }
        }
        
        if (last != null) {
            result.push(last);
        }
        
        return (List<Interval>)result;
    }
}