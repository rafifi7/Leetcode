// O(n) from iterating through to find max in array +
// O(n log n) from doing binary search on the range, but everytime, you need to evaluate using a checker that iterates through array to find total number of hours for value k
//  -> O(n log n) 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // find the minimum number of bananas she has to eat per hour in order to eat all of the bananas
        
        // currently the maximum would be the largest number in the list of piles
        // the minimum possible would be 1 per hour

        // create algorithm that checks if the minimum integer k works

        // then do binary search using hte algorithm on the range 1 - max(num)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        // we have our range now we can do binary search using our checker function
        int low = 1;
        int high = max;
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            
            if (kChecker(piles, mid, h)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;


    }

    public boolean kChecker (int[] piles, int k, int h) {
        int count = 0; //count of the hours as we simulate koko eating the bananas
        for (int i = 0; i < piles.length; i++) {
            count += Math.ceil((double) piles[i] / k);
        }
        return count <= h;
    } 
    
}
