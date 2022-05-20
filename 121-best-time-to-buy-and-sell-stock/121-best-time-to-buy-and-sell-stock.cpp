class Solution {
public:
    int maxProfit(vector<int>& prices) {
        // int tmax = -1;
        // for (int i = 0; i < prices.size(); i++) {
        //     int m = -1;
        //     for (int j = i+1; j < prices.size(); j++)
        //         m = max(m, prices[j] - prices[i]);
        //     tmax = max(tmax, m);
        // }
        // return ((tmax == -1) ? 0 : tmax);
        int left = 0, right = 1, maxP = 0;
        while (right < prices.size()) {
            int curr = prices[right] - prices[left];
            maxP = max(maxP, curr);
            if (prices[left] > prices[right])
                left = right;
            right++;
        }
        return maxP;
    }
};