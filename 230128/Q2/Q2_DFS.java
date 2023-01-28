import java.util.ArrayList;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting meeting) {
        return this.start - meeting.start;
    }
}

public class Main {

    static ArrayList<Meeting> list = new ArrayList<>();
    static int n;
    static int totalCnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        list.add(new Meeting(0, 0));
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Meeting(start, end));
        }

        list.sort(Meeting::compareTo);

        DFS(0, 0, 0, 0, 0);

        System.out.println(totalCnt);
    }

    static void DFS(int index, int cnt, int lastEnd, int start, int end) {
        if (lastEnd > start) {
            if(cnt > totalCnt) totalCnt = cnt;
        } else {
            for (int i = index + 1; i <= n; i++) {
                DFS(i, cnt + 1, end, list.get(i).start, list.get(i).end);
            }
        }
    }
}