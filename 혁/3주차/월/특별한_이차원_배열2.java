package 월;

public class 특별한_이차원_배열2 {
    public int solution(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        특별한_이차원_배열2 sol = new 특별한_이차원_배열2();
        int[][] arr1 = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int[][] arr2 = {{19, 498, 258, 587}, {63, 93, 7, 754}, {258, 7, 1000, 723}, {587, 754, 723, 81}};

        System.out.println(sol.solution(arr1));
        System.out.println(sol.solution(arr2));
    }

}
