class Solution {
    public int solution(String s) {
        int minLength = s.length(); // 압축 길이 중 가장 짧은 길이를 저장할 변수

        // 1~문자열 절반까지 자르면서 확인
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            String result = ""; // 압축 결과 문자열
            String prev = s.substring(0, unit); // 처음 잘라낸 문자열
            int count = 1; // 반복 횟수

            // unit 단위로 문자열 순회하며 비교
            for (int i = unit; i < s.length(); i += unit) {
                // 다음 잘라낼 문자열
                int end = Math.min(i + unit, s.length());
                String current = s.substring(i, end);

                if (current.equals(prev)) { // 현재와 이전 조각이 같으면 반복 횟수 증가
                    count++;
                } else {
                    // 반복된 게 2 이상이면 숫자 + 문자열로 압축하기
                    if (count > 1)
                        result += count + prev;
                    else
                        result += prev;

                    // 새로운 조각으로 prev 갱신, count 초기화
                    prev = current;
                    count = 1;
                }
            }

            // 마지막 남은 문자열 처리
            if (count > 1)
                result += count + prev;
            else
                result += prev;

            // 최소 길이 갱신하기
            if (result.length() < minLength) {
                minLength = result.length();
            }
        }

        return minLength;
    }
}
