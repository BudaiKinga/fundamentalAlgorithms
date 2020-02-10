package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class PrimMinimumSpanningTree {

    private static final int[][] ADJ2 =
            {
                    //     a  b  c  d  e  f  g  h  i
                    /*a*/ {0, 4, 0, 0, 0, 0, 0, 8, 0},
                    /*b*/ {4, 0, 8, 0, 0, 0, 0, 11, 0},
                    /*c*/ {0, 8, 0, 7, 0, 4, 0, 0, 2},
                    /*d*/ {0, 0, 7, 0, 9, 14, 0, 0, 0},
                    /*e*/ {0, 0, 0, 9, 0, 10, 0, 0, 0},
                    /*f*/ {0, 0, 4, 14, 10, 0, 2, 0, 0},
                    /*g*/ {0, 0, 0, 0, 0, 2, 0, 1, 6},
                    /*h*/ {8, 11, 0, 0, 0, 0, 1, 0, 7},
                    /*i*/ {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };


    private Map<Integer, Integer> parent = new HashMap<>();
    Map<Integer, Integer> key = new HashMap<>();

    public void prim(int[][] adj, int root) {
        int nodes = adj.length;
        for (int i = 0; i < nodes; i++) {
            key.put(i, Integer.MAX_VALUE);
            parent.put(i, null);
        }

        // start from root
        key.put(root, 0);

        // Queue interface implemented by LinkedList for example
        List<Integer> queue = new LinkedList<>(key.keySet());
        while (!queue.isEmpty()) {
            int u = extractMinimum(queue);
            for (int v = 0; v < adj[u].length; v++) {
                if (adj[u][v] != 0 && queue.contains(v) && key.get(v) >= adj[u][v]) {
                    parent.put(v, u);
                    key.put(v, adj[u][v]);
                }
            }
        }

        // in the end we have in parent the parents of each node and in key the value from
    }

    private int extractMinimum(List<Integer> queue) {
        int minKey = key.get(0);
        int minIndex = 0;

        for (int i = 1; i < queue.size(); i++) {
            int node = queue.get(i);
            int nodeValue = key.get(node);
            if (nodeValue < minKey) {
                minKey = nodeValue;
                minIndex = i;
            }
        }
        return queue.remove(minIndex);
    }


    public static void main(String[] args) {
        PrimMinimumSpanningTree pmst = new PrimMinimumSpanningTree();
        pmst.prim(ADJ2, 0);
        pmst.prettyPrint();
    }

    private void prettyPrint() {
        for (int i = 0; i < key.size(); i++) {
            System.out.println("Node: " + i + " has parent " + parent.get(i) + " with edge weight " + key.get(i));
        }
    }

}
