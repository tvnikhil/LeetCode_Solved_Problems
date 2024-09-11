class Heap implements Comparable<Heap> {
    public int num;
    
    public Heap(int num) {
        this.num = num;
    }
    
    @Override
    public int compareTo(Heap other) {
        return Integer.compare(other.num, this.num);
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Heap> maxHeap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(new Heap(nums[i]));
        }
        
        int ans = 0;
        while (k > 0) {
            ans = maxHeap.poll().num;
            k--;
        }
        
        return ans;
    }
}