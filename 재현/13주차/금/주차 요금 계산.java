import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, List<Time>> map = new HashMap<>();
        
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String t = st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            
            st = new StringTokenizer(t, ":");
            Time time = new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            List<Time> list = map.getOrDefault(number, new ArrayList<>());
            list.add(time);
            map.put(number, list);
        }
        
        for (Map.Entry<Integer, List<Time>> entry : map.entrySet()) {
            List<Time> times = entry.getValue();
            if (times.size() % 2 != 0) {
                times.add(new Time(23, 59));
            }
        }
        
        Map<Integer, Integer> timeMap = new HashMap<>();
        
        for (Map.Entry<Integer, List<Time>> entry : map.entrySet()) {
            int number = entry.getKey();
            List<Time> times = entry.getValue();
            int total = 0;
            
            for (int i = 0; i < times.size(); i += 2) {
                Time in = times.get(i);
                Time out = times.get(i + 1);
                total += (out.hour * 60 + out.minutes) - (in.hour * 60 + in.minutes);
            }
            
            timeMap.put(number, total);
        }
        
        List<int[]> feeList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : timeMap.entrySet()) {
            int number = entry.getKey();
            int time = entry.getValue();
            int fee = fees[1];

            if (time > fees[0]) {
                fee += Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            }

            feeList.add(new int[]{number, fee});
        }

        feeList.sort(Comparator.comparingInt(a -> a[0]));

        int[] answer = new int[feeList.size()];
        for (int i = 0; i < feeList.size(); i++) {
            answer[i] = feeList.get(i)[1];
        }
        
        return answer;
    }
}

class Time {
    int hour, minutes;
    Time(int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }
}