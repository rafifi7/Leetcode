// hashmap solution O(2n) time complexity which is cool but not very fast, takes a lot of memory can be much more optimal
class Solution {
    public int maxOperations(int[] nums, int k) {
        int numOperations = 0; 
        // what if hashmap and set every number and their counts
        // then iterate through the set and find each 
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) { // add counts of nums into hashmap
            if (hm.containsKey(nums[i])) {
                hm.put(nums[i], hm.get(nums[i]) + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        for (int i = 0; i < nums.length; i++) { // 
            int target = k - nums[i];
            if (hm.containsKey(nums[i]) && hm.containsKey(target)) {
                if (nums[i] == target)  {// same number
                    if (hm.get(target) > 1) {//if the count of target is atleast 2
                        if (hm.get(target) - 2 == 0)
                            hm.remove(target);
                        else  
                            hm.put(target, hm.get(target) - 2);
                        numOperations++;
                    }
                } else { // target and nums[i] are different
                    // updating target in hashmap
                    if (hm.get(target) - 1 == 0)
                        hm.remove(target);
                    else
                        hm.put(target, hm.get(target) - 1);
                    // updating nums[i] in hashmap
                    if (hm.get(nums[i]) - 1 == 0)
                        hm.remove(nums[i]);
                    else
                        hm.put(nums[i], hm.get(nums[i]) - 1);

                    numOperations++;
                }
            
            }

        }

        return numOperations;
    }
}

//optimal soltuion using two pointer technique

