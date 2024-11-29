// i think the most optimal solution o(2n)
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = 0;
        List<Boolean> ret = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (max < candies[i]) max = candies[i]; 
        }

        for (int i = 0; i < n; i++) {
            if (candies[i] + extraCandies >= max)
                ret.add(true);
            else
                ret.add(false);
        }

        return ret;

    }
}