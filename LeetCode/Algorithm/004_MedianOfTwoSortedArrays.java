/*

There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2;
        
        if ((m + n) % 2 == 0) {
            return (findKth(nums1, nums2, k - 1, 0, m - 1, 0, n - 1) + findKth(nums1, nums2, k, 0, m - 1, 0, n - 1)) * 0.5;
        } else {
            return (double)findKth(nums1, nums2, k, 0, m - 1, 0, n - 1);
        }
    }
    
    public int findKth(int[] a, int[] b, int k, int aBegin, int aEnd, int bBegin, int bEnd) {
        int aLength = aEnd - aBegin + 1;
        int bLength = bEnd - bBegin + 1;
        
        if (aLength == 0) {
            return b[bBegin + k];
        }
        
        if (bLength == 0) {
            return a[aBegin + k];
        }
        
        if (k == 0) {
            return a[aBegin] < b[bBegin] ? a[aBegin] : b[bBegin];
        }
        
        int aMid = aLength * k / (aLength + bLength); // aMid / aLength = k / (aLength + bLength)
        int bMid = k - aMid - 1;
        
        if (a[aBegin + aMid] > b[bBegin + bMid]) {
            k = k - bMid - 1;
            aEnd = aBegin + aMid;
            bBegin = bBegin + bMid + 1;
        } else {
            k = k - aMid - 1;
            bEnd = bBegin + bMid;
            aBegin = aBegin + aMid + 1;
        }
        
        return findKth(a, b, k, aBegin, aEnd, bBegin, bEnd);
    }
}