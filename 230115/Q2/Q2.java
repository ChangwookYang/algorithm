import java.util.Scanner;

public class Main {

    static int n, m, sum, max, limit;
    static int[] score;
    static int[] time;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        limit = max = sum = 0;
        score = new int[n];
        time = new int[n];

        for (int i = 0; i < n; i++) {
            score[i] = scanner.nextInt();
            time[i] = scanner.nextInt();
        }

        DFS(0);
        System.out.println(max);
    }

    private static void DFS(int index) {
        if (index == n) {
            if (limit <= m)
                max = Math.max(max, sum);
        } else {
            int nextIndex = index + 1;
            sum += score[index];
            limit += time[index];
            DFS(nextIndex);

            sum -= score[index];
            limit -= time[index];
            DFS(nextIndex);
        }
    }


}
