package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 피로도 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        for (int[] p: permResult) System.out.print(Arrays.toString(p) + " ");
        int r2 = solution(k, dungeons);
        System.out.println(r2);
    }

    public static int solution(int k, int[][] dungeons) {
        n = dungeons.length; r = dungeons.length;
        output = new int[r];
        visited = new boolean[n];
        perm(0);


        int answer = 0;
        for (int[] perm : permResult) {
            int curP = k;
            int count = 0;
            for (int i : perm) {
                if (curP >= dungeons[i][0]) {
                    curP -= dungeons[i][1];
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    static List<int[]> permResult = new ArrayList<>();
    static int[] output;
    static int n, r;
    static boolean[] visited;

    public static void perm(int cnt) {
        if (cnt == r) {
            permResult.add(output.clone());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            output[cnt] = i;
            visited[i] = true;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
