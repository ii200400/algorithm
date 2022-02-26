// 문제 링크 : https://www.acmicpc.net/problem/2851
// 제출 공유 링크 : http://boj.kr/0306f60c007d4d6f858c10e4d72d05c4

// 그냥 주어진 조건대로 만들면 되는것 같다.

// 마지막 버섯까지 먹으면서도 예외처리 없나 고려했으면서
// 그새 또 까먹어서 마지막줄에 출력문을 안 넣고 왜 안되나 하고있었다..

package com.baekjoon.problem.java2851;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i<10; i++) {
            // 값을 읽어왔는데
            int tempSum = sum + sc.nextInt();

            // 다음 버섯을 먹을 때 100점이 넘는다면
            if (tempSum >= 100) {
                // 버섯을 먹기전에 값이 100에 가까울 때는 전의 값을
                if (100-sum < tempSum-100){
                    System.out.println(sum);
                }else
                    // 버섯을 먹은 후의 값이 100에 가까울 때 혹은
                    // 먹기 전과 후의 차이가 같다면 먹은 후의 값을 출력한다.
                    System.out.println(tempSum);

                return;
            }

            // 그렇지 않다면 그냥 버섯을 먹는다.
            sum = tempSum;
        }

        // 마지막 버섯까지 다먹었다면 그 수를 출력한다.
        System.out.println(sum);
    }
}
