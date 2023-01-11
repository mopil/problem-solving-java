package programmers.lv1;

public class 다트_게임 {

    public static void main(String[] args) {
//        String dartResult = "1S2D*3T";
        String dartResult = "1D2S#10S";

        int r = solution(dartResult);
        System.out.println(r);
    }

    public static int solution(String dartResult) {
        int[] scores = new int[3];
        String numStr = "";
        int idx = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            String s = String.valueOf(c);
            if (s.matches("[0-9]")) {
                numStr += String.valueOf(c);
            } else if (s.matches("[SDT]")) {
                int score = Integer.parseInt(numStr);
                switch (s) {
                    case "S":
                        scores[idx++] = (int) Math.pow(score, 1);
                        break;
                    case "D":
                        scores[idx++] = (int) Math.pow(score, 2);
                        break;
                    case "T":
                        scores[idx++] = (int) Math.pow(score, 3);
                        break;
                }
                numStr = "";
            } else {
                if (c == '*') {
                    scores[idx - 1] *= 2;
                    if (idx > 1) scores[idx - 2] *= 2;
                } else if (c == '#') {
                    scores[idx - 1] *= -1;
                }
            }
        }
        int total = 0;
        for (int n : scores) total += n;
        return total;
    }
}
