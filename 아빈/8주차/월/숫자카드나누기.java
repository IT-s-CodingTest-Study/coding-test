import java.util.*;
// class Solution {
// 	public int solution(int[] arrayA, int[] arrayB) {
// 		int answer = 0;
// 		int maxA = Arrays.stream(arrayA).max().getAsInt();
// 		int maxB = Arrays.stream(arrayB).max().getAsInt();
// 		int big = Math.max(maxA, maxB);
// 		boolean a = false;
// 		boolean b = false;
// 		for(int i = 1; i <= big; i++){
// 			for(int j = 0; j < arrayA.length; j++){
// 				if(arrayA[j] % i != 0){
// 					a = false;
// 					break;
// 				} else if(arrayA[j] % i == 0 && arrayB[j] % i != 0) {
// 					a = true;
// 				} else {
// 					a = false;
// 					break;
// 				}
// 			}
// 			for(int j = 0; j < arrayB.length; j++){
// 				if(arrayB[j] % i != 0){
// 					b = false;
// 					break;
// 				} else if(arrayB[j] % i == 0 && arrayA[j] % i != 0){
// 					b = true;
// 				} else {
// 					b = false;
// 					break;
// 				}
// 			}
// 			if(a || b) {
// 				answer = i;
// 			}
// 		}
//
// 		return answer;
// 	}
// }

import java.util.*;
class 숫자카드나누기 {
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int gcdA = arrayA[0];
		int gcdB = arrayB[0];

		for(int i = 1; i < arrayA.length; i++){
			gcdA = gcd(gcdA, arrayA[i]);
			gcdB = gcd(gcdB, arrayB[i]);
		}
		if(valid(gcdA, arrayB)){
			answer = Math.max(answer, gcdA);
		}
		if(valid(gcdB, arrayA)){
			answer = Math.max(answer, gcdB);
		}
		return answer;
	}
	private boolean valid(int gcd, int [] arr) {
		for(int n : arr){
			if(n % gcd == 0) return false;
		}
		return true;
	}
	private int gcd(int a, int b){
		if(b==0) return a;
		return gcd(b, a % b);
	}
}