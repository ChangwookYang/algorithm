import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture> {
    public int money;
    public int day;

    public Lecture(int money, int day) {
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture time) {
        return time.day - this.day;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Lecture> list = new ArrayList<>();

        int maxDay = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int money = scanner.nextInt();
            int day = scanner.nextInt();
            list.add(new Lecture(money, day));

            maxDay = Math.max(maxDay, day);
        }
        Collections.sort(list);

        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());

        int answer = 0;
        int i = 0;
        for (int day = maxDay; day > 0; day--) {

            for (; i < list.size(); i++) {
                if (list.get(i).day == day) {
                    pQ.offer(list.get(i).money);
                } else break;
            }

            if (!pQ.isEmpty())
                answer += pQ.poll();
        }

        System.out.println(answer);
    }
}