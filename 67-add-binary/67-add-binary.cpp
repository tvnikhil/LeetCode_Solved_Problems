class Solution {
public:
    string addBinary(string a, string b) {
        if (a.size() < b.size()) {
            int n = b.size() - a.size();
            for (int i = 0; i < n; i++)
                a = to_string(0) + a;
        }
        else if (a.size() > b.size()) {
            int n = a.size() - b.size();
            for (int i = 0; i < n; i++)
                b = to_string(0) + b;
        }
        // cout << a << " " << b << endl;
        int p1 = a.size()-1, p2 = b.size()-1, carry = 0;
        string c = "";
        while (p1 >= 0 && p2 >= 0) {
            // cout << p1 << " " << p2 << endl;
            if (a[p1] == '1' && b[p2] == '1') {
                if (carry) {
                    c = to_string(1) + c;
                }
                else {
                    c = to_string(0) + c;
                }
                carry = 1;
            }
            else if (a[p1] == '0' && b[p2] == '0') {
                if (carry) {
                    c = to_string(1) + c;
                    carry = 0;
                }
                else {
                    c = to_string(0) + c;
                }
            }
            else {
                if (carry) {
                    c = to_string(0) + c;
                    carry = 1;
                }
                else {
                    c = to_string(1) + c;
                }
            }
            p1--;
            p2--;
        }
        if (carry) {
            c = to_string(1) + c;
        }
        return c;
    }
};