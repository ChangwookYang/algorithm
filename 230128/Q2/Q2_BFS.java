import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Meeting implements Comparable<Meeting> {
    int index;
    int start;
    int end;

    public Meeting(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting meeting) {
        return this.start - meeting.start;
    }
}

public class Main {

    static Queue<Meeting> queue = new LinkedList<>();
    static ArrayList<Meeting> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        queue.offer(new Meeting(0, 0, 0));
        list.add(new Meeting(0, 0, 0));

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Meeting(i + 1, start, end));
        }
        list.sort(Meeting::compareTo);
        System.out.println(BFS());
    }

    static int BFS() {
        int cnt = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt = cnt + 1;

            for (int i = 0; i < size; i++) {
                Meeting meeting = queue.poll();
                int index = meeting.index;
                for (int j = index; j < list.size(); j++) {
                    if (list.get(j).start >= meeting.end && list.get(j).start != meeting.start) {
                        queue.add(list.get(j));
                    }
                }
            }
        }

        return cnt;
    }
}