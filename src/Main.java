import java.util.Scanner;

public class Main {


    static int[][] graph;
    static int[] check;
    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new int[n + 1][n + 1];
        check = new int[n + 1];

        answer = 0;
        check[1] = 1;
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a][b] = 1;
        }

        DFS(1, n);
        System.out.println(answer);
    }

    private static void DFS(int node, int lastNode) {
        if (node == lastNode) {
            answer++;
        } else {
            for (int i = 1; i <= lastNode; i++) {
                if (graph[node][i] == 1 && check[i] == 0) {
                    check[node] = 1;
                    DFS(i, lastNode);
                    check[node] = 0;
                }
            }
        }

    }

}
