import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int n, m;
    static Integer[] coins;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        coins = new Integer[n];
        for (int i = 0; i < n; i++)
            coins[i] = scanner.nextInt();
        m = scanner.nextInt();

        Arrays.sort(coins, Collections.reverseOrder());

        System.out.println(knapsack(0, m));
    }

    private static int knapsack(int index, int sum) {
        if (index == n || sum == 0) {
            if(sum == 0)
                return 0;
            else
                return Integer.MAX_VALUE;
        } else {
            int count = sum / coins[index];
            int newSum = sum - count * coins[index];
            return Math.min(
                    knapsack(index + 1, sum),
                    count + knapsack(index + 1, newSum)
            );
        }
    }


}