import java.util.PriorityQueue;
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        // make an array of tuples and sort by descending order of second list
        int[][] arrayOfPairs = new int [nums1.length][2];
        //n
        for (int i = 0; i < nums1.length; i++) {
            arrayOfPairs[i][0] = nums1[i];
            arrayOfPairs[i][1] = nums2[i];
        }
        //nlogn
        Arrays.sort(arrayOfPairs, (a, b) -> Integer.compare(b[1], a[1]));

        // nums1 -> 3, 1, 3, 2
        // nums2 -> 1, 2, 3, 4

        // will now be in ascending order based on nums2
        // can traverse in reverse ig to find the smallest k
        long runningSum = 0;
        long maxScore = Integer.MIN_VALUE;
        //currMin will be the current index of the arrayOfPairs[i][0]

        // need a minHeap to keep track of which nums1 we want to remove everytime we 
        // shift the window to the left
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for (i = 0; i < arrayOfPairs.length; i++) {
            runningSum += arrayOfPairs[i][0];// summing num1
            pq.add(arrayOfPairs[i][0]);
            if (pq.size() > k) {
                runningSum -= pq.poll();
            }
            if (pq.size() == k) {
                maxScore = Math.max(runningSum * arrayOfPairs[i][1], maxScore);
            }
        }

        return maxScore;
    }
}