import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n, m, cnt;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt(); // col
        n = scanner.nextInt(); // row
        cnt = 0;
        arr = new int[n][m]; // [row][col]

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int value = scanner.nextInt();
                arr[i][j] = value;
                if (value == 1)
                    queue.offer(new Point(i, j)); // row, col
            }
        }

        BFS();

        boolean isExistNotRipe = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0)
                    isExistNotRipe = true;
            }
        }

        if (isExistNotRipe) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }

    private static void BFS() {

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean isNewRipe = false;
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                int curX = point.x; // row
                int curY = point.y; // col
                for (int dir = 0; dir < 4; dir++) {
                    int newX = curX + dx[dir];
                    int newY = curY + dy[dir];
                    if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                        continue;
                    } else if (arr[newX][newY] == 0) {
                        arr[newX][newY] = 1;
                        isNewRipe = true;
                        queue.offer(new Point(newX, newY));
                    }
                }
            }
            if(isNewRipe) cnt++;
        }

    }


    private static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}