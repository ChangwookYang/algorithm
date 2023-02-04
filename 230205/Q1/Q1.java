import java.util.Scanner;

public class Main {

    static int n;
    static int[][] arr;
    static int[][] check;
    static int[] moveX = {-1, -1, -1, 0,  0, 1, 1,  1};
    static int[] moveY = { 1,  0, -1, 1, -1, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        arr = new int[n + 1][n + 1];
        check = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                cnt += DFS(i, j);
            }
        }

        System.out.println(cnt);
    }

    private static int DFS(int x, int y) {
        if (x == 0 || y == 0 || x == n+1 || y == n+1)
            return 0;
        else if (arr[x][y] == 0 || check[x][y] == 1)
            return 0;
        else {
            for (int i = 0; i < 8; i++) {
                check[x][y] = 1;
                DFS(x + moveX[i], y + moveY[i]);
            }
            return 1;
        }
    }
}