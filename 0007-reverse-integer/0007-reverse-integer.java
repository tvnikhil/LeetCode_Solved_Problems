class Solution {
    public int reverse(int x) {
        int rev = 0;
        boolean flag = (x >= 0) ? true: false;
        x = Math.abs(x);
        while (x > 0) {
            if (rev > Integer.MAX_VALUE/10)
                return 0;
            if (rev == Integer.MAX_VALUE/10 && x % 10 > 1)
                return 0;
            rev = rev * 10 + x % 10;
            x = x/10;
        }
        return (flag == true) ? rev: -rev;
    }
}