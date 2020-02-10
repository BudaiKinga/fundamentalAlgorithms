package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by BudaiK on Feb, 2020.
 * <p>
 * Consider a directed graph whose vertices are numbered from 1 to n. There is an edge from a vertex i to a vertex j iff either j = i + 1 or j = 3i. The task is to find the minimum number of edges in a path in G from vertex 1 to vertex n.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * <p>
 * Each test case contains a value of n.
 * <p>
 * Output:
 * Print the number of edges in the shortest path from 1 to n.
 * <p>
 * Constraints:
 * 1<=T<=30
 * 1<=n <=1000
 * <p>
 * Example:
 * Input:
 * 2
 * 9
 * 4
 * <p>
 * Output:
 * 2
 * 2
 */
public class Dijkstra {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nrCases = sc.nextInt();

        for (int i = 0; i < nrCases; i++) {
            List<Pair> path = new ArrayList<>();
            int n = sc.nextInt();
            int startnode = 1;
            // search for shortest path
            int nrNodes = dijkstra(path, startnode, n);
            // print nr of edges in shortest path
            System.out.println(nrNodes);
        }
    }

    private static Map<Integer, Integer> costFromSource = new HashMap<>();
    private static Map<Integer, Integer> parentOfNodeFromShortestPath = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();


    public static int dijkstra(List<Pair> path, int start, int end) {
        initializeSingleSource(start, end);
        List<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int u = extractMin(queue);
            if (!visited.contains(u)) {
                List<Integer> neighbors = getNeighbors(u, end);
                updateTotalCostFromSource(u, neighbors);
                queue.addAll(neighbors);
                visited.add(u);
            }
        }
        // build up path
        buildPath(path, start, end);
        return costFromSource.get(end);
    }

    private static void buildPath(List<Pair> path, int start, int end) {
        // build up path starting from the end
        int parentNode =parentOfNodeFromShortestPath.get(end);
        Pair p = new Pair(parentNode, end);
        path.add(p);
        while (parentNode != start) {
            int node = parentNode;
            parentNode = parentOfNodeFromShortestPath.get(node);
            p = new Pair(parentNode, node);
            path.add(p);
        }
    }

    private static void updateTotalCostFromSource(int u, List<Integer> neighbors) {
        for (int neigh : neighbors) {
            int cost = costFromSource.get(neigh);
            int candidateCost = costFromSource.get(u) + 1; // we have edge of weight 1
            if (candidateCost < cost) {
                parentOfNodeFromShortestPath.put(neigh, u);
                costFromSource.put(neigh, candidateCost);
            }
        }
    }

    private static List<Integer> getNeighbors(int u, int n) {
        List<Integer> neighs = new ArrayList<>();
        // add those v that: v = u +1 and v = 3*u
        int v = u+1;
        if (v <= n) {
            neighs.add(v);
        }

        v = u*3;
        if (v <= n) {
            neighs.add(v);
        }
        return neighs;
    }

    public static void initializeSingleSource(int startNode, int totalNodes) {
        for (int i = 1; i <= totalNodes; i++) {
            costFromSource.put(i, Integer.MAX_VALUE);
        }
        costFromSource.put(startNode, 0);
        // parents are null because HashMap returns null
        visited = new HashSet<>();
    }

    public static int extractMin(List<Integer> queue) {
        int minIndex = 0;
        int minDist = costFromSource.get(queue.get(minIndex));
        for (int i = 1; i < queue.size(); i++) {
            int candidateNode = queue.get(i);
            int weight = costFromSource.get(candidateNode);
            if (weight < minDist) {
                minIndex = i;
            }
        }
        return queue.remove(minIndex);
    }


}