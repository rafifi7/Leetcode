// O(n log(n) + m log(n)) sorting takes nlogn then we iterate through the spells and do log n on the potions as we try to find the smallest valid potion 

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //spells of length m
        //potions of length n

        // spells[i] represenets the strength of the ith spell and potions[j] represents the strength of the jth potion
        Arrays.sort(potions);// potions is now sorted for us to do binary search on
        
        int[] ret = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int count = 0;
            int low = 0;
            int high = potions.length -1;

            // in every loop we need to check mid if its high enough
            // if mid is successful -> lower high to mid 
            // if mid not successful -> increase low to mid
            // want to find lowest successful potion 
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if ((long) potions[mid] * spells[i] >= success) {
                    high = mid - 1; // Search left for earlier valid potion
                } else {
                    low = mid + 1; // Search right
                }
            }
            
            
            ret[i] = potions.length - low;
            
            
        }

        return ret;
    }
}