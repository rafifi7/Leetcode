// bfs solution using queue
// O (m * n) because m = columns n is rows
// you have to iterate through the 2d array


class Solution {

    class Pair {
        int first;
        int second;
        int third;

        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    public int orangesRotting(int[][] grid) {
        List<Pair> queue = new ArrayList<>(); // queue obj
        List<Integer> times = new ArrayList<>();
        int currTime = 0;
        int totalOranges = 0;
        int rottenOranges = 0;
        // first check grid for any rotten 
        // add rotten oranges to queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, currTime));
                    rottenOranges++;
                    totalOranges++;
                } else if (grid[i][j] == 1) {
                    totalOranges++;
                }               
            }
        }
        if (rottenOranges == totalOranges) return 0;
        // we have count of total oranges and current rotten oranges
        // queue has all rotten oranges
        
        
        while (!queue.isEmpty()) {
            Pair coords = queue.remove(0);
            currTime = coords.third + 1;
            if (coords.first - 1 >= 0 && coords.first - 1 < grid.length && coords.second >= 0 && coords.second < grid[0].length) {
                //going up one
                if (grid[coords.first - 1][coords.second] == 1) {
                    grid[coords.first - 1][coords.second] = 2;
                    queue.add(new Pair(coords.first - 1, coords.second, currTime));
                    rottenOranges++;
                }
            }
            if (coords.first + 1 >= 0 && coords.first + 1 < grid.length && coords.second >= 0 && coords.second < grid[0].length) {
                // going down one
                if (grid[coords.first + 1][coords.second] == 1) {
                    grid[coords.first + 1][coords.second] = 2;
                    queue.add(new Pair(coords.first + 1, coords.second, currTime));
                    rottenOranges++;
                }
            }

            if (coords.first >= 0 && coords.first < grid.length && coords.second - 1 >= 0 && coords.second - 1 < grid[0].length) {
                // going left one
                if (grid[coords.first][coords.second - 1] == 1) {
                    grid[coords.first][coords.second - 1] = 2;
                    queue.add(new Pair(coords.first, coords.second - 1, currTime));
                    rottenOranges++;
                }
            }

            if (coords.first >= 0 && coords.first < grid.length && coords.second + 1 >= 0 && coords.second + 1< grid[0].length) {
                // going right one
                if (grid[coords.first][coords.second + 1] == 1) {
                    grid[coords.first][coords.second + 1] = 2;
                    queue.add(new Pair(coords.first, coords.second + 1, currTime));
                    rottenOranges++;
                }
            }

        }


        if (rottenOranges != totalOranges) return -1;

        return currTime - 1;
    }
}