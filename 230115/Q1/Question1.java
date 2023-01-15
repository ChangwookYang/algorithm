import java.util.Scanner;

public class Main {

    static int c, n, sum, max;
    static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();
        max = sum = 0;
        arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        DFS(0);
        System.out.println(max);
    }

    private static void DFS(int index) {
        if (index == n) {
            if (sum <= c)
                max = Math.max(max, sum);
        } else {
            int nextIndex = index + 1;
            sum += arr[index];
            DFS(nextIndex);
            sum -= arr[index];
            DFS(nextIndex);
        }
    }


}
