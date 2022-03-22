#include <bits/stdc++.h>

class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> two_powers;
        vector<int> bits_count{0, 1, 1, 2, 1, 2, 2, 3, 1, 2};
        if (n <= 9) 
        {
            vector<int> ans(bits_count.begin(), bits_count.begin()+n+1);
            return ans;
        }
        int limit = 100001;
        for (int i = 1; i <= limit; i = i*2)
            two_powers.push_back(i);
        for (int i = 10; i <= n; i++)
        {
            vector<int>::iterator lpos = lower_bound(two_powers.begin(), two_powers.end(), i);
            int pos = (lpos - two_powers.begin());
            if (pos != 0 && two_powers[pos] != i)
                pos--;
            bits_count.push_back(1 + bits_count[i-two_powers[pos]]);
        }
        return bits_count;
    }
};