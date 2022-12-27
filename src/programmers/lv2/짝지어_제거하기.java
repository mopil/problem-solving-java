package programmers.lv2;

import java.util.Stack;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        String s = "baabaa";
//        String s = "cdcd";
//        String s = "c";
        int r = solution(s);
        System.out.println(r);
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                char topChar = stack.peek();
                if (topChar == chars[i]) stack.pop();
                else stack.push(chars[i]);
            } else {
                stack.push(chars[i]);
            }

        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}
