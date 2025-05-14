public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 3x3부터 yellow가 칠해질 공간이 있다
        int carpet = brown + yellow;
        for(int i = 3; i <= carpet; i++) {
            int height = i;
            int width = carpet / i;

            if(width < 3) continue;

            if(width >= height) {
                // (가로 - 2) * (세로 - 2)를 한 값이 yellow 개수
                if((width - 2) * (height - 2) == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}
