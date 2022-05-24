class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.size() == 0)
            return 0;
        int i = 0;
        while (i < haystack.size()) {
            if (haystack[i] == needle[0]) {
                int p1 = i, p2 = 0;
                while (p1 < haystack.size() && p2 < needle.size() && haystack[p1] == needle[p2]) {
                    p1++;
                    p2++;
                }
                if (p2 == needle.size())
                    return i;
            }
            i++;
        }
        return -1;
    }
};