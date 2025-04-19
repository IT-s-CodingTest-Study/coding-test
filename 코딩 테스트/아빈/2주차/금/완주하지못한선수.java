import java.util.*;
class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> partiMap = new HashMap<>();
		for(int i = 0; i < participant.length; i++){
			if(partiMap.containsKey(participant[i])){
				partiMap.put(participant[i], partiMap.get(participant[i]) + 1);
				continue;
			}
			partiMap.put(participant[i], 1);
		}

		for(int i = 0; i < completion.length; i++){
			if(partiMap.get(completion[i]) > 1) {
				partiMap.put(completion[i], partiMap.get(completion[i]) - 1);
				continue;
			}
			partiMap.remove(completion[i]);
		}
		for(String key : partiMap.keySet()){
			answer = key;
		}
		return answer;
	}
}