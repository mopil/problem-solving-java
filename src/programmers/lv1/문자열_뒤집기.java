package programmers.lv1;

import java.util.Arrays;

public class 문자열_뒤집기 {
    public static long[] solution(long n) {
        int len = String.valueOf(n).length();
        long[] answer = new long[len];
        int i = 0;
        while (n != 0) {
            answer[i++] = n % 10;
            n /= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] r = solution(10_000_000_000L);
        System.out.println(Arrays.toString(r));
    }
}
