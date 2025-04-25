import java.util.*;

class Solution {
	public int[] solution(String[] operations) {
		TreeMap<Integer, Integer> tree = new TreeMap<>();

		for (String op : operations) {
			String[] str = op.split(" ");
			int num = Integer.parseInt(str[1]);

			if ("I".equals(str[0])) {
				tree.put(num, tree.getOrDefault(num, 0) + 1);
			} else {
				if (tree.isEmpty()) continue;

				int key = (num == 1) ? tree.lastKey() : tree.firstKey();
				if (tree.get(key) == 1) {
					tree.remove(key);
				} else {
					tree.put(key, tree.get(key) - 1);
				}
			}
		}

		if (tree.isEmpty()) return new int[]{0, 0};

		return new int[]{tree.lastKey(), tree.firstKey()};
	}
}
