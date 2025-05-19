package 월;

public class 숫자_카드_나누기 {
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    int getArrayGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    int getMax(int gcd, int[] opp) {
        for (int i = gcd; i >= 2; i--) {
            if (gcd % i != 0) continue;

            boolean valid = true;
            for (int num : opp) {
                if (num % i == 0) {
                    valid = false;
                    break;
                }
            }
            if (valid) return i;
        }
        return 0;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        int a = getArrayGCD(arrayA);
        int b = getArrayGCD(arrayB);
        int aC = getMax(a, arrayB);
        int bC = getMax(b, arrayA);
        return Math.max(aC, bC);
    }
}
