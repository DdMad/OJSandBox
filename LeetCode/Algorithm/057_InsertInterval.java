/*

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Stack<Interval> result = new Stack<Interval>();
        if (intervals == null || intervals.size() == 0) {
            result.push(newInterval);
            return (List<Interval>)result;
        }
        
        boolean isInserted = false;
        for (int i = 0; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if (isInserted) {
                result.push(intervals.get(i));
            } else {
                if (currentInterval.start > newInterval.end) {
                    result.push(newInterval);
                    result.push(currentInterval);
                    isInserted = true;
                } else if (currentInterval.end < newInterval.start) {
                    result.push(currentInterval);
                } else {
                    newInterval.start = currentInterval.start < newInterval.start ? currentInterval.start : newInterval.start;
                    newInterval.end = currentInterval.end > newInterval.end ? currentInterval.end : newInterval.end;
                }
            }
        }
        
        if (!isInserted) {
            result.push(newInterval);
        }
        
        return (List<Interval>)result;
    }
}