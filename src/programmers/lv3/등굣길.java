package programmers.lv3;

import java.util.Arrays;

public class 등굣길 {
    static void print(int[][] a) {
        for(int[] i: a) {
            System.out.println(Arrays.toString(i));
        }
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 5;
//        int[][] puddles = {{1, 2}, {4,2}};
        int[][] puddles = {};
        int r = solution(m, n, puddles);
        System.out.println(r);
    }

    public static int solution(int m, int n, int[][] puddles) {
        int[][] d = new int[n][m];
        for (int[] puddle : puddles)
            d[puddle[1] - 1][puddle[0] - 1] = -1;

        d[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] == -1 || (i == 0 && j == 0)) continue;
                int next;
                // 맨 위 라인
                if (i == 0) {
                    if (d[0][j-1] == -1) next = 0;
                    else next = d[0][j-1];
                } // 맨 왼쪽 라인
                else if (j == 0) {
                    if (d[i-1][0] == -1) next = 0;
                    else next = d[i-1][0];
                }
                else {
                    int fromLeft = d[i][j-1];
                    int fromTop = d[i-1][j];
                    // 왼쪽이 물 웅덩이 -> 위에서 오는거 선택
                    if (fromLeft == -1) next = fromTop;
                    // 위쪽이 물 웅덩이 -> 왼쪽에서 오는거 선택
                    else if (fromTop == -1) next = fromLeft;
                    else next = (fromLeft + fromTop) % 1_000_000_007; // 효율성 테스트 넘기기
                }
                d[i][j] += next;
            }
        }
        print(d);
        int answer = d[n - 1][m - 1];
        return answer % 1_000_000_007;
    }
}
