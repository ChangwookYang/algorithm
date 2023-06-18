import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{0});

        for (List<Integer> list : subsets) {
            for (Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> result = new ArrayList<>();
    static boolean[] include;

    public static List<List<Integer>> subsets(int[] nums) {
        include = new boolean[nums.length];
        result.add(new ArrayList<>());
        dfs(nums, 0, include);

        return result;
    }

    private static void dfs(int[] nums, int index, boolean[] include) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                if (include[i]) {
                    list.add(nums[i]);
                }
            }
            result.add(list);
        } else {
            include[index] = true;
            dfs(nums, index + 1, include);
            include[index] = false;
            dfs(nums, index + 1, include);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


