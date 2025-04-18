import java.util.*;
import java.lang.*;
class 문자열압축 {
	public int solution(String s) {
		int answer = s.length();
		int count = 1;
		for(int i = 1; i <= s.length()/2; i++){

			StringBuilder sb = new StringBuilder();
			String str = s.substring(0, i);                 //비교해야할 문자열 패턴
			for(int j = i; j <= s.length() - i; j+=i){
				String comparsion = s.substring(j, j+i);
				if(str.equals(comparsion)){
					count++;
				} else {
					if(count > 1){
						sb.append(count + str);
					} else {
						sb.append(str);
					}
					str = comparsion;
					count = 1;
				}
			}
			if(count > 1){
				sb.append(count);
			}
			sb.append(str);
			if(s.length() % i != 0){
				sb.append(s.substring(s.length() - s.length() % i));
			}
			answer = Math.min(answer, sb.length());
			count = 1;
		}
		return answer;
	}
}