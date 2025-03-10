// solution, first we load all the letters corresponding to each number 2-9 to a hashmap

// then we run our backtracking algo 

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();

        // number of combinations we can have is equal to 4 or 3 to the digits.length degree
        HashMap<String, List<String>> map = new HashMap();
        map.put("2", Arrays.asList("a", "b", "c"));
        map.put("3", Arrays.asList("d", "e", "f"));
        map.put("4", Arrays.asList("g", "h", "i"));
        map.put("5", Arrays.asList("j", "k", "l"));
        map.put("6", Arrays.asList("m", "n", "o"));
        map.put("7", Arrays.asList("p", "q", "r", "s"));
        map.put("8", Arrays.asList("t", "u", "v"));
        map.put("9", Arrays.asList("w", "x", "y", "z"));

        if (digits.length() >= 0)
            backtrack(0, "", digits, ret, map);
        if (ret.size() == 1 && ret.get(0) == "") {
            ret.remove(0);
        }
        return ret;
    }

    public void backtrack(int i, String currStr, String digits, List<String> ret, HashMap<String, List<String>> map) {
        if (currStr.length() == digits.length()) {
            ret.add(currStr);
            return;
        }
        List<String> chars = map.get(String.valueOf(digits.charAt(i)));
        if (!chars.isEmpty()) {
            for (String s : chars) { 
                String newStr = currStr + s;
                backtrack(i + 1, newStr, digits, ret, map);
            }
        }
    }
}