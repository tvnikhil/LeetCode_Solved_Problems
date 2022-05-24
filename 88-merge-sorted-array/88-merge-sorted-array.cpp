class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> merg;
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < nums2.size()) {
            if (nums1[p1] == nums2[p2]) {
                merg.push_back(nums1[p1]);
                merg.push_back(nums2[p2]);
                p1++;
                p2++;
            }
            else if (nums1[p1] < nums2[p2]) {
                merg.push_back(nums1[p1]);
                p1++;
            }
            else {
                merg.push_back(nums2[p2]);
                p2++;
            }
        }
        while (p1 < m) {
            merg.push_back(nums1[p1]);
            p1++;
        }
        while (p2 < n) {
            merg.push_back(nums2[p2]);
            p2++;
        }
        nums1 = merg;
    }
};