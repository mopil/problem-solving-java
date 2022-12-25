package programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public static void main(String[] args) {
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
//        String msg = "ABABABABABABABAB";
//        String msg = "KAKAO";
        List<Integer> r = solution(msg);
        System.out.println(r);
    }
    static Map<String, Integer> dict = new HashMap<>();

    public static List<Integer> solution(String msg) {
        // 사전 초기화
        List<Integer> result = new ArrayList<>();
        int dictIdx = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            dict.put(String.valueOf((char) i), dictIdx++);
        }

        int i = 0;
        while (i < msg.length()) {
            String w = "";
            while (i < msg.length()) {
                if (!dict.containsKey(w + msg.charAt(i))) break;
                else w += msg.charAt(i);
                i++;
            }

            result.add(dict.get(w));
            if (i < msg.length())
                dict.put(w + msg.charAt(i), dictIdx++);
        }

        return result;
    }



}



//    public static List<Integer> solution(String msg) {
//        // 사전 초기화
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < ALPHABET_LENGTH; i++) {
//            words.add(String.valueOf((char) ('A' + i)));
//        }
//        char[] chars = msg.toCharArray();
//        int i = 0;
//        while (i < chars.length) {
//            String curChar = String.valueOf(chars[i]);
//            String nextChar;
//            if (i == chars.length - 1) nextChar = "";
//            else nextChar = String.valueOf(chars[i + 1]);
//            String singleChar = curChar;
//            String singleNextChar = nextChar;
//            boolean flag = false;
//            int j = i + 2;
//            while (j < chars.length) {
//                curChar = curChar + nextChar;
//                nextChar = String.valueOf(chars[j]);
//                if (words.contains(curChar) && !words.contains(curChar + nextChar)) {
//                    i = j ;
//                    flag = true;
//                    break;
//                }
//                j++;
//            }
//            if (flag) {
//                words.add(curChar + nextChar);
//                result.add(words.indexOf(curChar) + 1);
//                System.out.println("words: " + words + "\n[" + (words.indexOf(curChar) + 1) + "] curChar: " + curChar + " nextChar: " + nextChar);
//            } else {
//                words.add(singleChar + singleNextChar);
//                result.add(words.indexOf(singleChar) + 1);
//                System.out.println("words: " + words + "\n[" + (words.indexOf(curChar) + 1) + "] curChar: " + singleChar + " nextChar: " + singleNextChar);
//
//                i++;
//            }
//        }
//
////        if (i < chars.length)
//        System.out.println(chars.length);
//        System.out.println(i);
//        return result;
//    }
//}
