class Heap implements Comparable<Heap> {
    public int num, freq;

    public Heap(int num, int freq) {
        this.num = num;
        this.freq = freq;
    }

    @Override
    public int compareTo(Heap other) {
        return Integer.compare(other.freq, this.freq);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Heap> maxHeap = new PriorityQueue<>();
        Map<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[k];
        
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            }
            else
                hm.put(nums[i], 1);
        }
        
        for (Integer key : hm.keySet()) {
            int freq = hm.get(key);
            maxHeap.offer(new Heap(key, freq));
        }
        int p = 0;
        while (k > 0) {
            ans[p++] = maxHeap.poll().num;
            k--;
        }
        
        return ans;
    }
}