class 정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;
		for(int i = 1; i < triangle.length; i++){
			for(int j = 0; j < triangle[i].length; j++){
				if(j == 0){
					triangle[i][j] += triangle[i-1][j];
				} else if(j == i) {
					triangle[i][j] += triangle[i-1][i-1];
				} else {
					triangle[i][j] += Math.max(triangle[i -1][j-1], triangle[i-1][j]);
				}
			}
		}
		int a = triangle.length - 1;
		for(int i : triangle[a]){
			answer = Math.max(answer, i);
		}
		return answer;
	}
}