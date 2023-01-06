package programmers.lv3;

import java.util.*;

public class 베스트앨범 {

    public static void main(String[] args) {
//        String[] genres = {"classic", "pop", "classic", "classic", "pop", "jazz"};
//        int[] plays = {500, 600, 150, 800, 2500, 300};
        String[] genres = {"classic", "classic", "pop", "pop"};
        int[] plays = {10, 10, 3, 17};
        List<Integer> r = solution(genres, plays);
        System.out.println(r);
    }

    static class Music {
        int id;
        int playCount;

        public Music(int id, int playCount) {
            this.id = id;
            this.playCount = playCount;
        }

        @Override
        public String toString() {
            return this.id + ":" + this.playCount;
        }
    }

    static class Genre {
        public String genreName;
        public int totalPlayCount;

        public Genre(String genreName, int totalPlayCount) {
            this.genreName = genreName;
            this.totalPlayCount = totalPlayCount;
        }

        @Override
        public String toString() {
            return this.genreName + ":" + this.totalPlayCount;
        }
    }

    public static List<Integer> solution(String[] genres, int[] plays) {
        // 장르 - 음악 (인덱스, 플레이 횟수) 저장
        Map<String, TreeSet<Music>> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i]))
                /* TreeSet에 저장할 때 자동 정렬 조건을 넣어준다.
                   첫 번째 정렬 조건은 playCount 내림차순, 두 번째 정렬 조건은 인덱스 오름 차순
                 */
                map.put(genres[i], new TreeSet<>((m1, m2) -> {
                    if (m1.playCount == m2.playCount) return m1.id - m2.id;
                    else return m2.playCount - m1.playCount;
                }));
            map.get(genres[i]).add(new Music(i, plays[i]));
        }

        // 장르 - 총 플레이 횟수를 저장
        List<Genre> genreList = new ArrayList<>();
        for (String genre : map.keySet()) {
            int total = 0;
            for (Music m : map.get(genre)) total += m.playCount;
            genreList.add(new Genre(genre, total));
        }

        // 디버깅 용 출력, toString을 override해야 값을 확인 가능
        System.out.println(map);
        System.out.println(genreList);

        // 장르 - 총 플레이 횟수를 내림차순으로 정렬
        genreList.sort((g1, g2) -> g2.totalPlayCount - g1.totalPlayCount);

        List<Integer> answer = new ArrayList<>();
        for (Genre genre : genreList) {
            TreeSet<Music> musics = map.get(genre.genreName);
            for (int j = 0; j < 2; j++) {
                // 음악이 한 개인 경우는 그것만 넣기
                if (musics.isEmpty()) break;
                answer.add(musics.pollFirst().id);
            }
        }
        return answer;
    }
}
