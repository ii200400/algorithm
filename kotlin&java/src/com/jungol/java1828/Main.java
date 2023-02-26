// 문제 링크 : http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=1101&sca=99&sfl=wr_hit&stx=1828
// 제출 링크 (공유 링크 아님) : http://jungol.co.kr/theme/jungol/result.php?sid=5503434

// 이전에 비슷한 문제를 본 것 같다.
// 기본적으로 최고온도를 기준으로 정렬을 하고 최고온도가 같으면 최저온도를 기준으로 정렬한다.
// 정렬은 내림차순으로 한다.

// 처음에는 최저온도를 기준으로 정렬했는데 반례보니까 아니였다..

package com.jungol.java1828;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        int n = sc.nextInt();   // 화학물질 수
        int[][] arr = new int[n][2];    // 화학물질의 최고, 최저온도 배열
        for (int i = 0; i<n; i++){
            arr[i] = new int[] {sc.nextInt(), sc.nextInt()};
        }

        // 최고기온과 최저기온 순으로 내림차순을 한다.
        Arrays.sort(arr, (o1, o2) -> (o1[1] - o2[1]) != 0? (o1[1] - o2[1]) : o1[0] - o2[0]);
        // 정렬 확인용
//        System.out.println(Arrays.deepToString(arr));

        int refrigeratorNum = 0;    // 필요한 냉장고 수
        int temperature = -271;     // 현재 냉장고 온도(어떤 화학물질의 최고온도)
        // 정렬된 화학물질을 하나씩 꺼내는데
        for (int[] item : arr) {
            // 현재 냉장고 온도(temperature)가
            // 지금 꺼내는 것의 최저온도보다 낮다면 (지금 냉장고에 못 넣으면)
            if (temperature < item[0]){
                // 냉장고를 추가하고
                refrigeratorNum++;
                // 방금 꺼낸 물질의 화학물질의 최고온도 값을 냉장고 온도로 설정한다.
                temperature = item[1];
                // 냉장고 추가 시 설정 온도 확인용
//                System.out.println(temperature); 
            }
        }

        // 필요한 냉장고의 갯수를 출력한다.
        System.out.println(refrigeratorNum);
    }
}
