class 큰수만들기 {
	public String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		int start = 0;
		for(int i = 0; i < number.length() - k; i++){
			char max_num = '0';
			for(int j = start; j <= i + k; j++){
				if(max_num < number.charAt(j)) {
					max_num = number.charAt(j);
					start = j + 1;
				}
			}
			sb.append(max_num);
		}
		return sb.toString();
	}
}