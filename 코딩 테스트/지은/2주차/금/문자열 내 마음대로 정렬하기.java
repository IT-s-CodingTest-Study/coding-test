class Solution {
    public String[] solution(String[] strings, int n) {
        // n번째 문자를 앞에 붙여서 새로운 문자열 변경
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }

        // 정렬
        java.util.Arrays.sort(strings);

        // 앞에 붙인 문자 제거하고 원래 문자열로 복구
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }

        return strings;
    }
}

