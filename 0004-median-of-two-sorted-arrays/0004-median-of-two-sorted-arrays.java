class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0, p2 = 0, idx = 0;
        int l = nums1.length + nums2.length;
        int ele1 = -1, ele2 = -1, ele2Idx = l/2;
        int ele1Idx = ele2Idx - 1;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                if (idx == ele1Idx) ele1 = nums1[p1];
                if (idx == ele2Idx) ele2 = nums1[p1];
                p1++;
                idx++;
            }
            else {
                if (idx == ele1Idx) ele1 = nums2[p2];
                if (idx == ele2Idx) ele2 = nums2[p2];
                p2++;
                idx++;
            }
        }
        while (p1 < nums1.length) {
            if (idx == ele1Idx) ele1 = nums1[p1];
            if (idx == ele2Idx) ele2 = nums1[p1];
            p1++;
            idx++;
        }
        while (p2 < nums2.length) {
            if (idx == ele1Idx) ele1 = nums2[p2];
            if (idx == ele2Idx) ele2 = nums2[p2];
            p2++;
            idx++;
        }
        double res = 0;
        if (l % 2 == 0)
            res = (ele1 + ele2) / (double) 2;
        else
            res = ele2;
        return res;
    }
}