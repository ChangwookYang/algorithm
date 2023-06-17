import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ListNode[] node = new ListNode[] {
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };


        ListNode listNode = mergeKLists2(node);
        while (listNode != null) {
            System.out.println(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public static ListNode mergeKLists2(ListNode[] lists) {
        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i < lists.length - interval; i += 2 * interval) {
                ListNode listNode1 = lists[i];
                ListNode listNode2 = null;
                if(i+interval < lists.length) {
                    listNode2 = lists[i + interval];
                }
                lists[i] = mergeTwoList(listNode1, listNode2);
            }
            interval = interval * 2;
        }

        return lists[0];
    }

    private static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode(0);
        ListNode returnNode = merged;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }

        while (list1 != null) {
            merged.next = new ListNode(list1.val);
            list1 = list1.next;
            merged = merged.next;
        }

        while (list2 != null) {
            merged.next = new ListNode(list2.val);
            list2 = list2.next;
            merged = merged.next;
        }

        return returnNode.next;
    }


    public static ListNode mergeKLists1(ListNode[] lists) {
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


