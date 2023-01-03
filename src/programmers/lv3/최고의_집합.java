package programmers.lv3;

import java.util.*;


public class 최고의_집합 {
    public static void main(String[] args) {
        int n = 4;
        int s = 9;
        int[] r = solution(n, s);
    }

    public static int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] answer = new int[n];
        Arrays.fill(answer, s / n);
        for (int i = 0; i < s % n; i++)
            answer[i]++;
        Arrays.sort(answer);
        return answer;

    }
}
