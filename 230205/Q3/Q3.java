import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        combination = new int[m];
        int level = 0;
        int start = 0;
        DFS(level, start);
    }

    static int[] combination;
    private static void DFS(int level, int start) {
        if (level == m) { // m개 뽑았을때
            for (int value : combination) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < n; i++) {
                // 시작점부터 n개까지 뽑아내야함
                combination[level] = i;
                DFS(level + 1, i + 1);
            }
        }

    }


}