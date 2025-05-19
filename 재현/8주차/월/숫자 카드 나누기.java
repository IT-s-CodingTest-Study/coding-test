class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int A_GCD = getGCD(arrayA);
        int B_GCD = getGCD(arrayB);
                
        boolean isDivisor = false;
        for (int num : arrayA) {
            if (num % B_GCD == 0) {
                isDivisor = true;
                break;
            }
        }
        if (!isDivisor) 
            answer = Math.max(answer, B_GCD);
        
        isDivisor = false;
        for (int num : arrayB) {
            if (num % A_GCD == 0) {
                isDivisor= true;
                break;
            }
        }
        if (!isDivisor) 
            answer = Math.max(answer, A_GCD);
        
        return answer;
    }
    
    public int getGCD(int[] arr) {
        int result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
    
}