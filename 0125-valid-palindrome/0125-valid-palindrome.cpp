class Solution {
public:
    void checkPalindrome(string &s, int start, int end) {
        if (start > end)
            return;
        swap(s[start], s[end]);
        checkPalindrome(s, start + 1, end - 1);
    }
    
    bool isPalindrome(string s) {
        string new_s;
        for (int i = 0; i < s.size(); i++) {
            int c = int(s[i]);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
                if (c >= 65 && c <= 90)
                    new_s.push_back(int(s[i]) + 32);
                else
                    new_s.push_back(s[i]);
            }
        }
        // cout << new_s << endl;
        string temp = new_s;
        checkPalindrome(new_s, 0, new_s.size() - 1);
        if (new_s == temp)
            return 1;
        return 0;
    }
};