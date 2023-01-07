import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] check;
    static int answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        check = new int[n + 1];

        answer = 0;
        check[1] = 1;
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            list.get(a).add(b);
        }

        DFS(1, n);
        System.out.println(answer);
    }

    private static void DFS(int node, int lastNode) {
        if (node == lastNode) {
            answer++;
        } else {
            for (int val : list.get(node)) {
                if (check[val] == 0) {
                    check[node] = 1;
                    DFS(val, lastNode);
                    check[node] = 0;
                }
            }
        }

    }

}
