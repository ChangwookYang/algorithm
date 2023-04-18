import java.util.ArrayList;
import java.util.List;

public class MyLinkedList {
    List<Integer> list;

    public MyLinkedList() {
        list = new ArrayList<Integer>();
    }

    public int get(int index) {
        return list.get(index);
    }

    public void addAtHead(int val) {
        list.add(0, val);
    }

    public void addAtTail(int val) {
        list.add(val);
    }

    public void addAtIndex(int index, int val) {
        list.add(index, val);
    }

    public void deleteAtIndex(int index) {
        list.remove(index);
    }
}
