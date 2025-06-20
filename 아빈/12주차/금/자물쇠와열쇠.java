class 자물쇠와열쇠 {
	public int[][] rotate(int[][] key){
		int n = key.length;
		int[][] rotated = new int[n][n];

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				rotated[j][n - 1 - i] = key[i][j];
			}
		}

		return rotated;
	}

	public boolean check(int[][] nLock, int offset, int n) {
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(nLock[i + offset][j + offset] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean solution(int[][] key, int[][] lock) {
		int n = key.length;
		int m = lock.length;

		int offset = n - 1;
		int size = m + 2 * offset;

		int[][] nLock = new int[size][size];

		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++){
				nLock[i + offset][j + offset] = lock[i][j];
			}
		}

		for(int r = 0; r < 4; r++){
			key = rotate(key);
			for(int x = 0; x <= size - n; x++){
				for(int y = 0; y <= size - n; y++){
					for(int i = 0; i < n; i++){
						for(int j = 0; j < n; j++){
							nLock[x + i][y + j] += key[i][j];
						}
					}

					if(check(nLock, offset, m)){
						return true;
					}

					for(int i = 0; i < n; i++){
						for(int j = 0; j < n; j++){
							nLock[x + i][y + j] -= key[i][j];
						}
					}
				}
			}
		}


		return false;
	}
}