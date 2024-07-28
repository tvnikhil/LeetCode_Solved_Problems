// class Solution:
//     def isPrime(self, num):
//         limit = math.floor(math.sqrt(num))
//         for i in range(2, limit+1):
//             if num % i == 0:
//                 return False
//         return True

//     def nonSpecialCount(self, l: int, r: int) -> int:
//         ans = 0
//         for i in range(l, r+1):
//             if i == 1:
//                 continue
//             if i == 4:
//                 ans += 1
//                 continue
//             if i % 2 == 0:
//                 continue
//             root = math.sqrt(i)
//             if math.floor(root) == math.ceil(root):
//                 if self.isPrime(root):
//                     ans += 1
//         return (r - l + 1 - ans)

class Solution {
    public boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int limit = (int) Math.sqrt(num);
        for (int i = 2; i <= limit; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public int nonSpecialCount(int l, int r) {
        int ans = 0;
        for (int i = (int) Math.ceil(Math.sqrt(l)); i <= (int) Math.floor(Math.sqrt(r)); i++) {
            // if (i == 1) {
            //     continue;
            // }
            // if (i == 4) {
            //     ans++;
            //     continue;
            // }
            // if (i % 2 == 0) {
            //     continue;
            // }
            // double root = Math.sqrt(i);
            // if (Math.floor(root) == Math.ceil(root)) {
            //     if (isPrime((int) root)) {
            //         ans++;
            //     }
            // }
            if (isPrime(i)) ans++;
        }
        return (r - l + 1 - ans);
    }
}