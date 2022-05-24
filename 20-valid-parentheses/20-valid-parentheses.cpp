class Solution {
public:
    bool isValid(string s) {
        stack<char> stk;
        for (char i: s) {
            if (i == '(' || i == '{' || i == '[')
                stk.push(i);
            else
            {
                if (i == ')' && stk.size() != 0 && stk.top() != '(')
                    return false;
                if (i == '}' && stk.size() != 0 && stk.top() != '{')
                    return false;
                if (i == ']' && stk.size() != 0 && stk.top() != '[')
                    return false;
                if (stk.size() != 0)
                    stk.pop();
                else
                    return false;
            }
        }
        if (stk.size() == 0)
            return true;
        return false;
    }
};