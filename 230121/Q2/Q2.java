import java.util.Scanner;

public class Main {

    static int n, r;
    static int[][] combination;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        r = scanner.nextInt();
        combination = new int[n + 1][r + 1];
        System.out.println(combination(n, r));
    }

    private static int combination(int n, int r) {
        if (n == r || r == 0) return 1;
        else if (combination[n][r] > 0) return combination[n][r];
        else {
            int value = combination(n - 1, r - 1) + combination(n - 1, r);
            combination[n][r] = value;
            return value;
        }
    }
}
