import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
//        String[] keymap = new String[]{"ABACD", "BCEFD"};
//        String[] targets = new String[]{"ABCD", "AABB"};
        String[] keymap = new String[]{"AGB", "BSSS"};
        String[] targets = new String[]{"AGZ", "BSSS"};
        int[] solution = solution(keymap, targets);
        for (int sol : solution) {
            System.out.println(sol);
        }
    }

    public static int[] solution(String[] keymap, String[] targets) {
        ArrayList<Integer> list = new ArrayList<>();

        for (String target : targets) {
            int cnt = 0;
            // target 기준 for문
            boolean isSelected = true;
            for (int i = 0; i < target.length(); i++) {
                isSelected = false;
                // key 값 기준
                for (int keyIndex = 0; keyIndex < 100 && !isSelected; keyIndex++) {
                    for (String key : keymap) {
                        if (keyIndex >= key.length()) {
                            // 초과할 경우 무시
                            continue;
                        } else {
                            if (key.charAt(keyIndex) == target.charAt(i)) {
                                isSelected = true;
                                cnt += (keyIndex + 1);
                                break;
                            }
                        }
                    }
                }
                if(!isSelected) break;
            }
            if(!isSelected || cnt == 0) list.add(-1);
            else list.add(cnt);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}