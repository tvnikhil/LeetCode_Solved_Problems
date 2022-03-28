class Solution {
public:
    int longestPalindrome(string s) {
        map<char, int> count;
        for (int i = 0; i < s.length(); i++)
        {
            if (count.find(s[i]) == count.end())
                count[s[i]] = 1;
            else
                count[s[i]]++;
        }
        int ans = 0;
        for (auto &it : count)
        {
            if (it.second > 1) {
                if (it.second % 2 == 0) {
                    ans += it.second;
                    it.second = 0;
                }
                else {
                    ans += it.second - 1;
                    it.second = 1;
                }
            }
        }
        for (auto &it : count) {
            if (it.second == 1) {
                ans++;
                break;
            }
        }
        return ans;
    }
};