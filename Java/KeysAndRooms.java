import java.util.Stack;

// dfs solution with a stack and a visited array
// O(N + e) n being the rooms and e being the numbers of keys

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[rooms.size()];
        int count = 1;
        for (int i = 1 ; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[0] = true;
        for (int j = 0; j < rooms.get(0).size(); j++) {
            stack.add(rooms.get(0).get(j));
        }

        while (!stack.isEmpty()) {
            int key = stack.pop();
            if (visited[key] == true) {
                continue;
            } else {
                visited[key] = true;
                count++;
                for (int j = 0; j < rooms.get(key).size(); j++) {
                    stack.add(rooms.get(key).get(j));
                }
            }
        }

        return visited.length == count;
    }
}