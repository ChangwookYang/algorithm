import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeList = new ArrayList<>();

        for (ListNode node : lists) {
            while (node != null) {
                nodeList.add(node.val);
                node = node.next;
            }
        }

        Collections.sort(nodeList);


        ListNode dummy = new ListNode(0);
        ListNode answer = dummy;
        for (Integer val : nodeList) {
            dummy.next = new ListNode(val);
            dummy = dummy.next;
        }

        return answer.next;
    }

    public class ListNode {
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


