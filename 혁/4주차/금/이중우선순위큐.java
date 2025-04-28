import java.util.*;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (String op : operations) {

            String[] parts = op.split(" ");
            String cmd = parts[0];
            int num = Integer.parseInt(parts[1]);

            if (cmd.equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else if (cmd.equals("D")) {
                if (map.isEmpty()) continue;

                int key = (num == 1) ? map.lastKey() : map.firstKey();
                int count = map.get(key);

                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }

        if (map.isEmpty()) {
            return new int[]{0, 0};
        } else {
            return new int[]{map.lastKey(), map.firstKey()};
        }
    }
}
