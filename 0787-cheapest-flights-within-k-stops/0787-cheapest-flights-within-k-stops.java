class Tuple implements Comparable<Tuple>{
    int stop, node, cost;
    
    public Tuple(int stop, int node, int cost) {
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Tuple other) {
        if (this.stop != other.stop)
            return Integer.compare(this.stop, other.stop);
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < flights.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(flights[i][1]); temp.add(flights[i][2]);
            adj.get(flights[i][0]).add(temp);
        }
        int[] price = new int[n];
        for (int i = 0; i < n; i++) price[i] = Integer.MAX_VALUE;
        price[src] = 0;
        PriorityQueue<Tuple> pque = new PriorityQueue<>();
        pque.offer(new Tuple(0, src, 0));
        while (!pque.isEmpty()) {
            Tuple curr = pque.poll();
            int currCity = curr.node, currStop = curr.stop, currCost = curr.cost;
            if (currStop > k)
                break;
            for (int i = 0; i < adj.get(currCity).size(); i++) {
                int to = adj.get(currCity).get(i).get(0);
                int cost = adj.get(currCity).get(i).get(1);
                int newCost = cost + currCost;
                if (newCost < price[to]) {
                    price[to] = newCost;
                    pque.offer(new Tuple(currStop+1, to, newCost));
                }
            }
        }
        return (price[dst] != Integer.MAX_VALUE) ? price[dst]: -1;
    }
}