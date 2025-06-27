import java.util.*;
public class 주차요금계산 {
    public List<Integer> solution(int[] fees, String[] records) {
        // 차량 입차하면 추가, 출차하면 삭제
        // <차 번호, 입차 시간>
        Map<String, Integer> parking = new HashMap<>();
        // <차 번호, 총 주차 시간>
        Map<String, Integer> totalFee = new TreeMap<>();

        for(String record : records) {
            // 시간, 차량번호, 내역 순
            String[] temp = record.split(" ");
            int time = getTime(temp[0]);
            String car = temp[1];
            String inOut = temp[2];

            if(inOut.equals("IN")) {
                parking.put(car, time);
            } else {
                totalFee.put(car, totalFee.getOrDefault(car, 0) + time - parking.get(car));
                parking.remove(car);    // 출차한 차는 삭제
            }
        }

        if(!parking.isEmpty()) {
            for(String car : parking.keySet()) {
                Integer fee = totalFee.get(car);
                fee = fee == null ? 0 : fee;
                // 23시 59분에 출차된 것으로 간주
                totalFee.put(car, fee + (23 * 60 + 59) - parking.get(car));
            }
        }

        // 총 주차 요금
        List<Integer> list = new ArrayList<>();
        for(Integer time : totalFee.values()) {
            int baseTime = fees[0];
            int baseFee = fees[1];
            int partTime = fees[2];
            int partFee = fees[3];

            if(time <= baseTime) {
                list.add(baseFee);
            } else {
                int total = (int)(baseFee + Math.ceil((double)(time - baseTime) / partTime) * partFee);
                list.add(total);
            }
        }

        return list;
    }

    // 분 단위 계산
    public int getTime(String str) {
        String[] temp = str.split(":");

        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}
