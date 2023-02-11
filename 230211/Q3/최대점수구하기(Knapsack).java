import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static class Question implements Comparable<Question> {
        public int score;
        public int time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Question question) {
            return question.time - this.time;
        }
    }

    static int n, m, score;
    static ArrayList<Question> questions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        score = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int score  = scanner.nextInt();
            int time  = scanner.nextInt();
            questions.add(new Question(score, time));
        }

        Collections.sort(questions);

        System.out.println(maxScore(0, m));
    }

    private static int maxScore (int index, int totalTime) {
        if (index == n) {
            return 0;
        } else {
            int score = questions.get(index).score;
            int time = questions.get(index).time;
            if (totalTime - time < 0) {
                return maxScore(index + 1, totalTime);
            } else {
                return Math.max(
                        maxScore(index + 1, totalTime),
                        score + maxScore(index + 1, totalTime - time)
                );
            }
        }
    }

}