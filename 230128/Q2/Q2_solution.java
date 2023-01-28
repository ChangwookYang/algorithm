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
        if (this.end == meeting.end) return this.start - meeting.start;
        else return this.end - meeting.end;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Meeting(start, end));
        }

        list.sort(Meeting::compareTo);

        int cnt = 0;
        int endTime = 0;
        for (Meeting meeting : list) {
            if (meeting.start >= endTime) {
                cnt++;
                endTime = meeting.end;
            }
        }

        System.out.println(cnt);
    }
}