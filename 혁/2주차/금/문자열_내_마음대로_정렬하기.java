package 금;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        문자열_내_마음대로_정렬하기 solution = new 문자열_내_마음대로_정렬하기();
        // 테스트 케이스 1
        String[] strings1 = {"sun", "bed", "car"};
        int n1 = 1;
        String[] result1 = solution.solution(strings1, n1);
        System.out.println(Arrays.toString(result1)); // ["car", "bed", "sun"]

        // 테스트 케이스 2
        String[] strings2 = {"abce", "abcd", "cdx"};
        int n2 = 2;
        String[] result2 = solution.solution(strings2, n2);
        System.out.println(Arrays.toString(result2)); // ["abcd", "abce", "cdx"]
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
        });
        return strings;
    }
}
