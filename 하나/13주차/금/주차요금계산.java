import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
        Map<String, Integer> map = new HashMap<>(); 
        Map<String, Integer> inMap = new HashMap<>();

        for (String record : records) {
            String[] r = record.split(" ");
            String[] time = r[0].split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String car = r[1];
            String type = r[2];

            if (type.equals("IN")) {
                inMap.put(car, minute);
            } else {
                int inTime = inMap.remove(car);
                int duration = minute - inTime;
                map.put(car, map.getOrDefault(car, 0) + duration);
            }
        }

        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int duration = (23 * 60 + 59) - inTime;
            map.put(car, map.getOrDefault(car, 0) + duration);
        }

        List<String> cars = new ArrayList<>(map.keySet());
        Collections.sort(cars);
        int[] result = new int[cars.size()];

        for (int i = 0; i < cars.size(); i++) {
            String car = cars.get(i);
            int time = map.get(car);

            if (time <= baseTime) {
                result[i] = baseFee;
            } else {
                int extra = time - baseTime;
                int fee = baseFee + (int) Math.ceil((double) extra / unitTime) * unitFee;
                result[i] = fee;
            }
        }

        return result;
    }
}
