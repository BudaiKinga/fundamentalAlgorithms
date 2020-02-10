package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import javafx.util.Pair;

public class DepthFirstSearch
{

    private static final int[][] ADJ =
        {
            //     0  1  2  3  4  5  6  7
            /*0*/ {0, 1, 0, 1, 0, 0, 0, 0},
            /*1*/ {1, 0, 1, 0, 0, 0, 0, 0},
            /*2*/ {0, 0, 0, 0, 1, 1, 0, 0},
            /*3*/ {0, 0, 1, 0, 0, 0, 0, 0},
            /*4*/ {0, 0, 0, 1, 0, 1, 0, 1},
            /*5*/ {0, 0, 0, 0, 0, 0, 1, 0},
            /*6*/ {0, 0, 0, 0, 0, 0, 0, 1},
            /*7*/ {0, 0, 0, 0, 0, 1, 0, 0}
        };

    private static final int[][] ADJ2 =
        {
            //     0  1  2  3  4  5
            /*0*/ {0, 1, 0, 1, 0, 0},
            /*1*/ {0, 0, 0, 1, 0, 0},
            /*2*/ {0, 1, 0, 0, 0, 0},
            /*3*/ {0, 0, 1, 0, 0, 0},
            /*4*/ {0, 0, 1, 0, 0, 1},
            /*5*/ {0, 0, 0, 0, 0, 1}
        };

    private static int TIME_COUNTER = 1;

    private int[][] adj;
    private Stack<Integer> stack;
    private Map<Integer, Integer> discovered;
    private Map<Integer, Integer> finished;
    private Set<Integer> visited;
    private List<Pair<Integer, Integer>> dfsPath = new LinkedList<>();

    public DepthFirstSearch(int[][] adj)
    {
        this.adj = adj;
        stack = new Stack<>();
        discovered = new HashMap<>();
        finished = new HashMap<>();
        visited = new HashSet<>();
    }

    public void dfs()
    {
        for (int i = 0; i < adj.length; i++)
        {
            if (!visited.contains(i))
            {
                dfsWithStack(i);
            }
        }
    }

    private void dfs(int start)
    {
        discovered.put(start, getTime());
        List<Integer> neighb = getNeighbours(start, adj);
        visited.add(start);
        for (Integer node : neighb)
        {
            if (!visited.contains(node))
            {
                dfsPath.add(new Pair<>(start, node));
                dfs(node);
            }
        }
        finished.put(start, getTime());
    }

    private void dfsWithStack(int start)
    {
        stack.push(start);
        while(!stack.empty())
        {
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.println("node: " + current);
            }
            List<Integer> neighb = getNeighbours(current, adj);
            for (Integer node : neighb)
            {
                if (!visited.contains(node))
                {
                    stack.push(node);
                }
            }
        }
    }

    private List<Integer> getNeighbours(int start, int[][] adj)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < adj[start].length; i++)
        {
            if (adj[start][i] == 1)
            {
                list.add(i);
            }
        }
        return list;
    }

    private int getTime()
    {
        return TIME_COUNTER++;
    }

    public static void main(String[] args)
    {
        DepthFirstSearch t = new DepthFirstSearch(ADJ2);
        t.dfs();
        for (Pair<Integer, Integer> p : t.getDfsPath())
        {
            System.out.println(p.getKey() + " " + p.getValue());
        }
        for (int i = 0; i < t.discovered.size(); i++)
        {
            System.out.println(i + ": " + t.discovered.get(i) + "\\" + t.finished.get(i));
        }

    }

    private List<Pair<Integer, Integer>> getDfsPath()
    {
        return dfsPath;
    }
}
