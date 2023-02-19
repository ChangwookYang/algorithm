import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        int solution = solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"});
//        int solution = solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"});

        System.out.println(solution);
    }

    private static int solution(String[] maps) {
        int toL = bfs(maps, 'S', 'L');
        int toE = bfs(maps, 'L', 'E');
        if(toL == -1 || toE == -1) return -1;
        else return toL + toE;
    }

    private static int bfs(String[] maps, char start, char end) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length();

        boolean[][] check = new boolean[row][col];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == start) {
                    queue.offer(new Point(i, j));
                    check[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            answer++;

            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int newX = point.x + dx[dir];
                    int newY = point.y + dy[dir];

                    if (newX < 0 || newY < 0 || newX >= row || newY >= col) {
                        continue;
                    } else if (maps[newX].charAt(newY) != 'X' && maps[newX].charAt(newY) != end && !check[newX][newY]) {
                        queue.offer(new Point(newX, newY));
                        check[newX][newY] = true;
                    } else if (maps[newX].charAt(newY) == end) {
                        return answer;
                    }
                }
            }
        }
        return -1;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}