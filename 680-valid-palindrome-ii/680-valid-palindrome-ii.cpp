class Solution {
public:
    bool checkPalindrome(string c, int i, int j) {
        int p1 = i, p2 = j;
        while (p1 < p2) {
            if (c[p1] == c[p2]) {
                p1++;
                p2--;
            }
            else
                return false;
        }
        return true;
    }
    bool validPalindrome(string s) {
        int p1 = 0, p2 = s.size()-1;
        while (p1 < p2) {
            if (s[p1] == s[p2]) {
                p1++;
                p2--;
            }
            else {
                return (checkPalindrome(s, p1, p2-1) || checkPalindrome(s, p1+1, p2));
            }
        }
        return true;
    }
};