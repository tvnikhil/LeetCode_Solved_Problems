class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        reverse(digits.begin(), digits.end());
        int carry = 0, i = 0;
        while (i < digits.size()) {
            if (digits[i] < 9) {
                digits[i]++;
                if (carry == 1)
                    carry--;
                break;
            }
            else {
                carry = 1;
                digits[i] = 0;
                i++;
            }
        }
        if (carry == 1)
            digits.push_back(1);
        reverse(digits.begin(), digits.end());
        return digits;
    }
};