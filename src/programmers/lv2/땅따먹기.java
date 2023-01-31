package programmers.lv2;

import java.util.Arrays;

public class 땅따먹기 {
    public static void main(String[] args) {
        int[][] land = {
                {4,3,2,1}, {2,2,2,1}, {6,6,6,4}, {8,7,6,5}
//                {1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}
//                {3,1,5,4}, {6,9,7,1}, {2,8,6,4}, {1,5,9,8}
//                {1,1,1,1}, {1,2,1,1}, {1,2,3,1}
//                {1, 1, 1, 1}, {2, 2, 2, 3}, {3, 3, 3, 6}, {4, 4, 4, 7}
        };
        int r = solution(land);
        System.out.println(r);
    }

    static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
    static int solution(int[][] land) {
        for (int i = 1 ; i<land.length ; i++) {
            land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
            land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
            land[i][2] += max(land[i-1][1], land[i-1][0], land[i-1][3]);
            land[i][3] += max(land[i-1][1], land[i-1][2], land[i-1][0]);
        }
        Arrays.sort(land[land.length - 1]);
        return land[land.length - 1][3];
    }
}
