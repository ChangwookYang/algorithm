import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] coins;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        coins = new int[n];
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            queue.offer(value);
            coins[i] = value;
        }
        m = scanner.nextInt();

        System.out.println(bfs());
    }

    private static int bfs() {

        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt++;
            for (int i = 0; i < size; i++) {
                Integer sum = queue.poll();
                for (int value : coins) {
                    sum += value;
                    if (sum == m) {
                        return cnt;
                    } else if (sum < m) {
                        queue.offer(sum);
                    }
                    sum -= value;
                }

            }
        }

        return 0;
    }


}
