package programmers.lv2;

public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        String s = "3people unFollowed me";
//        String s = "for the last week";
//        String s = "abb  ccdd";
        String r = solution(s);
        System.out.println(r);
    }

    public static String solution(String s) {
        boolean flag = true;
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            if (chars[i] == ' ') {
                flag = true;
                i++;
                continue;
            }
            if (flag) {
                char upper = String.valueOf(chars[i]).toUpperCase().charAt(0);
                chars[i] = upper;
                flag = false;
            } else {
                char upper = String.valueOf(chars[i]).toLowerCase().charAt(0);
                chars[i] = upper;
            }
            i++;
        }
        return String.valueOf(chars);
    }
}
