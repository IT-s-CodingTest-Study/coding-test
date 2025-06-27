package 금;

import java.util.*;

public class 주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalMap = new TreeMap<>();

        for (String r : records) {
            String[] parts = r.split(" ");
            int time = toMin(parts[0]);
            String car = parts[1];
            if (parts[2].equals("IN")) {
                inMap.put(car, time);
            } else {
                int in = inMap.remove(car);
                totalMap.put(car, totalMap.getOrDefault(car, 0) + (time - in));
            }
        }

        for (String car : inMap.keySet()) {
            int in = inMap.get(car);
            totalMap.put(car, totalMap.getOrDefault(car, 0) + (1439 - in));
        }

        List<Integer> result = new ArrayList<>();
        for (int t : totalMap.values()) {
            if (t <= fees[0]) {
                result.add(fees[1]);
            } else {
                int over = t - fees[0];
                int fee = fees[1] + (int) Math.ceil(over / (double) fees[2]) * fees[3];
                result.add(fee);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    int toMin(String time) {
        String[] h = time.split(":");
        return Integer.parseInt(h[0]) * 60 + Integer.parseInt(h[1]);
    }
}



