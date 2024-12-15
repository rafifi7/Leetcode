class Solution {
    public String predictPartyVictory(String senate) {
        // we have two queues where we add the indices of each letter to respective queue
        Queue<Integer> rads = new ArrayDeque<>();
        Queue<Integer> dirs = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) if (senate.charAt(i) == 'R') rads.add(i); else dirs.add(i);
        // adds everything to each queue
        int offset = senate.length(); // use offset to remember the order of the next turn
        int r, d;

        while (!rads.isEmpty() && !dirs.isEmpty()) { // while both qs are not empty
            r = rads.poll();
            d = dirs.poll();

            if (r < d) {
                rads.add(r + offset);
            } else {
                dirs.add(d + offset);
            }
        }

        if (dirs.isEmpty()) {
            return "Radiant";
        } else {
            return "Dire";
        }

    }
}