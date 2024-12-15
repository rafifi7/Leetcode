class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stack = new ArrayList<>();
        int top = -1; // Initialize top to -1 to represent an empty stack

        for (int i = 0; i < asteroids.length; i++) {
            int nextAsteroid = asteroids[i];

            // Handle collisions while the stack is not empty and a collision scenario occurs
            while (top >= 0 && stack.get(top) > 0 && nextAsteroid < 0) {
                int lastAsteroid = stack.get(top);

                if (Math.abs(lastAsteroid) > Math.abs(nextAsteroid)) {
                    nextAsteroid = 0; // Next asteroid is destroyed
                } else if (Math.abs(lastAsteroid) == Math.abs(nextAsteroid)) {
                    stack.remove(top--); // Both asteroids are destroyed
                    nextAsteroid = 0;
                } else {
                    stack.remove(top--); // Last asteroid is destroyed
                }
            }

            // Add the next asteroid if it's not destroyed
            if (nextAsteroid != 0) {
                stack.add(nextAsteroid);
                top++;
            }
        }

        // Convert to int array
        int[] ret = new int[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.get(i);
        }
        return ret;
    }
}