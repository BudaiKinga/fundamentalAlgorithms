package graph;

/**
 * Created by BudaiK on Feb, 2020.
 */
public class Pair {

    public int u;
    public int v;

    public Pair(int u, int v) {
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "u=" + u +
                ", v=" + v +
                '}';
    }
}