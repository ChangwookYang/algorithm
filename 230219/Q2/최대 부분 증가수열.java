import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        arr = new int[n];
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(getMaxLength());
    }

    private static int getMaxLength() {
        int max = 1;
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            answer[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (value > arr[j]) {
                    answer[i] = Math.max(answer[i], answer[j] + 1);
                }
            }
            max = Math.max(max, answer[i]);
        }

        return max;
    }
}