package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class Tarjan
{

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
    private Map<Integer, Integer> lowLinkValues;
    private Stack<Integer> stack;

    private List<Integer> dfsPath = new LinkedList<>();

    public Tarjan(int[][] adj)
    {
        this.adj = adj;
        lowLinkValues = new HashMap<>();
        stack = new Stack<>();
    }

    public Set<List<Integer>> buildStrongyConnComponents()
    {
        Set<List<Integer>> scc = new HashSet<>();
        int start = new Random().nextInt(adj.length);
        dfs(start);
        return scc;
    }

    private void dfs(int start)
    {
        int[] neighb = adj[start];
        lowLinkValues.put(start, start);
        stack.push(start);
        for (int i = 0; i<neighb.length; i++) {
            if (neighb[i] == 1) {
                // there is edge
                if (!stack.contains(neighb[i])) {
                    dfs(neighb[i]);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Tarjan t = new Tarjan(ADJ);
        Set<List<Integer>> scc = t.buildStrongyConnComponents();
        for (List<Integer> l : scc)
        {
            for (Integer node : l)
            {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

}
