// 문제 링크 : https://www.acmicpc.net/problem/2309
// 제출 공유 링크 : http://boj.kr/06fed2ebc352453aa9e316c70c1c6dca

package com.baekjoon.problem.java2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] heights = new int[9]; // 난쟁이들의 키 배열
        // 배열 초기화
        int sum = 0;    // 아홉 난쟁이의 키 총합
        for (int i = 0; i<9; i++){
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        // 출력이 오름차순을 요구하기 때문에 정렬 진행
        Arrays.sort(heights);

        int i , j = 0;
        outer: for (i = 0; i<9; i++){
            // 한 난쟁이와
            int temp = sum - heights[i];
            for (j = i+1; j<9; j++){
                // 또 다른 난쟁이의 키를 총합에서 뺀 값이 100이라면
                // 바로 이중 for문을 탈출한다.
                if (temp-heights[j] == 100)
                    break outer;
            }
        }

        // 일곱 난쟁이의 키만 출력한다.
        for (int k = 0; k<9; k++){
            if (k == i || k== j)
                continue;
            System.out.println(heights[k]);
        }
    }
}
