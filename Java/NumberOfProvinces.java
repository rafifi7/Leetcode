/* 
  O(n^2 + n) solution because we are iterating through the entire matrix then making an adjacency list to iterate through using a stack
  could be simplified a lot
*/
import java.util.Stack;
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1) {
            return 1;
        }
        // hashmap maps the city to a set of all the other citys
        List<Set<Integer>> cityList = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            cityList.add(new HashSet<>());
        }
        // assuming this is an undirected graph

        int[] visited = new int[isConnected.length]; // keeps track of what we have visited already
        // 0 = not visited, 1 = 1 province connects all of them, 2 = 2 province connects all of them
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    cityList.get(i).add(j); 
                }// adding the city that its connected to, to a city List so we know what each node connects to
            }
        }
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < visited.length; i++) { // add first city on top but doesnt matter
            if (visited[i] == 0) { // if we havent visited the node
                stack.push(i); // add to stack
                count++; // number of provinces increases 
                while (!stack.isEmpty()) {  // do dfs on the city
                    int city = stack.pop(); 
                    visited[city] = 1; // mark as visited
                    for (int neighbor : cityList.get(city)) { // for each neighboring city of the first city
                        if (visited[neighbor] == 0) {  // if we havent visited the city, add the city to stack
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
        return count;
    }
}


// O (n^2) but more optimal than prev solution because prev solution was O(n^2 + n)
// this solution allows for running dfs on each unvisited 

import java.util.Stack;
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 1) {
            return 1;
        }
        // assuming this is an undirected graph
        int[] visited = new int[isConnected.length]; // keeps track of what we have visited already
        // 0 = not visited, 1 = means it has been visited before
        int count = 0;

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                stack.push(i);
                while (!stack.isEmpty()) {
                    // pop the stack
                    int city = stack.pop();
                    visited[city] = 1; // set city to visited
                    for (int j = 0; j < isConnected[0].length; j++) {
                        if (isConnected[city][j] == 1 && visited[j] == 0) { 
                            // run dfs on curr city by iterating through each neighboring city that has not been visited
                            stack.push(j);
                        }
                    }
                }
                count++; // increment only if we are adding a new visited thingy, aka province
            }
        }
        return count;
    }
}