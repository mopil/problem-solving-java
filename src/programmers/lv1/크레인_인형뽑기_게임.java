package programmers.lv1;

import java.util.*;

public class 크레인_인형뽑기_게임 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int r = solution(board, moves);
        System.out.println(r);
    }

    public static int solution(int[][] board, int[] moves) {
        List<Stack<Integer>> mat = new ArrayList<>();
        for (int j = 0; j < board[0].length; j++) {
            Stack<Integer> temp = new Stack<>();
            for (int i = board.length - 1; i >= 0; i--) {
                int n = board[i][j];
                if (n != 0) temp.add(n);
            }
            mat.add(temp);
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int n : moves) {
            // 보드에서 꺼내기
            int popped;
            try {
                popped = mat.get(n - 1).pop();
            } catch (Exception ignored) {
                continue;
            }

            // 결과물 스택에 넣기
            stack.push(popped);

            // 동일한거 터트리기
            while (true) {
                if (stack.size() <= 1) break;
                int a = stack.pop(); // 맨위
                int b = stack.pop(); // 아래
                if (a != b) {
                    stack.push(b);
                    stack.push(a);
                    break;
                }
                result += 2;
            }
        }
        System.out.println(stack);
        return result;
    }
}
