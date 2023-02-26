import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        int n = sc.nextInt(), k = sc.nextInt() - 1; // 사람 수, 요세푸스 수?(사람이 빠져나갈 때 마다 1명씩 자동 카운트가 되어 -1)
        LinkedList<Integer> people = new LinkedList<>(); // 남아있는 사람들 리스트
        int[] yoNums = new int[n]; // 요세푸스 순열
        // n만큼 리스트에 사람들 추가
        for (int i = 1; i<=n; i++){
            people.add(i);
        }

        // n번 반복하면서 요세푸스 순열 제작
        int idx = 0; // 이전에 빠져나간 사람의 인덱스
        for(int i = 0; i<n; i++){
            // 나간 사람을 요세푸스 순열에 추가
            int outIdx = (idx+k) % people.size();
            yoNums[i] = people.remove(outIdx);
            idx = outIdx;
        }

        // 어.. 자바 11부터 가능한 줄 알았는데 자바 8도 된다..
        // 그런데 접두사, 접미사, 구분자 쓴다고 가독성이 저세상으로 가버렸다;;
        // 이차원 배열 입력받을 때 가끔 아니면 안 사용할 듯 하다.
        String print = Arrays.stream(yoNums)    // int[]의 요소를 하나씩
                .mapToObj(String::valueOf)      // String으로 변환하고
                .collect(Collectors.joining(", ", "<", ">"));   // 접두, 접미, 구분자를 넣어서 이쁘게 출력한다.
        System.out.println(print);
    }
}