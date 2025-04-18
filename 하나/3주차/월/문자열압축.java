	class 문자열압축 {
    public int solution(String s) {
        int answer = s.length(); // 최대 길이로 초기화

        for (int step = 1; step <= s.length() / 2; step++) {
            String compression = ""; // 압축된 문자열 저장
            String prev = s.substring(0, step); // 비교할 첫 문자열
            int count = 1;  //prev가 1번 등장해서 1부터 시작

            //step 단위로 문자열을 잘라가며 압축 시작
            for (int j = step; j <= s.length(); j += step) {
                //다음 문자 추출 , 만약 문자열 끝을 넘어가면 남은 부분만 자름
                String sub = (j + step <= s.length()) ? s.substring(j, j + step) : s.substring(j);

                if (prev.equals(sub)) {
                    count++; //같은 문자열일 경우 count증가 (aa)
                } else {
                    //count > 1일땐 반복된 문자이므로 숫자 + 문자 (2a)
                    //count == 1이면 그냥 문자 (a)
                    compression += (count > 1 ? count + prev : prev);
                    prev = sub; //prev 업데이트
                    count = 1; //count 초기화
                }
            }

            //마지막 prev도 처리
            compression += (count > 1 ? count + prev : prev);
            //압축된 문자열 길이 중 가장 짧은걸로 갱신 
            answer = Math.min(answer, compression.length());
        }

        return answer; 
    }
}
