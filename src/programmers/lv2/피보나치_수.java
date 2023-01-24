package programmers.lv2;

public class 피보나치_수 {
    public static void main(String[] args) {
        int n = 3;
        int r = solution(n);
        System.out.println(r);
    }

    public static int solution(int n) {
        int[] dp = new int[100_001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] % 1234567 + dp[i - 2] % 1234567;
        }
        return dp[n] % 1234567;
    }
}
