package programmers.lv1;

public class 최소직사각형 {
    public static void main(String[] args) {
        int[][] sizes = {
                {60, 50}, {30, 70}, {60, 30}, {80, 40}
        };
        int r = solution(sizes);
        System.out.println(r);
    }

    public static int solution(int[][] sizes) {
        int maxW = 0; int maxH = 0;
        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        return maxH * maxW;
    }
}
