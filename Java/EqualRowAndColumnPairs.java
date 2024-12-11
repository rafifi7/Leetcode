// O(N^2) + O(n) not bad but probably can be optimized 

class Solution {
    public int equalPairs(int[][] grid) {
        // have one hashmap with counts and one arraylist of keys
        HashMap<String, Integer> rowMap = new HashMap<>();
        List<String> colKeys = new ArrayList<>();

        StringBuilder sbRow = new StringBuilder();
        StringBuilder sbCol = new StringBuilder();

        int numPairs = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sbRow.append(grid[i][j] + " ");
                sbCol.append(grid[j][i] + " ");
            }
            //add counts of each row to hashmap
            rowMap.put(sbRow.toString(), rowMap.getOrDefault(sbRow.toString(), 0) + 1);
            //add each column to arraylist
            colKeys.add(sbCol.toString());
            
            //reset both string builders
            sbRow.setLength(0);
            sbCol.setLength(0);
        }

        for (String key: colKeys) {
            if (rowMap.containsKey(key)) {
                numPairs += rowMap.get(key); //adds count of each row that matches to a column to numPairs 
            }
        }
        

        return numPairs;
    }
}