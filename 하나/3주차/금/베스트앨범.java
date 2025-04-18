import java.util.*;

class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, List<Song>> musicList = new HashMap<>();

        //  장르별 총 재생수, 장르별 노래 리스트 생성
        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);

            musicList.putIfAbsent(genres[i], new ArrayList<>());
            musicList.get(genres[i]).add(new Song(i, plays[i])); // id, plays
        }

        //  장르별 총 재생수 기준 정렬
        List<String> genreOrder = new ArrayList<>(total.keySet());
        genreOrder.sort((a, b) -> total.get(b) - total.get(a));

        List<Integer> result = new ArrayList<>();

        //장르 순서대로 최대 2곡
        for (String genre : genreOrder) {
            List<Song> songs = musicList.get(genre);

            // 재생 많은 순 , 고유 번호 낮은 순
            songs.sort((s1, s2) -> {
                if (s1.plays == s2.plays) return s1.id - s2.id;
                return s2.plays - s1.plays;
            });

            // 장르당 2곡
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i).id);
            }
        }

        // 결과 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}

// Song 클래스 정의
class Song {
    int id;
    int plays;

    public Song(int id, int plays) {
        this.id = id;
        this.plays = plays;
    }
}
