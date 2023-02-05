import java.util.ArrayList;
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
    static int m;
    static int min = Integer.MAX_VALUE;
    static int[] combination;
    static ArrayList<Point> houses = new ArrayList<>();
    static ArrayList<Point> pizzas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    houses.add(new Point(i, j));
                } else if (value == 2) {
                    pizzas.add(new Point(i, j));
                }
            }
        }
        combination = new int[m];
        int level = 0;
        int start = 0;
        DFS(level, start);

        System.out.println(min);
    }

    private static void DFS(int level, int start) {
        if (level == m) {
            int sum = 0;
            for (Point house : houses) {
                int distant = Integer.MAX_VALUE;
                for (int i : combination) {
                    int calculate = Math.abs(house.x - pizzas.get(i).x) + Math.abs(house.y - pizzas.get(i).y);
                    distant = Math.min(distant, calculate);
                }
                sum += distant;
            }
            min = Math.min(min, sum);
        } else {
            for (int i = start; i < pizzas.size(); i++) {
                combination[level] = i;
                DFS(level + 1, i + 1);
            }
        }

    }


}