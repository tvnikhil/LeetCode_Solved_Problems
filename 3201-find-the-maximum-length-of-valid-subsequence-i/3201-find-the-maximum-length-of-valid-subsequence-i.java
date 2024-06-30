class Solution {
    public int maximumLength(int[] nums) {
        int[] rems = new int[nums.length];
        int zCnt = 0, oCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            rems[i] = nums[i] % 2;
            if (rems[i] == 0) zCnt++;
            else oCnt++;
        }
        int altLen = 0, choice = rems[0];
        for (int i = 0; i < rems.length; i++) {
            if (rems[i] == choice) {
                altLen++;
                if (choice == 0) choice = 1;
                else choice = 0;
            }
        }
        return(Math.max(altLen, Math.max(zCnt, oCnt)));
    }
}