import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

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
                cnt += BFS(i, j);
            }
        }

        System.out.println(cnt);
    }


    private static int BFS(int x, int y) {
        if (x == 0 || y == 0 || x == n + 1 || y == n + 1) return 0;
        else if(arr[x][y] == 0) return 0;
        else if(check[x][y] == 1) return 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int index = 0; index < size; index++) {
                Point poll = queue.poll();

                for (int i = 0; i < 8; i++) {
                    int newX = x + moveX[i];
                    int newY = y + moveY[i];

                    if (newX == 0 || newY == 0 || newX == n + 1 || newY == n + 1)
                        continue;
                    else if (arr[newX][newY] == 0 || check[newX][newY] == 1) {
                        continue;
                    } else {

                        queue.offer(new Point(newX, newY));
                        check[poll.x][poll.y] = 1;
                    }
                }
            }
        }

        return 1;
    }

    private static boolean isNotValid(int x, int y) {
        if (x == 0 || y == 0 || x == n + 1 || y == n + 1)
            return true;
        else return arr[x][y] == 0 || check[x][y] == 1;
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