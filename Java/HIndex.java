// O (n) loading into hashmap + O(n) find the max key of the hashmap + O(n) search for largest hIndex by iterating through frequency table backwards from max Hindex to 0 
// O(3n) -> O(n)
class Solution {
    public int hIndex(int[] citations) {
        
        // step1: load the citation data into the hashmap
        // 

        // example 2: citations = [1,3,1]
        // output 1

        // example 1: citaitons = [3, 0, 6, 1, 5]
        // output 3
        // cit[0]= 3 1/1
        // cit[1] = 0 0/1
        // cit[2] = 6 2/2
        // cit[3] = 1 2/3
        // cit[5] = 5 3/3

        // hashmap 
        HashMap<Integer, Integer> citationCount = new HashMap<>();

        for (int i = 0; i < citations.length; i++) {
            citationCount.put(citations[i], citationCount.getOrDefault(citations[i], 0) + 1);
        }

        // citationsCount
        // 1: 2, 3: 1

        int max = Collections.max(citationCount.keySet());
        // max citations.length
        // min could be 0

        // check if there are 3 papers with 3 citations
        // check if there are 2 papers with 2 citations 
        // check if there are 1 papers with 1 citaions

        int count = 0;
        for (int i = max; i >= 0; i--) {
            if (citationCount.containsKey(i)) {
                count += citationCount.get(i);
            }
            if (count >= i) {
                return i;
            }
        }
        return 0;

    }
}

// O(nlogn) sorting + O(logn) to binary search 
// O(nlogn)
class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);
        int n = citations.length;


        int high = n - 1;
        int low = 0;
        int ret = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // n - mid is the number of citations that are at least this much
            if (citations[mid] >= n - mid) {
                ret = Math.max(ret, n - mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ret;

    }
}