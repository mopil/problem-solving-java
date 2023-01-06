package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 파일명_정렬 {
    public static void main(String[] args) {
//        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
//        String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        String[] expect = {"img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};

        String[] files = {"foo010bar020.zip"};
        List<String> r = solution(files);
        System.out.println("결과: " + r);
        System.out.println("기대: " + Arrays.toString(expect));
    }

    static class File {
        int originalIndex;
        String originalName;
        String head;
        String lowerHead;
        String originalNumber;
        int number;
        String tail;

        public File(String head, String number, String tail, int originalIndex) {
            this.originalNumber = number; // 010 -> 10 으로 변경되니까 원본 숫자 문자열 저장
            this.originalName = head + number + tail; // 최종 결과값을 List<String> 형태로 만들 때 사용
            this.head = head;
            this.lowerHead = head.toLowerCase(); // head 정렬 비교 때 대소문자 분간이 없으므로 저장
            this.number = Integer.parseInt(number); // number 정렬 비교 때 사용
            this.tail = tail;
            this.originalIndex = originalIndex; // head 같고, number 같을 때 인덱스 비교 때 사용
        }

        // 디버깅 용 toString
        @Override
        public String toString() {
            return "[" + originalIndex + "]" + head + "/" + originalNumber + "/" + tail;
        }
    }

    // String file -> File 객체로 변환
    static File getFile(String file, int index) {
        int i = 0;
        // head 추출 : 숫자가 아닐때 까지 i(인덱스) 더하기
        while (!file.substring(i, i + 1).matches("[0-9]")) i++;
        // subString으로 head 추출
        String head = file.substring(0, i);
        int numStart = i; // number 추출용 subString 시작 인덱스 저장
        boolean noTale = false; // tale이 없는 경우를 체크용
        
        // number 추출
        while (file.substring(i, i + 1).matches("[0-9]")) {
            // F-15 처럼 tale이 없는 경우 == i(인덱스)가 사이즈를 넘어가면 사이즈 값으로 대체
            if (i >= file.length() - 1) {
                i = file.length();
                noTale = true;
                break;
            }
            i++;
        }
        String number = file.substring(numStart, i);
        // tale 추출
        String tail = "";
        if (!noTale) tail = file.substring(i);
        return new File(head, number, tail, index);
    }

    public static List<String> solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        // String file -> File 로, List<File> 생성
        for (int i = 0; i < files.length; i++)
            fileList.add(getFile(files[i], i));
        
        // 정렬 조건 1. head 사전순, 2. number 오름차순, 3. 인덱스 오름차순
        fileList.sort((f1, f2) -> {
            if (f1.lowerHead.equals(f2.lowerHead) && (f1.number == f2.number)) {
                return f1.originalIndex - f2.originalIndex;
            } else if (f1.lowerHead.equals(f2.lowerHead)) {
                return f1.number - f2.number;
            } else {
                return f1.lowerHead.compareTo(f2.lowerHead);
            }
        });
        // 디버깅 용 print
        System.out.println(Arrays.toString(files));
        System.out.println(fileList);
        // 커스텀 File 객체에서 다시 원본 String file 로 변경해서 리턴
        return fileList.stream().map(file -> file.originalName).collect(Collectors.toList());
    }
}
