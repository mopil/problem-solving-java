package programmers.lv1;

public class 이상한_문자_만들기 {
    public static String solution(String s) {
        char[] chars = s.toCharArray();
        String answer = "";
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (chars[i] == ' ') {
                count = 0;
                answer += " ";
                i++;
                continue;
            }
            if (count % 2 == 0)
                answer += String.valueOf(chars[i]).toUpperCase();
            else
                answer += String.valueOf(chars[i]).toLowerCase();
            i++;
            count++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "try hello world";
        String a = solution(s);
        System.out.println(a);
    }
}
