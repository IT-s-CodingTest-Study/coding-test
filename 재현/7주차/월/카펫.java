class Solution {
    public int[] solution(int brown, int yellow) {
        
        int sum = brown + yellow;
        
        for (int height = 3; height <= sum / 3; height++) {
            if (sum % height == 0) {
                int width = sum / height;
                if (2 * (width + height - 2) == brown) {
                    return new int[]{width, height};
                }
            }
        }
        
        return new int[0];
    }
}