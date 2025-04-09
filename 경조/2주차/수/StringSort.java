import java.util.Arrays;

class StringSort {
    public String[] StringSort(String[] strings, int n) {
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

    public static void main(String[] args) {
        StringSort sol = new StringSort();

        String[] test1 = {"sun", "bed", "car"};
        int n1 = 1;
        System.out.println("테스트 1 결과: " + Arrays.toString(sol.StringSort(test1, n1)));
        // 기대 출력: [car, bed, sun]

        String[] test2 = {"abce", "abcd", "cdx"};
        int n2 = 2;
        System.out.println("테스트 2 결과: " + Arrays.toString(sol.StringSort(test2, n2)));
        // 기대 출력: [abcd, abce, cdx]
    }
}
