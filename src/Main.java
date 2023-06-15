import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] plus = new int[]{-1, 0, 1};

    public static void main(String[] args) {
        int result = maxLevelSum(new TreeNode(1));
    }

    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int max = Integer.MIN_VALUE;
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            int sum = 0;
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            if (sum > max) {
                max = sum;
                maxLevel = level;
            }
            level++;
        }

        return maxLevel;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


