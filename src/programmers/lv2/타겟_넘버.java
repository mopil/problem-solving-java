package programmers.lv2;

public class 타겟_넘버 {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        solution(numbers, target);
        System.out.println(count);
    }

    public static int solution(int[] numbers, int target) {
        dfs(target, 0, 0, numbers);
        return count;
    }

    static int count = 0;

    static void dfs(int target, int sum, int layer, int[] numbers) {
        if (layer >= numbers.length && sum == target) count++;
        else if (layer >= numbers.length) return;
        else {
            dfs(target, sum + numbers[layer], layer + 1, numbers);
            dfs(target, sum - numbers[layer], layer + 1, numbers);
        }
    }
}
