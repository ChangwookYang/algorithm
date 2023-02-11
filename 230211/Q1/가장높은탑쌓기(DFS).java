import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    public int width, height, weight;

    public Brick(int width, int height, int weight) {
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Brick brick) {
        return this.width - brick.width;
    }
}

public class Main {

    static int n;
    static int maxHeight;
    static ArrayList<Brick> bricks = new ArrayList<>();
    static boolean[] tower;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tower = new boolean[n];
        maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            int weight = scanner.nextInt();
            bricks.add(new Brick(width, height, weight));
        }

        Collections.sort(bricks);
        DFS(0, 0, 0);

        System.out.println(maxHeight);
    }

    private static void DFS(int index, int lastWidth, int lastWeight) {
        if (index == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (tower[i]) sum += bricks.get(i).height;
            }
            maxHeight = Math.max(maxHeight, sum);
        } else {
            Brick brick = bricks.get(index);
            int width = brick.width;
            int weight = brick.weight;

            if (width > lastWidth && weight > lastWeight) {
                tower[index] = true;
                DFS(index + 1, width, weight);
            }

            tower[index] = false;
            DFS(index + 1, lastWidth, lastWeight);
        }
    }


}