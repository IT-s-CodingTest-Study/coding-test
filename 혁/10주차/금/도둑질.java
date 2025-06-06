package 금;

public class 도둑질 {
    public int solution(int[] arr) {
        int n = arr.length;
        if (n == 3) {
            return Math.max(arr[0], Math.max(arr[1], arr[2]));
        }

        int a = getMax(arr, 0, n - 2);
        int b = getMax(arr, 1, n - 1);

        return Math.max(a, b);
    }

    private int getMax(int[] arr, int s, int e) {
        int prev = 0;
        int curr = 0;

        for (int i = s; i <= e; i++) {
            int temp = Math.max(prev + arr[i], curr);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}

