import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // 장르, 총 재생 횟수로 저장
        HashMap<String, Integer> playCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        // 장르 저장
        ArrayList<String> sortGenres = new ArrayList<>(playCount.keySet());
        // 재생 횟수 많은 순으로 장르 정렬(내림차순)
        sortGenres.sort((s1, s2) -> playCount.get(s2).compareTo(playCount.get(s1)));

        ArrayList<Integer> result = new ArrayList<>();
        for(String g : sortGenres) {
            // [인덱스 번호, 재생 횟수] 형태로 저장
            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++){
                if(genres[i].equals(g)){
                    list.add(new int[] {i, plays[i]});
                }
            }
            // 재생 횟수 많은 순으로 정렬(내림차순)
            list.sort((a, b) -> {
                // 재생 횟수 같다면 인덱스 번호 작은거부터 정렬
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            });
            // 리스트 크기보다 작거나 2번까지만 반복하면서 인덱스번호 저장
            for (int i = 0; i < list.size() && i < 2; i++) {
                result.add(list.get(i)[0]);
            }
        }
        answer = result.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
