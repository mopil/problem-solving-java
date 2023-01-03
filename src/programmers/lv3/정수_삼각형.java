package programmers.lv3;

import java.util.Arrays;

public class 정수_삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        };
        int r = solution(triangle);
        System.out.println(r);
    }

    public static int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left, right;
                // 맨 왼쪽
                if (j == 0) {
                    left = 0;
                    right = triangle[i - 1][0];
                }
                // 맨 오른쪽
                else if (j == triangle[i].length - 1) {
                    left = triangle[i - 1][j - 1];
                    right = 0;
                } else {
                    left = triangle[i - 1][j - 1];
                    right = triangle[i - 1][j];
                }
                triangle[i][j] += Math.max(left, right);
            }
        }
        int[] last = triangle[triangle.length - 1];
        Arrays.sort(last);
        return last[last.length - 1];
    }
}
