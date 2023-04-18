public class Main {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode answerList = new ListNode();
        ListNode dummy = answerList;
        while(list1 !=null && list2 != null) {
            if(list1.val > list2.val) {
                answerList.next = list2;
                list2 = list2.next;
            } else {
                answerList.next = list1;
                list1 = list1.next;
            }
            answerList = answerList.next;
        }

        while(list1 != null) {
            answerList.next = list1;
            list1 = list1.next;
        }


        while(list2 != null) {
            answerList.next = list2;
            list2 = list2.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode list1 = new ListNode(-9, new ListNode(3));
        ListNode list2 = new ListNode(5, new ListNode(7));
        mergeTwoLists(list1, list2);
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
