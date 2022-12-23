package programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LRU (Last Recently Used) 알고리즘
 * cache hit -> 해당 값을 큐 맨 앞으로 보내고(기존거는 삭제), 큐가 꽉차면 맨 뒤에거를 제거
 * cache miss -> 해당 값을 큐 맨 앞에 추가, 큐가 꽉차면 맨 뒤에거를 제거
 */

public class 캐시 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        int r = solution(cacheSize, cities);
        System.out.println(r);
    }

    public static int solution(int cacheSize, String[] cities) {
        Deque<String> q = new ArrayDeque<>();
        int time = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.contains(city)) {
                // cache hit
                q.remove(city);
                time += 1;
                System.out.print("캐시 힛!");
            } else {
                // cache miss
                time += 5;
                System.out.print("캐시 미스!");
            }
            q.addFirst(city);
            if (q.size() > cacheSize) q.removeLast();
            System.out.println("현재 도시 : " + city + " / 큐 상태 : " + q);
        }
        return time;
    }

}
