class Solution {
    public int calcBallsCnt(int[] arr, int gap) {
        int nextPossiblePlace = arr[0] + gap, ballsCnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= nextPossiblePlace) {
                ballsCnt++;
                nextPossiblePlace = arr[i] + gap;
            }
        }
        return ballsCnt;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1], ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int ballsCnt = calcBallsCnt(position, mid);
            if (ballsCnt < m)
                high = mid - 1;
            else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
}