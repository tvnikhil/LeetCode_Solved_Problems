class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = ((n1 + n2 + 1) / 2) - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1)
                r1 = nums1[mid1];
            if (mid2 < n2)
                r2 = nums2[mid2];
            if (mid1 > 0)
                l1 = nums1[mid1 - 1];
            if (mid2 > 0)
                l2 = nums2[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    int maxi = Math.max(l1, l2);
                    int mini = Math.min(r1, r2);
                    return (maxi + mini) / (double) 2;
                }
                else
                    return (double) Math.max(l1, l2);
            }
            else if (l1 > r2)
                high = mid1 - 1;
            else
                low = mid1 + 1;
        }
        return 0;
        
        // int p1 = 0, p2 = 0, idx = 0;
        // int l = nums1.length + nums2.length;
        // int ele1 = -1, ele2 = -1, ele2Idx = l/2;
        // int ele1Idx = ele2Idx - 1;
        // while (p1 < nums1.length && p2 < nums2.length) {
        //     if (nums1[p1] < nums2[p2]) {
        //         if (idx == ele1Idx) ele1 = nums1[p1];
        //         if (idx == ele2Idx) ele2 = nums1[p1];
        //         p1++;
        //         idx++;
        //     }
        //     else {
        //         if (idx == ele1Idx) ele1 = nums2[p2];
        //         if (idx == ele2Idx) ele2 = nums2[p2];
        //         p2++;
        //         idx++;
        //     }
        // }
        // while (p1 < nums1.length) {
        //     if (idx == ele1Idx) ele1 = nums1[p1];
        //     if (idx == ele2Idx) ele2 = nums1[p1];
        //     p1++;
        //     idx++;
        // }
        // while (p2 < nums2.length) {
        //     if (idx == ele1Idx) ele1 = nums2[p2];
        //     if (idx == ele2Idx) ele2 = nums2[p2];
        //     p2++;
        //     idx++;
        // }
        // double res = 0;
        // if (l % 2 == 0)
        //     res = (ele1 + ele2) / (double) 2;
        // else
        //     res = ele2;
        // return res;
    }
}