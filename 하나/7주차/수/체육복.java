class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] extra = new int[n+1];
        
        for(int r : reserve) extra[r]++;
        for(int l : lost) extra[l]--;
        
        for(int i = 1; i <= n; i++){
            if(extra[i] == -1){ //체육복 없는 학생
                if(i > 1 && extra[i-1] == 1){  
                    extra[i]++;
                    extra[i - 1]--;
                }else if (i < n && extra[i+1] == 1){
                    extra[i]++;
                    extra[i+1]--;
                }
            }
        }
        
        int count = 0; 
        for(int i = 1; i <= n; i++){
            if(extra[i] >= 0) count++;
        }
        
        return count;
    }
}
