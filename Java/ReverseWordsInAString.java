// dont really know how to improve i feel because its O(n) to trim each word and O(n) to go through the array list of strings

class Solution {
    public String reverseWords(String s) {
        //manual trimming word by word since .trim().split() did not work
        List<String> arr = new ArrayList<>();
        int tracker = 0; // will be like a holder for the last letter of a word
        s = s.trim();
        while (s.length() > 0) {// going to continuosly substring it until there is no more
            if (tracker < s.length() && s.charAt(tracker) != ' ') {
                tracker++;
            } else {
                if (tracker == 0)
                    s = s.substring(1);
                else {
                    // if tracker not 0 then there was a word so we should add to arraylist
                    // and substring the word out
                    arr.add(s.substring(0, tracker));
                    s = s.substring(tracker);
                    tracker = 0;
                }
            }
        }


        System.out.println(arr.toString());

        StringBuilder sb = new StringBuilder("");
        for (int i = arr.size() - 1; i >= 0; i--) {
            sb.append(arr.get(i));
            if (i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}

// much cleaner solution where we trim then split then remove all blank words from array then reversing through list of words

// OPTIMAL: could be optimized if you found the indicies of each word and had two pointers from start and end 
    class Solution {
        public String reverseWords(String s) {
            s = s.trim();
            String[] words = s.split(" ");
            ArrayList<String> arr = new ArrayList<>();

            for (String word: words) {
                if (word != "") {
                    arr.add(word);
                }

            }

           
            StringBuilder sb = new StringBuilder();
            for (int i = arr.size() - 1; i >= 0; i--) {
                sb.append(arr.get(i));
                if (i != 0) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }
    }