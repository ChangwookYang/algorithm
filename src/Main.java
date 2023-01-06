import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt = rt = null;
    }
}

public class Main {
    Node root;

    public static int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else
            return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
    }

    public static int BFS(Node root) {
        int L = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.lt == null && node.rt == null) {
                    return L;
                } else {
                    if(node.lt != null)
                        queue.offer(node.lt);
                    if(node.rt != null)
                        queue.offer(node.rt);
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Main tree = new Main();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        int result = DFS(0, tree.root);
        int result2 = BFS(tree.root);
        System.out.println(result);
        System.out.println(result2);
    }

}
