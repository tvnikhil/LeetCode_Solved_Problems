class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        long int rev = 0, temp = x;
        while (x > 0) {
            rev = x%10 + rev*10;
            x /= 10;
        }
        // cout << rev << endl;
        if (rev == temp)
            return true;
        return false;
    }
};