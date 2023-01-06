package programmers.lv2;

public class 점프와_순간이동 {
    public static void main(String[] args) {
        int N = 5000;
        int r = solution(N);
        System.out.println(r);
    }

    public static int solution(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1) / 2;
                count++;
            }
        }
        return ++count;
    }

    // DFS로 풀면 5000만 되도 시간초과
//    static int result = Integer.MAX_VALUE;
//    static void dfs(int cur, int target, int count) {
//        if (cur > target) return;
//        if (cur == target) {
//            result = Math.min(result, count);
//            return;
//        }
//        else {
//            dfs(cur + 1, target, count + 1);
//            dfs(cur * 2, target, count);
//        }
//    }
}
