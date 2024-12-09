// hashmap solution O(2n) time complexity which is cool but not very fast, takes a lot of memory can be more optimal
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

//optimized version of ^ runs O(n)
class Solution {
    public int maxOperations(int[] nums, int k) {
        int numOperations = 0; 
        // what if hashmap every number and their counts
        Map<Integer, Integer> hm = new HashMap<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) { // add counts of nums into hashmap
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            target = k - nums[i];
            if (target == nums[i] && hm.get(target) > 1) { // if the same and count of at least 2
                numOperations++;
                hm.put(target, hm.get(target) - 2); // decrease count by 2
            } else if (target != nums[i] && hm.containsKey(target) && hm.get(target) > 0) { 
                // if target is in hashmap and count of atleast 1
                numOperations++;
                hm.put(target, hm.get(target) - 1);
                hm.put(nums[i], hm.get(nums[i]) - 1);
            }
        }


        return numOperations;
    }
}


//optimal soltuion using two pointer technique
class Solution {
    public int maxOperations(int[] nums, int k) {
        int numOperations = 0; 
        int l = 0, r = nums.length - 1;
        Arrays.sort(nums);
        int sum = 0;
        while (l < r) {
            sum = nums[l] + nums[r];
            if (sum == k) {
                numOperations++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            }

        }

        return numOperations;
    }
}