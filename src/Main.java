public class Main {

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode head = new ListNode(1);
        removeNthFromEnd(head, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(head.val, head.next);

        int size = 1;
        while (temp.next != null) {
            size += 1;
            temp = temp.next;
        }

        int removeNumber = size - n;
        ListNode answer = new ListNode();
        ListNode returnNode = answer;
        for (int i = 0; i < size; i++) {
            if (i != removeNumber) {
                answer.next = new ListNode(head.val);
                answer = answer.next;
            }
            head = head.next;
        }

        return returnNode.next;
    }

    private static class ListNode {
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
