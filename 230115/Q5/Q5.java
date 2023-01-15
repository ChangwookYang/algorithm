import java.util.Scanner;

public class Main {

    static int n, r;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        r = scanner.nextInt();

        arr = new int[n + 1][r + 1];

        arr[1][1] = 1;

        combination(n, r);

    }

    private static int combination(int n, int r) {
        if (n == 1 && r == 1) return 1;
        else if (r == 1) return n;

        if (arr[n][r] > 0) {
            return arr[n][r];
        } else {
            int value = combination(n - 1, r - 1) + combination(n - 1, r);
            arr[n][r] = value;
            return value;
        }
    }


}
