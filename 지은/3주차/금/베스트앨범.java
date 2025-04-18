import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 수 저장
        HashMap<String, Integer> genrePlayCount = new HashMap<>(); 
        // 장르별로 노래들을 [인덱스, 재생수]로 저장
        HashMap<String, List<int[]>> genreSongMap = new HashMap<>();

        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            // 해당 장르 총 재생 수 합산
            if (genrePlayCount.containsKey(genre)) {
                genrePlayCount.put(genre, genrePlayCount.get(genre) + play);
            } else {
                genrePlayCount.put(genre, play);
            }

            // 해당 장르에 곡 리스트가 없으면 새로 만들고, 곡 정보 추가
            if (!genreSongMap.containsKey(genre)) {
                genreSongMap.put(genre, new ArrayList<>());
            }
            // 현재 곡의 [인덱스, 재생수]를 추가
            genreSongMap.get(genre).add(new int[]{i, play});
        }

        // 장르 리스트 뽑고 총 재생수 기준으로 정렬
        String[] genreList = new String[genrePlayCount.size()];
        int idx = 0;
        Iterator<String> it = genrePlayCount.keySet().iterator();
        while (it.hasNext()) {
            genreList[idx++] = it.next();
        }

        // 총 재생수 기준 내림차순 정렬
        Arrays.sort(genreList, new Comparator<String>() {
            public int compare(String a, String b) {
                return genrePlayCount.get(b) - genrePlayCount.get(a);
            }
        });

        // 최종 결과 담을 동적 배열 선언
        List<Integer> answerList = new ArrayList<>();

        // 정렬된 장르 순서대로 하나씩 처리
        for (int i = 0; i < genreList.length; i++) {
            String genre = genreList[i];
            // 해당 장르의 곡 리스트 꺼냄
            List<int[]> songs = genreSongMap.get(genre);

            // 정렬: 재생 수 내림차순, 인덱스 오름차순
            Collections.sort(songs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (b[1] != a[1]) {
                        return b[1] - a[1]; // 재생 수 큰 게 먼저
                    } else {
                        return a[0] - b[0]; // 인덱스 작은 게 먼저
                    }
                }
            });

            // 정렬된 곡 리스트에서 2곡까지 추출
            answerList.add(songs.get(0)[0]); // 가장 많이 재생
            if (songs.size() > 1) {
                answerList.add(songs.get(1)[0]); // 두번째로 많이 재생
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
