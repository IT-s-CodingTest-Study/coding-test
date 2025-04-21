package 금;
//베스트앨범
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> songs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
            songs.computeIfAbsent(genres[i], x -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }

        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        List<Integer> answer = new ArrayList<>();
        for (String genre : genreOrder) {
            songs.get(genre).sort((a, b) -> b[1] != a[1] ? b[1] - a[1] : a[0] - b[0]);

            for (int i = 0; i < Math.min(2, songs.get(genre).size()); i++) {
                answer.add(songs.get(genre).get(i)[0]);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
