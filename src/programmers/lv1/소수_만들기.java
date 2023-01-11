package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 소수_만들기 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        int r = solution(nums);
        System.out.println(r);
    }

    public static <T> List<List<T>> getCombination(List<T> arr, int r) {
        boolean[] visited = new boolean[arr.size()];
        List<List<T>> result = new ArrayList<>();
        normalCombination(arr, visited, 0, arr.size(), r, result);
        return result;
    }

    private static <T> void normalCombination(List<T> arr, boolean[] visited, int start, int n, int r, List<List<T>> result) {
        if (r == 0) {
            List<T> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) if (visited[i]) temp.add(arr.get(i));
            result.add(temp);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            normalCombination(arr, visited, i + 1, n, r - 1, result);
            visited[i] = false;
        }
    }

    static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static int solution(int[] nums) {
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) nList.add(i);
        List<List<Integer>> comb = getCombination(nList, 3);
        int count = 0;
        for (List<Integer> integers : comb) {
            int temp = 0;
            for (int n : integers) temp += nums[n];
            if (isPrime(temp)) count++;
        }
        return count;
    }
}
