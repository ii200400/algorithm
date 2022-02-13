// 문제 링크 : https://www.acmicpc.net/problem/1244
// 제출 공유 링크 : http://boj.kr/c86be0c53f2046c3b14649f79dd36d7b

package com.baekjoon.problem.java1244;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기화
        int n = sc.nextInt();
        boolean[] switchs = new boolean[n+1]; // 0번 스위치도 만든다.

        for (int i = 1; i<n+1; i++){
            switchs[i] = sc.nextInt() == 1;
        }

        // 사람 수 만큼 입력받고 작업 진행
        int pSize = sc.nextInt();
        for (int i = 0; i<pSize; i++){
            int sex = sc.nextInt();
            int switchNum = sc.nextInt();
            if (sex == 1){ // 남학생이라면
                // 받은 수의 배수들 번호의 스위치를 반전시킨다.
                for (int j = switchNum; j<n+1; j += switchNum)
                    switchs[j] = !switchs[j];

            }else{// 여학생이라면
                // 받은 스위치 인덱스 숫자를 기준으로
                for (int j = 0; 0 < switchNum-j && switchNum+j<n+1; j++){
                    // 대칭이 되는 곳 까지
                    if (switchs[switchNum-j] != switchs[switchNum+j])
                        break;
                    // 두 스위치를 반전시킨다.
                    switchs[switchNum+j] = switchs[switchNum-j] = !switchs[switchNum-j];
                }
            }
        }

        // 결과값 출력
        for (int i = 1; i<n+1; i++) {
            System.out.print(switchs[i]? "1 " : "0 ");
            if (i%20 == 0) // 20개씩 끊어서 출력하라고 했다.
                System.out.println();
        }
    }
}
