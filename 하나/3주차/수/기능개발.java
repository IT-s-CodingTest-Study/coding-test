import java.util.*;
class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
            
        //각 기능이 완료되기까지 필요한 일수 먼저 계산
        for(int i =0; i<progresses.length; i++){
          int progress = 100 - progresses[i];
          days[i] = (int)Math.ceil((double)progress/speeds[i]);
        }
             
          int current = days[0];
          int count = 1;
            
        for(int i = 1; i<days.length; i++){
            if(days[i] <=current){
                count++; //현재 배포 날짜에 추가
            }else{
                answer.add(count);
                current = days[i]; //기준  변경
                count = 1; //배포날짜 초기화
            }
        }answer.add(count);
    
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
}
