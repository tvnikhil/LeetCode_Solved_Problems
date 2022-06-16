class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        double r = log10(n) / log10(2);
        if (ceil(r) == floor(r))
            return true;
        return false;
    }
};