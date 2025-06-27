import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        Map<String, Integer> times = new HashMap<>();  // 주차 시간 저장
        Map<String, Integer> inTime = new HashMap<>(); // 입차 시간 저장

        // 입/출차 기록 처리
        for (String r : records) {
            String[] s = r.split(" "); 
            int time = toMinute(s[0]);  // 분 단위 시간으로 변환
            String car = s[1];          // 차량 번호

            // 입차인 경우 기록
            if (s[2].equals("IN")) {
                inTime.put(car, time);
            }
            // 출차인 경우: 입차시간부터 주차시간 계산
            else {
                int in = inTime.remove(car);  
                times.put(car, times.getOrDefault(car, 0) + (time - in));
            }
        }

        // 남아있는 차 처리 -> 23:59에 출차한 것으로 간주
        for (String car : inTime.keySet()) {
            int in = inTime.get(car);
            int out = toMinute("23:59");
            times.put(car, times.getOrDefault(car, 0) + (out - in));
        }

        // 차량 번호 정렬
        List<String> cars = new ArrayList<>(times.keySet());
        Collections.sort(cars);

        // 요금 계산
        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int t = times.get(cars.get(i));    // 주차 시간
            answer[i] = calculate(fees, t);    // 요금 계산
        }
        return answer;
    }

    // "HH:MM" 형식의 시간을 분 단위 숫자로 바꾸는 함수
    int toMinute(String time) {
        String[] t = time.split(":"); 
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }

    // 주차 시간 t에 대해 요금 계산
    int calculate(int[] f, int t) {
        int baseTime = f[0], baseFee = f[1];
        int unitTime = f[2], unitFee = f[3];

        // 기본 시간 이하면 기본 요금
        if (t <= baseTime) return baseFee;

        // 초과 시간이면 단위 시간으로 나눠서 올림 계산 후 요금
        int over = t - baseTime;
        int units = (int)Math.ceil(over / (double)unitTime);
        return baseFee + units * unitFee;
    }
}
