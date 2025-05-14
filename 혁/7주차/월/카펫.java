package 월;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total / height; height++) {
            int width = total / height;
            if (total % height == 0) {

                if ((width - 2) * (height - 2) == yellow) {
                    return new int[]{width, height};
                }
            }
        }
        return new int[]{};
    }
}
