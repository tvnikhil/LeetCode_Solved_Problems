class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, idx = 0;
        int[] merged = new int[nums1.length + nums2.length];
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                merged[idx++] = nums1[p1];
                p1++;
            }
            else if (nums1[p1] > nums2[p2]) {
                merged[idx++] = nums2[p2];
                p2++;
            }
            else {
                merged[idx++] = nums2[p2];
                merged[idx++] = nums2[p2];
                p2++;
                p1++;
            }
        }
        while (p1 < nums1.length) {
            merged[idx++] = nums1[p1];
            p1++;
        }
        while (p2 < nums2.length) {
            merged[idx++] = nums2[p2];
            p2++;
        }
        int l = merged.length;
        double res = 0;
        if (l % 2 == 0) {
            res = (merged[l/2] + merged[(l/2)-1]) / (double) 2;
        }
        else
            res = merged[l/2];
        return res;
    }
}