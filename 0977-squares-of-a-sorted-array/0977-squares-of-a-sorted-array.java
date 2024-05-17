class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> ansArr = new ArrayList<Integer>(nums.length);
        int p = 0, q = nums.length - 1;
        while (p <= q) {
            if (Math.abs(nums[p]) < Math.abs(nums[q])) {
                ansArr.add(nums[q] * nums[q]);
                q--;
            }
            else if (Math.abs(nums[p]) > Math.abs(nums[q])) {
                ansArr.add(nums[p] * nums[p]);
                p++;
            }
            else if (p == q) {
                ansArr.add(nums[p] * nums[p]);
                p++;
                q--;
            }
            else {
                ansArr.add(nums[p] * nums[p]);
                ansArr.add(nums[q] * nums[q]);
                p++;
                q--;
            }
        }
        Collections.reverse(ansArr);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ansArr.get(i);
        }
        return nums;
    }
}