package programmers.lv2;

import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        String s = "(())()";
        boolean r = solution(s);
        System.out.println(r);
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') stack.push(chars[i]);
            else if (!stack.isEmpty()) stack.pop();
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
