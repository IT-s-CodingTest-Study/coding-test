class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int nowR = 12;
        int nowL = 10;
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                nowL = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                nowR = num;
            } else {
                if (num == 0) num = 11;
                int numRow = (num - 1) / 3;
                int numCol = (num - 1) % 3;

                int leftRow = (nowL - 1) / 3;
                int leftCol = (nowL - 1) % 3;

                int rightRow = (nowR - 1) / 3;
                int rightCol = (nowR - 1) % 3;

                int leftDist = Math.abs(numRow - leftRow) + Math.abs(numCol - leftCol);
                int rightDist = Math.abs(numRow - rightRow) + Math.abs(numCol - rightCol);

                if (leftDist == rightDist) {
                    if (hand.equals("right")) {
                        sb.append("R");
                        nowR = num;
                    } else {
                        sb.append("L");
                        nowL = num;
                    }
                } else if (leftDist < rightDist) {
                    sb.append("L");
                    nowL = num;
                } else {
                    sb.append("R");
                    nowR = num;
                }
            }
            
            
        }
        
        return sb.toString();
    }
}