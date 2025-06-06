class 도둑질 {
	public int solution(int[] money) {
		int[] arr1 = new int[money.length]; // 첫 번째 집을 터는 경우를 담는 배열
		int[] arr2 = new int[money.length]; // 첫 번째 집을 털지 않는 경우를 담는 배열

		arr1[0] = money[0];
		arr1[1] = money[0]; // 인접한 곳의 집은 털 수 없기 때문에 첫 집과 같은 수를 대입

		arr2[0] = 0;        // 첫 번째 집은 털지 않기 때문에 배열의 시작을 0으로
		arr2[1] = money[1];

		for(int i = 2; i < money.length; i++) {
			//현재 집을 털었을때와 그렇지 않았을때를 비교하여 큰 값을 대입
			arr1[i] = Math.max(arr1[i - 1], money[i] + arr1[i - 2]);
			arr2[i] = Math.max(arr2[i - 1], money[i] + arr2[i - 2]);
		}
		return Math.max(arr1[money.length - 2], arr2[money.length - 1]); // 첫 집을 털면 마지막 집은 털지 못하기 때문에 -2
	}
}