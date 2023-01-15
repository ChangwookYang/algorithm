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

        int combination = combination(n, r);
        System.out.println(combination);

    }

    private static int combination(int current, int r) {
        if (current == r || r == 0) return 1;

        if (arr[current][r] > 0) {
            return arr[current][r];
        } else {
            int value = combination(current - 1, r - 1) + combination(current - 1, r);
            arr[current][r] = value;
            return value;
        }
    }


}
