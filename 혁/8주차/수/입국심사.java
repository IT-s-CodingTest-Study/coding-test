package 수;

// n = 6  times = [7, 10] return 28

public class 입국심사 {

    public long countPerson(int[] times, long t) {
        long total = 0;
        for (int time : times) {
            total += t / time;
        }
        return total;
    }

    int getMax(int []arr){
        int max = arr[0];
        for (int a : arr) {
            max = Math.max(max, a);
        }
        return max;
    }

    public long solution(int n, int[] times) {
        long min = 1;
        long max = (long) getMax(times) * n;
        long answer = max;
        while (min <= max) {
            long center = (min + max) / 2;
            long processed = countPerson(times, center);
            if (processed >= n) {
                answer = center;
                max = center - 1;
            }else{
                min = center + 1;
            }
        }
        return answer;
    }
}
