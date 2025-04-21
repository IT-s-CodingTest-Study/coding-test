import java.util.*;
class 베스트앨범 {
	public int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		List<Integer> result = new ArrayList<>();
		Map<String, Map <Integer, Integer>> song = new HashMap<>();
		Map<String, Integer> total = new HashMap<>();
		for(int i = 0; i < genres.length; i++){
			if(!total.containsKey(genres[i])){
				Map<Integer, Integer> map = new HashMap<>();
				map.put(i, plays[i]);
				song.put(genres[i], map);
				total.put(genres[i], plays[i]);
			} else {
				song.get(genres[i]).put(i, plays[i]);
				total.put(genres[i], total.get(genres[i]) + plays[i]);
			}
		}

		List<String> keys = new ArrayList(total.keySet());
		Collections.sort(keys, (s1, s2) -> total.get(s2) - (total.get(s1)));

		for(String key : keys){
			Map<Integer, Integer> map = song.get(key);
			List<Integer> genre = new ArrayList(map.keySet());
			Collections.sort(genre, (s1, s2) -> map.get(s2) - (map.get(s1)));
			result.add(genre.get(0));
			if(genre.size() > 1){
				result.add(genre.get(1));
			}
		}
		answer = new int[result.size()];
		for(int i = 0; i < result.size(); i++){
			answer[i] = result.get(i);
		}

		return answer;
	}
}