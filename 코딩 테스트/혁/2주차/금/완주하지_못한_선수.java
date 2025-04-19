package 금;
import java.util.HashMap;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        완주하지_못한_선수 solution = new 완주하지_못한_선수();
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution.solution(participant1, completion1));
    }

    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }
        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                return name;
            }
        }
        return "";
    }
}
