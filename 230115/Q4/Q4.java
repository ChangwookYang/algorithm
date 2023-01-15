import java.util.Scanner;

public class Main {

    static int n, count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        count = 0;

        DFS(0);

        System.out.println(count);
    }

    private static void DFS(int stone) {
        if (stone >= n) {
            count++;
        } else {
            DFS(stone + 1);
            DFS(stone + 2);
        }
    }


}
