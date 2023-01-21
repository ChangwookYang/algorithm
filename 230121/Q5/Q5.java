import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int[][] arr;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static boolean[][] checked;
    static Queue<Point> tomato = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        arr = new int[m + 1][n + 1];
        checked = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) arr[i][j] = -1;
                else {
                    int value = scanner.nextInt();
                    arr[i][j] = value;
                    if (value == 1) {
                        checked[i][j] = true;
                        tomato.offer(new Point(i, j));
                    }
                }
            }
        }
        boolean isAlreadyDone = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(arr[i][j] == 0) {
                    isAlreadyDone = false;
                    break;
                }
            }
            if(!isAlreadyDone) break;
        }
        if(!isAlreadyDone) {
            int result = tomatos(m, n);

            boolean isNotAll = false;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if(arr[i][j] == 0) {
                        isNotAll = true;
                        break;
                    }
                }
                if(isNotAll) break;
            }
            if(isNotAll) System.out.println(-1);
            else System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

    private static int tomatos(int m, int n) {
        int days = 0;

        while (!tomato.isEmpty()) {
            int size = tomato.size();
            boolean isAdded = false;
            for (int i = 0; i < size; i++) {
                Point point = tomato.poll();
                for (int dir = 0; dir < 4; dir++) {
                    point.x += x[dir];
                    point.y += y[dir];
                    if (isValid(m, n, point.x, point.y)) {
                        checked[point.x][point.y] = true;
                        arr[point.x][point.y] = 1;
                        isAdded = true;
                        tomato.offer(new Point(point.x, point.y));
                    }
                    point.x -= x[dir];
                    point.y -= y[dir];
                }
            }
            if(isAdded)
                days += 1;

        }

        return days;
    }

    public static boolean isValid(int m, int n, int x, int y) {
        if (x == 0 || y == 0 || x > m || y > n) {
            return false;
        } else return arr[x][y] == 0 && !checked[x][y];
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
