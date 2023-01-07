package programmers.lv3;

public class 멀리_뛰기 {
    public static void main(String[] args) {
        int n = 40;
        long r = solution2(n);
        System.out.println(r);
    }

    public static long solution(int n) {
        if (n == 1) return 1;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }

    // 40까지 됨 그 이후는 시간 초과
    public static long solution2(int n) {
        dfs(0, n, 0);
        return count;
    }
    static int count = 0;
    static void dfs(int cur, int n, int depth) {
        if (cur > n) return;
        if (cur == n) {
            count++;
            return;
        } else {
            dfs(cur + 1, n, depth + 1);
            dfs(cur + 2, n, depth + 1);
        }
    }
}
