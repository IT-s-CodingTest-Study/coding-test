public class 특별한이차원배열2 {
    public int soultion(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return answer;
                }
            }
        }
        answer = 1;
        return answer;
    }
}
