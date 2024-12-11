import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);

        System.out.println("Graf:\n" + graph.toString());

        System.out.println(graph.getVertexCount());

        System.out.println(graph.getEdgesCount(true));

        graph.hasEdge(3, 4);

    }
}