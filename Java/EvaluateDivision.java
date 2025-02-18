import java.util.Queue;

/* 
  Lets say queries is of size q
  BFS traverses through a graph at most once by itself but it still explores every edge so its (O(v + e)) (vertices + edges)

  but we have to run bfs on every query so the overall time complexity is O(q(v + e)) or O(n^2 + n * e)




*/



class Solution {
    public class Pair {
        String var;
        double value;

        public Pair(String var, double value) {
            this.var = var;
            this.value = value;
        }
    }

   

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // we are given equations which are in pairs [[x,y], [y,z]] which are variables that we want to divide x by y
        // we are given values which are what [1.0, 2.0] which are what the equations are 
        // for example: x/y = 1.0 and y/z = 2.0
        // we are also given queries that we want to find the answer to like [x, z] x/y * y/z = x/z

        // we solve these queries using graphs by having a list of all of the values in relation to all the values

        HashMap<String, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equa = equations.get(i);
            Pair a = new Pair(equa.get(1), values[i]);
            Pair b = new Pair(equa.get(0), 1.0 / values[i]);
            if (!adj.containsKey(equa.get(0))) {
                adj.put(equa.get(0), new ArrayList<Pair>());
            }
            adj.get(equa.get(0)).add(a);

            if (!adj.containsKey(equa.get(1))) {
                adj.put(equa.get(1), new ArrayList<Pair>());
            }
            adj.get(equa.get(1)).add(b);
        }

        // a --2.0--> b --3.0--> c
        // c --1/3--> b --0.5--> a 

        // we have now mapped out each variable to every given relation to each other variable
        // now we have to run bfs on each query in queries list

        double[] ret = new double[queries.size()];
        // run bfs on every src and every target
        for (int i = 0; i < ret.length; i++) {
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            if (!adj.containsKey(src) || !adj.containsKey(target)) {
                ret[i] = -1.0;
                continue;
            }

            ret[i] = bfs(src, target, adj);
        }

        return ret;
    }

    public double bfs(String src, String target, HashMap<String, List<Pair>> adj) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(new Pair(src, 1)); // neutral value of 1 because this allows us to simply multiply
        visited.add(src);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String node = p.var;
            double weight = p.value;
            if (node.equals(target)) {
                return weight;
            }

            List<Pair> neighbors = adj.get(node);
            for (Pair neighbor: neighbors) {
                if (!visited.contains(neighbor.var)) {
                    q.add(new Pair(neighbor.var, neighbor.value * weight));
                    visited.add(neighbor.var);
                }
            }


        }
        return -1.0;
    }
}