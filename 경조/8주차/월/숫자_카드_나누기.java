public class 숫자_카드_나누기 {
    public int solution(int[] arrayA, int[] arrayB) {
        // arrayA, arrayB의 최대공약수 저장
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        int answer = 0;

        // arrayA의 최대공약수로 나눠지지 않을 경우 max 값 저장
        if(isNotDivisible(gcdA, arrayB)) answer = Math.max(answer, gcdA);
        // arrayB의 최대공약수로 나눠지지 않을 경우 max 값 저장
        if(isNotDivisible(gcdB, arrayA)) answer = Math.max(answer, gcdB);

        return answer;
    }

    // 최대공약수로 나눠지는지 확인하는 함수
    private static boolean isNotDivisible(int gcd, int[] arr) {
        for(int num : arr) {
            // 다른 쪽 배열의 최대공약수로 나눠질 경우 false
            if(num % gcd == 0) return false;
        }
        return true;
    }

    // 최대공약수 구하기
    private static int gcd(int a, int b) {
        while(b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private static int getGCD(int[] arr) {
        int result = arr[0];
        for(int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
}
