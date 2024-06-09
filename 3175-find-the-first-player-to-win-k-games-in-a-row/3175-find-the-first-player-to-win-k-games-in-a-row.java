class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        int wins = 0, winIdx = 0;
        for (int i = 1; i < skills.length; i++) {
            if (skills[i] < skills[winIdx])
                wins++;
            else {
                winIdx = i;
                wins = 1;
            }
            if (k == wins)
                return winIdx;
        }
        return winIdx;
    }
}