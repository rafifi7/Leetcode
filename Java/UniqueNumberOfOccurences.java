//  calm O(2n) problem, uses lots of memory though, probably could use less 

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // hold counts of values in hashmap
        // then add counts of counts to hashset
        Map<Integer, Integer> hm = new HashMap<>();
        List<Integer> distinctNums = new ArrayList<>();
        Set<Integer> counts = new HashSet<>();
        for (int i : arr) {
            if (hm.containsKey(i) == false) {
                hm.put(i,  1); //puts count of key in hashmap
                distinctNums.add(i);
            } else {
                hm.put(i, hm.get(i) + 1); 
            }
        }

        for (int i = 0; i < distinctNums.size(); i++) {
            int count = hm.get(distinctNums.get(i)); // getting the count of the distinct num from the hashmap
            if (counts.contains(count)) {
                return false;
            } else {
                counts.add(count); //adds count to the set
            }
        }
        return true;



    }
}