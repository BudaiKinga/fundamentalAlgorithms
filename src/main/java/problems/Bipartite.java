package problems;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class Bipartite {

    private int n = 3;
    private List<Pair<Integer, Integer>> relationships = new ArrayList<>(Arrays.asList(new Pair<>(0, 1), new Pair<>(1, 2)/*, new Pair<>(0, 2)*/));
    private Map<Integer, List<Integer>> rels = new HashMap<>();

    public String hasSolution() {
        // convert relationships
        convertRelations();

        // note with 0 the first partition, 1 the second
        int p = 0;
        Map<Integer, Integer> nodePartition = new HashMap<>();
        // start with node 0
        boolean ok = visitBFAndCompute(0, p, nodePartition);
        return ok ? "yes" : "no";
    }

    private void convertRelations() {
        for (int i = 0; i < n; i++) {
            rels.put(i, new ArrayList<>());
        }

        for (Pair<Integer, Integer> p : relationships) {
            int node = p.getKey();
            rels.get(node).add(p.getValue());
            rels.get(p.getValue()).add(node);
        }
    }

    private boolean visitBFAndCompute(int startNode, int p, Map<Integer, Integer> nodePartitions) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodePartitions.put(node, p % 2);
            visited.add(node);
            p++;
            List<Integer> neighs = rels.get(node);
            int nextPartition = p % 2;
            for (int ne : neighs) {
                Integer nodePartition = nodePartitions.get(ne);
                if (nodePartition != null  && nodePartition != nextPartition) {
                    return false;
                }
                nodePartitions.put(ne, nextPartition);
                // if not visited add to queue
                if (!visited.contains(ne)) {
                    queue.add(ne);
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Bipartite b = new Bipartite();
        System.out.println(b.hasSolution());
    }

}
