import java.util.*;
class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int sum = brown + yellow;
		for(int h = 3; h <= sum; h++){
			if(sum % h != 0) continue;
			int w = sum / h;
			if(w < h) continue;

			int iw = w - 2; //양 모서리 빼야함
			int ih = h - 2;
			if(iw * ih == yellow) {
				return new int[] {w, h};
			}
		}

		return new int[] {};
	}
}