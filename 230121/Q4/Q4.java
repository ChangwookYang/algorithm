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

    static int[][] arr;
    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static boolean[][] checked;
    static Queue<Point> path = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arr = new int[8][8];
        checked = new boolean[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int result = maze();
        System.out.println(result);
    }

    private static int maze() {
        path.offer(new Point(1, 1));

        int move = 0;
        while (!path.isEmpty()) {
            int size = path.size();
            for (int i = 0; i < size; i++) {
                Point point = path.poll();
                if (point.x == 7 && point.y == 7)
                    return move;

                for (int dir = 0; dir < 4; dir++) {
                    point.x += x[dir];
                    point.y += y[dir];
                    if (isValid(point.x, point.y)) {
                        checked[point.x][point.y] = true;
                        path.offer(new Point(point.x, point.y));
                    }
                    point.x -= x[dir];
                    point.y -= y[dir];

                }
            }
            move += 1;

        }

        return -1;
    }

    public static boolean isValid(int x, int y) {
        if (x == 0 || y == 0 || x == 8 || y == 8) {
            return false;
        } else return arr[x][y] == 0 && !checked[x][y];
    }
}
