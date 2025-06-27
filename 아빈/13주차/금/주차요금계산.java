import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
class 주차요금 계산 {
	public int[] solution(int[] fees, String[] records) throws Exception{
		List<Integer> answer = new ArrayList<>();
		Map<String, String> inRecordMap = new HashMap<>();
		Map<String, Integer> totalMap = new TreeMap<>();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		for(String record : records) {
			String[] r = record.split(" ");
			String time = r[0];
			String car = r[1];
			String type = r[2];
			if(type.equals("IN")){
				inRecordMap.put(car, time);
			} else {
				String inTime = inRecordMap.get(car);
				Date in = format.parse(inTime);
				Date out = format.parse(time);
				long difference = out.getTime() - in.getTime();
				long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
				totalMap.put(car, totalMap.getOrDefault(car, 0) + (int) minutes);
				inRecordMap.remove(car);
			}
		}

		for(String car : inRecordMap.keySet()){
			String inTime = inRecordMap.get(car);
			Date in = format.parse(inTime);
			Date out = format.parse("23:59");
			long difference = out.getTime() - in.getTime();
			long minutes = TimeUnit.MILLISECONDS.toMinutes(difference);
			totalMap.put(car, totalMap.getOrDefault(car, 0) + (int) minutes);
		}

		for(String car : totalMap.keySet()) {
			int time = totalMap.get(car);
			if(time <= fees[0]) {
				answer.add(fees[1]);
			} else {
				answer.add(fees[1] + (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3]);
			}
		}
		return answer.stream().mapToInt(i -> i).toArray();
	}
}