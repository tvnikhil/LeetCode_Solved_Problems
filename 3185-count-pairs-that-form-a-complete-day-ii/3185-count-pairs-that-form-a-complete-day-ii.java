class Solution {
    public long countCompleteDayPairs(int[] hours) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < hours.length; i++) {
            int rem = hours[i] % 24;
            if (rem != 0 && hm.get(24-rem) != null)
                ans += hm.get(24-rem);
            else if (rem == 0 && hm.get(0) != null)
                ans += hm.get(0);
            
            if (hm.get(rem) == null)
                hm.put(rem, 1);
            else
                hm.put(rem, hm.get(rem) + 1);
        }
        return ans;
    }
}