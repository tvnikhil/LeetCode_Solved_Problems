class Solution {
    public double calcPow(double x, long n) {
        if (n < 0)
            return calcPow(1/x, Math.abs(n));
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double ans = calcPow(x, n/2);
        if (n % 2 == 0)
            return ans * ans;
        return x * ans * ans;
    }
    public double myPow(double x, int n) {
        return calcPow(x, n);
    }
}