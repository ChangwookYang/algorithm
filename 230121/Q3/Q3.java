import java.util.Scanner;

public class Main {

    static int[][] arr;
    static boolean[][] checked;
    static int cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = new int[8][8];
        checked = new boolean[8][8];
        cnt = 0;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        maze(1, 1);
        System.out.println(cnt);
    }

    private static void maze(int x, int y) {
        if (x == 7 && y == 7) {
            cnt++;
        } else if (x == 0 || y == 0 || x == 8 || y == 8) {
            return;
        } else if (arr[x][y] == 0 && !checked[x][y]) {
            checked[x][y] = true;
            maze(x + 1, y);
            maze(x, y + 1);
            maze(x - 1, y);
            maze(x, y - 1);
            checked[x][y] = false;
        }
    }
}
