class Solution {
public:
    int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int t = x%10;
            if (ans > INT_MAX/10 || (ans == INT_MAX / 10 && t > 7))
                return 0;
            if (ans < INT_MIN/10 || (ans == INT_MIN / 10 && t < -8))
                return 0;
            ans = ans * 10 + t;
            x /= 10;
        }
        return ans;
    }
};