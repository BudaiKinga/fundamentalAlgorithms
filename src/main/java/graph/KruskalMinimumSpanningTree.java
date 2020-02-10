package graph;


import javafx.util.Pair;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class KruskalMinimumSpanningTree {

    private static final int[][] ADJ2 =
            {
                    //     a  b  c  d  e  f  g  h  i
                    /*a*/ {0, 4, 0, 0, 0, 0, 0, 8, 0},
                    /*b*/ {4, 0, 8, 0, 0, 0, 0, 11, 0},
                    /*c*/ {0, 8, 0, 7, 0, 4, 0, 0, 2},
                    /*d*/ {0, 0, 7, 0, 9, 10, 0, 0, 0},
                    /*e*/ {0, 0, 0, 9, 0, 10, 0, 0, 0},
                    /*f*/ {0, 0, 4, 14, 10, 0, 2, 0, 0},
                    /*g*/ {0, 0, 0, 0, 0, 2, 0, 1, 6},
                    /*h*/ {8, 11, 0, 0, 0, 0, 1, 0, 7},
                    /*i*/ {0, 0, 2, 0, 0, 0, 6, 7, 0}
            };

    Map<Pair<Integer, Integer>, Integer> minSpanningTree = new HashMap<>();

    Map<Character, Set<Integer>> setForest = new HashMap<>();


    private Set<Integer> unvisitedNodes = new HashSet<>();

    public void kruskal(int[][] adj) {
        // A from algorithm -> minSpanningTree

        // for each vertex assign new set
        char set = 'a';
        for (int i = 0;  i <adj.length; i++) {
            setForest.put(set, new HashSet<>(Arrays.asList(i)));
            set++;
        }

        // create edges
        Map<Pair<Integer, Integer>, Integer> edges = new HashMap<>();
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                int edge = adj[i][j];
                if (edge != 0) {
                    edges.put(new Pair<>(i, j), edge);
                }
            }
        }
        // take edges into non decreasing order
        while (!edges.isEmpty()) {

            Map.Entry<Pair<Integer, Integer>, Integer> edge = extractMinimum(edges);

            // do not edge if this means forming a cycle. check this by getting the set
            Character set1 = findSet(edge.getKey().getKey());
            Character set2 = findSet(edge.getKey().getValue());
            if (!set1.equals(set2)) {
                // add to spanning tree new edge
                minSpanningTree.put(edge.getKey(), edge.getValue());
                //union the two sets
                union(set1, set2);
            }
        }
    }

    private void union(Character set1, Character set2) {
        Set<Integer> secondSetElements = setForest.remove(set2);
        Set<Integer> firstSetElements = setForest.get(set1);
        firstSetElements.addAll(secondSetElements);
    }

    private Character findSet(int vertex) {
        for (Map.Entry<Character, Set<Integer>> vertices : setForest.entrySet()) {
            if (vertices.getValue().contains(vertex)) {
                return vertices.getKey();
            }
        }
        return null;
    }

    private Map.Entry<Pair<Integer, Integer>, Integer> extractMinimum(Map<Pair<Integer, Integer>, Integer> edges) {
        int minValue = Integer.MAX_VALUE;
        Map.Entry<Pair<Integer, Integer>, Integer> minEdge = new AbstractMap.SimpleEntry<>(new Pair<>(-1, -1), minValue);

        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : edges.entrySet()) {
            if (entry.getValue() < minValue) {
                minValue = entry.getValue();
                minEdge = entry;
            }
        }
        edges.remove(minEdge.getKey());
        return minEdge;
    }


    public static void main(String[] args) {
        KruskalMinimumSpanningTree kmst = new KruskalMinimumSpanningTree();
        kmst.kruskal(ADJ2);
        kmst.prettyPrint();
    }

    private void prettyPrint() {
        for (Map.Entry<Pair<Integer, Integer>, Integer> edge : minSpanningTree.entrySet()) {
            System.out.println("Edge " + edge.getKey().toString() + " with " + edge.getValue() + " in MST");
        }
    }

}
