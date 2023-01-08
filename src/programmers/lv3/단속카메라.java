package programmers.lv3;

import java.util.Arrays;

public class 단속카메라 {
    public static void main(String[] args) {
        int[][] routes = {
                {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}
//                {1, 5}, {3, 6}, {7, 10}, {2, 9}
//                {2, 1}, {1, 1}
        };
        int r = solution(routes);
        System.out.println(r);
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> {
            if (r1[1] == r2[1]) return r1[0] - r2[0];
            else return r1[1] - r2[1];
        });
        int camera = 0;
        int lastCameraPoint = -30001;
        for (int[] route : routes) {
            if (lastCameraPoint < route[0]) {
                // 현재 카메라의 위치가 route 진입 시점보다 작으면
                // 새로운 카메라를 route 진출 시점에 설치
                lastCameraPoint = route[1];
                camera++;
            }
        }
        return camera;
    }
}
