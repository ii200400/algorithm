// 문제 링크 : https://www.acmicpc.net/problem/8958
// 제출 공유 링크 : http://boj.kr/d59efe36bc48451fa5f2bdeff23ba1d0

// 음.. 그냥.. 탐색하고 출력한다.

package com.baekjoon.problem.java8958;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 만큼 반복
        for (int i = sc.nextInt(); i>0; i--){
            // 퀴즈 점수, 특정 문제까지 연속된 o의 개수
            int sum = 0, cnt = 0;

            // 퀴즈의 결과를 보면서
            char[] quizResults = sc.next().toCharArray();
            for (char result : quizResults){
                if(result == 'O'){
                    // 정답인 경우 연속 개수를 +1 하고
                    cnt++;
                    // 점수에 더해준다.
                    sum += cnt;
                }else{
                    cnt = 0;
                }
            }

            // 퀴즈 점수 출력
            System.out.println(sum);
        }
    }
}
