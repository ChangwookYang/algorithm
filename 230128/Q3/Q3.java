import java.util.ArrayList;
import java.util.Scanner;

class Time implements Comparable<Time> {
    int time;
    char state;

    public Time(int time, char state) {
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(Time time) {
        if (this.time == time.time) return this.state - time.state;
        else return this.time - time.time;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Time> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            list.add(new Time(start, 's'));
            int end = scanner.nextInt();
            list.add(new Time(end, 'e'));
        }

        list.sort(Time::compareTo);

        int cnt = 0;
        int answer = 0;
        for (Time time : list) {
            if(time.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}