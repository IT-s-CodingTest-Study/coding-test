import java.util.*;
class 문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
		String[] answer = new String [strings.length];      //최종 반환할 answer을 strings의 길이만큼 선언
		List<String> strList = new ArrayList<>();           // 정렬에 활용할 List선언
		for(int i = 0; i < answer.length; i++){             // 리스트에 비교할 문자와 단어를 합친 새로운 문자열을 삽입
			strList.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(strList);                          // 만약 첫 번째 문자와 비교했을때 같다면 비교할 문자열을 사전적으로 비교하도록 하여 정렬
		for(int i = 0; i < answer.length; i++){             // 앞의 반복문에서 만든 새로운 문자열에서 첫 번째 문자를 제거하고 answer에 삽입
			answer[i] = strList.get(i).substring(1);
		}
		return answer;
	}
}