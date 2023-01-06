package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Test230106 {

    static int[] checked = new int[10001];
    static int[] jumps = {1, -1, 5};
    public static int bfs(int s, int e) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        checked[s] = 1;

        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer position = queue.poll();
                if (position == e)
                    return count;

                for (int jump : jumps) {
                    int jumpedPosition = position + jump;
                    if(jumpedPosition > 0 && checked[jumpedPosition] == 0) {
                        checked[jumpedPosition] = 1;
                        queue.add(jumpedPosition);
                    }
                }
            }
            count++;
        }
        return 0;
    }
}