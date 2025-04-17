import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        Music[] musics = new Music[len];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            musics[i] = new Music(genres[i], plays[i], i);
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        Arrays.sort(musics, (a, b) -> {
            return b.play - a.play;
        });

        List<String> genreList = new ArrayList<>(map.keySet());
        Collections.sort(genreList, (a, b) -> map.get(b) - map.get(a));

        List<Integer> result = new ArrayList<>();
        for (String genre : genreList) {
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (musics[i].genre.equals(genre)) {
                    result.add(musics[i].index);
                    count++;
                }
                if (count == 2) break;
            }

        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;

    }
}

class Music {
    String genre;
    int play;
    int index;

    Music (String genre, int play, int index) {
        this.genre = genre;
        this.play = play;
        this.index = index;
    }
}