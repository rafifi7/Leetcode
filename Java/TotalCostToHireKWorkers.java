class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        int l = 0; 
        int r = costs.length - 1;

        while (l < candidates) {
            leftHeap.add(costs[l++]);
        }

        while (r >= l && costs.length - r <= candidates) {
            rightHeap.add(costs[r--]);
        }

        
        while (k > 0) {
            if (!rightHeap.isEmpty() && (leftHeap.isEmpty() || rightHeap.peek() < leftHeap.peek())) { 
            //if rightHeap is not empty and leftHeap isempty or the min cost in right is smaller than the min cost of left
                totalCost += rightHeap.poll();
                if (r >= l) rightHeap.add(costs[r--]); // Expand from the right
            } else {
                // if right heap is empty or leftHeap is not empty && min of rightHeap > min of leftHeap
                totalCost += leftHeap.poll();
                if (l <= r) leftHeap.add(costs[l++]); // Expand from the left
            }
            k--;
        }



        return totalCost;
    }
}