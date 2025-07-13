class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // so first we will get the counts of the elements into our frequency table aka hashmap
        HashMap<Integer, Integer> counts = new HashMap<>();
        
        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        // then we will iterate through the keys of the hashmap to find the top k most

        // i believe hte best way to do this is by making a list of pairs of num and numcount
        // [1,3], [2,2], [3,1]
        // this way i can sort this list by the second number decreasing and simply add the first number to 
        // an array of length k

        List<List<Integer>> numAndCount = new ArrayList<>();

        for (int countKey : counts.keySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(countKey);
            pair.add(counts.get(countKey));
            numAndCount.add(pair);
        }
        numAndCount.sort((a, b) -> b.get(1) - a.get(1));

        
        // size k
        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            // get first element of each pair of num and freq
            ret[i] = numAndCount.get(i).get(0);
        }

        // runtime total should be 
        // finding frequencies (O(n))
        // adding num and frequencies to list (O(n))
        // sorting numbers by frequencies (O(nlogn))
        // adding top k numbers to array (O(n))

        return ret;


    }
}