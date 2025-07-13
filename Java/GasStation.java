
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // int[] diff = new int[gas.length];
        int total = 0;
        int tank = 0;

        int optIdx = 0;
        for (int i = 0; i < gas.length; i ++) {
            // diff[i] = gas[i] - cost[i];
            int diff = gas[i] - cost[i];
            tank += diff;
            total += diff;
            if (tank < 0) {
                optIdx = i + 1;
                tank = 0;
            }
        }
        if (total < 0) {
            return -1;
        }
        return optIdx;

        
        
    }
}