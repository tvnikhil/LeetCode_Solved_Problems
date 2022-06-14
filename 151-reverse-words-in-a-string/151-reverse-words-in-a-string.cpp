class Solution {
public:
    string reverseWords(string s) {
        vector<string> words;
        string delim = " ";
        auto start = 0U;
        auto end = s.find(delim);
        while (end != std::string::npos)
        {
            // std::cout << s.substr(start, end - start) << std::endl;
            string t = s.substr(start, end-start);
            if (t.size())
                words.push_back(t);
            start = end + delim.length();
            end = s.find(delim, start);
        }
        // std::cout << s.substr(start, end);
        string t = s.substr(start, end);
        if (t.size())
            words.push_back(t);
        reverse(words.begin(), words.end());
        string ans = "";
        for (string i: words)
            ans += i + " ";
        ans.erase(ans.size()-1);
        return ans;
    }
};