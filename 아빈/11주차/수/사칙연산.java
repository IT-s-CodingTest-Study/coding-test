class 사칙연산 {
	public int solution(String arr[]) {
		int n = (arr.length + 1) / 2;
		int[] nums = new int[n];
		char[] ops = new char[n - 1];

		for(int i = 0; i < n; i++) nums[i] = Integer.parseInt(arr[2 * i]);
		for(int i = 0; i < n - 1; i++) ops[i] = arr[2 * i + 1].charAt(0);

		int[][] max = new int[n][n];
		int[][] min = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++) {
				max[i][j] = Integer.MIN_VALUE;
				min[i][j] = Integer.MAX_VALUE;
			}
			max[i][i] = nums[i];
			min[i][i] = nums[i];
		}

		for(int d = 1; d < n; d++) {
			for(int i = 0; i + d < n; i++){
				int j = i + d;
				for(int k = i; k < j; k++){
					if(ops[k] == '+') {
						max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
						min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
					} else {
						max[i][j] = Math.max(max[i][j], max[i][k] - min[k+1][j]);
						min[i][j] = Math.min(min[i][j], min[i][k] - max[k+1][j]);
					}
				}
			}
		}
		return max[0][n-1];
	}
}