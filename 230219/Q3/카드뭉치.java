public class Main {

    public static void main(String[] args) {
        String solution = solution(new String[]{"i", "drink", "water"}
                , new String[]{"want", "to"}
                , new String[]{"i", "want", "to", "drink", "water"});

        System.out.println(solution);
    }

    static String answer = "No";

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        DFS(0, 0, 0, cards1, cards2, goal);

        return answer;
    }

    public static void DFS(int index1, int index2, int goalIndex,
                           String[] cards1, String[] cards2, String[] goal) {
        if (goalIndex == goal.length) {
            answer = "YES";
        } else {
            if (index1 < cards1.length && cards1[index1].equals(goal[goalIndex])) {
                DFS(index1 + 1, index2, goalIndex + 1, cards1, cards2, goal);
            }

            if (index2 < cards2.length && cards2[index2].equals(goal[goalIndex])) {
                DFS(index1, index2 + 1, goalIndex + 1, cards1, cards2, goal);
            }
        }
    }
}