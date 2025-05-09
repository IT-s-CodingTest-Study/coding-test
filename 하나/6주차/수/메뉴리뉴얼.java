import java.util.*;
class 메뉴리뉴얼 {
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        //코스 종류별로 반복
        for(int c : course){
            map.clear();
            int max = 0;
            
            for(String order : orders){
                char[] chars = order.toCharArray();
                Arrays.sort(chars); //알파벳 순으로 정렬(중복방지)
                combination("", chars, c, 0); //조합 만들기
            }
            //조합 최대 등장 횟수 계산
            for(String key : map.keySet()){
                int count = map.get(key);
                if(count >= 2){
                    if(count > max){
                        max = count;
                    }
                }
            }
            //최대 등장 횟수면 result에 추가
            for(String key : map.keySet()){
                if(map.get(key)==max && max >=2){
                    result.add(key);
                }
            }
        }
        Collections.sort(result);  // 결과 정렬
        return result.toArray(new String[0]);
    }
    
    //조합 만들기
    void combination(String prefix, char[] chars, int len, int idx){
        if(prefix.length() == len){
            //완성되면 map에 저장
            map.put(prefix, map.getOrDefault(prefix, 0)+1);
            return;
        }
        //순서대로 알파벳을 붙여서 조합을 생성
        for(int i = idx; i<chars.length; i++){
            combination(prefix + chars[i], chars, len, i+1); 
        }
    }
}
