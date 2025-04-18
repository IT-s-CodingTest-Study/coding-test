import java.util.Arrays;

class StringSort {
    public String[] solution(String[] strings, int n) {
        String[] answer = strings;

        Arrays.sort(answer, (s1, s2) -> {
            if (s1.charAt(n) == s2.charAt(n)) {
                return s1.compareTo(s2);
            } else {
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        });

        return answer;
    }
}