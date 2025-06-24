import java.util.*;
class 광물캐기 {
	public int solution(int[] picks, String[] minerals) {
		int answer = 0;

		// 광물 묶음을 저장  dia, iron, stone 순으로 개수 배열을 저장
		List<int[]> mineralList = new ArrayList<>();

		//사용 가능한 곡괭이 총 개수
		int total = picks[0] + picks[1] + picks[2];

		// 캘 수 있는 광물 묶음의 개수 (곡괭이 수 or 전체 광물 / 5 중 작은 값)
		int chunkCount = Math.min(minerals.length / 5 + (minerals.length % 5 == 0 ? 0 : 1), total);

		// 광물을 5개 단위로 잘라 각 청크에 개수를 세어 저장
		for(int i = 0; i < chunkCount; i++) {
			int[] chunk = new int[3];

			// minerals에서 현재 묶음의 5개를 종류에 맞게 chunk에 삽입
			for(int j = i * 5; j < Math.min(i * 5 + 5, minerals.length); j++) {
				switch(minerals[j]) {
					case "diamond": chunk[0]++; break;
					case "iron": chunk[1]++; break;
					case "stone": chunk[2]++; break;
				}
			}

			//chunk를 추가
			mineralList.add(chunk);
		}

		//돌 곡괭이로 캤을 때의 피로도 기준으로 내림차순 정렬
		//강도 높은 광물은 좋은 곡괭이로 캐야 효율이 좋음
		mineralList.sort((a, b) ->
			(b[0] * 25 + b[1] * 5 + b[2]) - (a[0] * 25 + a[1] * 5 + a[2]));

		//각 광물 묶음을 순회하며 곡괭이 할당
		for(int[] chunk : mineralList) {
			if(picks[0] > 0) {
				answer += chunk[0] * 1 + chunk[1] * 1 + chunk[2] * 1;
				picks[0]--;//곡괭이 사용
			} else if(picks[1] > 0) {
				answer += chunk[0] * 5 + chunk[1] * 1 + chunk[2] * 1;
				picks[1]--;
			} else if(picks[2] > 0) {
				answer += chunk[0] * 25 + chunk[1] * 5 + chunk[2] * 1;
				picks[2]--;
			}
		}
		return answer;

	}
}