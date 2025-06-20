package 수;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        // 1. 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int cameraCount = 0;
        int lastCameraPosition = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int enter = route[0];
            int exit = route[1];

            // 현재 차량이 기존 카메라에 안 걸리면 새로운 카메라 설치
            if (enter > lastCameraPosition) {
                cameraCount++;
                lastCameraPosition = exit;  // 진출 지점에 카메라 설치
            }
        }

        return cameraCount;
    }
}
