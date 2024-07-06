class Solution {
    public long maximumPoints(int[] e, int currentEnergy) {
        if (currentEnergy == 0)
            return 0;
        Arrays.sort(e);
        int left = 0, right = e.length-1;
        long ans = 0;
        if (currentEnergy < e[left])
            return 0;
        while (left <= right) {
            if (currentEnergy >= e[left]) {
                ans += (currentEnergy / e[left]);
                currentEnergy = (currentEnergy % e[left]);
            }
            else if (ans > 0){
                currentEnergy += e[right];
                right--;
            }
            else
                break;
        }
        return ans;
    }
}