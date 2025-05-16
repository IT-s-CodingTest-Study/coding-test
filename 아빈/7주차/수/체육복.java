import java.util.*;
class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		Set<Integer> lost_set = new HashSet<>();
		Set<Integer> reserve_set = new HashSet();
		for(int l : lost){
			lost_set.add(l);
		}
		for(int r : reserve){
			if(lost_set.contains(r)) {
				lost_set.remove(r);
			} else {
				reserve_set.add(r);
			}
		}
		for(int r : reserve_set) {
			if(lost_set.contains(r - 1)) {
				lost_set.remove(r - 1);
			} else if(lost_set.contains(r + 1)) {
				lost_set.remove(r + 1);
			}
		}

		return n - lost_set.size();
	}
}