// used bfs  O(n * M)

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        queue.add(new int[] {entrance[0], entrance[1], 0});
        
        maze[entrance[0]][entrance[1]] = '+'; // Mark the entrance as visited

        while (!queue.isEmpty()) {
            int[] coords = queue.poll();
            int row = coords[0], col = coords[1], steps = coords[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check bounds and if the cell is open
                if (newRow >= 0 && newRow < maze.length && 
                    newCol >= 0 && newCol < maze[0].length && 
                    maze[newRow][newCol] == '.') {
                    
                    // Check if it's an exit (not the entrance)
                    if (newRow == 0 || newRow == maze.length - 1 || 
                        newCol == 0 || newCol == maze[0].length - 1) {
                        return steps + 1;
                    }
                    
                    // Mark as visited and add to queue
                    maze[newRow][newCol] = '+';
                    queue.add(new int[] {newRow, newCol, steps + 1});
                }
            }
        }
        return -1;
    }
}