class Solution {
    public String decodeString(String s) {
        List<Character> stack = new ArrayList<>();
        int freq = -1; // need to set later
        StringBuilder sb = new StringBuilder(""); 
        StringBuilder num = new StringBuilder("");
        // will use this to get full string that needs to be repeated
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') { // when it finds the first instance of ']'
                j = stack.size() - 1;
                while (stack.get(j) != '[') { //backtrack until it finds '['
                    sb.append(stack.get(j)); 
                    stack.remove(j--);
                }
                stack.remove(j--); // removes the '['and j will now be at the number

                //sb is reverse order tho so we will iterate backwords length of sb * freq

                while (j >= 0 && Character.isDigit(stack.get(j))) { //gets all digits for k
                    num.append(stack.get(j));
                    stack.remove(j--);
                } 
                num.reverse();
                freq = Integer.parseInt(num.toString());
                for (int l = 0; l < freq; l++) { // do this k times
                    for (int k = sb.length() - 1; k >= 0; k--) { //iterate through the str
                        stack.add(sb.charAt(k));
                    }
                }
                sb.setLength(0);
                num.setLength(0);
            } else {
                stack.add(s.charAt(i));
            }
        }

        sb.setLength(0);
        for (Character c : stack)
            sb.append(c);
        return sb.toString();


    }
}