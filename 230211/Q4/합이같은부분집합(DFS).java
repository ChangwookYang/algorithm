import java.util.Scanner;

public class Main {

    static int n, sum;
    static int[] arr;
    static boolean isExist = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        sum = 0;
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i];
        }

        DFS(0, 0);

        if (isExist)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static void DFS(int index, int tempSum) {
        if (index == n) {
            if (tempSum == sum - tempSum)
                isExist = true;
        } else {
            DFS(index + 1, tempSum + arr[index]);
            DFS(index + 1, tempSum);
        }
    }


}