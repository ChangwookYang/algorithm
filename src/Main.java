import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);

        for (List<Integer> list : lists) {
            String answer = "";
            for (Integer integer : list) {
                answer += integer + ",";
            }
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> lists = new ArrayList<>();

    // dfs
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(candidates[i]);

            next(candidates, list, i, target - candidates[i]);
        }

        return lists;
    }

    private static void next(int[] candidates, List<Integer> answer, int index, int target) {
        if (target == 0) {
            List<Integer> list = new ArrayList<>(answer);
            lists.add(list);
        } else if (target > 0) {
            int answerIndex = answer.size();
            for (int i = index; i < candidates.length; i++) {
                int temp = target - candidates[i];
                if (temp >= 0) {
                    answer.add(answerIndex, candidates[i]);
                    next(candidates, answer, i, target - candidates[i]);
                    answer.remove(answerIndex);
                }
            }
        }
    }
}
