package programmers.lv2;

import java.util.Arrays;

public class 전화번호_목록 {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
//        String[] phone_book = {"123", "456", "789"};
        boolean r = solution(phone_book);
        System.out.println(r);
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        String cur;
        String right = "";
        for (int i = 0; i < phone_book.length - 1; i++) {
            cur = phone_book[i];
            right = phone_book[i + 1];
            if (right.startsWith(cur)) return false;
        }
        return true;
    }
}
