package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import javafx.util.Pair;

public class BreadthFirstSearch
{
    // O(V+E)
    private static final int[][] ADJ =
        {
            //     1  2  3  4  5  6  7  8
            /*1*/ {0, 1, 0, 1, 0, 0, 0, 0},
            /*2*/ {1, 0, 1, 0, 0, 0, 0, 0},
            /*3*/ {0, 0, 0, 0, 1, 1, 0, 0},
            /*4*/ {0, 0, 1, 0, 0, 0, 0, 0},
            /*5*/ {0, 0, 0, 1, 0, 1, 0, 1},
            /*6*/ {0, 0, 0, 0, 0, 0, 1, 0},
            /*7*/ {0, 0, 0, 0, 0, 0, 0, 1},
            /*8*/ {0, 0, 0, 0, 0, 1, 0, 0}
        };

    private int[][] adj;
    private Queue<Integer> queue;
    private Set<Integer> visited;
    private List<Pair<Integer, Integer>> bfsPath = new LinkedList<>();
    private Map<Integer, Integer> shortestDistance;

    public BreadthFirstSearch(int[][] adj)
    {
        this.adj = adj;
        queue = new LinkedList<>();
    }

    private void bfs(int start)
    {
        shortestDistance = new HashMap<>();
        for (int i = 0; i < adj.length; i++)
        {
            shortestDistance.put(i, 0);
        }
        visited = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            int currNode = queue.remove();
            List<Integer> neighb = getNeighbs(currNode);
            for (Integer node : neighb)
            {
                if (!visited.contains(node))
                {
                    bfsPath.add(new Pair<>(currNode, node));
                    shortestDistance.put(node, shortestDistance.get(currNode) + 1);
                    visited.add(node);
                    queue.add(node);
                }
            }
            visited.add(currNode);
        }
    }

    private List<Integer> getNeighbs(int currNode)
    {
        List<Integer> negihbs = new LinkedList<>();
        for (int i = 0; i < adj[currNode].length; i++)
        {
            if (adj[currNode][i] == 1)
            {
                negihbs.add(i);
            }
        }
        return negihbs;
    }

    public List<Pair<Integer, Integer>> getBfsPath()
    {
        return bfsPath;
    }

    public static void main(String[] args)
    {
        BreadthFirstSearch t = new BreadthFirstSearch(ADJ);
        int start = 0;
        t.bfs(start);
        for (Pair<Integer, Integer> edge : t.getBfsPath())
        {
            System.out.println(edge.getKey() + " " + edge.getValue());
        }
        System.out.println();
        System.out.println("Shortest distances:");
        for (int i = 0; i < t.adj.length; i++)
        {
            System.out.println(start + " -> " + i + ": " + t.shortestDistance.get(i));
        }
    }

}
