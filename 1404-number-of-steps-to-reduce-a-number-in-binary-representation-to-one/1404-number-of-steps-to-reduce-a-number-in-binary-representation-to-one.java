class Solution {
    public String addOne(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == '1') {
            ans.insert(0, '0');
            i--;
        }
        if (i >= 0) {
            ans.insert(0, '1');
            ans.insert(0, s.substring(0, i));
            return ans.toString();
        }
        ans.insert(0, '1');
        return ans.toString();
    }
    
    public int numSteps(String s) {
        int count = 0;
        while (!s.equals("1")) {
            if (s.charAt(s.length() - 1) == '1') {
                s = addOne(s);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            count++;
        }
        return count;
    }
}