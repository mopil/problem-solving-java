package programmers.lv1;

import java.util.Stack;

public class 같은_숫자는_싫어 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == stack.peek()) continue;
            stack.push(arr[i]);
        }
        System.out.println(stack);
    }
}
