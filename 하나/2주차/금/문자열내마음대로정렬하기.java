import java.util.*;

class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
       String[] answer = new String[strings.length];
       HashMap<String, Character> spell = new HashMap<>();

        Arrays.sort(strings); 

        for (String s : strings) {
            spell.put(s, s.charAt(n));
        }

        // keySet을 리스트로 변환해서 정렬
        List<String> keyList = new ArrayList<>(spell.keySet());

        // n번째 문자 기준, 같으면 사전순
        Collections.sort(keyList, (a, b) -> {
            char ca = spell.get(a);
            char cb = spell.get(b);

            if (ca == cb) return a.compareTo(b);
            return Character.compare(ca, cb);
        });

        return keyList.toArray(new String[0]);
    }
}
