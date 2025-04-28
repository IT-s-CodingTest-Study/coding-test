import java.util.*;
class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        // <숫자, 개수> 형태로 정의
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(String operation : operations) {
            String[] str = operation.split(" ");
            String op = str[0];                     // 명령어
            int num = Integer.parseInt(str[1]);     // 숫자
            if(op.equals("I")) {
                // 키가 중복될 시 갯수 추가
                tree.put(num, tree.getOrDefault(num, 0) + 1);
            } else if(op.equals("D") && !tree.isEmpty()) {
                // num이 1이면 최댓값, -1이면 최솟값
                int key = (num == 1) ? tree.lastKey() : tree.firstKey();
                if(tree.get(key) == 1) {
                    tree.remove(key);
                } else {
                    tree.put(key, tree.get(key) - 1);
                }
            }
        }

        return tree.isEmpty() ? new int[]{0, 0} : new int[]{tree.lastKey(), tree.firstKey()};
    }
}