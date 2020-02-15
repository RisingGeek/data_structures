import java.util.ArrayList;

public class graph {
    public static class Edge {
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int n = 7;
    static ArrayList<Edge>[] graph = new ArrayList[n];

    public static void addEdge(int u, int v, int w) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public static int findIndex(int u, int v) {
        int index = -1;
        for (int i = 0; i < graph[u].size(); i++) {
            if (graph[u].get(i).v == v) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public static void removeEdge(int u, int v) {
        int vIdx = findIndex(u, v);
        int uIdx = findIndex(v, u);
        graph[u].remove(vIdx);
        graph[v].remove(uIdx);
    }

    public static void removeVertex(int vertex) {
        for (int i = graph[vertex].size() - 1; i >= 0; i--) {
            removeEdge(graph[vertex].get(i).v, vertex);
        }
    }

    public static void display() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + "-> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.v + ", " + e.w + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(0, 1, 10);
        addEdge(0, 3, 20);
        addEdge(1, 2, 16);
        addEdge(2, 3, 60);
        addEdge(3, 4, 30);
        addEdge(4, 5, 2);
        addEdge(4, 6, 8);
        display();
        // removeEdge(3, 4);
        removeVertex(3);
        display();
    }

}