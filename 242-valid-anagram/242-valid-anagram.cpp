class Solution {
public:
    // void getFrequency(unordered_map<char, int> &hm, string test) {
    //     for (int i = 'a'; i <= 'z'; i++)
    //         hm[(char) i] = 0;
    //     for (int i = 0; i < test.size(); i++)
    //         hm[test[i]]++;
    // }
    // bool compare(unordered_map<char, int> &hm1, unordered_map<char, int> &hm2) {
    //     for (int i = 'a'; i <= 'z'; i++) {
    //         if (hm1[(char) i] != hm2[(char) i])
    //             return false;
    //     }
    //     return true;
    // }
    bool isAnagram(string s, string t) {
        // unordered_map<char, int> hm1, hm2;
        // getFrequency(hm1, s);
        // getFrequency(hm2, t);
        // return compare(hm1, hm2);
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        if (s == t)
            return 1;
        return 0;
    }
};