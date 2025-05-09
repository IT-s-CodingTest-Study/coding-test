import java.util.*;

public class 메뉴_리뉴얼 {
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> courseMap = new HashMap<>();

        for(int i = 0; i<orders.length; i++){
            char[]chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = new String(chars);

        }
        for(int len : course){
            Map<String, Integer> map = new HashMap<>();
            int maxCount = 0;
            for(String order : orders){
                combine(order, len, 0, new StringBuilder(), map);
            }
            for (int count : map.values()) {
                if(count > maxCount) maxCount = count;
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount && maxCount >=2 ) result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    void combine(String order, int courseLength, int start, StringBuilder sb, Map<String,Integer>map){
        if(sb.length() == courseLength){
            String key = sb.toString();
            map.put(key, map.getOrDefault(key,0)+1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));
            combine(order, courseLength, i+1, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
