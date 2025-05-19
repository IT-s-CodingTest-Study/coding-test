class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int a : arrayA)
            gcdA = gcd(gcdA, a); // arrayA의 최대공약수
        for (int b : arrayB)
            gcdB = gcd(gcdB, b); // arrayB의 최대공약수

        // 둘 중 큰 값 리턴
        return Math.max(
                isValid(gcdA, arrayB) ? gcdA : 0,
                isValid(gcdB, arrayA) ? gcdB : 0);
    }

    // 최대공약수 구하기
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 나눌 수 없는 수여야 하므로 하나라도 나눠지면 false
    boolean isValid(int divisor, int[] arr) {
        for (int num : arr) {
            if (num % divisor == 0)
                return false;
        }
        return true;
    }
}
