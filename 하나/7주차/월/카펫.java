class Solution {
    public int[] solution(int brown, int yellow) {
        int s = brown + yellow;
        
        //세로는 3 이상
        for(int h = 3; h <= s / 3; h++){
            int w = s / h;
            
            //전체 넓이가 나누어 떨어지고
            if(s % h == 0 && w >= h){
                //yellow 영역이 일치하면 정답
                if((w-2)*(h-2)==yellow){
                    return new int[]{w, h};
                }
            }
        }
        return new int[]{};
    }
}
/*전체 넓이 = brown + yellow
(가로 - 2)*(세로 -2) = yellow
가로는 세로보다 크거나 같아야 하므로 (세로 ≤ 가로)
*/
