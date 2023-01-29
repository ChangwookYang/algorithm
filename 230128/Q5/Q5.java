import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    public int node;
    public int cost;

    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge node) {
        return node.cost - this.cost;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] dist = new int[n + 1];

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int cost = scanner.nextInt();

            list.get(from).add(new Edge(to, cost));
        }
        list.get(1).add(new Edge(1, 0));
        dist[1] = 0;
        for (int i = 2; i <= n; i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Edge> pQ = new PriorityQueue<>();

        pQ.add(new Edge(1, 0));
        while (!pQ.isEmpty()) {
            Edge current = pQ.poll();
            int from = current.node;
            int cost = current.cost;
            if (cost > dist[from]) continue;
            for (Edge to : list.get(from)) {
                int toNode = to.node;
                int toCost = to.cost;
                if (cost + toCost < dist[toNode]) {
                    dist[toNode] = cost + toCost;
                    pQ.offer(new Edge(toNode, cost + toCost));
                }
            }
        }
    }
}