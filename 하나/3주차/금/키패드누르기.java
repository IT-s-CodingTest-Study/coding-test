class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        //키패드 배열 
        int[][] pad = {{1,2,3},{4,5,6},{7,8,9},{11,0,11}};
        
        //각 숫자에 대한 좌표 저장용
        int[][] pos = new int[10][];
        for(int i = 0; i<pad.length; i++){
            for(int j =0; j<pad[i].length; j++){
                int value = pad[i][j];
                if(value==11)continue; //기호 제외
                pos[value] = new int[]{i,j}; //숫자 좌표 저장
            }
        }
        
        int[]left = {3,0};
        int[]right = {3,2};
        
        for(int num : numbers){
            int[] target = pos[num]; //눌러야 할 숫자의 좌표
            
            if(num ==1 || num == 4|| num ==7){
                answer.append("L");
                left = target; //왼손 이동
            }else if (num ==3 || num == 6|| num ==9){
                 answer.append("R");
                right = target; //오른손 이동
            }else{
                //가운데 키패드일 경우 거리 계산
                int leftDist = Math.abs(left[0]-target[0])+ Math.abs(left[1]-target[1]);
                int rightDist = Math.abs(right[0]-target[0])+Math.abs(right[1]-target[1]);
                if(leftDist < rightDist){
                    answer.append("L");
                    left = target;
                }else if (leftDist > rightDist){
                    answer.append("R");
                    right = target;
                }else{
                    if(hand.equals("right")){
                        answer.append("R");
                        right = target;
                    }else{
                        answer.append("L");
                        left = target;
                    }
                }
            }
        }
        return answer.toString();
    }
}
