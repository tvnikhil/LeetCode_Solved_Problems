class Solution {
public:
    int recursiveFib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return (recursiveFib(n - 1) + recursiveFib(n - 2));
    }
    
    int fib(int n) {
        return recursiveFib(n);
    }
};