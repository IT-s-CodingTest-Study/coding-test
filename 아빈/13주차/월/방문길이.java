import java.util.*;
class 방문길이 {
	public int solution(String dirs) {
		int answer = 0;

		Set<String> visited = new HashSet<>();
		int x = 0;
		int y = 0;

		for(char op : dirs.toCharArray()){
			int nx = x;
			int ny = y;

			switch(op){
				case 'U': ny++; break;
				case 'D': ny--; break;
				case 'L': nx--; break;
				case 'R': nx++; break;
			}

			if(nx < -5 || ny < -5 || nx > 5 || ny > 5) {
				continue;
			}
			String path1 = x + "" + y + "" + nx + "" + ny;
			String path2 = nx + "" + ny + "" + x + "" + y;

			if(!visited.contains(path1) && !visited.contains(path2)) {
				visited.add(path1);
				visited.add(path2);
				answer++;
			}

			x = nx;
			y = ny;
		}

		return answer;
	}
}