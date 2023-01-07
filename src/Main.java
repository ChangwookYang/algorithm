import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            list.get(a).add(b);
        }

        DFS_TREE(1);
        DFS_DIST(1);
    }

    private static void DFS_DIST(int root) {
        int[] check = new int[n + 1];
        int[] dist = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        check[1] = 1;
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                for (int neigbhor : list.get(node)) {
                    if (check[neigbhor] == 0) {
                        queue.offer(neigbhor);
                        check[neigbhor] = 1;
                        dist[neigbhor] = dist[node] + 1;
                    }
                }
            }
        }

        for (int i = 2; i < n + 1; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }



    private static void DFS_TREE(int root) {
        int[] check = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        check[1] = 1;
        int distance = 1;
        int[] result = new int[n + 1];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                for (int val : list.get(cur)) {
                    if (check[val] == 0) {
                        queue.offer(val);
                        check[val] = 1;
                        result[val] = distance;
                    }
                }
            }
            distance++;
        }

        for (int i = 2; i < n + 1; i++) {
            System.out.println(i + " : " + result[i]);
        }
    }


}
