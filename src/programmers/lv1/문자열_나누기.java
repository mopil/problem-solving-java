package programmers.lv1;

public class 문자열_나누기 {

    public static void main(String[] args) {
        String s = "aaabbaccccabba";
//        String s = "banana";
//        String s = "abracadabra";
//        String s = "a";
        int r = solution(s);
        System.out.println(r);
    }

    public static int solution(String s) {
        int result = 0;
        while (s.length() > 0) {
            int sameCount = 1;
            int diffCount = 0;
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                char next = s.charAt(i);
                if (c == next) sameCount++;
                else diffCount++;
                if (sameCount == diffCount) break;
            }
            s = s.substring(sameCount + diffCount);
            result++;
        }
        return result;
    }

//    // 재귀 풀이 -> 초과
//    static int count = 0;
//
//    static void recur(String s) {
//        String chunk = split(s);
//        if (chunk == null || chunk.isBlank()) return;
//        if (chunk.length() <= 1) {
//            count++;
//            return;
//        }
//        count++;
//        System.out.print(chunk);
//        int start = chunk.length();
//        String remain = s.substring(start);
//        System.out.println("/ " + remain);
//        recur(remain);
//    }
//
//    static String split(String s) {
//        if (s.length() <= 1) return s;
//        try {
//            int sameCount = 1;
//            int notSameCount = 0;
//            int i = 1;
//            char c = s.charAt(0);
//            while (i < s.length()) {
//                char cur = s.charAt(i);
//                if (c == cur) sameCount++;
//                else notSameCount++;
//                if (sameCount == notSameCount) break;
//                i++;
//            }
//            s = s.substring(0, i + 1);
//            return s;
//        } catch (Exception e) {
//            return null;
//        }
//    }
}
