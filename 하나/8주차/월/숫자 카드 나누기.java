import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
 
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int a : arrayA){
            gcdA = gcd(gcdA, a);
        }
        
         for(int b : arrayB){
            gcdB = gcd(gcdB, b);
        }
        
        int checkA = check(gcdA, arrayB);
        int checkB = check(gcdB, arrayA);
        
        return Math.max(checkA, checkB);
    }
    
    //최대 공약수 구하기
    public int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
    
    //한 쪽 배열이 최대 공약수로 안 나누어지는지 검증
    public int check(int gcd, int[] array){
        for(int arr : array){
            if(arr % gcd == 0 ) return 0;
        }
        return gcd;
    }
}
