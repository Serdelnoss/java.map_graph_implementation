import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<T>> map = new HashMap<>();

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<T>());
    }

    public void addEdge(T source, T destination, boolean bidirectional) {
        if (!map.containsKey(source)) {
            addVertex(source);
        }
        if (!map.containsKey(destination)) {
            addVertex(destination);
        }

        map.get(source).add(destination);
        if (bidirectional) {
            map.get(destination).add(source);
        }
    }

    public int getVertexCount() {
        return map.keySet().size();
    }

    public int getEdgesCount(boolean bidirectional) {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirectional) {
            count = count / 2;
        }
        return count;
    }

    public boolean hasVertex(T s) {
        if (map.containsKey(s)) {
            System.out.println("Graph contain " + s + " as vertex.");
            return true;
        } else {
            System.out.println("Graph does not contain " + s + " as vertex.");
            return false;
        }
    }

    public boolean hasEdge(T s, T d) {
        if (map.get(s).contains(d)) {
            System.out.println("Graph contain edge between " + s + " and " + d + ".");
            return true;
        } else {
            System.out.println("Graph does not contain edge between " + s + " and " + d + ".");
            return false;
        }
    }

    public void neighbours(T s) {
        if (!map.containsKey(s)) {
            return;
        }
        System.out.println("Neighbors of " + s + " are:");
        for (T w : map.get(s)) {
            System.out.print(w + ", ");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : map.keySet()) {
            builder.append(v.toString()).append(": ");
            for (T w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
