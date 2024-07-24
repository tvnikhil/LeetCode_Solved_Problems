class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int a = 10;
        int b = 1;
        int sum = a;
        for (int i = 2; i <= n; i++) {
            if (i == 2) b = 9 * (a-1);
            else b = a * (11-i);
            a = b;
            sum += b;
        }
        return sum;
    }
}